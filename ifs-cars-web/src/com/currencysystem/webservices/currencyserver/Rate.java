/**
 * Rate.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.currencysystem.webservices.currencyserver;

public class Rate  implements java.io.Serializable {
    private java.lang.String licenseKey;

    private java.lang.String baseCurrency;

    private java.lang.String toCurrency;

    private boolean rounding;

    private java.lang.String format;

    private com.currencysystem.webservices.currencyserver.CurncsrvReturnRate returnRate;

    private java.lang.String time;

    private java.lang.String type;

    public Rate() {
    }

    public Rate(
           java.lang.String licenseKey,
           java.lang.String baseCurrency,
           java.lang.String toCurrency,
           boolean rounding,
           java.lang.String format,
           com.currencysystem.webservices.currencyserver.CurncsrvReturnRate returnRate,
           java.lang.String time,
           java.lang.String type) {
           this.licenseKey = licenseKey;
           this.baseCurrency = baseCurrency;
           this.toCurrency = toCurrency;
           this.rounding = rounding;
           this.format = format;
           this.returnRate = returnRate;
           this.time = time;
           this.type = type;
    }


    /**
     * Gets the licenseKey value for this Rate.
     * 
     * @return licenseKey
     */
    public java.lang.String getLicenseKey() {
        return licenseKey;
    }


    /**
     * Sets the licenseKey value for this Rate.
     * 
     * @param licenseKey
     */
    public void setLicenseKey(java.lang.String licenseKey) {
        this.licenseKey = licenseKey;
    }


    /**
     * Gets the baseCurrency value for this Rate.
     * 
     * @return baseCurrency
     */
    public java.lang.String getBaseCurrency() {
        return baseCurrency;
    }


    /**
     * Sets the baseCurrency value for this Rate.
     * 
     * @param baseCurrency
     */
    public void setBaseCurrency(java.lang.String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }


    /**
     * Gets the toCurrency value for this Rate.
     * 
     * @return toCurrency
     */
    public java.lang.String getToCurrency() {
        return toCurrency;
    }


    /**
     * Sets the toCurrency value for this Rate.
     * 
     * @param toCurrency
     */
    public void setToCurrency(java.lang.String toCurrency) {
        this.toCurrency = toCurrency;
    }


    /**
     * Gets the rounding value for this Rate.
     * 
     * @return rounding
     */
    public boolean isRounding() {
        return rounding;
    }


    /**
     * Sets the rounding value for this Rate.
     * 
     * @param rounding
     */
    public void setRounding(boolean rounding) {
        this.rounding = rounding;
    }


    /**
     * Gets the format value for this Rate.
     * 
     * @return format
     */
    public java.lang.String getFormat() {
        return format;
    }


    /**
     * Sets the format value for this Rate.
     * 
     * @param format
     */
    public void setFormat(java.lang.String format) {
        this.format = format;
    }


    /**
     * Gets the returnRate value for this Rate.
     * 
     * @return returnRate
     */
    public com.currencysystem.webservices.currencyserver.CurncsrvReturnRate getReturnRate() {
        return returnRate;
    }


    /**
     * Sets the returnRate value for this Rate.
     * 
     * @param returnRate
     */
    public void setReturnRate(com.currencysystem.webservices.currencyserver.CurncsrvReturnRate returnRate) {
        this.returnRate = returnRate;
    }


    /**
     * Gets the time value for this Rate.
     * 
     * @return time
     */
    public java.lang.String getTime() {
        return time;
    }


    /**
     * Sets the time value for this Rate.
     * 
     * @param time
     */
    public void setTime(java.lang.String time) {
        this.time = time;
    }


    /**
     * Gets the type value for this Rate.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this Rate.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Rate)) return false;
        Rate other = (Rate) obj;
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
            ((this.baseCurrency==null && other.getBaseCurrency()==null) || 
             (this.baseCurrency!=null &&
              this.baseCurrency.equals(other.getBaseCurrency()))) &&
            ((this.toCurrency==null && other.getToCurrency()==null) || 
             (this.toCurrency!=null &&
              this.toCurrency.equals(other.getToCurrency()))) &&
            this.rounding == other.isRounding() &&
            ((this.format==null && other.getFormat()==null) || 
             (this.format!=null &&
              this.format.equals(other.getFormat()))) &&
            ((this.returnRate==null && other.getReturnRate()==null) || 
             (this.returnRate!=null &&
              this.returnRate.equals(other.getReturnRate()))) &&
            ((this.time==null && other.getTime()==null) || 
             (this.time!=null &&
              this.time.equals(other.getTime()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType())));
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
        if (getBaseCurrency() != null) {
            _hashCode += getBaseCurrency().hashCode();
        }
        if (getToCurrency() != null) {
            _hashCode += getToCurrency().hashCode();
        }
        _hashCode += (isRounding() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getFormat() != null) {
            _hashCode += getFormat().hashCode();
        }
        if (getReturnRate() != null) {
            _hashCode += getReturnRate().hashCode();
        }
        if (getTime() != null) {
            _hashCode += getTime().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Rate.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", ">Rate"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("licenseKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "licenseKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("baseCurrency");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "baseCurrency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toCurrency");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "toCurrency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rounding");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "rounding"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("format");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "format"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnRate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "returnRate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "curncsrvReturnRate"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("time");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "time"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "type"));
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
