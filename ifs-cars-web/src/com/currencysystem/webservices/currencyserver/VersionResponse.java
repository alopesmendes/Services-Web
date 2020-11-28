/**
 * VersionResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.currencysystem.webservices.currencyserver;

public class VersionResponse  implements java.io.Serializable {
    private java.lang.String versionResult;

    public VersionResponse() {
    }

    public VersionResponse(
           java.lang.String versionResult) {
           this.versionResult = versionResult;
    }


    /**
     * Gets the versionResult value for this VersionResponse.
     * 
     * @return versionResult
     */
    public java.lang.String getVersionResult() {
        return versionResult;
    }


    /**
     * Sets the versionResult value for this VersionResponse.
     * 
     * @param versionResult
     */
    public void setVersionResult(java.lang.String versionResult) {
        this.versionResult = versionResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof VersionResponse)) return false;
        VersionResponse other = (VersionResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.versionResult==null && other.getVersionResult()==null) || 
             (this.versionResult!=null &&
              this.versionResult.equals(other.getVersionResult())));
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
        if (getVersionResult() != null) {
            _hashCode += getVersionResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(VersionResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", ">VersionResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("versionResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservices.currencysystem.com/currencyserver/", "VersionResult"));
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
