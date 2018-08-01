/**
 * SSCWEB12333Locator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thinkgem.jeesite.modules.nwws.client.port;

public class SSCWEB12333Locator extends org.apache.axis.client.Service implements SSCWEB12333 {

    public SSCWEB12333Locator() {
    }


    public SSCWEB12333Locator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SSCWEB12333Locator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SSCWEB12333Port
    //private java.lang.String SSCWEB12333Port_address = "http://10.189.128.24:6101/SSCWEB12333/SSCWEB12333";
    private java.lang.String SSCWEB12333Port_address = "http://10.189.128.24:8501/SSCWEB12333/SSCWEB12333";

    public java.lang.String getSSCWEB12333PortAddress() {
        return SSCWEB12333Port_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SSCWEB12333PortWSDDServiceName = "SSCWEB12333Port";

    public java.lang.String getSSCWEB12333PortWSDDServiceName() {
        return SSCWEB12333PortWSDDServiceName;
    }

    public void setSSCWEB12333PortWSDDServiceName(java.lang.String name) {
        SSCWEB12333PortWSDDServiceName = name;
    }

    public SSCWEB12333Port getSSCWEB12333Port() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SSCWEB12333Port_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSSCWEB12333Port(endpoint);
    }

    public SSCWEB12333Port getSSCWEB12333Port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            SSCWEB12333PortStub _stub = new SSCWEB12333PortStub(portAddress, this);
            _stub.setPortName(getSSCWEB12333PortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSSCWEB12333PortEndpointAddress(java.lang.String address) {
        SSCWEB12333Port_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (SSCWEB12333Port.class.isAssignableFrom(serviceEndpointInterface)) {
                SSCWEB12333PortStub _stub = new SSCWEB12333PortStub(new java.net.URL(SSCWEB12333Port_address), this);
                _stub.setPortName(getSSCWEB12333PortWSDDServiceName());
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
        if ("SSCWEB12333Port".equals(inputPortName)) {
            return getSSCWEB12333Port();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://127.0.0.1:7003", "SSCWEB12333");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://127.0.0.1:7003", "SSCWEB12333Port"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SSCWEB12333Port".equals(portName)) {
            setSSCWEB12333PortEndpointAddress(address);
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
