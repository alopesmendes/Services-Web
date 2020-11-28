/**
 * Export.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.currencysystem.webservices.currencyserver;

public class Export  implements java.io.Serializable {
    private java.lang.String licenseKey;

    private java.lang.String format;

    private java.lang.String encoding;

    private java.lang.String baseCurrency;

    private java.lang.String locale;

    private java.lang.String flags;

    private java.lang.String serviceLicenseKey;

    private java.lang.String serviceExpirationTime;

    private java.lang.String serviceRenewalURL;

    private java.lang.String errorCode;

    private java.lang.String errorMessage;

    private java.lang.String time;

    private java.lang.String type;

    public Export() {
    }

    public Export(
           java.lang.String licenseKey,
           java.lang.String format,
           java.lang.String encoding,
           java.lang.String baseCurrency,
           java.lang.String locale,
           java.lang.String flags,
           java.lang.String serviceLicenseKey,
           java.lang.String serviceExpirationTime,
           java.lang.String serviceRenewalURL,
           java.lang.String errorCode,
           java.lang.String errorMessage,
           java.lang.String time,
           java.lang.String type) {
           this.licenseKey = licenseKey;
           this.format = format;
           this.encoding = encoding;
           this.baseCurrency = baseCurrency;
           this.locale = locale;
           this.flags = flags;
           this.serviceLicenseKey = serviceLicenseKey;
           this.serviceExpirationTime = serviceExpirationTime;
           this.serviceRenewalURL = serviceRenewalURL;
           this.errorCode = errorCode;
           this.errorMessage = errorMessage;
           this.time = time;
           this.type = type;
    }


    /**
     * Gets the licenseKey value for this Export.
     * 
     * @return licenseKey
     */
    public java.lang.String getLicenseKey() {
        return licenseKey;
    }


    /**
     * Sets the licenseKey value for this Export.
     * 
     * @param licenseKey
     */
    public void setLicenseKey(java.lang.String licenseKey) {
        this.licenseKey = licenseKey;
    }


    /**
     * Gets the format value for this Export.
     * 
     * @return format
     */
    public java.lang.String getFormat() {
        return format;
    }


    /**
     * Sets the format value for this Export.
     * 
     * @param format
     */
    public void setFormat(java.lang.String format) {
        this.format = format;
    }


    /**
     * Gets the encoding value for this Export.
     * 
     * @return encoding
     */
    public java.lang.String getEncoding() {
        return encoding;
    }


    /**
     * Sets the encoding value for this Export.
     * 
     * @param encoding
     */
    public void setEncoding(java.lang.String encoding) {
        this.encoding = encoding;
    }


    /**
     * Gets the baseCurrency value for this Export.
     * 
     * @return baseCurrency
     */
    public java.lang.String getBaseCurrency() {
        return baseCurrency;
    }


    /**
     * Sets the baseCurrency value for this Export.
     * 
     * @param baseCurrency
     */
    public void setBaseCurrency(java.lang.String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }


    /**
     * Gets the locale value for this Export.
     * 
     * @return locale
     */
    public java.lang.String getLocale() {
        return locale;
    }


    /**
     * Sets the locale value for this Export.
     * 
     * @param locale
     */
    public void setLocale(java.lang.String locale) {
        this.locale = locale;
    }


    /**
     * Gets the flags value for this Export.
     * 
     * @return flags
     */
    public java.lang.String getFlags() {
        return flags;
    }


    /**
     * Sets the flags value for this Export.
     * 
     * @param flags
     */
    public void setFlags(java.lang.String flags) {
        this.flags = flags;
    }


    /**
     * Gets the serviceLicenseKey value for this Export.
     * 
     * @return serviceLicenseKey
     */
    public java.lang.String getServiceLicenseKey() {
        return serviceLicenseKey;
    }


    /**
     * Sets the serviceLicenseKey value for this Export.
     * 
     * @param serviceLicenseKey
     */
    public void setServiceLicenseKey(java.lang.String serviceLicenseKey) {
        this.serviceLicenseKey = serviceLicenseKey;
    }


    /**
     * Gets the serviceExpirationTime value for this Export.
     * 
     * @return serviceExpirationTime
     */
    public java.lang.String getServiceExpirationTime() {
        return serviceExpirationTime;
    }


    /**
     * Sets the serviceExpirationTime value for this Export.
     * 
     * @param serviceExpirationTime
     */
    public void setServiceExpirationTime(java.lang.String serviceExpirationTime) {
        this.serviceExpirationTime = serviceExpirationTime;
    }


    /**
     * Gets the serviceRenewalURL value for this Export.
     * 
     * @return serviceRenewalURL
     */
    public java.lang.String getServiceRenewalURL() {
        return serviceRenewalURL;
    }


    /**
     * Sets the serviceRenewalURL value for this Export.
     * 
     * @param serviceRenewalURL
     */
    public void setServiceRenewalURL(java.lang.String serviceRenewalURL) {
        this.serviceRenewalURL = serviceRenewalURL;
    }


    /**
     * Gets the errorCode value for this Export.
     * 
     * @return errorCode
     */
    public java.lang.String getErrorCode() {
        return errorCode;
    }


    /**
     * Sets the errorCode value for this Export.
     * 
     * @param errorCode
     */
    public void setErrorCode(java.lang.String errorCode) {
        this.errorCode = errorCode;
    }


    /**
     * Gets the errorMessage value for this Export.
     * 
     * @return errorMessage
     */
    public java.lang.String getErrorMessage() {
        return errorMessage;
    }


    /**
     * Sets the errorMessage value for this Export.
     * 
     * @param errorMessage
     */
    public void setErrorMessage(java.lang.String errorMessage) {
        this.errorMessage = errorMessage;
    }


    /**
     * Gets the time value for this Export.
     * 
     * @return time
     */
    public java.lang.String getTime() {
        return time;
    }


    /**
     * Sets the time value for this Export.
     * 
     * @param time
     */
    public void setTime(java.lang.String time) {
        this.time = time;
    }


    /**
     * Gets the type value for this Export.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this Export.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Export)) return false;
        Export other = (Export) obj;
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
            ((this.format==null && other.getFormat()==null) || 
             (this.format!=null &&
              this.format.equals(other.getFormat()))) &&
            ((this.encoding==null && other.getEncoding()==null) || 
             (this.encoding!=null &&
              this.encoding.equals(other.getEncoding()))) &&
            ((this.baseCurrency==null && other.getBaseCurrency()==null) || 
             (this.baseCurrency!=null &&
              this.baseCurrency.equals(other.getBaseCurrency()))) &&
            ((this.locale==null && other.getLocale()==null) || 
             (this.locale!=null &&
              this.locale.equals(other.getLocale()))) &&
            ((this.flags==null && other.getFlags()==null) || 
             (this.flags!=null &&
              this.flags.equals(other.getFlags()))) &&
            ((this.serviceLicenseKey==null && other.getServiceLicenseKey()==null) || 
             (this.serviceLicenseKey!=null &&
              this.serviceLicenseKey.equals(other.getServiceLicenseKey()))) &&
            ((this.serviceExpirationTime==null && other.getServiceExpirationTime()==null) || 
             (this.serviceExpirationTime!=null &&
              this.serviceExpirationTime.equals(other.getServiceExpirationTime()))) &&
            ((this.serviceRenewalURL==null && other.getServiceRenewalURL()==null) || 
             (this.serviceRenewalURL!=null &&
              this.serviceRenewalURL.equals(other.getServiceRenewalURL()))) &&
            ((this.errorCode==null && other.getErrorCode()==null) || 
             (this.errorCode!=null &&
              this.errorCode.equals(other.getErrorCode()))) &&
            ((this.errorMessage==null && other.getErrorMessage()==null) || 
             (this.errorMessage!=null &&
              this.errorMessage.equals(other.getErrorMessage()))) &&
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
        if (getFormat() != null) {
            _hashCode += getFormat().hashCode();
        }
        if (getEncoding() != null) {
            _hashCode += getEncoding().hashCode();
        }
        if (getBaseCurrency() != null) {
            _hashCode += getBaseCurrency().hashCode();
        }
        if (getLocale() != null) {
            _hashCode += getLocale().hashCode();
        }
        if (getFlags() != null) {
            _hashCode += getFlags().hashCode();
        }
        if (getServiceLicenseKey() != null) {
            _hashCode += getServiceLicenseKey().hashCode();
        }
        if (getServiceExpirationTime() != null) {
            _hashCode += getServiceExpirationTime().hashCode();
        }
        if (getServiceRenewalURL() != null) {
            _hashCode += getServiceRenewalURL().hashCode();
        }
        if (getErrorCode() != null) {
            _hashCode += getErrorCode().hashCode();
        }
        if (getErrorMessage() != null) {
            _hashCode += getErrorMessage().hashCode();
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
        new org.apache.axis.description.TypeDesc(Export.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", ">Export"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("licenseKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "licenseKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("encoding");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "encoding"));
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
        elemField.setFieldName("locale");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "locale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flags");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "flags"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceLicenseKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "serviceLicenseKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceExpirationTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "serviceExpirationTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceRenewalURL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "serviceRenewalURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "errorCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "errorMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
