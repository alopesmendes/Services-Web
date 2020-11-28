/**
 * CurrencyToLocale.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.currencysystem.webservices.currencyserver;

public class CurrencyToLocale  implements java.io.Serializable {
    private java.lang.String licenseKey;

    private java.lang.String currency;

    private com.currencysystem.webservices.currencyserver.CurncsrvReturnLocale returnLocale;

    public CurrencyToLocale() {
    }

    public CurrencyToLocale(
           java.lang.String licenseKey,
           java.lang.String currency,
           com.currencysystem.webservices.currencyserver.CurncsrvReturnLocale returnLocale) {
           this.licenseKey = licenseKey;
           this.currency = currency;
           this.returnLocale = returnLocale;
    }


    /**
     * Gets the licenseKey value for this CurrencyToLocale.
     * 
     * @return licenseKey
     */
    public java.lang.String getLicenseKey() {
        return licenseKey;
    }


    /**
     * Sets the licenseKey value for this CurrencyToLocale.
     * 
     * @param licenseKey
     */
    public void setLicenseKey(java.lang.String licenseKey) {
        this.licenseKey = licenseKey;
    }


    /**
     * Gets the currency value for this CurrencyToLocale.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this CurrencyToLocale.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the returnLocale value for this CurrencyToLocale.
     * 
     * @return returnLocale
     */
    public com.currencysystem.webservices.currencyserver.CurncsrvReturnLocale getReturnLocale() {
        return returnLocale;
    }


    /**
     * Sets the returnLocale value for this CurrencyToLocale.
     * 
     * @param returnLocale
     */
    public void setReturnLocale(com.currencysystem.webservices.currencyserver.CurncsrvReturnLocale returnLocale) {
        this.returnLocale = returnLocale;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CurrencyToLocale)) return false;
        CurrencyToLocale other = (CurrencyToLocale) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.licenseKey==null && other.getLicenseKey()==null) || 
             (this.licenseKey!=null &&
              this.licenseKey.equals(other.getLicenseKey()))) &&
            ((this.currency==null && other.getCurrency()==null) || 
             (this.currency!=null &&
              this.currency.equals(other.getCurrency()))) &&
            ((this.returnLocale==null && other.getReturnLocale()==null) || 
             (this.returnLocale!=null &&
              this.returnLocale.equals(other.getReturnLocale())));
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
        if (getLicenseKey() != null) {
            _hashCode += getLicenseKey().hashCode();
        }
        if (getCurrency() != null) {
            _hashCode += getCurrency().hashCode();
        }
        if (getReturnLocale() != null) {
            _hashCode += getReturnLocale().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CurrencyToLocale.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", ">CurrencyToLocale"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("licenseKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "licenseKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currency");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "currency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnLocale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "returnLocale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "curncsrvReturnLocale"));
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
