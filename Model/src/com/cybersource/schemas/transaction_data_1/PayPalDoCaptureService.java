
package com.cybersource.schemas.transaction_data_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PayPalDoCaptureService complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PayPalDoCaptureService"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="paypalAuthorizationId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="completeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paypalEcDoPaymentRequestID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paypalEcDoPaymentRequestToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paypalAuthorizationRequestID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paypalAuthorizationRequestToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="invoiceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="run" use="required" type="{urn:schemas-cybersource-com:transaction-data-1.137}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PayPalDoCaptureService", propOrder = {
         "paypalAuthorizationId", "completeType", "paypalEcDoPaymentRequestID", "paypalEcDoPaymentRequestToken",
         "paypalAuthorizationRequestID", "paypalAuthorizationRequestToken", "invoiceNumber"
    })
public class PayPalDoCaptureService {

    protected String paypalAuthorizationId;
    protected String completeType;
    protected String paypalEcDoPaymentRequestID;
    protected String paypalEcDoPaymentRequestToken;
    protected String paypalAuthorizationRequestID;
    protected String paypalAuthorizationRequestToken;
    protected String invoiceNumber;
    @XmlAttribute(name = "run", required = true)
    protected String run;

    /**
     * Gets the value of the paypalAuthorizationId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPaypalAuthorizationId() {
        return paypalAuthorizationId;
    }

    /**
     * Sets the value of the paypalAuthorizationId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPaypalAuthorizationId(String value) {
        this.paypalAuthorizationId = value;
    }

    /**
     * Gets the value of the completeType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCompleteType() {
        return completeType;
    }

    /**
     * Sets the value of the completeType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCompleteType(String value) {
        this.completeType = value;
    }

    /**
     * Gets the value of the paypalEcDoPaymentRequestID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPaypalEcDoPaymentRequestID() {
        return paypalEcDoPaymentRequestID;
    }

    /**
     * Sets the value of the paypalEcDoPaymentRequestID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPaypalEcDoPaymentRequestID(String value) {
        this.paypalEcDoPaymentRequestID = value;
    }

    /**
     * Gets the value of the paypalEcDoPaymentRequestToken property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPaypalEcDoPaymentRequestToken() {
        return paypalEcDoPaymentRequestToken;
    }

    /**
     * Sets the value of the paypalEcDoPaymentRequestToken property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPaypalEcDoPaymentRequestToken(String value) {
        this.paypalEcDoPaymentRequestToken = value;
    }

    /**
     * Gets the value of the paypalAuthorizationRequestID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPaypalAuthorizationRequestID() {
        return paypalAuthorizationRequestID;
    }

    /**
     * Sets the value of the paypalAuthorizationRequestID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPaypalAuthorizationRequestID(String value) {
        this.paypalAuthorizationRequestID = value;
    }

    /**
     * Gets the value of the paypalAuthorizationRequestToken property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPaypalAuthorizationRequestToken() {
        return paypalAuthorizationRequestToken;
    }

    /**
     * Sets the value of the paypalAuthorizationRequestToken property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPaypalAuthorizationRequestToken(String value) {
        this.paypalAuthorizationRequestToken = value;
    }

    /**
     * Gets the value of the invoiceNumber property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * Sets the value of the invoiceNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setInvoiceNumber(String value) {
        this.invoiceNumber = value;
    }

    /**
     * Gets the value of the run property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRun() {
        return run;
    }

    /**
     * Sets the value of the run property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRun(String value) {
        this.run = value;
    }

}
