/**
 * NwwsPortStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thinkgem.jeesite.modules.nwws.client.port;

import java.rmi.RemoteException;

import lss.nw_ws.valueobject.*;

public class NwwsPortStub extends org.apache.axis.client.Stub implements NwwsPort {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[49];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws2804");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "string"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "string0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfAB02View"));
        oper.setReturnClass(AB02View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws0010");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "codeView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "CodeView"), CodeView.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfCodeView"));
        oper.setReturnClass( CodeView[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws1104");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AB88View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AB88View"),  PM_AB88View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AB88View"));
        oper.setReturnClass( PM_AB88View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws2101");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View"),  PM_AC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"));
        oper.setReturnClass( PM_AC01View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws2102");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View"),  PM_AC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"));
        oper.setReturnClass( PM_AC01View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws2103");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View"),  PM_AC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"));
        oper.setReturnClass( PM_AC01View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws2201");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View"),  PM_AC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"));
        oper.setReturnClass( PM_AC01View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws2202");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View"),  PM_AC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"));
        oper.setReturnClass( PM_AC01View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws2204");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC88View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC88View"),  PM_AC88View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC88View"));
        oper.setReturnClass( PM_AC88View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws0011");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_KB01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_KB01View"),  PM_KB01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_KB01View"));
        oper.setReturnClass( PM_KB01View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws2363");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_KC31View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_KC31View"),  PM_KC31View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_KC31View"));
        oper.setReturnClass( PM_KC31View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws2151");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_MC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_MC01View"),  PM_MC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_MC01View"));
        oper.setReturnClass( PM_MC01View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws0303");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sA06AView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SA06AView"),  SA06AView.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfSA06AView"));
        oper.setReturnClass( SA06AView[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("querysa06A");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sA06AView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SA06AView"),  SA06AView.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfSA06AView"));
        oper.setReturnClass( SA06AView[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws0402");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "dailySynView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "DailySynView"),  DailySynView.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "DailySynView"));
        oper.setReturnClass( DailySynView.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws1101");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AB01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AB01View"),  PM_AB01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AB01View"));
        oper.setReturnClass( PM_AB01View.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws0000");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_IC10View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_IC10View"),  PM_IC10View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_IC10View"));
        oper.setReturnClass( PM_IC10View.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws0401");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sA06AView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SA06AView"),  SA06AView.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "RealSynView"));
        oper.setReturnClass( RealSynView.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws0002");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sS02View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SS02View"),  SS02View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SS02View"));
        oper.setReturnClass( SS02View.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws0003");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sS02View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SS02View"),  SS02View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SS02View"));
        oper.setReturnClass( SS02View.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws0001");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sS04View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SS04View"),  SS04View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SS04View"));
        oper.setReturnClass( SS04View.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws0301");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sA06AView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SA06AView"),  SA06AView.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws0302");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sA06AView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SA06AView"),  SA06AView.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws1311");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AB88View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AB88View"),  PM_AB88View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws1701");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AB01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AB01View"),  PM_AB01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws2301");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View"),  PM_AC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws2302");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01Views"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"),  PM_AC01View[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws2351");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_MC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_MC01View"),  PM_MC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws2361");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_KC29View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_KC29View"),  PM_KC29View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws2362");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_KC31View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_KC31View"),  PM_KC31View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws2403");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC88View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC88View"),  PM_AC88View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws2701");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View"),  PM_AC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws2702");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01Views"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"),  PM_AC01View[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[32] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws2703");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01Views"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"),  PM_AC01View[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[33] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws2705");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01Views"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"),  PM_AC01View[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[34] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws2801");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View"),  PM_AC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[35] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws2802");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View"),  PM_AC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[36] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws2803");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),  UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View"),  PM_AC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[37] = oper;
        
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws1105");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01Views"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"), PM_AC01View[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"));
        oper.setReturnClass(PM_AC01View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[38] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws1106");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfSA06AView"));
        oper.setReturnClass(SA06AView[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[39] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws1107");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AB01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AB01View"), PM_AB01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AB01View"));
        oper.setReturnClass(PM_AB01View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[40] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws1108");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View"), PM_AC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"));
        oper.setReturnClass(PM_AC01View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[41] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws1109");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View"), PM_AC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"));
        oper.setReturnClass(PM_AC01View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[42] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws1110");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View"), PM_AC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"));
        oper.setReturnClass(PM_AC01View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[43] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws1111");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View"),PM_AC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"));
        oper.setReturnClass(PM_AC01View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[44] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws1112");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View"), PM_AC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"));
        oper.setReturnClass(PM_AC01View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[45] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws1113");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AB01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AB01View"), PM_AB01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AB01View"));
        oper.setReturnClass(PM_AB01View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[46] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws2104");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View"),PM_AC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"));
        oper.setReturnClass(PM_AC01View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[47] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws2105");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"),UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View"), PM_AC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"));
        oper.setReturnClass(PM_AC01View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[48] = oper;

    }

    public NwwsPortStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public NwwsPortStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public NwwsPortStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AB02View");
            cachedSerQNames.add(qName);
            cls =  AB02View.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfAB02View");
            cachedSerQNames.add(qName);
            cls =  AB02View[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AB02View");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfCodeView");
            cachedSerQNames.add(qName);
            cls =  CodeView[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "CodeView");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AB88View");
            cachedSerQNames.add(qName);
            cls =  PM_AB88View[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AB88View");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View");
            cachedSerQNames.add(qName);
            cls =  PM_AC01View[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC88View");
            cachedSerQNames.add(qName);
            cls =  PM_AC88View[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC88View");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_KB01View");
            cachedSerQNames.add(qName);
            cls =  PM_KB01View[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_KB01View");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_KC31View");
            cachedSerQNames.add(qName);
            cls =  PM_KC31View[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_KC31View");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_MC01View");
            cachedSerQNames.add(qName);
            cls =  PM_MC01View[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_MC01View");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfSA06AView");
            cachedSerQNames.add(qName);
            cls =  SA06AView[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SA06AView");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfSynCountView");
            cachedSerQNames.add(qName);
            cls =  SynCountView[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SynCountView");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfSynSA06AView");
            cachedSerQNames.add(qName);
            cls =  SynSA06AView[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SynSA06AView");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BaseView");
            cachedSerQNames.add(qName);
            cls =  BaseView.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "CodeView");
            cachedSerQNames.add(qName);
            cls =  CodeView.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "DailySynView");
            cachedSerQNames.add(qName);
            cls =  DailySynView.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AB01View");
            cachedSerQNames.add(qName);
            cls =  PM_AB01View.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AB88View");
            cachedSerQNames.add(qName);
            cls =  PM_AB88View.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View");
            cachedSerQNames.add(qName);
            cls =  PM_AC01View.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC88View");
            cachedSerQNames.add(qName);
            cls =  PM_AC88View.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_IC10View");
            cachedSerQNames.add(qName);
            cls =  PM_IC10View.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_KB01View");
            cachedSerQNames.add(qName);
            cls =  PM_KB01View.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_KC29View");
            cachedSerQNames.add(qName);
            cls =  PM_KC29View.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_KC31View");
            cachedSerQNames.add(qName);
            cls =  PM_KC31View.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_MC01View");
            cachedSerQNames.add(qName);
            cls =  PM_MC01View.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "RealSynView");
            cachedSerQNames.add(qName);
            cls =  RealSynView.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SA06AView");
            cachedSerQNames.add(qName);
            cls =  SA06AView.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SS02View");
            cachedSerQNames.add(qName);
            cls =  SS02View.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SS04View");
            cachedSerQNames.add(qName);
            cls =  SS04View.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SynCountView");
            cachedSerQNames.add(qName);
            cls =  SynCountView.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SynSA06AView");
            cachedSerQNames.add(qName);
            cls =  SynSA06AView.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView");
            cachedSerQNames.add(qName);
            cls =  UserView.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
                    _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public  AB02View[] nwws2804(java.lang.String string, java.lang.String string0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws2804"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {string, string0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ( AB02View[]) _resp;
            } catch (java.lang.Exception _exception) {
                return ( AB02View[]) org.apache.axis.utils.JavaUtils.convert(_resp,  AB02View[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public  CodeView[] nwws0010( UserView userView,  CodeView codeView) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws0010"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, codeView});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ( CodeView[]) _resp;
            } catch (java.lang.Exception _exception) {
                return ( CodeView[]) org.apache.axis.utils.JavaUtils.convert(_resp,  CodeView[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public  PM_AB88View[] nwws1104( UserView userView,  PM_AB88View pM_AB88View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws1104"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_AB88View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ( PM_AB88View[]) _resp;
            } catch (java.lang.Exception _exception) {
                return ( PM_AB88View[]) org.apache.axis.utils.JavaUtils.convert(_resp,  PM_AB88View[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public  PM_AC01View[] nwws2101( UserView userView,  PM_AC01View pM_AC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws2101"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_AC01View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ( PM_AC01View[]) _resp;
            } catch (java.lang.Exception _exception) {
                return ( PM_AC01View[]) org.apache.axis.utils.JavaUtils.convert(_resp,  PM_AC01View[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public  PM_AC01View[] nwws2102( UserView userView,  PM_AC01View pM_AC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws2102"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_AC01View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ( PM_AC01View[]) _resp;
            } catch (java.lang.Exception _exception) {
                return ( PM_AC01View[]) org.apache.axis.utils.JavaUtils.convert(_resp,  PM_AC01View[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public  PM_AC01View[] nwws2103( UserView userView,  PM_AC01View pM_AC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws2103"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_AC01View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ( PM_AC01View[]) _resp;
            } catch (java.lang.Exception _exception) {
                return ( PM_AC01View[]) org.apache.axis.utils.JavaUtils.convert(_resp,  PM_AC01View[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public  PM_AC01View[] nwws2201( UserView userView,  PM_AC01View pM_AC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws2201"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_AC01View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ( PM_AC01View[]) _resp;
            } catch (java.lang.Exception _exception) {
                return ( PM_AC01View[]) org.apache.axis.utils.JavaUtils.convert(_resp,  PM_AC01View[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public  PM_AC01View[] nwws2202( UserView userView,  PM_AC01View pM_AC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws2202"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_AC01View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ( PM_AC01View[]) _resp;
            } catch (java.lang.Exception _exception) {
                return ( PM_AC01View[]) org.apache.axis.utils.JavaUtils.convert(_resp,  PM_AC01View[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public  PM_AC88View[] nwws2204( UserView userView,  PM_AC88View pM_AC88View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws2204"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_AC88View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ( PM_AC88View[]) _resp;
            } catch (java.lang.Exception _exception) {
                return ( PM_AC88View[]) org.apache.axis.utils.JavaUtils.convert(_resp,  PM_AC88View[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public  PM_KB01View[] nwws0011( UserView userView,  PM_KB01View pM_KB01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws0011"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_KB01View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ( PM_KB01View[]) _resp;
            } catch (java.lang.Exception _exception) {
                return ( PM_KB01View[]) org.apache.axis.utils.JavaUtils.convert(_resp,  PM_KB01View[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public  PM_KC31View[] nwws2363( UserView userView,  PM_KC31View pM_KC31View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws2363"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_KC31View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ( PM_KC31View[]) _resp;
            } catch (java.lang.Exception _exception) {
                return ( PM_KC31View[]) org.apache.axis.utils.JavaUtils.convert(_resp,  PM_KC31View[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public  PM_MC01View[] nwws2151( UserView userView,  PM_MC01View pM_MC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws2151"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_MC01View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ( PM_MC01View[]) _resp;
            } catch (java.lang.Exception _exception) {
                return ( PM_MC01View[]) org.apache.axis.utils.JavaUtils.convert(_resp,  PM_MC01View[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public  SA06AView[] nwws0303( SA06AView sA06AView) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws0303"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sA06AView});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ( SA06AView[]) _resp;
            } catch (java.lang.Exception _exception) {
                return ( SA06AView[]) org.apache.axis.utils.JavaUtils.convert(_resp,  SA06AView[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public  SA06AView[] querysa06A( SA06AView sA06AView) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "querysa06A"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sA06AView});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ( SA06AView[]) _resp;
            } catch (java.lang.Exception _exception) {
                return ( SA06AView[]) org.apache.axis.utils.JavaUtils.convert(_resp,  SA06AView[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public  DailySynView nwws0402( UserView userView,  DailySynView dailySynView) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws0402"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, dailySynView});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ( DailySynView) _resp;
            } catch (java.lang.Exception _exception) {
                return ( DailySynView) org.apache.axis.utils.JavaUtils.convert(_resp,  DailySynView.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public  PM_AB01View nwws1101( UserView userView,  PM_AB01View pM_AB01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws1101"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_AB01View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ( PM_AB01View) _resp;
            } catch (java.lang.Exception _exception) {
                return ( PM_AB01View) org.apache.axis.utils.JavaUtils.convert(_resp,  PM_AB01View.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public  PM_IC10View nwws0000( UserView userView,  PM_IC10View pM_IC10View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws0000"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_IC10View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ( PM_IC10View) _resp;
            } catch (java.lang.Exception _exception) {
                return ( PM_IC10View) org.apache.axis.utils.JavaUtils.convert(_resp,  PM_IC10View.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public  RealSynView nwws0401( UserView userView,  SA06AView sA06AView) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws0401"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, sA06AView});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ( RealSynView) _resp;
            } catch (java.lang.Exception _exception) {
                return ( RealSynView) org.apache.axis.utils.JavaUtils.convert(_resp,  RealSynView.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public  SS02View nwws0002( UserView userView,  SS02View sS02View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws0002"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, sS02View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ( SS02View) _resp;
            } catch (java.lang.Exception _exception) {
                return ( SS02View) org.apache.axis.utils.JavaUtils.convert(_resp,  SS02View.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public  SS02View nwws0003( UserView userView,  SS02View sS02View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws0003"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, sS02View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ( SS02View) _resp;
            } catch (java.lang.Exception _exception) {
                return ( SS02View) org.apache.axis.utils.JavaUtils.convert(_resp,  SS02View.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public  SS04View nwws0001( UserView userView,  SS04View sS04View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws0001"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, sS04View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ( SS04View) _resp;
            } catch (java.lang.Exception _exception) {
                return ( SS04View) org.apache.axis.utils.JavaUtils.convert(_resp,  SS04View.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwws0301( UserView userView,  SA06AView sA06AView) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws0301"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, sA06AView});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwws0302( UserView userView,  SA06AView sA06AView) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws0302"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, sA06AView});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwws1311( UserView userView,  PM_AB88View pM_AB88View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws1311"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_AB88View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwws1701( UserView userView,  PM_AB01View pM_AB01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws1701"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_AB01View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwws2301( UserView userView,  PM_AC01View pM_AC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws2301"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_AC01View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwws2302( UserView userView,  PM_AC01View[] pM_AC01Views) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws2302"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_AC01Views});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwws2351( UserView userView,  PM_MC01View pM_MC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws2351"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_MC01View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwws2361( UserView userView,  PM_KC29View pM_KC29View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws2361"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_KC29View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwws2362( UserView userView,  PM_KC31View pM_KC31View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws2362"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_KC31View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwws2403( UserView userView,  PM_AC88View pM_AC88View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws2403"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_AC88View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwws2701( UserView userView,  PM_AC01View pM_AC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws2701"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_AC01View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwws2702( UserView userView,  PM_AC01View[] pM_AC01Views) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws2702"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_AC01Views});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwws2703( UserView userView,  PM_AC01View[] pM_AC01Views) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[33]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws2703"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_AC01Views});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwws2705( UserView userView,  PM_AC01View[] pM_AC01Views) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[34]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws2705"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_AC01Views});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwws2801( UserView userView,  PM_AC01View pM_AC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[35]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws2801"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_AC01View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwws2802( UserView userView,  PM_AC01View pM_AC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[36]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws2802"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_AC01View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwws2803( UserView userView,  PM_AC01View pM_AC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[37]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws2803"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_AC01View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }
    
    public PM_AC01View[] nwws1105(PM_AC01View[] pM_AC01Views) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[38]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws1105"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pM_AC01Views});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (PM_AC01View[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (PM_AC01View[]) org.apache.axis.utils.JavaUtils.convert(_resp,PM_AC01View[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }


    public SA06AView[] nwws1106(UserView userView) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[39]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws1106"));

        setRequestHeaders(_call);
        setAttachments(_call);
        try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView});

            if (_resp instanceof java.rmi.RemoteException) {
                throw (java.rmi.RemoteException)_resp;
            }
            else {
                extractAttachments(_call);
                try {
                    return (SA06AView[]) _resp;
                } catch (java.lang.Exception _exception) {
                    return (SA06AView[]) org.apache.axis.utils.JavaUtils.convert(_resp, SA06AView[].class);
                }
            }
        } catch (org.apache.axis.AxisFault axisFaultException) {
            throw axisFaultException;
        }
    }


    public PM_AB01View[] nwws1107(PM_AB01View pM_AB01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[40]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws1107"));

        setRequestHeaders(_call);
        setAttachments(_call);
        try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pM_AB01View});

            if (_resp instanceof java.rmi.RemoteException) {
                throw (java.rmi.RemoteException)_resp;
            }
            else {
                extractAttachments(_call);
                try {
                    return (PM_AB01View[]) _resp;
                } catch (java.lang.Exception _exception) {
                    return (PM_AB01View[]) org.apache.axis.utils.JavaUtils.convert(_resp, PM_AB01View[].class);
                }
            }
        } catch (org.apache.axis.AxisFault axisFaultException) {
            throw axisFaultException;
        }
    }
    public PM_AC01View[] nwws1108(PM_AC01View pM_AC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[41]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws1108"));

        setRequestHeaders(_call);
        setAttachments(_call);
        try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pM_AC01View});

            if (_resp instanceof java.rmi.RemoteException) {
                throw (java.rmi.RemoteException)_resp;
            }
            else {
                extractAttachments(_call);
                try {
                    return (PM_AC01View[]) _resp;
                } catch (java.lang.Exception _exception) {
                    return (PM_AC01View[]) org.apache.axis.utils.JavaUtils.convert(_resp, PM_AC01View[].class);
                }
            }
        } catch (org.apache.axis.AxisFault axisFaultException) {
            throw axisFaultException;
        }
    }

    public PM_AC01View[] nwws1109(PM_AC01View pM_AC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[42]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws1109"));

        setRequestHeaders(_call);
        setAttachments(_call);
        try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pM_AC01View});

            if (_resp instanceof java.rmi.RemoteException) {
                throw (java.rmi.RemoteException)_resp;
            }
            else {
                extractAttachments(_call);
                try {
                    return (PM_AC01View[]) _resp;
                } catch (java.lang.Exception _exception) {
                    return (PM_AC01View[]) org.apache.axis.utils.JavaUtils.convert(_resp, PM_AC01View[].class);
                }
            }
        } catch (org.apache.axis.AxisFault axisFaultException) {
            throw axisFaultException;
        }
    }

    public PM_AC01View[] nwws1110(PM_AC01View pM_AC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[43]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws1110"));

        setRequestHeaders(_call);
        setAttachments(_call);
        try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pM_AC01View});

            if (_resp instanceof java.rmi.RemoteException) {
                throw (java.rmi.RemoteException)_resp;
            }
            else {
                extractAttachments(_call);
                try {
                    return (PM_AC01View[]) _resp;
                } catch (java.lang.Exception _exception) {
                    return (PM_AC01View[]) org.apache.axis.utils.JavaUtils.convert(_resp, PM_AC01View[].class);
                }
            }
        } catch (org.apache.axis.AxisFault axisFaultException) {
            throw axisFaultException;
        }
    }

    public PM_AC01View[] nwws1111(PM_AC01View pM_AC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[44]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws1111"));

        setRequestHeaders(_call);
        setAttachments(_call);
        try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pM_AC01View});

            if (_resp instanceof java.rmi.RemoteException) {
                throw (java.rmi.RemoteException)_resp;
            }
            else {
                extractAttachments(_call);
                try {
                    return (PM_AC01View[]) _resp;
                } catch (java.lang.Exception _exception) {
                    return (PM_AC01View[]) org.apache.axis.utils.JavaUtils.convert(_resp, PM_AC01View[].class);
                }
            }
        } catch (org.apache.axis.AxisFault axisFaultException) {
            throw axisFaultException;
        }
    }
    public PM_AC01View[] nwws1112(PM_AC01View pM_AC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[45]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws1112"));

        setRequestHeaders(_call);
        setAttachments(_call);
        try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pM_AC01View});

            if (_resp instanceof java.rmi.RemoteException) {
                throw (java.rmi.RemoteException)_resp;
            }
            else {
                extractAttachments(_call);
                try {
                    return (PM_AC01View[]) _resp;
                } catch (java.lang.Exception _exception) {
                    return (PM_AC01View[]) org.apache.axis.utils.JavaUtils.convert(_resp, PM_AC01View[].class);
                }
            }
        } catch (org.apache.axis.AxisFault axisFaultException) {
            throw axisFaultException;
        }
    }

    public PM_AB01View[] nwws1113(PM_AB01View pM_AB01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[46]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws1113"));

        setRequestHeaders(_call);
        setAttachments(_call);
        try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {pM_AB01View});

            if (_resp instanceof java.rmi.RemoteException) {
                throw (java.rmi.RemoteException)_resp;
            }
            else {
                extractAttachments(_call);
                try {
                    return (PM_AB01View[]) _resp;
                } catch (java.lang.Exception _exception) {
                    return (PM_AB01View[]) org.apache.axis.utils.JavaUtils.convert(_resp, PM_AB01View[].class);
                }
            }
        } catch (org.apache.axis.AxisFault axisFaultException) {
            throw axisFaultException;
        }
    }

    public PM_AC01View[] nwws2104(UserView userView, PM_AC01View pM_AC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[47]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws2104"));

        setRequestHeaders(_call);
        setAttachments(_call);
        try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_AC01View});

            if (_resp instanceof java.rmi.RemoteException) {
                throw (java.rmi.RemoteException)_resp;
            }
            else {
                extractAttachments(_call);
                try {
                    return (PM_AC01View[]) _resp;
                } catch (java.lang.Exception _exception) {
                    return (PM_AC01View[]) org.apache.axis.utils.JavaUtils.convert(_resp, PM_AC01View[].class);
                }
            }
        } catch (org.apache.axis.AxisFault axisFaultException) {
            throw axisFaultException;
        }
    }

    public PM_AC01View[] nwws2105(UserView userView, PM_AC01View pM_AC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[48]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:7003", "nwws2105"));

        setRequestHeaders(_call);
        setAttachments(_call);
        try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userView, pM_AC01View});

            if (_resp instanceof java.rmi.RemoteException) {
                throw (java.rmi.RemoteException)_resp;
            }
            else {
                extractAttachments(_call);
                try {
                    return (PM_AC01View[]) _resp;
                } catch (java.lang.Exception _exception) {
                    return (PM_AC01View[]) org.apache.axis.utils.JavaUtils.convert(_resp, PM_AC01View[].class);
                }
            }
        } catch (org.apache.axis.AxisFault axisFaultException) {
            throw axisFaultException;
        }
    }

}