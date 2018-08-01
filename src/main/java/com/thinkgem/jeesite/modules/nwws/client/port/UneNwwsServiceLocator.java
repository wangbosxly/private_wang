/**
 * UneNwwsServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thinkgem.jeesite.modules.nwws.client.port;

/**
 * 失业保险    调用接口公共类
 * @description 
 * @since 20170616
 * @version 1.0
 */
public class UneNwwsServiceLocator extends org.apache.axis.client.Service implements UneNwwsService {

    public UneNwwsServiceLocator() {
    }


    public UneNwwsServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public UneNwwsServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for UneNwwsServicePort
//    private java.lang.String UneNwwsServicePort_address = "http://10.189.129.236:8001/UneNwwsService/UneNwwsService";//正式
    private String UneNwwsServicePort_address = "http://10.189.129.227:7901/UneNwwsService/UneNwwsService?WSDL";//测试


    public String getUneNwwsServicePortAddress() {
        return UneNwwsServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private String UneNwwsServicePortWSDDServiceName = "UneNwwsServicePort";

    public String getUneNwwsServicePortWSDDServiceName() {
        return UneNwwsServicePortWSDDServiceName;
    }

    public void setUneNwwsServicePortWSDDServiceName(String name) {
        UneNwwsServicePortWSDDServiceName = name;
    }

    public UneNwwsServicePort getUneNwwsServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(UneNwwsServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getUneNwwsServicePort(endpoint);
    }

    public UneNwwsServicePort getUneNwwsServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            UneNwwsServicePortStub _stub = new UneNwwsServicePortStub(portAddress, this);
            _stub.setPortName(getUneNwwsServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setUneNwwsServicePortEndpointAddress(String address) {
        UneNwwsServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (UneNwwsServicePort.class.isAssignableFrom(serviceEndpointInterface)) {
                UneNwwsServicePortStub _stub = new UneNwwsServicePortStub(new java.net.URL(UneNwwsServicePort_address), this);
                _stub.setPortName(getUneNwwsServicePortWSDDServiceName());
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
        if ("UneNwwsServicePort".equals(inputPortName)) {
            return getUneNwwsServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://127.0.0.1:8001", "UneNwwsService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://127.0.0.1:8001", "UneNwwsServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {

if ("UneNwwsServicePort".equals(portName)) {
            setUneNwwsServicePortEndpointAddress(address);
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
