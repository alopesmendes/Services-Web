/**
 * LocaleToCurrencyResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.currencysystem.webservices.currencyserver;

public class LocaleToCurrencyResponse  implements java.io.Serializable {
    private java.lang.String localeToCurrencyResult;

    public LocaleToCurrencyResponse() {
    }

    public LocaleToCurrencyResponse(
           java.lang.String localeToCurrencyResult) {
           this.localeToCurrencyResult = localeToCurrencyResult;
    }


    /**
     * Gets the localeToCurrencyResult value for this LocaleToCurrencyResponse.
     * 
     * @return localeToCurrencyResult
     */
    public java.lang.String getLocaleToCurrencyResult() {
        return localeToCurrencyResult;
    }


    /**
     * Sets the localeToCurrencyResult value for this LocaleToCurrencyResponse.
     * 
     * @param localeToCurrencyResult
     */
    public void setLocaleToCurrencyResult(java.lang.String localeToCurrencyResult) {
        this.localeToCurrencyResult = localeToCurrencyResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LocaleToCurrencyResponse)) return false;
        LocaleToCurrencyResponse other = (LocaleToCurrencyResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.localeToCurrencyResult==null && other.getLocaleToCurrencyResult()==null) || 
             (this.localeToCurrencyResult!=null &&
              this.localeToCurrencyResult.equals(other.getLocaleToCurrencyResult())));
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
        if (getLocaleToCurrencyResult() != null) {
            _hashCode += getLocaleToCurrencyResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LocaleToCurrencyResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", ">LocaleToCurrencyResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("localeToCurrencyResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "LocaleToCurrencyResult"));
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
