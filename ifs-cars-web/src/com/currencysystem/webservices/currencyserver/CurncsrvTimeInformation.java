/**
 * CurncsrvTimeInformation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.currencysystem.webservices.currencyserver;

public class CurncsrvTimeInformation implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected CurncsrvTimeInformation(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _curncsrvTimeRatesLastChange = "curncsrvTimeRatesLastChange";
    public static final java.lang.String _curncsrvTimeRatesCreation = "curncsrvTimeRatesCreation";
    public static final java.lang.String _curncsrvTimeRatesExpiration = "curncsrvTimeRatesExpiration";
    public static final java.lang.String _curncsrvTimeServiceExpiration = "curncsrvTimeServiceExpiration";
    public static final java.lang.String _curncsrvTimeCurrent = "curncsrvTimeCurrent";
    public static final java.lang.String _curncsrvTimeRatesEffective = "curncsrvTimeRatesEffective";
    public static final java.lang.String _curncsrvTimeRatesDataContent = "curncsrvTimeRatesDataContent";
    public static final java.lang.String _curncsrvTimeRatesPublication = "curncsrvTimeRatesPublication";
    public static final CurncsrvTimeInformation curncsrvTimeRatesLastChange = new CurncsrvTimeInformation(_curncsrvTimeRatesLastChange);
    public static final CurncsrvTimeInformation curncsrvTimeRatesCreation = new CurncsrvTimeInformation(_curncsrvTimeRatesCreation);
    public static final CurncsrvTimeInformation curncsrvTimeRatesExpiration = new CurncsrvTimeInformation(_curncsrvTimeRatesExpiration);
    public static final CurncsrvTimeInformation curncsrvTimeServiceExpiration = new CurncsrvTimeInformation(_curncsrvTimeServiceExpiration);
    public static final CurncsrvTimeInformation curncsrvTimeCurrent = new CurncsrvTimeInformation(_curncsrvTimeCurrent);
    public static final CurncsrvTimeInformation curncsrvTimeRatesEffective = new CurncsrvTimeInformation(_curncsrvTimeRatesEffective);
    public static final CurncsrvTimeInformation curncsrvTimeRatesDataContent = new CurncsrvTimeInformation(_curncsrvTimeRatesDataContent);
    public static final CurncsrvTimeInformation curncsrvTimeRatesPublication = new CurncsrvTimeInformation(_curncsrvTimeRatesPublication);
    public java.lang.String getValue() { return _value_;}
    public static CurncsrvTimeInformation fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        CurncsrvTimeInformation enumeration = (CurncsrvTimeInformation)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static CurncsrvTimeInformation fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CurncsrvTimeInformation.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "curncsrvTimeInformation"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
