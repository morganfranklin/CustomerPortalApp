
package com.cybersource.schemas.transaction_data_1;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Pos complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Pos"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="entryMode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cardPresent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="terminalCapability" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="trackData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="terminalID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="terminalType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="terminalLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="transactionSecurity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="catLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="conditionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="environment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paymentData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="deviceReaderData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="encryptionAlgorithm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="encodingMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="deviceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="serviceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="terminalIDAlternate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="terminalCompliance" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Pos", propOrder = {
         "entryMode", "cardPresent", "terminalCapability", "trackData", "terminalID", "terminalType",
         "terminalLocation", "transactionSecurity", "catLevel", "conditionCode", "environment", "paymentData",
         "deviceReaderData", "encryptionAlgorithm", "encodingMethod", "deviceID", "serviceCode", "terminalIDAlternate",
         "terminalCompliance"
    })
public class Pos {

    protected String entryMode;
    protected String cardPresent;
    protected String terminalCapability;
    protected String trackData;
    protected String terminalID;
    protected String terminalType;
    protected String terminalLocation;
    protected String transactionSecurity;
    protected String catLevel;
    protected String conditionCode;
    protected String environment;
    protected String paymentData;
    protected String deviceReaderData;
    protected String encryptionAlgorithm;
    protected String encodingMethod;
    protected String deviceID;
    protected String serviceCode;
    protected String terminalIDAlternate;
    protected BigInteger terminalCompliance;

    /**
     * Gets the value of the entryMode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEntryMode() {
        return entryMode;
    }

    /**
     * Sets the value of the entryMode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEntryMode(String value) {
        this.entryMode = value;
    }

    /**
     * Gets the value of the cardPresent property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCardPresent() {
        return cardPresent;
    }

    /**
     * Sets the value of the cardPresent property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCardPresent(String value) {
        this.cardPresent = value;
    }

    /**
     * Gets the value of the terminalCapability property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTerminalCapability() {
        return terminalCapability;
    }

    /**
     * Sets the value of the terminalCapability property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTerminalCapability(String value) {
        this.terminalCapability = value;
    }

    /**
     * Gets the value of the trackData property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTrackData() {
        return trackData;
    }

    /**
     * Sets the value of the trackData property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTrackData(String value) {
        this.trackData = value;
    }

    /**
     * Gets the value of the terminalID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTerminalID() {
        return terminalID;
    }

    /**
     * Sets the value of the terminalID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTerminalID(String value) {
        this.terminalID = value;
    }

    /**
     * Gets the value of the terminalType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTerminalType() {
        return terminalType;
    }

    /**
     * Sets the value of the terminalType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTerminalType(String value) {
        this.terminalType = value;
    }

    /**
     * Gets the value of the terminalLocation property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTerminalLocation() {
        return terminalLocation;
    }

    /**
     * Sets the value of the terminalLocation property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTerminalLocation(String value) {
        this.terminalLocation = value;
    }

    /**
     * Gets the value of the transactionSecurity property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTransactionSecurity() {
        return transactionSecurity;
    }

    /**
     * Sets the value of the transactionSecurity property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTransactionSecurity(String value) {
        this.transactionSecurity = value;
    }

    /**
     * Gets the value of the catLevel property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCatLevel() {
        return catLevel;
    }

    /**
     * Sets the value of the catLevel property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCatLevel(String value) {
        this.catLevel = value;
    }

    /**
     * Gets the value of the conditionCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getConditionCode() {
        return conditionCode;
    }

    /**
     * Sets the value of the conditionCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setConditionCode(String value) {
        this.conditionCode = value;
    }

    /**
     * Gets the value of the environment property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEnvironment() {
        return environment;
    }

    /**
     * Sets the value of the environment property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEnvironment(String value) {
        this.environment = value;
    }

    /**
     * Gets the value of the paymentData property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPaymentData() {
        return paymentData;
    }

    /**
     * Sets the value of the paymentData property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPaymentData(String value) {
        this.paymentData = value;
    }

    /**
     * Gets the value of the deviceReaderData property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDeviceReaderData() {
        return deviceReaderData;
    }

    /**
     * Sets the value of the deviceReaderData property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDeviceReaderData(String value) {
        this.deviceReaderData = value;
    }

    /**
     * Gets the value of the encryptionAlgorithm property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEncryptionAlgorithm() {
        return encryptionAlgorithm;
    }

    /**
     * Sets the value of the encryptionAlgorithm property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEncryptionAlgorithm(String value) {
        this.encryptionAlgorithm = value;
    }

    /**
     * Gets the value of the encodingMethod property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEncodingMethod() {
        return encodingMethod;
    }

    /**
     * Sets the value of the encodingMethod property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEncodingMethod(String value) {
        this.encodingMethod = value;
    }

    /**
     * Gets the value of the deviceID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDeviceID() {
        return deviceID;
    }

    /**
     * Sets the value of the deviceID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDeviceID(String value) {
        this.deviceID = value;
    }

    /**
     * Gets the value of the serviceCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * Sets the value of the serviceCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setServiceCode(String value) {
        this.serviceCode = value;
    }

    /**
     * Gets the value of the terminalIDAlternate property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTerminalIDAlternate() {
        return terminalIDAlternate;
    }

    /**
     * Sets the value of the terminalIDAlternate property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTerminalIDAlternate(String value) {
        this.terminalIDAlternate = value;
    }

    /**
     * Gets the value of the terminalCompliance property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getTerminalCompliance() {
        return terminalCompliance;
    }

    /**
     * Sets the value of the terminalCompliance property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setTerminalCompliance(BigInteger value) {
        this.terminalCompliance = value;
    }

}
