
package com.cybersource.schemas.transaction_data_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PinDebitReversalService complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PinDebitReversalService"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="pinDebitRequestID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "PinDebitReversalService", propOrder = { "pinDebitRequestID" })
public class PinDebitReversalService {

    protected String pinDebitRequestID;
    @XmlAttribute(name = "run", required = true)
    protected String run;

    /**
     * Gets the value of the pinDebitRequestID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPinDebitRequestID() {
        return pinDebitRequestID;
    }

    /**
     * Sets the value of the pinDebitRequestID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPinDebitRequestID(String value) {
        this.pinDebitRequestID = value;
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
