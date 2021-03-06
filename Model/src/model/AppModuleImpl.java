package model;

import java.math.BigDecimal;

import model.common.AppModule;

import model.readonly.CollectorROVOImpl;
import model.readonly.CollectorROVORowImpl;
import model.readonly.OpenItemsROVOImpl;
import model.readonly.OpenItemsROVORowImpl;
import model.readonly.SalesPersonROVOImpl;
import model.readonly.SalesPersonROVORowImpl;

import oracle.adf.share.logging.ADFLogger;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.SequenceImpl;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Jun 02 08:28:45 IST 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AppModuleImpl extends ApplicationModuleImpl implements AppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public AppModuleImpl() {
    }
    
    private static ADFLogger _logger = ADFLogger.createADFLogger(AppModuleImpl.class);

    /**
     * Container's getter for CustomerView2.
     * @return CustomerView2
     */
    public CustomerViewImpl getCustomerView2() {
        return (CustomerViewImpl) findViewObject("CustomerView2");
    }

    /**
     * Container's getter for PaymentProfileViewObject2.
     * @return PaymentProfileViewObject2
     */
    public PaymentProfileViewObjectImpl getPaymentProfileViewObject2() {
        return (PaymentProfileViewObjectImpl) findViewObject("PaymentProfileViewObject2");
    }


    /**
     * Container's getter for LookupHelper1.
     * @return LookupHelper1
     */
    public ViewObjectImpl getLookupHelper1() {
        return (ViewObjectImpl) findViewObject("LookupHelper1");
    }

    /**
     * Container's getter for LovMonths1.
     * @return LovMonths1
     */
    public ViewObjectImpl getLovMonths1() {
        return (ViewObjectImpl) findViewObject("LovMonths1");
    }

    /**
     * Container's getter for LovYears1.
     * @return LovYears1
     */
    public ViewObjectImpl getLovYears1() {
        return (ViewObjectImpl) findViewObject("LovYears1");
    }

    /**
     * Container's getter for LovCountries1.
     * @return LovCountries1
     */
    public ViewObjectImpl getLovCountries1() {
        return (ViewObjectImpl) findViewObject("LovCountries1");
    }

    /**
     * Container's getter for Customer2ProfileViewLink.
     * @return Customer2ProfileViewLink
     */
    public ViewLinkImpl getCustomer2ProfileViewLink() {
        return (ViewLinkImpl) findViewLink("Customer2ProfileViewLink");
    }

    /**
     * Container's getter for OpenItems1.
     * @return OpenItems1
     */
    public OpenItemsImpl getOpenItems1() {
        return (OpenItemsImpl) findViewObject("OpenItems1");
    }

    /**
     * Container's getter for Customer2OpenItemsViewLink1.
     * @return Customer2OpenItemsViewLink1
     */
    public ViewLinkImpl getCustomer2OpenItemsViewLink1() {
        return (ViewLinkImpl) findViewLink("Customer2OpenItemsViewLink1");
    }

    /**
     * Container's getter for OpenItems2.
     * @return OpenItems2
     */
    public OpenItemsImpl getOpenItems2() {
        return (OpenItemsImpl) findViewObject("OpenItems2");
    }
    
    public String getSequenceNextVal(String sequenceName) {
        SequenceImpl s = new SequenceImpl(sequenceName, getDBTransaction());
        return s.getSequenceNumber().toString();
    }
    
    public String getSalesPerson(String custId){
        String salesPerson = null;
        SalesPersonROVOImpl salesPersonROVO = this.getSalesPersonROVO1();
        salesPersonROVO.executeEmptyRowSet();
        salesPersonROVO.setbind_CustId(custId);
        salesPersonROVO.executeQuery();
        SalesPersonROVORowImpl salesPersonROVORow = (SalesPersonROVORowImpl)salesPersonROVO.first();
        if(null!=salesPersonROVORow)
            salesPerson = salesPersonROVORow.getSupportTeamMbr();
        return salesPerson;
    }
    
    public String getCollector(String custId){
        String collector = null;
        CollectorROVOImpl collectorROVO = this.getCollectorROVO1();
        collectorROVO.executeEmptyRowSet();
        collectorROVO.setbind_CustId(custId);
        collectorROVO.executeQuery();
        CollectorROVORowImpl collectorROVORow = (CollectorROVORowImpl)collectorROVO.first();
        if(null!=collectorROVORow)
            collector = collectorROVORow.getCollector();
        return collector;
    }

    /**
     * Container's getter for CollectorROVO1.
     * @return CollectorROVO1
     */
    public CollectorROVOImpl getCollectorROVO1() {
        return (CollectorROVOImpl) findViewObject("CollectorROVO1");
    }

    /**
     * Container's getter for SalesPersonROVO1.
     * @return SalesPersonROVO1
     */
    public SalesPersonROVOImpl getSalesPersonROVO1() {
        return (SalesPersonROVOImpl) findViewObject("SalesPersonROVO1");
    }

    /**
     * Container's getter for OpenItemsROVO1.
     * @return OpenItemsROVO1
     */
    public OpenItemsROVOImpl getOpenItemsROVO() {
        return (OpenItemsROVOImpl) findViewObject("OpenItemsROVO");
    }
    
    public void applyAgainstOldest(String custId, BigDecimal totalAmountTemp){
        System.err.println("applyAgainstOldest: "+custId);
        System.err.println("applyAgainstOldest: "+totalAmountTemp);
        OpenItemsROVOImpl openItemsROVO = this.getOpenItemsROVO();
        openItemsROVO.executeEmptyRowSet();
        openItemsROVO.setbind_CustId(custId);
        openItemsROVO.executeQuery();
        CustomerViewRowImpl customerViewRow = (CustomerViewRowImpl)this.getCustomerView2().getCurrentRow();
        RowSetIterator openItemsIterator = openItemsROVO.createRowSetIterator(null);
        while(openItemsIterator.hasNext()){
            OpenItemsROVORowImpl openItemsROVORow = (OpenItemsROVORowImpl)openItemsIterator.next();
            String item = openItemsROVORow.getItem();
            System.err.println("applyAgainstOldest: "+item);
            Key key = new Key(new Object[] { custId.trim(),item.trim() });
            System.err.println("applyAgainstOldest Key: "+key);
            Row[] openItems = null;
            if(null!=key)
                openItems = customerViewRow.getOpenItems().findByKey(key, 1);
            if(null!=openItems && openItems.length>0){
                System.err.println("applyAgainstOldest openItems length: "+openItems.length);
                OpenItemsRowImpl openItemsRow =(OpenItemsRowImpl)openItems[0];
                openItemsRow.setselected(Boolean.FALSE);
                openItemsRow.setpaymentAmount(null);
                BigDecimal balanceAmount = openItemsRow.getBalAmt();
                System.out.println(balanceAmount.compareTo(totalAmountTemp));
                if (totalAmountTemp.compareTo(BigDecimal.valueOf(0)) == 1) {
                    System.err.println("applyAgainstOldest totalAmountTemp: "+totalAmountTemp);
                    if (balanceAmount.compareTo(totalAmountTemp) > 0) {
                        openItemsRow.setpaymentAmount(totalAmountTemp);
                        totalAmountTemp = totalAmountTemp.subtract(balanceAmount);
                    } else if (balanceAmount.compareTo(totalAmountTemp) <= 0) {
                        openItemsRow.setpaymentAmount(balanceAmount);
                        totalAmountTemp = totalAmountTemp.subtract(balanceAmount);
                    }
                } else {
                    openItemsRow.setpaymentAmount(null);
                }
            }
        }
        openItemsIterator.closeRowSetIterator();
        
        if (totalAmountTemp.compareTo(BigDecimal.valueOf(0)) == 1) {
            OpenItemsROVORowImpl openItemsROVORow = (OpenItemsROVORowImpl)openItemsROVO.last();
            String item = openItemsROVORow.getItem();
            Key key = new Key(new Object[] { custId.trim(),item.trim() });
            Row[] openItems = null;
            if(null!=key)
                openItems = customerViewRow.getOpenItems().findByKey(key, 1);
            if(null!=openItems && openItems.length>0){
                OpenItemsRowImpl openItemsRow =(OpenItemsRowImpl)openItems[0];
                openItemsRow.setpaymentAmount(openItemsRow.getBalAmt().add(totalAmountTemp));
            }
        }
    }
}

