package model;

import java.sql.ResultSet;

import java.util.ArrayList;

import oracle.adf.model.binding.DCIteratorBinding;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.server.SQLBuilder;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.server.ViewRowSetImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed May 17 11:13:06 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PaymentProfileViewObjectImpl extends ViewObjectImpl {
    private ArrayList<PaymentProfileEntry> myList = new ArrayList<PaymentProfileEntry>();

    @Override
    public void prepareRowSetForQuery(ViewRowSetImpl viewRowSetImpl) {

        RowSetIterator[] masterRows = viewRowSetImpl.getMasterRowSetIterators();

        if (masterRows == null) {
            System.out.println("master rows null");
        } else {
            if (masterRows.length <= 0) {
                System.out.println("master rows length zero or negative");
            } else {
                if (masterRows[0].getCurrentRow() == null) {
                    System.out.println("master rows current row null");
                } else {
                    if (masterRows[0].getCurrentRow().getAttribute("CustId") == null) {
                        System.out.println("no deal number attribute");
                    } else {
                        String managerId = (String) masterRows[0].getCurrentRow().getAttribute("CustId");
                        viewRowSetImpl.ensureVariableManager().setVariableValue("BindCustomerId", managerId);
                    }
                }
            }
        }

        super.prepareRowSetForQuery(viewRowSetImpl);

    }


    /**
     * This is the default constructor (do not remove).
     */
    public PaymentProfileViewObjectImpl() {
    }

    /**
     * Method to set the new fetch index
     * @param rowset
     * @param index
     */
    private void setFetchIndex(Object rowset, int index) {
        if (index == myList.size()) {
            setFetchCompleteForCollection(rowset, true);
        }
        setUserDataForCollection(rowset, new Integer(index));
    }

    /**
     * Method to get the current fetch index
     * @param rowset
     * @return
     *
     */
    private int getFetchIndex(Object rowset) {
        int value = ((Integer) getUserDataForCollection(rowset)).intValue();
        return value;
    }

    private Object getParamValue(String varName, Object[] params) {

        if (getBindingStyle() == SQLBuilder.BINDING_STYLE_ORACLE_NAME) {
            if (params != null) {
                for (Object param : params) {
                    Object[] nameValue = (Object[]) param;
                    String name = (String) nameValue[0];
                    if (name.equals(varName)) {
                        // return nameValue[1];
                        // name = (String) nameValue[1];
                        return (String) nameValue[1];
                    }
                }
            }
        }
        throw new JboException("No bind variable named '" + varName + "'");
    }

    /**
     * executeQueryForCollection - for custom java data source support.
     */
    @Override
    protected void executeQueryForCollection(Object qc, Object[] params, int noUserParams) {

        String passedParameter = "unknown";

        passedParameter = (String) getParamValue("BindCustomerId", params);

        // myList.clear();

        // Prashant: placeholder below, please replace by creating a new class that is Cybersource adapter, that will
        // call Cybersource web service and populate the myList array with retrieved payment profiles
        //      myList.add(new PaymentProfileEntry("test profile " + noUserParams, passedParameter, "","","",""));

        // target implementation
        CyberSourceAdapter localAdapter = new CyberSourceAdapter();
        localAdapter.populateCreditCardProfilesArray(myList, passedParameter);

        setFetchIndex(qc, 0);

        super.executeQueryForCollection(qc, params, noUserParams);

    }

    /**
     * hasNextForCollection - for custom java data source support.
     */
    @Override
    protected boolean hasNextForCollection(Object qc) {
        return getFetchIndex(qc) < myList.size();
    }

    /**
     * createRowFromResultSet - for custom java data source support.
     */
    @Override
    protected ViewRowImpl createRowFromResultSet(Object qc, ResultSet resultSet) {
        int curIndex = getFetchIndex(qc);
        PaymentProfileViewObjectRowImpl currentRow = (PaymentProfileViewObjectRowImpl) createNewRowForCollection(qc);
        currentRow.setProfileId(myList.get(curIndex).getPaymentProfileId());
        currentRow.setCustomerId(myList.get(curIndex).getCustomerId());
        currentRow.setProfileToken(myList.get(curIndex).getPaymentProfileId());
        currentRow.setProfileName(myList.get(curIndex).getProfileName());
        currentRow.setProfileAccountNumber(myList.get(curIndex).getProfileAccount());
        currentRow.setProfileExpiry(myList.get(curIndex).getExpiryDate());
        currentRow.setProfileMethod(myList.get(curIndex).getProfilePayMethod());
        currentRow.setemail(myList.get(curIndex).getEmail());
        setFetchIndex(qc, curIndex + 1);
        return currentRow;
    }

    /**
     * getQueryHitCount - for custom java data source support.
     */
    @Override
    public long getQueryHitCount(ViewRowSetImpl viewRowSet) {
        long value = super.getQueryHitCount(viewRowSet);
        return value;
    }

    /**
     * getCappedQueryHitCount - for custom java data source support.
     */
    @Override
    public long getCappedQueryHitCount(ViewRowSetImpl viewRowSet, Row[] masterRows, long oldCap, long cap) {
        long value = super.getCappedQueryHitCount(viewRowSet, masterRows, oldCap, cap);
        return value;
    }

    /**
     * Returns the variable value for BindCustomerId.
     * @return variable value for BindCustomerId
     */
    public String getBindCustomerId() {
        return (String) ensureVariableManager().getVariableValue("BindCustomerId");
    }

    /**
     * Sets <code>value</code> for variable BindCustomerId.
     * @param value value to bind as BindCustomerId
     */
    public void setBindCustomerId(String value) {
        ensureVariableManager().setVariableValue("BindCustomerId", value);
    }
}

