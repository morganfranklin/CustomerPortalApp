
package com.cybersource.schemas.transaction_data_1;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CCAuthReversalReply complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CCAuthReversalReply"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="reasonCode" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="amount" type="{urn:schemas-cybersource-com:transaction-data-1.137}amount" minOccurs="0"/&gt;
 *         &lt;element name="authorizationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="processorResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="requestDateTime" type="{urn:schemas-cybersource-com:transaction-data-1.137}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="forwardCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reconciliationID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="processorTransactionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paymentCardService" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paymentCardServiceResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CCAuthReversalReply", propOrder = {
         "reasonCode", "amount", "authorizationCode", "processorResponse", "requestDateTime", "forwardCode",
         "reconciliationID", "processorTransactionID", "paymentCardService", "paymentCardServiceResult"
    })
public class CCAuthReversalReply {

    @XmlElement(required = true)
    protected BigInteger reasonCode;
    protected String amount;
    protected String authorizationCode;
    protected String processorResponse;
    protected String requestDateTime;
    protected String forwardCode;
    protected String reconciliationID;
    protected String processorTransactionID;
    protected String paymentCardService;
    protected String paymentCardServiceResult;

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
     * Gets the value of the authorizationCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAuthorizationCode() {
        return authorizationCode;
    }

    /**
     * Sets the value of the authorizationCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAuthorizationCode(String value) {
        this.authorizationCode = value;
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
     * Gets the value of the forwardCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getForwardCode() {
        return forwardCode;
    }

    /**
     * Sets the value of the forwardCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setForwardCode(String value) {
        this.forwardCode = value;
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
     * Gets the value of the paymentCardService property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPaymentCardService() {
        return paymentCardService;
    }

    /**
     * Sets the value of the paymentCardService property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPaymentCardService(String value) {
        this.paymentCardService = value;
    }

    /**
     * Gets the value of the paymentCardServiceResult property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPaymentCardServiceResult() {
        return paymentCardServiceResult;
    }

    /**
     * Sets the value of the paymentCardServiceResult property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPaymentCardServiceResult(String value) {
        this.paymentCardServiceResult = value;
    }

}
