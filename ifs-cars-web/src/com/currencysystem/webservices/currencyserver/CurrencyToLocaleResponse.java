/**
 * CurrencyToLocaleResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.currencysystem.webservices.currencyserver;

public class CurrencyToLocaleResponse  implements java.io.Serializable {
    private java.lang.Object currencyToLocaleResult;

    public CurrencyToLocaleResponse() {
    }

    public CurrencyToLocaleResponse(
           java.lang.Object currencyToLocaleResult) {
           this.currencyToLocaleResult = currencyToLocaleResult;
    }


    /**
     * Gets the currencyToLocaleResult value for this CurrencyToLocaleResponse.
     * 
     * @return currencyToLocaleResult
     */
    public java.lang.Object getCurrencyToLocaleResult() {
        return currencyToLocaleResult;
    }


    /**
     * Sets the currencyToLocaleResult value for this CurrencyToLocaleResponse.
     * 
     * @param currencyToLocaleResult
     */
    public void setCurrencyToLocaleResult(java.lang.Object currencyToLocaleResult) {
        this.currencyToLocaleResult = currencyToLocaleResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CurrencyToLocaleResponse)) return false;
        CurrencyToLocaleResponse other = (CurrencyToLocaleResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.currencyToLocaleResult==null && other.getCurrencyToLocaleResult()==null) || 
             (this.currencyToLocaleResult!=null &&
              this.currencyToLocaleResult.equals(other.getCurrencyToLocaleResult())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCurrencyToLocaleResult() != null) {
            _hashCode += getCurrencyToLocaleResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CurrencyToLocaleResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", ">CurrencyToLocaleResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currencyToLocaleResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "CurrencyToLocaleResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
