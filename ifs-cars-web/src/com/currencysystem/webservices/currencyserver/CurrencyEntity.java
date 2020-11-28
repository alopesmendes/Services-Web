/**
 * CurrencyEntity.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.currencysystem.webservices.currencyserver;

public class CurrencyEntity  implements java.io.Serializable {
    private java.lang.String licenseKey;

    private java.lang.String currency;

    private java.lang.String locale;

    private com.currencysystem.webservices.currencyserver.CurncsrvEntityDenomination denomination;

    private boolean titleStyle;

    public CurrencyEntity() {
    }

    public CurrencyEntity(
           java.lang.String licenseKey,
           java.lang.String currency,
           java.lang.String locale,
           com.currencysystem.webservices.currencyserver.CurncsrvEntityDenomination denomination,
           boolean titleStyle) {
           this.licenseKey = licenseKey;
           this.currency = currency;
           this.locale = locale;
           this.denomination = denomination;
           this.titleStyle = titleStyle;
    }


    /**
     * Gets the licenseKey value for this CurrencyEntity.
     * 
     * @return licenseKey
     */
    public java.lang.String getLicenseKey() {
        return licenseKey;
    }


    /**
     * Sets the licenseKey value for this CurrencyEntity.
     * 
     * @param licenseKey
     */
    public void setLicenseKey(java.lang.String licenseKey) {
        this.licenseKey = licenseKey;
    }


    /**
     * Gets the currency value for this CurrencyEntity.
     * 
     * @return currency
     */
    public java.lang.String getCurrency() {
        return currency;
    }


    /**
     * Sets the currency value for this CurrencyEntity.
     * 
     * @param currency
     */
    public void setCurrency(java.lang.String currency) {
        this.currency = currency;
    }


    /**
     * Gets the locale value for this CurrencyEntity.
     * 
     * @return locale
     */
    public java.lang.String getLocale() {
        return locale;
    }


    /**
     * Sets the locale value for this CurrencyEntity.
     * 
     * @param locale
     */
    public void setLocale(java.lang.String locale) {
        this.locale = locale;
    }


    /**
     * Gets the denomination value for this CurrencyEntity.
     * 
     * @return denomination
     */
    public com.currencysystem.webservices.currencyserver.CurncsrvEntityDenomination getDenomination() {
        return denomination;
    }


    /**
     * Sets the denomination value for this CurrencyEntity.
     * 
     * @param denomination
     */
    public void setDenomination(com.currencysystem.webservices.currencyserver.CurncsrvEntityDenomination denomination) {
        this.denomination = denomination;
    }


    /**
     * Gets the titleStyle value for this CurrencyEntity.
     * 
     * @return titleStyle
     */
    public boolean isTitleStyle() {
        return titleStyle;
    }


    /**
     * Sets the titleStyle value for this CurrencyEntity.
     * 
     * @param titleStyle
     */
    public void setTitleStyle(boolean titleStyle) {
        this.titleStyle = titleStyle;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CurrencyEntity)) return false;
        CurrencyEntity other = (CurrencyEntity) obj;
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
            ((this.locale==null && other.getLocale()==null) || 
             (this.locale!=null &&
              this.locale.equals(other.getLocale()))) &&
            ((this.denomination==null && other.getDenomination()==null) || 
             (this.denomination!=null &&
              this.denomination.equals(other.getDenomination()))) &&
            this.titleStyle == other.isTitleStyle();
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
        if (getLocale() != null) {
            _hashCode += getLocale().hashCode();
        }
        if (getDenomination() != null) {
            _hashCode += getDenomination().hashCode();
        }
        _hashCode += (isTitleStyle() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CurrencyEntity.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", ">CurrencyEntity"));
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
        elemField.setFieldName("locale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "locale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("denomination");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "denomination"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "curncsrvEntityDenomination"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titleStyle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "titleStyle"));
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
