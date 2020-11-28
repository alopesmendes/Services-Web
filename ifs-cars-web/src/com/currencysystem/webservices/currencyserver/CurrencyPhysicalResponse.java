/**
 * CurrencyPhysicalResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.currencysystem.webservices.currencyserver;

public class CurrencyPhysicalResponse  implements java.io.Serializable {
    private boolean currencyPhysicalResult;

    public CurrencyPhysicalResponse() {
    }

    public CurrencyPhysicalResponse(
           boolean currencyPhysicalResult) {
           this.currencyPhysicalResult = currencyPhysicalResult;
    }


    /**
     * Gets the currencyPhysicalResult value for this CurrencyPhysicalResponse.
     * 
     * @return currencyPhysicalResult
     */
    public boolean isCurrencyPhysicalResult() {
        return currencyPhysicalResult;
    }


    /**
     * Sets the currencyPhysicalResult value for this CurrencyPhysicalResponse.
     * 
     * @param currencyPhysicalResult
     */
    public void setCurrencyPhysicalResult(boolean currencyPhysicalResult) {
        this.currencyPhysicalResult = currencyPhysicalResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CurrencyPhysicalResponse)) return false;
        CurrencyPhysicalResponse other = (CurrencyPhysicalResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.currencyPhysicalResult == other.isCurrencyPhysicalResult();
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
        _hashCode += (isCurrencyPhysicalResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CurrencyPhysicalResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", ">CurrencyPhysicalResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currencyPhysicalResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "CurrencyPhysicalResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
