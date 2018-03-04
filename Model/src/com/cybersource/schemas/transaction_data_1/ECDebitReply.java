
package com.cybersource.schemas.transaction_data_1;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ECDebitReply complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ECDebitReply"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="reasonCode" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="settlementMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="requestDateTime" type="{urn:schemas-cybersource-com:transaction-data-1.137}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="amount" type="{urn:schemas-cybersource-com:transaction-data-1.137}amount" minOccurs="0"/&gt;
 *         &lt;element name="verificationLevel" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="processorTransactionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reconciliationID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="processorResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="avsCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="avsCodeRaw" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="verificationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="verificationCodeRaw" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="correctedAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="correctedRoutingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ownerMerchantID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ECDebitReply", propOrder = {
         "reasonCode", "settlementMethod", "requestDateTime", "amount", "verificationLevel", "processorTransactionID",
         "reconciliationID", "processorResponse", "avsCode", "avsCodeRaw", "verificationCode", "verificationCodeRaw",
         "correctedAccountNumber", "correctedRoutingNumber", "ownerMerchantID"
    })
public class ECDebitReply {

    @XmlElement(required = true)
    protected BigInteger reasonCode;
    protected String settlementMethod;
    protected String requestDateTime;
    protected String amount;
    protected BigInteger verificationLevel;
    protected String processorTransactionID;
    protected String reconciliationID;
    protected String processorResponse;
    protected String avsCode;
    protected String avsCodeRaw;
    protected String verificationCode;
    protected String verificationCodeRaw;
    protected String correctedAccountNumber;
    protected String correctedRoutingNumber;
    protected String ownerMerchantID;

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
     * Gets the value of the settlementMethod property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSettlementMethod() {
        return settlementMethod;
    }

    /**
     * Sets the value of the settlementMethod property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSettlementMethod(String value) {
        this.settlementMethod = value;
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
     * Gets the value of the verificationLevel property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getVerificationLevel() {
        return verificationLevel;
    }

    /**
     * Sets the value of the verificationLevel property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setVerificationLevel(BigInteger value) {
        this.verificationLevel = value;
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
     * Gets the value of the avsCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAvsCode() {
        return avsCode;
    }

    /**
     * Sets the value of the avsCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAvsCode(String value) {
        this.avsCode = value;
    }

    /**
     * Gets the value of the avsCodeRaw property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAvsCodeRaw() {
        return avsCodeRaw;
    }

    /**
     * Sets the value of the avsCodeRaw property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAvsCodeRaw(String value) {
        this.avsCodeRaw = value;
    }

    /**
     * Gets the value of the verificationCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVerificationCode() {
        return verificationCode;
    }

    /**
     * Sets the value of the verificationCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVerificationCode(String value) {
        this.verificationCode = value;
    }

    /**
     * Gets the value of the verificationCodeRaw property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVerificationCodeRaw() {
        return verificationCodeRaw;
    }

    /**
     * Sets the value of the verificationCodeRaw property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVerificationCodeRaw(String value) {
        this.verificationCodeRaw = value;
    }

    /**
     * Gets the value of the correctedAccountNumber property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCorrectedAccountNumber() {
        return correctedAccountNumber;
    }

    /**
     * Sets the value of the correctedAccountNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCorrectedAccountNumber(String value) {
        this.correctedAccountNumber = value;
    }

    /**
     * Gets the value of the correctedRoutingNumber property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCorrectedRoutingNumber() {
        return correctedRoutingNumber;
    }

    /**
     * Sets the value of the correctedRoutingNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCorrectedRoutingNumber(String value) {
        this.correctedRoutingNumber = value;
    }

    /**
     * Gets the value of the ownerMerchantID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOwnerMerchantID() {
        return ownerMerchantID;
    }

    /**
     * Sets the value of the ownerMerchantID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOwnerMerchantID(String value) {
        this.ownerMerchantID = value;
    }

}
