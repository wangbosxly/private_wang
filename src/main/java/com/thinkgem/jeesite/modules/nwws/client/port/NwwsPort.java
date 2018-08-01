package com.thinkgem.jeesite.modules.nwws.client.port;

import lss.nw_ws.valueobject.*;




public interface NwwsPort extends java.rmi.Remote {
    public  AB02View[] nwws2804(java.lang.String string, java.lang.String string0) throws java.rmi.RemoteException;
    public  CodeView[] nwws0010( UserView userView,  CodeView codeView) throws java.rmi.RemoteException;
    public  PM_AB88View[] nwws1104( UserView userView,  PM_AB88View pM_AB88View) throws java.rmi.RemoteException;
    public  PM_AC01View[] nwws2101( UserView userView,  PM_AC01View pM_AC01View) throws java.rmi.RemoteException;
    public  PM_AC01View[] nwws2102( UserView userView,  PM_AC01View pM_AC01View) throws java.rmi.RemoteException;
    public  PM_AC01View[] nwws2103( UserView userView,  PM_AC01View pM_AC01View) throws java.rmi.RemoteException;
    public  PM_AC01View[] nwws2201( UserView userView,  PM_AC01View pM_AC01View) throws java.rmi.RemoteException;
    public  PM_AC01View[] nwws2202( UserView userView,  PM_AC01View pM_AC01View) throws java.rmi.RemoteException;
    public  PM_AC88View[] nwws2204( UserView userView,  PM_AC88View pM_AC88View) throws java.rmi.RemoteException;
    public  PM_KB01View[] nwws0011( UserView userView,  PM_KB01View pM_KB01View) throws java.rmi.RemoteException;
    public  PM_KC31View[] nwws2363( UserView userView,  PM_KC31View pM_KC31View) throws java.rmi.RemoteException;
    public  PM_MC01View[] nwws2151( UserView userView,  PM_MC01View pM_MC01View) throws java.rmi.RemoteException;
    public  SA06AView[] nwws0303( SA06AView sA06AView) throws java.rmi.RemoteException;
    public  SA06AView[] querysa06A( SA06AView sA06AView) throws java.rmi.RemoteException;
    public  DailySynView nwws0402( UserView userView,  DailySynView dailySynView) throws java.rmi.RemoteException;
    public  PM_AB01View nwws1101( UserView userView,  PM_AB01View pM_AB01View) throws java.rmi.RemoteException;
    public  PM_IC10View nwws0000( UserView userView,  PM_IC10View pM_IC10View) throws java.rmi.RemoteException;
    public  RealSynView nwws0401( UserView userView,  SA06AView sA06AView) throws java.rmi.RemoteException;
    public  SS02View nwws0002( UserView userView,  SS02View sS02View) throws java.rmi.RemoteException;
    public  SS02View nwws0003( UserView userView,  SS02View sS02View) throws java.rmi.RemoteException;
    public  SS04View nwws0001( UserView userView,  SS04View sS04View) throws java.rmi.RemoteException;
    public void nwws0301( UserView userView,  SA06AView sA06AView) throws java.rmi.RemoteException;
    public void nwws0302( UserView userView,  SA06AView sA06AView) throws java.rmi.RemoteException;
    public void nwws1311( UserView userView,  PM_AB88View pM_AB88View) throws java.rmi.RemoteException;
    public void nwws1701( UserView userView,  PM_AB01View pM_AB01View) throws java.rmi.RemoteException;
    public void nwws2301( UserView userView,  PM_AC01View pM_AC01View) throws java.rmi.RemoteException;
    public void nwws2302( UserView userView,  PM_AC01View[] pM_AC01Views) throws java.rmi.RemoteException;
    public void nwws2351( UserView userView,  PM_MC01View pM_MC01View) throws java.rmi.RemoteException;
    public void nwws2361( UserView userView,  PM_KC29View pM_KC29View) throws java.rmi.RemoteException;
    public void nwws2362( UserView userView,  PM_KC31View pM_KC31View) throws java.rmi.RemoteException;
    public void nwws2403( UserView userView,  PM_AC88View pM_AC88View) throws java.rmi.RemoteException;
    public void nwws2701( UserView userView,  PM_AC01View pM_AC01View) throws java.rmi.RemoteException;
    public void nwws2702( UserView userView,  PM_AC01View[] pM_AC01Views) throws java.rmi.RemoteException;
    public void nwws2703( UserView userView,  PM_AC01View[] pM_AC01Views) throws java.rmi.RemoteException;
    public void nwws2705( UserView userView,  PM_AC01View[] pM_AC01Views) throws java.rmi.RemoteException;
    public void nwws2801( UserView userView,  PM_AC01View pM_AC01View) throws java.rmi.RemoteException;
    public void nwws2802( UserView userView,  PM_AC01View pM_AC01View) throws java.rmi.RemoteException;
    public void nwws2803( UserView userView,  PM_AC01View pM_AC01View) throws java.rmi.RemoteException;
    public PM_AB01View[] nwws1113(PM_AB01View pM_AB01View) throws java.rmi.RemoteException;
    public PM_AC01View[] nwws1105(PM_AC01View[] pM_AC01View) throws java.rmi.RemoteException;
    public SA06AView[] nwws1106(UserView userView) throws java.rmi.RemoteException;
    public PM_AB01View[] nwws1107(PM_AB01View pM_AB01View) throws java.rmi.RemoteException;
    public PM_AC01View[] nwws1108(PM_AC01View pM_AC01View) throws java.rmi.RemoteException;
    public PM_AC01View[] nwws1109(PM_AC01View pM_AC01View) throws java.rmi.RemoteException;
    public PM_AC01View[] nwws1110(PM_AC01View pM_AC01View) throws java.rmi.RemoteException;
    public PM_AC01View[] nwws1111(PM_AC01View pM_AC01View) throws java.rmi.RemoteException;
    public PM_AC01View[] nwws1112(PM_AC01View pM_AC01View) throws java.rmi.RemoteException;
    public PM_AC01View[] nwws2104(UserView userView, PM_AC01View pM_AC01View) throws java.rmi.RemoteException;
    public PM_AC01View[] nwws2105(UserView userView, PM_AC01View pM_AC01View) throws java.rmi.RemoteException;
}
