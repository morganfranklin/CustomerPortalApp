package view;

import java.io.Serializable;

import java.math.BigDecimal;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import model.CyberSourceAdapter;
import model.OpenItemsRowImpl;

import oracle.adf.model.BindingContext;
import oracle.adf.model.OperationBinding;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.faces.bi.event.pivotTable.SortEvent;
import oracle.adf.view.rich.component.rich.RichQuery;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.model.QueryDescriptor;
import oracle.adf.view.rich.model.QueryModel;

import oracle.adfinternal.view.faces.model.binding.FacesCtrlHierNodeBinding;

import oracle.binding.BindingContainer;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.SortCriteria;
import oracle.jbo.ViewObject;

import view.mail.SendMail;

import view.util.ADFUtils;


public class NewPaymentProfileBean implements Serializable {
    @SuppressWarnings("compatibility:1663981544468693284")
    private static final long serialVersionUID = 1473170519560023624L;


    PaymentProfile myPaymentProfileBean;
    private static final String OPEN_ITEMS_ITERATOR = "OpenItems1Iterator";

    private String customerId;
    private String paymentProfileId = "brontosaurus";
    private String billToFirstName;
    private String billToLastName;
    private String billToStreet1;
    private String billToCity;
    private String billToState;
    private String billToPostalCode;
    private String billToCountry;
    private String billToEmail;
    private String purchaseTotalsCurrency;
    private String cardAccountNumber;
    private String cardExpirationMonth;
    private String cardExpirationYear;
    private String cardCardType;


    // private String substriptionIdentifier;
    //   private BigDecimal totalPaymentAmount;


    private RichTable invoiceTableBinding;

    private RichPanelGridLayout gridBinding;
    private RichQuery queryBinding;
    private static ADFLogger _logger = ADFLogger.createADFLogger(NewPaymentProfileBean.class);

    public void updateTotalPaymentAmount(ActionEvent actionEvent) {
        this.myPaymentProfileBean.setTotalPaymentAmount(myPaymentProfileBean.getTotalPaymentAmount());
    }

    public String getHtmlBodyForPaymentConfirmation() {
        String bodyText = "<h1>Transaction Receipt</h1>";
        String custId = (String)ADFUtils.evaluateEL("#{bindings.CustId.inputValue}");
        String custName = (String)ADFUtils.evaluateEL("#{bindings.Name1.inputValue}");
        bodyText = bodyText + "<p><b>Customer ID:</b> " + custId +"</p>";
        bodyText = bodyText + "<p><b>Customer Name:</b> " + custName +"</p>";
        bodyText = bodyText + " <p><img  src=\"cid:image\" ><b>Transaction Confirmation</b> </p>";
        bodyText =
            bodyText + " <p>The payment below has processed successfully.  Please note the transaction id below for reference.</p>" +
            this.myPaymentProfileBean.getTransactionRequestId();
        bodyText =
            bodyText + " <table cellpadding=\"10\" cellspacing=\"1\">\n" + "  <tr>\n" +
            "    <th cellpadding=\"10\">Invoice</th>\n" + "    <th>Due Date</th>\n" +
            "     <th>Outstanding amount</th>\n" + "    <th>Payment Amount</th>\n" + "  </tr>";
        DCIteratorBinding itr = ADFUtils.findIterator(OPEN_ITEMS_ITERATOR);
        ViewObject vo = itr.getViewObject();
        RowSetIterator rsi = vo.createRowSetIterator(null);
        String iteratorHtml = "";
        //DecimalFormat df2 = new DecimalFormat("#,###,###,##.00");
        DecimalFormat df2 = new DecimalFormat("###,###,###.00");
        SimpleDateFormat sm = new SimpleDateFormat("MM-dd-yyyy");
        while (rsi.hasNext()) {
            OpenItemsRowImpl row = (OpenItemsRowImpl) rsi.next();
            if (row != null && row.getpaymentAmount() != null) {
                iteratorHtml = iteratorHtml + "<tr>";
                iteratorHtml = iteratorHtml + "<td>" + row.getItem() + "</td>";
                java.sql.Date sqldate = row.getDueDt().dateValue();
                iteratorHtml = iteratorHtml + "<td>" + sm.format(new Date(sqldate.getTime())) + "</td>";
                iteratorHtml = iteratorHtml + "<td>" + df2.format(row.getBalAmt()) + "</td>";
                iteratorHtml = iteratorHtml + "<td>" + df2.format(row.getpaymentAmount()) + "</td>";
                iteratorHtml = iteratorHtml + "</tr>";
            }
        }
        rsi.closeRowSetIterator();
        
        if(checkIfNoInvoiceSelected()){
            iteratorHtml = iteratorHtml + "<tr>";
            iteratorHtml = iteratorHtml + "<td>" + myPaymentProfileBean.getPsPendingItemSeq() + "</td>";
            iteratorHtml = iteratorHtml + "<td></td><td></td>";
            iteratorHtml = iteratorHtml + "<td>" + df2.format(myPaymentProfileBean.getTotalPaymentAmount()) + "</td>";
            iteratorHtml = iteratorHtml + "</tr>";
        }
        
        iteratorHtml =
            iteratorHtml + "<tr><td></td><td></td><td>Total Amount</td><td>" +
            df2.format(myPaymentProfileBean.getTotalPaymentAmount()) + "</td></tr>";
        bodyText = bodyText + iteratorHtml + " </table>";
        System.out.println(bodyText);
        return bodyText;
    }


    public void callChargeCreditCard(ActionEvent actionEvent) {
        
        String localProfileId = (String)ADFUtils.evaluateEL("#{bindings.ProfileId.inputValue}");
        System.out.println("NewPaymentProfileBean.java:136 : "+ localProfileId);
        String email = (String)ADFUtils.evaluateEL("#{bindings.email.inputValue}");
        _logger.info("Inside callChargeCreditCard Email Id:"+email);
        
        if (checkIsOverPaymentAllowed()) {
            Map<String, String> replyMap = chargeCreditCardForAmount(myPaymentProfileBean.getTotalPaymentAmount(),
                                                                     "USD", 
                                                                     localProfileId);
            if (replyMap != null) {
                if (replyMap.get("DECISION").equalsIgnoreCase("ACCEPT") && replyMap.get("REASON_CODE").equals("100")) {
                    this.myPaymentProfileBean.setPaymentSuccess(Boolean.TRUE);
                    this.myPaymentProfileBean.setTransactionRequestId(replyMap.get("REQUEST_ID").toString());
                    String bodyText = getHtmlBodyForPaymentConfirmation();
                    _logger.info("Inside callChargeCreditCard Before sendEmail Email Id:" + email);
                    SendMail.sendEmail(email, "Invoice Payment confirmation", bodyText);

                    // 171115 begin
                    this.myPaymentProfileBean.savePendingItems();
                    // 171115 end

                } else {
                    this.myPaymentProfileBean.setPaymentSuccess(Boolean.FALSE);
                    if (null != replyMap.get("DECISION") && null != replyMap.get("REASON_CODE") &&
                        null != replyMap.get("MESSAGE")) {
                        ADFUtils.setvalueToExpression("#{pageFlowScope.transactionMessage}", replyMap.get("MESSAGE"));
                    } else {
                        ADFUtils.setvalueToExpression("#{pageFlowScope.transactionMessage}",
                                                      "The below transaction has failed. Please correct the error and try again.");
                    }
                }
            } else {
                this.myPaymentProfileBean.setPaymentSuccess(Boolean.FALSE);
                ADFUtils.setvalueToExpression("#{pageFlowScope.transactionMessage}","The below transaction has failed. Please correct the error and try again.");
            }
        } else {
            ADFUtils.showErrorMessage("Please apply overpayment to open item. Overpayment is only allowed if customer does not have open items.");

        }

    }


    private Map<String, String> chargeCreditCardForAmount(BigDecimal amount, String currencyCd, String subscriptionId) {
        CyberSourceAdapter localAdapter = new CyberSourceAdapter();
        Map<String, String> replyMap = localAdapter.createPurchaseAction(amount, currencyCd, subscriptionId);
        return replyMap;

    }

    public void callCreditCardAddition() {

        HashMap createCusData = new HashMap();
        String requestID;

        // Example of CreateProfile or new subscription
        // Add required fields
        createCusData.put("billTo_firstName", this.billToFirstName);
        createCusData.put("billTo_lastName", this.billToLastName);
        createCusData.put("billTo_street1", this.billToStreet1);
        createCusData.put("billTo_city", this.billToCity);
        createCusData.put("billTo_state", this.billToState);
        createCusData.put("billTo_postalCode", this.billToPostalCode);
        createCusData.put("billTo_country", "US");
        createCusData.put("billTo_email", "tomasz.zarzycki@morganfranklin.com");
        createCusData.put("purchaseTotals_currency", "USD");
        createCusData.put("card_accountNumber", cardAccountNumber);
        createCusData.put("card_expirationMonth", cardExpirationMonth);
        createCusData.put("card_expirationYear", cardExpirationYear);
        createCusData.put("card_cardType", "001");
        createCusData.put("merchantID", "morganfranklin");
        createCusData.put("merchantReferenceCode", "COV_003");

        CyberSourceAdapter localAdapter = new CyberSourceAdapter();
        localAdapter.createProfileAction(createCusData);

    }

    public void setPaymentProfileId(String paymentProfileId) {
        this.paymentProfileId = paymentProfileId;
    }

    public String getPaymentProfileId() {
        return paymentProfileId;
    }

    public void setBillToFirstName(String billToFirstName) {
        this.billToFirstName = billToFirstName;
    }

    public String getBillToFirstName() {
        return billToFirstName;
    }

    public void setBillToLastName(String billToLastName) {
        this.billToLastName = billToLastName;
    }

    public String getBillToLastName() {
        return billToLastName;
    }

    public void setBillToStreet1(String billToStreet1) {
        this.billToStreet1 = billToStreet1;
    }

    public String getBillToStreet1() {
        return billToStreet1;
    }

    public void setBillToCity(String billToCity) {
        this.billToCity = billToCity;
    }

    public String getBillToCity() {
        return billToCity;
    }

    public void setBillToState(String billToState) {
        this.billToState = billToState;
    }

    public String getBillToState() {
        return billToState;
    }

    public void setBillToPostalCode(String billToPostalCode) {
        this.billToPostalCode = billToPostalCode;
    }

    public String getBillToPostalCode() {
        return billToPostalCode;
    }

    public void setBillToCountry(String billToCountry) {
        this.billToCountry = billToCountry;
    }

    public String getBillToCountry() {
        return billToCountry;
    }

    public void setBillToEmail(String billToEmail) {
        this.billToEmail = billToEmail;
    }

    public String getBillToEmail() {
        return billToEmail;
    }

    public void setPurchaseTotalsCurrency(String purchaseTotalsCurrency) {
        this.purchaseTotalsCurrency = purchaseTotalsCurrency;
    }

    public String getPurchaseTotalsCurrency() {
        return purchaseTotalsCurrency;
    }

    public void setCardAccountNumber(String cardAccountNumber) {
        this.cardAccountNumber = cardAccountNumber;
    }

    public String getCardAccountNumber() {
        return cardAccountNumber;
    }

    public void setCardExpirationMonth(String cardExpirationMonth) {
        this.cardExpirationMonth = cardExpirationMonth;
    }

    public String getCardExpirationMonth() {
        return cardExpirationMonth;
    }

    public void setCardExpirationYear(String cardExpirationYear) {
        this.cardExpirationYear = cardExpirationYear;
    }

    public String getCardExpirationYear() {
        return cardExpirationYear;
    }

    public void setCardCardType(String cardCardType) {
        this.cardCardType = cardCardType;
    }

    public String getCardCardType() {
        return cardCardType;
    }

    public NewPaymentProfileBean() {
        super();
    }

    public void setCustomerId(String customerId, String subscriptionId) {
        this.customerId = customerId + this.getBillToFirstName();
        // this.substriptionIdentifier = "unknown 306";
        System.out.println("DEBUG NewPaymentProfileBean.java:308: " + subscriptionId);
        this.myPaymentProfileBean.setSelectedTokenValue(subscriptionId);
    }
    
    // public String getSubstriptionIdentifier() {
       //  return substriptionIdentifier;
    // }

    public String getCustomerId() {
        return customerId;
    }

    //    public void setTotalPaymentAmount(BigDecimal totalPaymentAmount) {
    //        this.totalPaymentAmount = totalPaymentAmount;
    //    }

    //    public BigDecimal getTotalPaymentAmount() {
    //        BigDecimal total = new BigDecimal(0);
    //        DCIteratorBinding itr = ADFUtils.findIterator(OPEN_ITEMS_ITERATOR);
    //        ViewObject vo = itr.getViewObject();
    //        RowSetIterator rsi = vo.createRowSetIterator(null);
    //        while (rsi.hasNext()) {
    //            Row r = rsi.next();
    //            BigDecimal paymentAmount = (BigDecimal) r.getAttribute("paymentAmount");
    //            if (paymentAmount != null) {
    //                total = total.add(paymentAmount);
    //            }
    //        }
    //        rsi.closeRowSetIterator();
    //        totalPaymentAmount = total;
    //        return totalPaymentAmount;
    //    }

    public void payAllActionListener(ActionEvent actionEvent) {
        BigDecimal total = new BigDecimal(0);
        DCIteratorBinding itr = ADFUtils.findIterator(OPEN_ITEMS_ITERATOR);
        ViewObject vo = itr.getViewObject();
        RowSetIterator rsi = vo.createRowSetIterator(null);
        while (rsi.hasNext()) {
            OpenItemsRowImpl r = (OpenItemsRowImpl) rsi.next();
            BigDecimal balanceAmount = (BigDecimal) r.getAttribute("BalAmt");
            r.setAttribute("paymentAmount", balanceAmount);
            r.setselected(true);
            BigDecimal paymentAmount = (BigDecimal) r.getAttribute("paymentAmount");
            if (paymentAmount != null) {
                total = total.add(paymentAmount);
            }
        }
        myPaymentProfileBean.setSelectAll(true);
        rsi.closeRowSetIterator();
        myPaymentProfileBean.setTotalPaymentAmount(total);
    }

    private Boolean checkIsOverPaymentAllowed() {
        DCIteratorBinding itr = ADFUtils.findIterator(OPEN_ITEMS_ITERATOR);
        ViewObject vo = itr.getViewObject();
        Boolean isOverPaymentDone = false;
        Boolean balAmtVsPayAmt = true;
        if (itr.getEstimatedRowCount() > 1) {
            RowSetIterator rsi = vo.createRowSetIterator(null);
            while (rsi.hasNext()) {
                OpenItemsRowImpl r = (OpenItemsRowImpl) rsi.next();
                BigDecimal balanceAmount = (BigDecimal) r.getAttribute("BalAmt");
                BigDecimal paymentAmount = (BigDecimal) r.getAttribute("paymentAmount");
                if (paymentAmount != null && paymentAmount.compareTo(balanceAmount) == 1) {
                    isOverPaymentDone = true;
                }
            }
            if (isOverPaymentDone) {
                rsi.reset();
                while (rsi.hasNext()) {
                    OpenItemsRowImpl r = (OpenItemsRowImpl) rsi.next();
                    BigDecimal balanceAmount = (BigDecimal) r.getAttribute("BalAmt");
                    BigDecimal paymentAmount = (BigDecimal) r.getAttribute("paymentAmount");
                    if (paymentAmount == null || paymentAmount.compareTo(balanceAmount) == -1) {
                        balAmtVsPayAmt = false;
                        break;
                    }
                }
            }
            rsi.closeRowSetIterator();
        } 
        return balAmtVsPayAmt;
    }

    public String payParticularInvoice() {
        // Add event code here...

        
        FacesCtrlHierNodeBinding tableBinding = (FacesCtrlHierNodeBinding) invoiceTableBinding.getSelectedRowData();
        OpenItemsRowImpl row = (OpenItemsRowImpl) tableBinding.getRow();
        BigDecimal paymentAmount = row.getpaymentAmount();
        String invoiceItem = row.getItem();
        if (paymentAmount != null && paymentAmount.compareTo(BigDecimal.valueOf(0)) > 0) {
            if (checkIsOverPaymentAllowed()) {
                DCIteratorBinding itr = ADFUtils.findIterator(OPEN_ITEMS_ITERATOR);
                ViewObject vo = itr.getViewObject();
                RowSetIterator rsi = vo.createRowSetIterator(null);
                while (rsi.hasNext()) {
                    OpenItemsRowImpl r = (OpenItemsRowImpl) rsi.next();
                    if (!invoiceItem.equalsIgnoreCase(r.getItem())) {
                        r.setAttribute("paymentAmount", null);
                    }
                }
                rsi.closeRowSetIterator();
                return "toConfirmPayment";
            } else {
                ADFUtils.showErrorMessage("Please apply overpayment to open item. Overpayment is only allowed if customer does not have open items.");
                return "";
            }
        } else {
            ADFUtils.showErrorMessage("Please enter amount greater than 0");
            return "";
        }
    }


    public void applyAgainstOldestActionListener(ActionEvent actionEvent) {
        // Add event code here...
        myPaymentProfileBean.setIndividualAmountIsNull(true);
        if (myPaymentProfileBean.getTotalPaymentAmount().compareTo(BigDecimal.valueOf(0)) == 1) {
            BigDecimal totalAmountTemp = new BigDecimal(myPaymentProfileBean.getTotalPaymentAmount().toString());
            DCIteratorBinding itr = ADFUtils.findIterator(OPEN_ITEMS_ITERATOR);
            Row currentRow = itr.getCurrentRow();
            ViewObject vo = itr.getViewObject();
            //resetTableSort(invoiceTableBinding, OPEN_ITEMS_ITERATOR);
            
            OperationBinding op = ADFUtils.findOperation("applyAgainstOldest");
            if (null != op) {
                op.getParamsMap().put("totalAmountTemp", totalAmountTemp);
                op.execute();
            }
            /*clearAllPaymentAmount();
            RowSetIterator rsi = vo.createRowSetIterator(null);
            rsi.reset();
            while (rsi.hasNext()) {
                Row r = rsi.next();
                BigDecimal balanceAmount = (BigDecimal) r.getAttribute("BalAmt");
                System.out.println(balanceAmount.compareTo(totalAmountTemp));
                if (totalAmountTemp.compareTo(BigDecimal.valueOf(0)) == 1) {
                    if (balanceAmount.compareTo(totalAmountTemp) > 0) {
                        r.setAttribute("paymentAmount", totalAmountTemp);
                        totalAmountTemp = totalAmountTemp.subtract(balanceAmount);
                    } else if (balanceAmount.compareTo(totalAmountTemp) <= 0) {
                        r.setAttribute("paymentAmount", balanceAmount);
                        totalAmountTemp = totalAmountTemp.subtract(balanceAmount);
                    }
                } else {
                    r.setAttribute("paymentAmount", null);

                }
            }

            if (totalAmountTemp.compareTo(BigDecimal.valueOf(0)) == 1) {
                OpenItemsRowImpl r = (OpenItemsRowImpl) rsi.first();
                r.setpaymentAmount(r.getBalAmt().add(totalAmountTemp));
            }
            rsi.closeRowSetIterator();*/
            if(null!=currentRow)
                vo.setCurrentRow(currentRow);
            Row firstRow = vo.first();
            //if single row in open items has payment amount then paying the payments is valid
            if(null!=firstRow && null!=firstRow.getAttribute("paymentAmount"))
                myPaymentProfileBean.setIndividualAmountIsNull(false);
            myPaymentProfileBean.setSelectAll(Boolean.FALSE);
            AdfFacesContext.getCurrentInstance().addPartialTarget(invoiceTableBinding);
        }
    }

    public void setInvoiceTableBinding(RichTable invoiceTableBinding) {
        this.invoiceTableBinding = invoiceTableBinding;
    }

    public RichTable getInvoiceTableBinding() {
        return invoiceTableBinding;
    }

    private Boolean checkIfAllIndividualAmountSNull() {

        BigDecimal total = new BigDecimal(0);
        DCIteratorBinding itr = ADFUtils.findIterator(OPEN_ITEMS_ITERATOR);
        ViewObject vo = itr.getViewObject();
        RowSetIterator rsi = vo.createRowSetIterator(null);
        Boolean isAllAmountNull = true;
        while (rsi.hasNext()) {
            Row r = rsi.next();
            BigDecimal paymentAmount = (BigDecimal) r.getAttribute("paymentAmount");
            if (paymentAmount != null) {
                isAllAmountNull = false;
                break;
            } else {
                isAllAmountNull = true;
            }
        }
        rsi.closeRowSetIterator();
        return isAllAmountNull;
    }

    private void updateTotalAmountToBePaid() {
        BigDecimal total = new BigDecimal(0);
        DCIteratorBinding itr = ADFUtils.findIterator(OPEN_ITEMS_ITERATOR);
        ViewObject vo = itr.getViewObject();
        RowSetIterator rsi = vo.createRowSetIterator(null);
        while (rsi.hasNext()) {
            Row r = rsi.next();
            BigDecimal paymentAmount = (BigDecimal) r.getAttribute("paymentAmount");
            if (paymentAmount != null) {
                total = total.add(paymentAmount);
            }
        }
        rsi.closeRowSetIterator();
        // totalPaymentAmount = total;
        myPaymentProfileBean.setIndividualAmountIsNull(false);
        myPaymentProfileBean.setTotalPaymentAmount(total);
    }

    public void selectedInvoiceValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        FacesCtrlHierNodeBinding tableBinding = (FacesCtrlHierNodeBinding) invoiceTableBinding.getSelectedRowData();
        OpenItemsRowImpl row = (OpenItemsRowImpl) tableBinding.getRow();
        if (valueChangeEvent.getNewValue() != null && Boolean.TRUE.equals((valueChangeEvent.getNewValue()))) {

            row.setpaymentAmount(row.getBalAmt());

        } else {

            System.out.println(row.getBalAmt());
            row.setpaymentAmount(null);

        }
        // updateTotalAmountToBePaid();
        myPaymentProfileBean.setIndividualAmountIsNull(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(invoiceTableBinding);
    }

    private void clearAllPaymentAmount() {
        DCIteratorBinding itr = ADFUtils.findIterator(OPEN_ITEMS_ITERATOR);
        ViewObject vo = itr.getViewObject();
        RowSetIterator rsi = vo.createRowSetIterator(null);
        while (rsi.hasNext()) {
            OpenItemsRowImpl row = (OpenItemsRowImpl) rsi.next();
            row.setselected(Boolean.FALSE);
            row.setpaymentAmount(null);
            //row.setselected(false);
        }
        rsi.closeRowSetIterator();
        myPaymentProfileBean.setSelectAll(Boolean.FALSE);
    }

    public void selectedAllTableValueChangeListener(ValueChangeEvent valueChangeEvent) {
        DCIteratorBinding itr = ADFUtils.findIterator(OPEN_ITEMS_ITERATOR);
        ViewObject vo = itr.getViewObject();
        RowSetIterator rsi = vo.createRowSetIterator(null);
        if (Boolean.TRUE.equals(valueChangeEvent.getNewValue())) {
            while (rsi.hasNext()) {
                OpenItemsRowImpl row = (OpenItemsRowImpl) rsi.next();
                row.setselected(Boolean.TRUE);
            }

            payAllActionListener(null);
        } else {
            while (rsi.hasNext()) {
                OpenItemsRowImpl row = (OpenItemsRowImpl) rsi.next();
                row.setselected(Boolean.FALSE);
                row.setpaymentAmount(null);
            }
            myPaymentProfileBean.setTotalPaymentAmount(null);
        }
        rsi.closeRowSetIterator();
        AdfFacesContext.getCurrentInstance().addPartialTarget(invoiceTableBinding);
    }

    public void setMyPaymentProfileBean(PaymentProfile myPaymentProfileBean) {
        this.myPaymentProfileBean = myPaymentProfileBean;
    }

    public PaymentProfile getMyPaymentProfileBean() {
        return myPaymentProfileBean;
    }

    public void payUsingThisProfile(ActionEvent actionEvent) {
        // Add event code here...
        // this.substriptionIdentifier = actionEvent.getComponent().getAttributes().get("profileId").toString();
        
        /* System.out.println("DEBUG 301");
        FacesCtrlHierNodeBinding tableBinding = (FacesCtrlHierNodeBinding) this.
        System.out.println("DEBUG 302");
        PaymentProfileViewObjectRowImpl row = (PaymentProfileViewObjectRowImpl) tableBinding.getRow();
        System.out.println("DEBUG 304");
        this.setPaymentProfileId(row.getProfileId());
        System.out.println("DEBUG 305" + this.getPaymentProfileId()); */
        
        String localProfileId = (String)ADFUtils.evaluateEL("#{bindings.ProfileId.inputValue}");
        
        Object profile = actionEvent.getComponent().getAttributes().get("profileId");
        OperationBinding op = ADFUtils.findOperation("setCurrentRowWithKey");
        op.getParamsMap().put("rowKey", profile);
        op.execute();
        //AdfFacesContext.getCurrentInstance().addPartialTarget(profileBinding);
        AdfFacesContext.getCurrentInstance().addPartialTarget(gridBinding);
        
        this.myPaymentProfileBean.setSelectedTokenValue(localProfileId);
        System.out.println("DEBUG 1126: " + localProfileId);
        
    }

    public String payUsingThisProfileAction() {
        if (checkIsOverPaymentAllowed()) {
            this.myPaymentProfileBean.setNoInvoicesSelected(checkIfNoInvoiceSelected());
            return "toConfirmPayment";
        } else {
            ADFUtils.showErrorMessage("Please apply overpayment to open item. Overpayment is only allowed if customer does not have open items.!");
            return "";
        }
    }

    public void setGridBinding(RichPanelGridLayout gridBinding) {
        this.gridBinding = gridBinding;
    }

    public RichPanelGridLayout getGridBinding() {
        return gridBinding;
    }

    public void toOpenInvoicesActionListener(ActionEvent actionEvent) {
        // Add event code here...
        this.getMyPaymentProfileBean().setShowPaymentProfiles(true);
        QueryModel queryModel = queryBinding.getModel();
        QueryDescriptor queryDescriptor = queryBinding.getValue();
        queryModel.reset(queryDescriptor);
        //        queryBinding.refresh(FacesContext.getCurrentInstance());
    }

    public void toPaymentProfileActionListener(ActionEvent actionEvent) {
        // Add event code here...
        this.getMyPaymentProfileBean().setShowPaymentProfiles(false);
        QueryModel queryModel = queryBinding.getModel();
        QueryDescriptor queryDescriptor = queryBinding.getValue();
        queryModel.reset(queryDescriptor);
        //        queryBinding.refresh(FacesContext.getCurrentInstance());
    }

    public void paymentAmountValueChangeListener(ValueChangeEvent valueChangeEvent) {
        //   updateTotalAmountToBePaid();

        Boolean isOverPaymentAllowed = true;
        myPaymentProfileBean.setIndividualAmountIsNull(false);
        FacesCtrlHierNodeBinding tableBinding = (FacesCtrlHierNodeBinding) invoiceTableBinding.getSelectedRowData();
        OpenItemsRowImpl row = (OpenItemsRowImpl) tableBinding.getRow();
        BigDecimal currnetRowBalanceAmount = row.getBalAmt();
        BigDecimal currnetRowPaymentAmount =
            (null != valueChangeEvent.getNewValue() && valueChangeEvent.getNewValue().toString().trim().length() > 0) ?
            (BigDecimal) valueChangeEvent.getNewValue() : null;
        String currentInvoice = row.getItem();

        DCIteratorBinding itr = ADFUtils.findIterator(OPEN_ITEMS_ITERATOR);
        ViewObject vo = itr.getViewObject();
        RowSetIterator rsi = vo.createRowSetIterator(null);
        if (itr.getEstimatedRowCount() > 0 && null != currnetRowPaymentAmount &&
            currnetRowPaymentAmount.compareTo(currnetRowBalanceAmount) == 1) {
            while (rsi.hasNext()) {
                OpenItemsRowImpl r = (OpenItemsRowImpl) rsi.next();
                if (!currentInvoice.equalsIgnoreCase(r.getItem())) {
                    BigDecimal balanceAmount = (BigDecimal) r.getAttribute("BalAmt");
                    BigDecimal paymentAmount = (BigDecimal) r.getAttribute("paymentAmount");
                    if (paymentAmount == null || paymentAmount.compareTo(balanceAmount) == -1) {
                        isOverPaymentAllowed = false;
                        break;
                    } else {
                        isOverPaymentAllowed = true;
                    }
                }
            }
            rsi.closeRowSetIterator();
        }
        if (!isOverPaymentAllowed) {
            ADFUtils.showErrorMessage("Please apply overpayment to open item. Overpayment is only allowed if customer does not have open items.");
        }
    }

    public void totalAmountValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if (valueChangeEvent.getNewValue() != null && checkIfAllIndividualAmountSNull()) {
            myPaymentProfileBean.setIndividualAmountIsNull(true);

        } else {
            clearAllPaymentAmount();
            AdfFacesContext.getCurrentInstance().addPartialTarget(invoiceTableBinding);
        }

    }

    public void resetTableSort(RichTable tableComponent, String iteratorName) {
        BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding iter = (DCIteratorBinding) bindings.get(iteratorName);

        tableComponent.queueEvent(new SortEvent(tableComponent, SortEvent.SortType.COLUMN,
                                                new HashMap<String, Object>()));
        /*Key currentRow = null;
        Row row = iter.getCurrentRow();
        if (row != null) {
            currentRow = row.getKey();
        }*/
        oracle.jbo.SortCriteria[] sc = new SortCriteria[0];
        iter.applySortCriteria(sc);
        iter.executeQuery();
        /*if (currentRow != null) {
            iter.setCurrentRowWithKey(currentRow.toStringFormat(true));
        }*/
    }

    private Boolean checkIfNoInvoiceSelected() {
        Boolean checkInvoiceSelected = true;
        DCIteratorBinding itr = ADFUtils.findIterator(OPEN_ITEMS_ITERATOR);
        if (itr.getEstimatedRowCount() > 0) {
            ViewObject vo = itr.getViewObject();
            RowSetIterator rsi = vo.createRowSetIterator(null);
            while (rsi.hasNext()) {
                OpenItemsRowImpl r = (OpenItemsRowImpl) rsi.next();
                BigDecimal paymentAmount = (BigDecimal) r.getAttribute("paymentAmount");
                if (paymentAmount != null &&
                    this.myPaymentProfileBean.getTotalPaymentAmount().compareTo(new BigDecimal(0)) == 1) {
                    checkInvoiceSelected = false;
                    break;
                }
            }
            rsi.closeRowSetIterator();
        }
        return checkInvoiceSelected;
    }
    //
    //    public void sortListener(org.apache.myfaces.trinidad.event.SortEvent sortEvent) {
    //        // Add event code here...
    //        DCIteratorBinding itr = ADFUtils.findIterator(OPEN_ITEMS_ITERATOR);
    //        ViewObject vo = itr.getViewObject();
    //        vo.setSortBy("DueDt desc");
    //        vo.setQueryMode(ViewObject.QUERY_MODE_SCAN_VIEW_ROWS);
    //        vo.executeQuery();
    //    }
    public String chargeAction() {
        if ((myPaymentProfileBean.getTotalPaymentAmount() != null &&
             myPaymentProfileBean.getTotalPaymentAmount().compareTo(BigDecimal.valueOf(0)) > 0)) {

            if (checkIsOverPaymentAllowed()) {

                this.myPaymentProfileBean.setNoInvoicesSelected(checkIfNoInvoiceSelected());
                return "toConfirmPayment";
            } else {
                ADFUtils.showErrorMessage("Please apply overpayment to open item. Overpayment is only allowed if customer does not have open items.!");
                return "";
            }
        } else {
            ADFUtils.showErrorMessage("Please enter amount greater than 0");
            return "";
        }
    }

    public void returnToHomeActionListener(ActionEvent actionEvent) {
        // Add event code here...
        resetAndRollBackChanges();
    }

    public void returnToInvoiceList(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.executeOperationBinding("Rollback");
    }

    public void cancelActionListener(ActionEvent actionEvent) {
        // Add event code here...
        myPaymentProfileBean.setTotalPaymentAmount(new BigDecimal(0));
        resetAndRollBackChanges();
    }

    public void resetAndRollBackChanges() {

        DCIteratorBinding itr = ADFUtils.findIterator("CustomerView2Iterator");
        ViewObject object = itr.getViewObject();
        object.executeEmptyRowSet();
        ADFUtils.executeOperationBinding("Rollback");


    }

    public void setQueryBinding(RichQuery queryBinding) {
        this.queryBinding = queryBinding;
    }

    public RichQuery getQueryBinding() {
        return queryBinding;
    }

    public String onAccountAction() {
        this.myPaymentProfileBean.setNoInvoicesSelected(checkIfNoInvoiceSelected());
        
        DCBindingContainer bindings = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        oracle.binding.OperationBinding operationBinding = bindings.getOperationBinding("getSequenceNextVal");
        if (null != operationBinding)
            this.myPaymentProfileBean.setPsPendingItemSeq("OA-"+(String)operationBinding.execute());
        
        oracle.binding.OperationBinding operationBinding1 = bindings.getOperationBinding("getSalesPerson");
        if (null != operationBinding1)
            this.myPaymentProfileBean.setNewItemSalesPerson((String)operationBinding1.execute());
        
        oracle.binding.OperationBinding operationBinding2 = bindings.getOperationBinding("getCollector");
        if (null != operationBinding2)
            this.myPaymentProfileBean.setNewItemCollector((String)operationBinding2.execute());
        
        return "toConfirmPayment";
    }
    

    public boolean isChargeDisable() {
        BigDecimal totalBalAmount = new BigDecimal(0);
        DCIteratorBinding itr = ADFUtils.findIterator(OPEN_ITEMS_ITERATOR);
        ViewObject vo = itr.getViewObject();
        if (vo.getEstimatedRowCount() <= 0)
            return true;
        else {
            RowSetIterator rsi = vo.createRowSetIterator(null);
            while (rsi.hasNext()) {
                OpenItemsRowImpl row = (OpenItemsRowImpl) rsi.next();
                totalBalAmount = totalBalAmount.add(row.getBalAmt());
            }
            rsi.closeRowSetIterator();
            if(totalBalAmount.compareTo(BigDecimal.valueOf(0)) <= 0)
                return true;
        }
        return false;
    }
    
    public boolean isPayButtonDisable() {
        DCIteratorBinding itr = ADFUtils.findIterator(OPEN_ITEMS_ITERATOR);
        ViewObject vo = itr.getViewObject();
        if (vo.getEstimatedRowCount() == 1){
            OpenItemsRowImpl firstRow = (OpenItemsRowImpl) vo.first();
            if(null!=firstRow && null!=firstRow.getBalAmt()){
                BigDecimal balAmount = firstRow.getBalAmt();
                if(balAmount.compareTo(BigDecimal.valueOf(0))==-1)
                    return true;
            }
        }
        return false;
    }

}
