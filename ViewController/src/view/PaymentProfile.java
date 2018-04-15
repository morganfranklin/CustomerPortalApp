package view;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;

import model.GenericDataHandler;

import oracle.adf.model.binding.DCIteratorBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

import view.util.ADFUtils;

public class PaymentProfile implements Serializable {
    @SuppressWarnings("compatibility:-9188164881694416807")
    private static final long serialVersionUID = 1L;

    private BigDecimal totalPaymentAmount;
    private static final String OPEN_ITEMS_ITERATOR = "OpenItems1Iterator";
    private Boolean paymentSuccess = false;
    private String transactionRequestId;
    private Boolean showPaymentProfiles = false;
    private Boolean individualAmountIsNull = false;
    private Boolean selectAll=false;
    private Boolean noInvoicesSelected=false;
    
    private String selectedTokenValue = "X123A";
    private String psPendingItemSeq;
    private String newItemSalesPerson;
    private String newItemCollector;

    public void setPsPendingItemSeq(String psPendingItemSeq) {
        this.psPendingItemSeq = psPendingItemSeq;
    }

    public String getPsPendingItemSeq() {
        return psPendingItemSeq;
    }

    public void setTransactionRequestId(String transactionRequestId) {
        this.transactionRequestId = transactionRequestId;
    }

    public String getTransactionRequestId() {
        return transactionRequestId;
    }


    public PaymentProfile() {
        super();
    }

    public void setTotalPaymentAmount(BigDecimal totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }
    
    private Map<String, String> pendingItemArray = new HashMap<String,String>();    
    private String customerId = "unknown";

    public BigDecimal getTotalPaymentAmount() {
        
            // 171115 add
            pendingItemArray.clear();
            
            if (!individualAmountIsNull) {
            BigDecimal total = new BigDecimal(0);
            DCIteratorBinding itr = ADFUtils.findIterator(OPEN_ITEMS_ITERATOR);
            ViewObject vo = itr.getViewObject();
            RowSetIterator rsi = vo.createRowSetIterator(null);
            while (rsi.hasNext()) {
                Row r = rsi.next();
                BigDecimal paymentAmount = (BigDecimal) r.getAttribute("paymentAmount");
                String dstIdAr = (String) r.getAttribute("DstIdAr");
                String salesPerson = (String) r.getAttribute("SalesPerson");
                String collector = (String) r.getAttribute("Collector");    
                
                if (paymentAmount != null) {

                    // 17115                     
                    pendingItemArray.put((String) r.getAttribute("Item"), "OPEN_ITEM" + ":" +paymentAmount+":"+dstIdAr+":"+salesPerson+":"+collector);
                    customerId=(String) r.getAttribute("CustId");
                    total = total.add(paymentAmount);
                }
            }
            
            rsi.closeRowSetIterator();
            totalPaymentAmount = total;
        }
            //For new item
            if(this.getNoInvoicesSelected()){
                
                pendingItemArray.put(this.getPsPendingItemSeq(), "ON_ACCOUNT" + ":" + this.totalPaymentAmount+":PY-12502"+":"+this.getNewItemSalesPerson()+":"+this.getNewItemCollector());
                customerId = (String)ADFUtils.evaluateEL("#{bindings.CustId.inputValue}");
            }
        
        return totalPaymentAmount;

    }
    

    public void setPaymentSuccess(Boolean paymentSuccess) {
        this.paymentSuccess = paymentSuccess;
    }

    public Boolean getPaymentSuccess() {
        return paymentSuccess;
    }

    public void setShowPaymentProfiles(Boolean showPaymentProfiles) {
        this.showPaymentProfiles = showPaymentProfiles;
    }

    public Boolean getShowPaymentProfiles() {
        return showPaymentProfiles;
    }

    public void setIndividualAmountIsNull(Boolean individualAmountIsNull) {
        this.individualAmountIsNull = individualAmountIsNull;
    }

    public Boolean getIndividualAmountIsNull() {
        return individualAmountIsNull;
    }

    public void setSelectAll(Boolean selectAll) {
        this.selectAll = selectAll;
    }

    public Boolean getSelectAll() {
        return selectAll;
    }

    public void setNoInvoicesSelected(Boolean noInvoicesSelected) {
        this.noInvoicesSelected = noInvoicesSelected;
    }

    public Boolean getNoInvoicesSelected() {
        return noInvoicesSelected;
    }

    public void setSelectedTokenValue(String selectedTokenValue) {
        this.selectedTokenValue = selectedTokenValue;
    }

    public String getSelectedTokenValue() {
        return selectedTokenValue;
    }
    
    public void savePendingItems() {

        GenericDataHandler dataAdapter = new GenericDataHandler();
        
        dataAdapter.savePendingItems(dataAdapter.connectDb(), this.pendingItemArray, this.customerId);

    }

    public void setNewItemSalesPerson(String newItemSalesPerson) {
        this.newItemSalesPerson = newItemSalesPerson;
    }

    public String getNewItemSalesPerson() {
        return newItemSalesPerson;
    }

    public void setNewItemCollector(String newItemCollector) {
        this.newItemCollector = newItemCollector;
    }

    public String getNewItemCollector() {
        return newItemCollector;
    }
}
