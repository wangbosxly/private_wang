/**
 * SSCWEB12333Port.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thinkgem.jeesite.modules.nwws.client.port;

import com.thinkgem.jeesite.modules.nwws.skbentity.PSSC110;
import com.thinkgem.jeesite.modules.nwws.skbentity.RSSC110;
import com.thinkgem.jeesite.modules.nwws.skbentity.SscInfoVO;
import com.thinkgem.jeesite.modules.nwws.skbentity.WebServiceResult;

public interface SSCWEB12333Port extends java.rmi.Remote {
    public String SSC109(SscInfoVO sscInfoVO) throws java.rmi.RemoteException;
    public String SSC111(String string) throws java.rmi.RemoteException;
    public RSSC110 SSC110(PSSC110 pSSC110) throws java.rmi.RemoteException;
    public WebServiceResult SSC101(SscInfoVO sscInfoVO) throws java.rmi.RemoteException;
    public WebServiceResult SSC102(SscInfoVO sscInfoVO) throws java.rmi.RemoteException;
    public WebServiceResult SSC103(SscInfoVO sscInfoVO) throws java.rmi.RemoteException;
    public WebServiceResult SSC104(SscInfoVO sscInfoVO) throws java.rmi.RemoteException;
    public WebServiceResult SSC105(SscInfoVO sscInfoVO) throws java.rmi.RemoteException;
    public WebServiceResult SSC106(SscInfoVO sscInfoVO) throws java.rmi.RemoteException;
    public WebServiceResult SSC107(SscInfoVO sscInfoVO) throws java.rmi.RemoteException;
    public WebServiceResult SSC108(SscInfoVO sscInfoVO) throws java.rmi.RemoteException;
    public WebServiceResult SSC112(SscInfoVO sscInfoVO) throws java.rmi.RemoteException;
}
