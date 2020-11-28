/**
 * LocaleToCurrency.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.currencysystem.webservices.currencyserver;

public class LocaleToCurrency  implements java.io.Serializable {
    private java.lang.String licenseKey;

    private java.lang.String locale;

    private boolean activeOnly;

    public LocaleToCurrency() {
    }

    public LocaleToCurrency(
           java.lang.String licenseKey,
           java.lang.String locale,
           boolean activeOnly) {
           this.licenseKey = licenseKey;
           this.locale = locale;
           this.activeOnly = activeOnly;
    }


    /**
     * Gets the licenseKey value for this LocaleToCurrency.
     * 
     * @return licenseKey
     */
    public java.lang.String getLicenseKey() {
        return licenseKey;
    }


    /**
     * Sets the licenseKey value for this LocaleToCurrency.
     * 
     * @param licenseKey
     */
    public void setLicenseKey(java.lang.String licenseKey) {
        this.licenseKey = licenseKey;
    }


    /**
     * Gets the locale value for this LocaleToCurrency.
     * 
     * @return locale
     */
    public java.lang.String getLocale() {
        return locale;
    }


    /**
     * Sets the locale value for this LocaleToCurrency.
     * 
     * @param locale
     */
    public void setLocale(java.lang.String locale) {
        this.locale = locale;
    }


    /**
     * Gets the activeOnly value for this LocaleToCurrency.
     * 
     * @return activeOnly
     */
    public boolean isActiveOnly() {
        return activeOnly;
    }


    /**
     * Sets the activeOnly value for this LocaleToCurrency.
     * 
     * @param activeOnly
     */
    public void setActiveOnly(boolean activeOnly) {
        this.activeOnly = activeOnly;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LocaleToCurrency)) return false;
        LocaleToCurrency other = (LocaleToCurrency) obj;
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
            ((this.locale==null && other.getLocale()==null) || 
             (this.locale!=null &&
              this.locale.equals(other.getLocale()))) &&
            this.activeOnly == other.isActiveOnly();
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
        if (getLocale() != null) {
            _hashCode += getLocale().hashCode();
        }
        _hashCode += (isActiveOnly() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LocaleToCurrency.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", ">LocaleToCurrency"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("licenseKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "licenseKey"));
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
        elemField.setFieldName("activeOnly");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "activeOnly"));
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
