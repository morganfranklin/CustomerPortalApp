
package com.cybersource.schemas.transaction_data_1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MorphingElement complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="MorphingElement"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="element" type="{urn:schemas-cybersource-com:transaction-data-1.137}Element" maxOccurs="1000" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MorphingElement", propOrder = { "element" })
public class MorphingElement {

    protected List<Element> element;

    /**
     * Gets the value of the element property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the element property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElement().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     *
     *
     */
    public List<Element> getElement() {
        if (element == null) {
            element = new ArrayList<Element>();
        }
        return this.element;
    }

}
