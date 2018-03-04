
package com.cybersource.schemas.transaction_data_1;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaySubscriptionCreateReply complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PaySubscriptionCreateReply"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="reasonCode" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="subscriptionID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="instrumentIdentifierID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="instrumentIdentifierStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="instrumentIdentifierNew" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="instrumentIdentifierIDNew" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaySubscriptionCreateReply", propOrder = {
         "reasonCode", "subscriptionID", "instrumentIdentifierID", "instrumentIdentifierStatus",
         "instrumentIdentifierNew", "instrumentIdentifierIDNew"
    })
public class PaySubscriptionCreateReply {

    @XmlElement(required = true)
    protected BigInteger reasonCode;
    @XmlElement(required = true)
    protected String subscriptionID;
    protected String instrumentIdentifierID;
    protected String instrumentIdentifierStatus;
    protected String instrumentIdentifierNew;
    protected String instrumentIdentifierIDNew;

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
     * Gets the value of the subscriptionID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSubscriptionID() {
        return subscriptionID;
    }

    /**
     * Sets the value of the subscriptionID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSubscriptionID(String value) {
        this.subscriptionID = value;
    }

    /**
     * Gets the value of the instrumentIdentifierID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getInstrumentIdentifierID() {
        return instrumentIdentifierID;
    }

    /**
     * Sets the value of the instrumentIdentifierID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setInstrumentIdentifierID(String value) {
        this.instrumentIdentifierID = value;
    }

    /**
     * Gets the value of the instrumentIdentifierStatus property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getInstrumentIdentifierStatus() {
        return instrumentIdentifierStatus;
    }

    /**
     * Sets the value of the instrumentIdentifierStatus property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setInstrumentIdentifierStatus(String value) {
        this.instrumentIdentifierStatus = value;
    }

    /**
     * Gets the value of the instrumentIdentifierNew property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getInstrumentIdentifierNew() {
        return instrumentIdentifierNew;
    }

    /**
     * Sets the value of the instrumentIdentifierNew property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setInstrumentIdentifierNew(String value) {
        this.instrumentIdentifierNew = value;
    }

    /**
     * Gets the value of the instrumentIdentifierIDNew property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getInstrumentIdentifierIDNew() {
        return instrumentIdentifierIDNew;
    }

    /**
     * Sets the value of the instrumentIdentifierIDNew property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setInstrumentIdentifierIDNew(String value) {
        this.instrumentIdentifierIDNew = value;
    }

}
