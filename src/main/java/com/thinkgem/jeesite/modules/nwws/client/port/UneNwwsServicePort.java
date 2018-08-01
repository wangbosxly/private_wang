/**
 * UneNwwsServicePort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thinkgem.jeesite.modules.nwws.client.port;
import com.thinkgem.jeesite.modules.nwws.syentity.*;

/**
 * 失业保险    调用接口公共类
 * @description 
 * @since 20170616
 * @version 1.0
 */
public interface UneNwwsServicePort extends java.rmi.Remote {
    public CodeView[] nwws0010(UserView userView, CodeView codeView) throws java.rmi.RemoteException;
    public PM_AB88View[] nwwssy1104(UserView userView, PM_AB88View pM_AB88View) throws java.rmi.RemoteException;
    public PM_AB88View[] nwwssy1302(UserView userView, PM_AB88View pM_AB88View) throws java.rmi.RemoteException;
    public PM_AB88View[] nwwssy1901(UserView userView, PM_AB88View pM_AB88View) throws java.rmi.RemoteException;
    public PM_AB88View[] nwwssy1902(UserView userView, PM_AB88View pM_AB88View) throws java.rmi.RemoteException;
    public PM_AC01View[] nwwssy1105(UserView userView, CodeView codeView) throws java.rmi.RemoteException;
    public PM_AC01View[] nwwssy2101(UserView userView, PM_AC01View pM_AC01View) throws java.rmi.RemoteException;
    public PM_AC01View[] nwwssy2102(UserView userView, PM_AC01View pM_AC01View) throws java.rmi.RemoteException;
    public PM_AC01View[] nwwssy2103(UserView userView, PM_AC01View pM_AC01View) throws java.rmi.RemoteException;
    public PM_AC01View[] nwwssy2107(UserView userView, PM_AC01View pM_AC01View) throws java.rmi.RemoteException;
    public PM_AC88View[] nwwssy2104(UserView userView, PM_AC88View pM_AC88View) throws java.rmi.RemoteException;
    public PM_JC02View[] nwwssy2105(UserView userView, PM_JC02View pM_JC02View) throws java.rmi.RemoteException;
    public PM_JC02View[] nwwssy2106(UserView userView, PM_JC02View pM_JC02View) throws java.rmi.RemoteException;
    public DailySynView nwws0402(UserView userView, DailySynView dailySynView) throws java.rmi.RemoteException;
    public PM_AB01View nwwssy1101(UserView userView, PM_AB01View pM_AB01View) throws java.rmi.RemoteException;
    public PM_JC02View nwwssy2901(UserView userView, PM_AC01View pM_AC01View) throws java.rmi.RemoteException;
    public PM_JC02View nwwssy2902(UserView userView, PM_AC01View pM_AC01View) throws java.rmi.RemoteException;
    public ParamView nwwssy0002(UserView userView, ParamView paramView) throws java.rmi.RemoteException;
    public SS02View nwwssy0003(UserView userView, SS02View sS02View) throws java.rmi.RemoteException;
    public SS04View nwws0001(UserView userView, SS04View sS04View) throws java.rmi.RemoteException;
    public SYRealSynView nwws0401(UserView userView, RealSynView realSynView) throws java.rmi.RemoteException;
    public void nwws0301(UserView userView, SA06AView sA06AView) throws java.rmi.RemoteException;
    public void nwws0302(UserView userView, SA06AView sA06AView) throws java.rmi.RemoteException;
    public void nwwssy1301(UserView userView, PM_AB88View pM_AB88View) throws java.rmi.RemoteException;
    public void nwwssy1311(UserView userView, PM_AB88View pM_AB88View) throws java.rmi.RemoteException;
    public void nwwssy1701(UserView userView, PM_AB01View pM_AB01View) throws java.rmi.RemoteException;
    public void nwwssy2301(UserView userView, PM_AC01View pM_AC01View) throws java.rmi.RemoteException;
    public void nwwssy2302(UserView userView, PM_AC01View[] pM_AC01Views) throws java.rmi.RemoteException;
    public void nwwssy2310(UserView userView, PM_JC02View pM_JC02View) throws java.rmi.RemoteException;
    public void nwwssy2311(UserView userView, PM_JC02View pM_JC02View) throws java.rmi.RemoteException;
    public void nwwssy2701(UserView userView, PM_AC01View pM_AC01View) throws java.rmi.RemoteException;
    public void nwwssy2702(UserView userView, PM_AC01View[] pM_AC01Views) throws java.rmi.RemoteException;
    public void nwwssy2703(UserView userView, PM_AC01View[] pM_AC01Views) throws java.rmi.RemoteException;
}
