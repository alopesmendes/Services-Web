/**
 * Time.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.currencysystem.webservices.currencyserver;

public class Time  implements java.io.Serializable {
    private java.lang.String licenseKey;

    private java.lang.String currencies;

    private com.currencysystem.webservices.currencyserver.CurncsrvTimeInformation information;

    private com.currencysystem.webservices.currencyserver.CurncsrvTimePriority priority;

    private com.currencysystem.webservices.currencyserver.CurncsrvReturnTime returnTime;

    private java.lang.String time;

    private java.lang.String type;

    public Time() {
    }

    public Time(
           java.lang.String licenseKey,
           java.lang.String currencies,
           com.currencysystem.webservices.currencyserver.CurncsrvTimeInformation information,
           com.currencysystem.webservices.currencyserver.CurncsrvTimePriority priority,
           com.currencysystem.webservices.currencyserver.CurncsrvReturnTime returnTime,
           java.lang.String time,
           java.lang.String type) {
           this.licenseKey = licenseKey;
           this.currencies = currencies;
           this.information = information;
           this.priority = priority;
           this.returnTime = returnTime;
           this.time = time;
           this.type = type;
    }


    /**
     * Gets the licenseKey value for this Time.
     * 
     * @return licenseKey
     */
    public java.lang.String getLicenseKey() {
        return licenseKey;
    }


    /**
     * Sets the licenseKey value for this Time.
     * 
     * @param licenseKey
     */
    public void setLicenseKey(java.lang.String licenseKey) {
        this.licenseKey = licenseKey;
    }


    /**
     * Gets the currencies value for this Time.
     * 
     * @return currencies
     */
    public java.lang.String getCurrencies() {
        return currencies;
    }


    /**
     * Sets the currencies value for this Time.
     * 
     * @param currencies
     */
    public void setCurrencies(java.lang.String currencies) {
        this.currencies = currencies;
    }


    /**
     * Gets the information value for this Time.
     * 
     * @return information
     */
    public com.currencysystem.webservices.currencyserver.CurncsrvTimeInformation getInformation() {
        return information;
    }


    /**
     * Sets the information value for this Time.
     * 
     * @param information
     */
    public void setInformation(com.currencysystem.webservices.currencyserver.CurncsrvTimeInformation information) {
        this.information = information;
    }


    /**
     * Gets the priority value for this Time.
     * 
     * @return priority
     */
    public com.currencysystem.webservices.currencyserver.CurncsrvTimePriority getPriority() {
        return priority;
    }


    /**
     * Sets the priority value for this Time.
     * 
     * @param priority
     */
    public void setPriority(com.currencysystem.webservices.currencyserver.CurncsrvTimePriority priority) {
        this.priority = priority;
    }


    /**
     * Gets the returnTime value for this Time.
     * 
     * @return returnTime
     */
    public com.currencysystem.webservices.currencyserver.CurncsrvReturnTime getReturnTime() {
        return returnTime;
    }


    /**
     * Sets the returnTime value for this Time.
     * 
     * @param returnTime
     */
    public void setReturnTime(com.currencysystem.webservices.currencyserver.CurncsrvReturnTime returnTime) {
        this.returnTime = returnTime;
    }


    /**
     * Gets the time value for this Time.
     * 
     * @return time
     */
    public java.lang.String getTime() {
        return time;
    }


    /**
     * Sets the time value for this Time.
     * 
     * @param time
     */
    public void setTime(java.lang.String time) {
        this.time = time;
    }


    /**
     * Gets the type value for this Time.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this Time.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Time)) return false;
        Time other = (Time) obj;
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
            ((this.currencies==null && other.getCurrencies()==null) || 
             (this.currencies!=null &&
              this.currencies.equals(other.getCurrencies()))) &&
            ((this.information==null && other.getInformation()==null) || 
             (this.information!=null &&
              this.information.equals(other.getInformation()))) &&
            ((this.priority==null && other.getPriority()==null) || 
             (this.priority!=null &&
              this.priority.equals(other.getPriority()))) &&
            ((this.returnTime==null && other.getReturnTime()==null) || 
             (this.returnTime!=null &&
              this.returnTime.equals(other.getReturnTime()))) &&
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
        if (getCurrencies() != null) {
            _hashCode += getCurrencies().hashCode();
        }
        if (getInformation() != null) {
            _hashCode += getInformation().hashCode();
        }
        if (getPriority() != null) {
            _hashCode += getPriority().hashCode();
        }
        if (getReturnTime() != null) {
            _hashCode += getReturnTime().hashCode();
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
        new org.apache.axis.description.TypeDesc(Time.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", ">Time"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("licenseKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "licenseKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currencies");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "currencies"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("information");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "information"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "curncsrvTimeInformation"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("priority");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "priority"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "curncsrvTimePriority"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("returnTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "returnTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "curncsrvReturnTime"));
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
