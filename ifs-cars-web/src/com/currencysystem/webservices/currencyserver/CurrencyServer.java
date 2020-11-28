/**
 * CurrencyServer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.currencysystem.webservices.currencyserver;

public interface CurrencyServer extends javax.xml.rpc.Service {

/**
 * Currency Server - An exchange rate information and currency conversion
 * Web service.
 */
    public java.lang.String getCurrencyServerSoapAddress();

    public com.currencysystem.webservices.currencyserver.CurrencyServerSoap getCurrencyServerSoap() throws javax.xml.rpc.ServiceException;

    public com.currencysystem.webservices.currencyserver.CurrencyServerSoap getCurrencyServerSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
