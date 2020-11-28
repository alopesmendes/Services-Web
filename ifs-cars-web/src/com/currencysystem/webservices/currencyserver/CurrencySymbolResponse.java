/**
 * CurrencySymbolResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.currencysystem.webservices.currencyserver;

public class CurrencySymbolResponse  implements java.io.Serializable {
    private java.lang.String currencySymbolResult;

    public CurrencySymbolResponse() {
    }

    public CurrencySymbolResponse(
           java.lang.String currencySymbolResult) {
           this.currencySymbolResult = currencySymbolResult;
    }


    /**
     * Gets the currencySymbolResult value for this CurrencySymbolResponse.
     * 
     * @return currencySymbolResult
     */
    public java.lang.String getCurrencySymbolResult() {
        return currencySymbolResult;
    }


    /**
     * Sets the currencySymbolResult value for this CurrencySymbolResponse.
     * 
     * @param currencySymbolResult
     */
    public void setCurrencySymbolResult(java.lang.String currencySymbolResult) {
        this.currencySymbolResult = currencySymbolResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CurrencySymbolResponse)) return false;
        CurrencySymbolResponse other = (CurrencySymbolResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.currencySymbolResult==null && other.getCurrencySymbolResult()==null) || 
             (this.currencySymbolResult!=null &&
              this.currencySymbolResult.equals(other.getCurrencySymbolResult())));
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
        if (getCurrencySymbolResult() != null) {
            _hashCode += getCurrencySymbolResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CurrencySymbolResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", ">CurrencySymbolResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currencySymbolResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "CurrencySymbolResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
