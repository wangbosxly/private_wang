/**
 * NwwsLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thinkgem.jeesite.modules.nwws.client.port;

public class NwwsLocator extends org.apache.axis.client.Service implements  Nwws {

    public NwwsLocator() {
    }


    public NwwsLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public NwwsLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for nwwsPort
    private java.lang.String nwwsPort_address = "http://10.189.129.227:7011/nwws/nwws";

    public java.lang.String getnwwsPortAddress() {
        return nwwsPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String nwwsPortWSDDServiceName = "nwwsPort";

    public java.lang.String getnwwsPortWSDDServiceName() {
        return nwwsPortWSDDServiceName;
    }

    public void setnwwsPortWSDDServiceName(java.lang.String name) {
        nwwsPortWSDDServiceName = name;
    }

    public  NwwsPort getnwwsPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(nwwsPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getnwwsPort(endpoint);
    }

    public  NwwsPort getnwwsPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
             NwwsPortStub _stub = new  NwwsPortStub(portAddress, this);
            _stub.setPortName(getnwwsPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setnwwsPortEndpointAddress(java.lang.String address) {
        nwwsPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if ( NwwsPort.class.isAssignableFrom(serviceEndpointInterface)) {
                 NwwsPortStub _stub = new  NwwsPortStub(new java.net.URL(nwwsPort_address), this);
                _stub.setPortName(getnwwsPortWSDDServiceName());
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
        if ("nwwsPort".equals(inputPortName)) {
            return getnwwsPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://10.189.129.227:7011", "nwws");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://10.189.129.227:7011", "nwwsPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("nwwsPort".equals(portName)) {
            setnwwsPortEndpointAddress(address);
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
