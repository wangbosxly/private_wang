/**
 * Nwws.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thinkgem.jeesite.modules.nwws.client.port;

public interface Nwws extends javax.xml.rpc.Service {
    public java.lang.String getnwwsPortAddress();

    public NwwsPort getnwwsPort() throws javax.xml.rpc.ServiceException;

    public NwwsPort getnwwsPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
