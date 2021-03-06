
package com.cybersource.schemas.transaction_data_1;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DirectDebitReply complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DirectDebitReply"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="reasonCode" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="amount" type="{urn:schemas-cybersource-com:transaction-data-1.137}amount" minOccurs="0"/&gt;
 *         &lt;element name="requestDateTime" type="{urn:schemas-cybersource-com:transaction-data-1.137}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="reconciliationID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="processorResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="processorTransactionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="mandateAuthenticationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="mandateID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="iban" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reconciliationReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DirectDebitReply", propOrder = {
         "reasonCode", "amount", "requestDateTime", "reconciliationID", "processorResponse", "processorTransactionID",
         "mandateAuthenticationDate", "mandateID", "iban", "reconciliationReferenceNumber"
    })
public class DirectDebitReply {

    @XmlElement(required = true)
    protected BigInteger reasonCode;
    protected String amount;
    protected String requestDateTime;
    protected String reconciliationID;
    protected String processorResponse;
    protected String processorTransactionID;
    protected String mandateAuthenticationDate;
    protected String mandateID;
    protected String iban;
    protected String reconciliationReferenceNumber;

    /**
     * Gets the value of the reasonCode property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getReasonCode() {
        return reasonCode;
    }

    /**
     * Sets the value of the reasonCode property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setReasonCode(BigInteger value) {
        this.reasonCode = value;
    }

    /**
     * Gets the value of the amount property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAmount(String value) {
        this.amount = value;
    }

    /**
     * Gets the value of the requestDateTime property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRequestDateTime() {
        return requestDateTime;
    }

    /**
     * Sets the value of the requestDateTime property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRequestDateTime(String value) {
        this.requestDateTime = value;
    }

    /**
     * Gets the value of the reconciliationID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReconciliationID() {
        return reconciliationID;
    }

    /**
     * Sets the value of the reconciliationID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReconciliationID(String value) {
        this.reconciliationID = value;
    }

    /**
     * Gets the value of the processorResponse property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getProcessorResponse() {
        return processorResponse;
    }

    /**
     * Sets the value of the processorResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setProcessorResponse(String value) {
        this.processorResponse = value;
    }

    /**
     * Gets the value of the processorTransactionID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getProcessorTransactionID() {
        return processorTransactionID;
    }

    /**
     * Sets the value of the processorTransactionID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setProcessorTransactionID(String value) {
        this.processorTransactionID = value;
    }

    /**
     * Gets the value of the mandateAuthenticationDate property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMandateAuthenticationDate() {
        return mandateAuthenticationDate;
    }

    /**
     * Sets the value of the mandateAuthenticationDate property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMandateAuthenticationDate(String value) {
        this.mandateAuthenticationDate = value;
    }

    /**
     * Gets the value of the mandateID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMandateID() {
        return mandateID;
    }

    /**
     * Sets the value of the mandateID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMandateID(String value) {
        this.mandateID = value;
    }

    /**
     * Gets the value of the iban property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIban() {
        return iban;
    }

    /**
     * Sets the value of the iban property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIban(String value) {
        this.iban = value;
    }

    /**
     * Gets the value of the reconciliationReferenceNumber property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReconciliationReferenceNumber() {
        return reconciliationReferenceNumber;
    }

    /**
     * Sets the value of the reconciliationReferenceNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReconciliationReferenceNumber(String value) {
        this.reconciliationReferenceNumber = value;
    }

}
