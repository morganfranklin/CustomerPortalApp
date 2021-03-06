
package com.cybersource.schemas.transaction_data_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PayPalUpdateAgreementService complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PayPalUpdateAgreementService"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="paypalBillingAgreementId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paypalBillingAgreementStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paypalBillingAgreementDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paypalBillingAgreementCustom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "PayPalUpdateAgreementService", propOrder = {
         "paypalBillingAgreementId", "paypalBillingAgreementStatus", "paypalBillingAgreementDesc",
         "paypalBillingAgreementCustom"
    })
public class PayPalUpdateAgreementService {

    protected String paypalBillingAgreementId;
    protected String paypalBillingAgreementStatus;
    protected String paypalBillingAgreementDesc;
    protected String paypalBillingAgreementCustom;
    @XmlAttribute(name = "run", required = true)
    protected String run;

    /**
     * Gets the value of the paypalBillingAgreementId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPaypalBillingAgreementId() {
        return paypalBillingAgreementId;
    }

    /**
     * Sets the value of the paypalBillingAgreementId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPaypalBillingAgreementId(String value) {
        this.paypalBillingAgreementId = value;
    }

    /**
     * Gets the value of the paypalBillingAgreementStatus property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPaypalBillingAgreementStatus() {
        return paypalBillingAgreementStatus;
    }

    /**
     * Sets the value of the paypalBillingAgreementStatus property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPaypalBillingAgreementStatus(String value) {
        this.paypalBillingAgreementStatus = value;
    }

    /**
     * Gets the value of the paypalBillingAgreementDesc property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPaypalBillingAgreementDesc() {
        return paypalBillingAgreementDesc;
    }

    /**
     * Sets the value of the paypalBillingAgreementDesc property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPaypalBillingAgreementDesc(String value) {
        this.paypalBillingAgreementDesc = value;
    }

    /**
     * Gets the value of the paypalBillingAgreementCustom property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPaypalBillingAgreementCustom() {
        return paypalBillingAgreementCustom;
    }

    /**
     * Sets the value of the paypalBillingAgreementCustom property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPaypalBillingAgreementCustom(String value) {
        this.paypalBillingAgreementCustom = value;
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
