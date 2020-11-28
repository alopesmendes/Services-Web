/**
 * CurncsrvFXModeMultiple.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.currencysystem.webservices.currencyserver;

public class CurncsrvFXModeMultiple implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected CurncsrvFXModeMultiple(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _curncsrvFXModeMultipleMerge = "curncsrvFXModeMultipleMerge";
    public static final java.lang.String _curncsrvFXModeMultipleCrossCheck = "curncsrvFXModeMultipleCrossCheck";
    public static final java.lang.String _curncsrvFXModeMultipleFailover = "curncsrvFXModeMultipleFailover";
    public static final CurncsrvFXModeMultiple curncsrvFXModeMultipleMerge = new CurncsrvFXModeMultiple(_curncsrvFXModeMultipleMerge);
    public static final CurncsrvFXModeMultiple curncsrvFXModeMultipleCrossCheck = new CurncsrvFXModeMultiple(_curncsrvFXModeMultipleCrossCheck);
    public static final CurncsrvFXModeMultiple curncsrvFXModeMultipleFailover = new CurncsrvFXModeMultiple(_curncsrvFXModeMultipleFailover);
    public java.lang.String getValue() { return _value_;}
    public static CurncsrvFXModeMultiple fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        CurncsrvFXModeMultiple enumeration = (CurncsrvFXModeMultiple)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static CurncsrvFXModeMultiple fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(CurncsrvFXModeMultiple.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "curncsrvFXModeMultiple"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
