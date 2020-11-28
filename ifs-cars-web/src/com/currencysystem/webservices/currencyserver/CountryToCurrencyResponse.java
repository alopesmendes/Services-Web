/**
 * CountryToCurrencyResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.currencysystem.webservices.currencyserver;

public class CountryToCurrencyResponse  implements java.io.Serializable {
    private java.lang.String countryToCurrencyResult;

    public CountryToCurrencyResponse() {
    }

    public CountryToCurrencyResponse(
           java.lang.String countryToCurrencyResult) {
           this.countryToCurrencyResult = countryToCurrencyResult;
    }


    /**
     * Gets the countryToCurrencyResult value for this CountryToCurrencyResponse.
     * 
     * @return countryToCurrencyResult
     */
    public java.lang.String getCountryToCurrencyResult() {
        return countryToCurrencyResult;
    }


    /**
     * Sets the countryToCurrencyResult value for this CountryToCurrencyResponse.
     * 
     * @param countryToCurrencyResult
     */
    public void setCountryToCurrencyResult(java.lang.String countryToCurrencyResult) {
        this.countryToCurrencyResult = countryToCurrencyResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CountryToCurrencyResponse)) return false;
        CountryToCurrencyResponse other = (CountryToCurrencyResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.countryToCurrencyResult==null && other.getCountryToCurrencyResult()==null) || 
             (this.countryToCurrencyResult!=null &&
              this.countryToCurrencyResult.equals(other.getCountryToCurrencyResult())));
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
        if (getCountryToCurrencyResult() != null) {
            _hashCode += getCountryToCurrencyResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CountryToCurrencyResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", ">CountryToCurrencyResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("countryToCurrencyResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "CountryToCurrencyResult"));
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
