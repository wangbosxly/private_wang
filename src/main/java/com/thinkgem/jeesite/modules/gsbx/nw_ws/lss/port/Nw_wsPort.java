/**
 * Nw_wsPort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thinkgem.jeesite.modules.gsbx.nw_ws.lss.port;

import com.thinkgem.jeesite.modules.gsbx.nw_ws.lss.entity.PM_AB88View;
import com.thinkgem.jeesite.modules.gsbx.nw_ws.lss.entity.PM_AC01View;
import com.thinkgem.jeesite.modules.gsbx.nw_ws.lss.entity.PM_KB01View;
import com.thinkgem.jeesite.modules.gsbx.nw_ws.lss.entity.UserView;

public interface Nw_wsPort extends java.rmi.Remote {
    public PM_KB01View[] nwws0011(UserView userView, PM_KB01View pM_KB01View) throws java.rmi.RemoteException;
    public String nwws0001(String string) throws java.rmi.RemoteException;
    public String nwws0004(String string) throws java.rmi.RemoteException;
    public String nwws0010(String string) throws java.rmi.RemoteException;
    public String nwws0301(String string) throws java.rmi.RemoteException;
    public String nwws0302(String string) throws java.rmi.RemoteException;
    public String nwws0401(String string) throws java.rmi.RemoteException;
    public String nwws0402(String string) throws java.rmi.RemoteException;
    public String nwws0403(String string) throws java.rmi.RemoteException;
    public String nwws1101(String string) throws java.rmi.RemoteException;
    public String nwws1102(String string) throws java.rmi.RemoteException;
    public String nwws1104(String string) throws java.rmi.RemoteException;
    public String nwws1105(String string) throws java.rmi.RemoteException;
    public String nwws1106(String string) throws java.rmi.RemoteException;
    public String nwws1107(String string) throws java.rmi.RemoteException;
    public String nwws1701(String string) throws java.rmi.RemoteException;
    public String nwws2101(String string) throws java.rmi.RemoteException;
    public String nwws2102(String string) throws java.rmi.RemoteException;
    public String nwws2103(String string) throws java.rmi.RemoteException;
    public String nwws2151(String string) throws java.rmi.RemoteException;
    public String nwws2301(String string) throws java.rmi.RemoteException;
    public String nwws2302(String string) throws java.rmi.RemoteException;
    public String nwws2351(String string) throws java.rmi.RemoteException;
    public String nwws2701(String string) throws java.rmi.RemoteException;
    public String nwws2702(String string) throws java.rmi.RemoteException;
    public String nwws2703(String string) throws java.rmi.RemoteException;
    public String nwws2901(String string) throws java.rmi.RemoteException;
    public String nwws2902(String string) throws java.rmi.RemoteException;
    public String nwws2903(String string) throws java.rmi.RemoteException;
    public String nwws2904(String string) throws java.rmi.RemoteException;
    public String nwws2905(String string) throws java.rmi.RemoteException;
    public void nwws1311(UserView userView, PM_AB88View pM_AB88View) throws java.rmi.RemoteException;
    public void nwws2705(UserView userView, PM_AC01View[] pM_AC01Views) throws java.rmi.RemoteException;
}
