package model.readonly;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Mar 01 23:37:44 CST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SalesPersonROVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public SalesPersonROVOImpl() {
    }

    /**
     * Returns the bind variable value for bind_CustId.
     * @return bind variable value for bind_CustId
     */
    public String getbind_CustId() {
        return (String) getNamedWhereClauseParam("bind_CustId");
    }

    /**
     * Sets <code>value</code> for bind variable bind_CustId.
     * @param value value to bind as bind_CustId
     */
    public void setbind_CustId(String value) {
        setNamedWhereClauseParam("bind_CustId", value);
    }
}

