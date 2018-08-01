/**
 * Nw_wsLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thinkgem.jeesite.modules.gsbx.nw_ws.lss.port;

public class Nw_wsLocator extends org.apache.axis.client.Service implements Nw_ws {

    public Nw_wsLocator() {
    }


    public Nw_wsLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Nw_wsLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for nw_wsPort
    //private String nw_wsPort_address = "http://10.189.187.45:7001/gsnw_ws/gsnw_ws";//本地
    private String nw_wsPort_address = "http://10.187.254.197:7001/gsnw_ws/gsnw_ws";//本地
   //private String nw_wsPort_address = "http://10.189.129.227:8005/gsnw_ws/gsnw_ws";//测试

    public String getnw_wsPortAddress() {
        return nw_wsPort_address;
    }

    // The WSDD service name defaults to the port name.
    private String nw_wsPortWSDDServiceName = "nw_wsPort";

    public String getnw_wsPortWSDDServiceName() {
        return nw_wsPortWSDDServiceName;
    }

    public void setnw_wsPortWSDDServiceName(String name) {
        nw_wsPortWSDDServiceName = name;
    }

    public Nw_wsPort getnw_wsPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(nw_wsPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getnw_wsPort(endpoint);
    }

    public Nw_wsPort getnw_wsPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            Nw_wsPortStub _stub = new Nw_wsPortStub(portAddress, this);
            _stub.setPortName(getnw_wsPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setnw_wsPortEndpointAddress(String address) {
        nw_wsPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (Nw_wsPort.class.isAssignableFrom(serviceEndpointInterface)) {
                Nw_wsPortStub _stub = new Nw_wsPortStub(new java.net.URL(nw_wsPort_address), this);
                _stub.setPortName(getnw_wsPortWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
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
        String inputPortName = portName.getLocalPart();
        if ("nw_wsPort".equals(inputPortName)) {
            return getnw_wsPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://127.0.0.1:7001", "nw_ws");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://127.0.0.1:7001", "nw_wsPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("nw_wsPort".equals(portName)) {
            setnw_wsPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
