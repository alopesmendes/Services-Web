/**
 * BankServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.corp.bank;

@SuppressWarnings("all")
public class BankServiceServiceLocator extends org.apache.axis.client.Service implements fr.uge.corp.bank.BankServiceService {

    public BankServiceServiceLocator() {
    }


    public BankServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BankServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BankService
    private java.lang.String BankService_address = "http://localhost:8080/bank/services/BankService";

    public java.lang.String getBankServiceAddress() {
        return BankService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BankServiceWSDDServiceName = "BankService";

    public java.lang.String getBankServiceWSDDServiceName() {
        return BankServiceWSDDServiceName;
    }

    public void setBankServiceWSDDServiceName(java.lang.String name) {
        BankServiceWSDDServiceName = name;
    }

    public fr.uge.corp.bank.BankService getBankService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BankService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBankService(endpoint);
    }

    public fr.uge.corp.bank.BankService getBankService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            fr.uge.corp.bank.BankServiceSoapBindingStub _stub = new fr.uge.corp.bank.BankServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getBankServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBankServiceEndpointAddress(java.lang.String address) {
        BankService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (fr.uge.corp.bank.BankService.class.isAssignableFrom(serviceEndpointInterface)) {
                fr.uge.corp.bank.BankServiceSoapBindingStub _stub = new fr.uge.corp.bank.BankServiceSoapBindingStub(new java.net.URL(BankService_address), this);
                _stub.setPortName(getBankServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BankService".equals(inputPortName)) {
            return getBankService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://bank.corp.uge.fr", "BankServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://bank.corp.uge.fr", "BankService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BankService".equals(portName)) {
            setBankServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
