/**
 * CurncsrvMessageType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.currencysystem.webservices.currencyserver;

public class CurncsrvMessageType implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected CurncsrvMessageType(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _curncsrvMessageInformation = "curncsrvMessageInformation";
    public static final java.lang.String _curncsrvMessageWarning = "curncsrvMessageWarning";
    public static final java.lang.String _curncsrvMessageError = "curncsrvMessageError";
    public static final CurncsrvMessageType curncsrvMessageInformation = new CurncsrvMessageType(_curncsrvMessageInformation);
    public static final CurncsrvMessageType curncsrvMessageWarning = new CurncsrvMessageType(_curncsrvMessageWarning);
    public static final CurncsrvMessageType curncsrvMessageError = new CurncsrvMessageType(_curncsrvMessageError);
    public java.lang.String getValue() { return _value_;}
    public static CurncsrvMessageType fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        CurncsrvMessageType enumeration = (CurncsrvMessageType)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static CurncsrvMessageType fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(CurncsrvMessageType.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "curncsrvMessageType"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
