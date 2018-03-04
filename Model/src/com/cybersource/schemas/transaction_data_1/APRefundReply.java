
package com.cybersource.schemas.transaction_data_1;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for APRefundReply complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="APRefundReply"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="reasonCode" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="transactionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="processorResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="amount" type="{urn:schemas-cybersource-com:transaction-data-1.137}amount" minOccurs="0"/&gt;
 *         &lt;element name="dateTime" type="{urn:schemas-cybersource-com:transaction-data-1.137}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="reconciliationID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="returnRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="providerResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="processorTransactionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paymentStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="responseCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="amountToPayer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="processorTransactionFeeRefunded" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="amountFromMerchant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="totalRefundAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="externalFundingAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="amountFromOriginalRecipient" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cumulativeAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APRefundReply", propOrder = {
         "reasonCode", "transactionID", "status", "processorResponse", "amount", "dateTime", "reconciliationID",
         "returnRef", "providerResponse", "processorTransactionID", "paymentStatus", "responseCode", "amountToPayer",
         "processorTransactionFeeRefunded", "amountFromMerchant", "totalRefundAmount", "externalFundingAmount",
         "amountFromOriginalRecipient", "cumulativeAmount"
    })
public class APRefundReply {

    @XmlElement(required = true)
    protected BigInteger reasonCode;
    protected String transactionID;
    protected String status;
    protected String processorResponse;
    protected String amount;
    protected String dateTime;
    protected String reconciliationID;
    protected String returnRef;
    protected String providerResponse;
    protected String processorTransactionID;
    protected String paymentStatus;
    protected String responseCode;
    protected String amountToPayer;
    protected String processorTransactionFeeRefunded;
    protected String amountFromMerchant;
    protected String totalRefundAmount;
    protected String externalFundingAmount;
    protected String amountFromOriginalRecipient;
    protected String cumulativeAmount;

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
     * Gets the value of the transactionID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTransactionID() {
        return transactionID;
    }

    /**
     * Sets the value of the transactionID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTransactionID(String value) {
        this.transactionID = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStatus(String value) {
        this.status = value;
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
     * Gets the value of the dateTime property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * Sets the value of the dateTime property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDateTime(String value) {
        this.dateTime = value;
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
     * Gets the value of the returnRef property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReturnRef() {
        return returnRef;
    }

    /**
     * Sets the value of the returnRef property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReturnRef(String value) {
        this.returnRef = value;
    }

    /**
     * Gets the value of the providerResponse property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getProviderResponse() {
        return providerResponse;
    }

    /**
     * Sets the value of the providerResponse property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setProviderResponse(String value) {
        this.providerResponse = value;
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
     * Gets the value of the paymentStatus property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * Sets the value of the paymentStatus property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPaymentStatus(String value) {
        this.paymentStatus = value;
    }

    /**
     * Gets the value of the responseCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the value of the responseCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setResponseCode(String value) {
        this.responseCode = value;
    }

    /**
     * Gets the value of the amountToPayer property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAmountToPayer() {
        return amountToPayer;
    }

    /**
     * Sets the value of the amountToPayer property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAmountToPayer(String value) {
        this.amountToPayer = value;
    }

    /**
     * Gets the value of the processorTransactionFeeRefunded property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getProcessorTransactionFeeRefunded() {
        return processorTransactionFeeRefunded;
    }

    /**
     * Sets the value of the processorTransactionFeeRefunded property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setProcessorTransactionFeeRefunded(String value) {
        this.processorTransactionFeeRefunded = value;
    }

    /**
     * Gets the value of the amountFromMerchant property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAmountFromMerchant() {
        return amountFromMerchant;
    }

    /**
     * Sets the value of the amountFromMerchant property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAmountFromMerchant(String value) {
        this.amountFromMerchant = value;
    }

    /**
     * Gets the value of the totalRefundAmount property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTotalRefundAmount() {
        return totalRefundAmount;
    }

    /**
     * Sets the value of the totalRefundAmount property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTotalRefundAmount(String value) {
        this.totalRefundAmount = value;
    }

    /**
     * Gets the value of the externalFundingAmount property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getExternalFundingAmount() {
        return externalFundingAmount;
    }

    /**
     * Sets the value of the externalFundingAmount property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setExternalFundingAmount(String value) {
        this.externalFundingAmount = value;
    }

    /**
     * Gets the value of the amountFromOriginalRecipient property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAmountFromOriginalRecipient() {
        return amountFromOriginalRecipient;
    }

    /**
     * Sets the value of the amountFromOriginalRecipient property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAmountFromOriginalRecipient(String value) {
        this.amountFromOriginalRecipient = value;
    }

    /**
     * Gets the value of the cumulativeAmount property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCumulativeAmount() {
        return cumulativeAmount;
    }

    /**
     * Sets the value of the cumulativeAmount property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCumulativeAmount(String value) {
        this.cumulativeAmount = value;
    }

}
