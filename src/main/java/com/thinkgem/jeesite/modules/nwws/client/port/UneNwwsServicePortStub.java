/**
 * UneNwwsServicePortStub.java
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
public class UneNwwsServicePortStub extends org.apache.axis.client.Stub implements UneNwwsServicePort {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[33];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws0010");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "codeView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "CodeView"), CodeView.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfCodeView"));
        oper.setReturnClass(CodeView[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy1104");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AB88View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AB88View"), PM_AB88View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AB88View"));
        oper.setReturnClass(PM_AB88View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy1302");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AB88View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AB88View"), PM_AB88View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AB88View"));
        oper.setReturnClass(PM_AB88View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy1901");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AB88View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AB88View"), PM_AB88View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AB88View"));
        oper.setReturnClass(PM_AB88View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy1902");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AB88View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AB88View"), PM_AB88View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AB88View"));
        oper.setReturnClass(PM_AB88View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy1105");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "codeView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "CodeView"), CodeView.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"));
        oper.setReturnClass(PM_AC01View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy2101");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View"), PM_AC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"));
        oper.setReturnClass(PM_AC01View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy2102");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View"), PM_AC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"));
        oper.setReturnClass(PM_AC01View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy2103");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View"), PM_AC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"));
        oper.setReturnClass(PM_AC01View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy2107");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View"), PM_AC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"));
        oper.setReturnClass(PM_AC01View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy2104");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC88View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC88View"), PM_AC88View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC88View"));
        oper.setReturnClass(PM_AC88View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy2105");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_JC02View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_JC02View"), PM_JC02View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_JC02View"));
        oper.setReturnClass(PM_JC02View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy2106");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_JC02View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_JC02View"), PM_JC02View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_JC02View"));
        oper.setReturnClass(PM_JC02View[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws0402");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "dailySynView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "DailySynView"), DailySynView.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "DailySynView"));
        oper.setReturnClass(DailySynView.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy1101");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AB01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AB01View"), PM_AB01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AB01View"));
        oper.setReturnClass(PM_AB01View.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy2901");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View"), PM_AC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_JC02View"));
        oper.setReturnClass(PM_JC02View.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy2902");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View"), PM_AC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_JC02View"));
        oper.setReturnClass(PM_JC02View.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy0002");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "paramView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ParamView"), ParamView.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ParamView"));
        oper.setReturnClass(ParamView.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy0003");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sS02View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SS02View"), SS02View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SS02View"));
        oper.setReturnClass(SS02View.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws0001");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sS04View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SS04View"), SS04View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SS04View"));
        oper.setReturnClass(SS04View.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws0401");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "realSynView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "RealSynView"), RealSynView.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SYRealSynView"));
        oper.setReturnClass(SYRealSynView.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "result"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws0301");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sA06AView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SA06AView"), SA06AView.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwws0302");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "sA06AView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SA06AView"), SA06AView.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy1301");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AB88View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AB88View"), PM_AB88View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy1311");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AB88View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AB88View"), PM_AB88View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy1701");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AB01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AB01View"), PM_AB01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy2301");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View"), PM_AC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy2302");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01Views"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"), PM_AC01View[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy2310");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_JC02View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_JC02View"), PM_JC02View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy2311");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_JC02View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_JC02View"), PM_JC02View.class, false, false);
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
        oper.setName("nwwssy2701");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01View"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View"), PM_AC01View.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy2702");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01Views"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"), PM_AC01View[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("nwwssy2703");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userView"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView"), UserView.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pM_AC01Views"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View"), PM_AC01View[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[32] = oper;

    }

    public UneNwwsServicePortStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public UneNwwsServicePortStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public UneNwwsServicePortStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfCodeView");
            cachedSerQNames.add(qName);
            cls = CodeView[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "CodeView");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AB88View");
            cachedSerQNames.add(qName);
            cls = PM_AB88View[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AB88View");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC01View");
            cachedSerQNames.add(qName);
            cls = PM_AC01View[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_AC88View");
            cachedSerQNames.add(qName);
            cls = PM_AC88View[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC88View");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfPM_JC02View");
            cachedSerQNames.add(qName);
            cls = PM_JC02View[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_JC02View");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfSynCountView");
            cachedSerQNames.add(qName);
            cls = SynCountView[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SynCountView");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfSynSA06AView");
            cachedSerQNames.add(qName);
            cls = SynSA06AView[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SynSA06AView");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ArrayOfSYSynSA06AView");
            cachedSerQNames.add(qName);
            cls = SYSynSA06AView[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SYSynSA06AView");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "BaseView");
            cachedSerQNames.add(qName);
            cls = BaseView.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "CodeView");
            cachedSerQNames.add(qName);
            cls = CodeView.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "DailySynView");
            cachedSerQNames.add(qName);
            cls = DailySynView.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ParamView");
            cachedSerQNames.add(qName);
            cls = ParamView.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AB01View");
            cachedSerQNames.add(qName);
            cls = PM_AB01View.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AB88View");
            cachedSerQNames.add(qName);
            cls = PM_AB88View.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC01View");
            cachedSerQNames.add(qName);
            cls = PM_AC01View.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_AC88View");
            cachedSerQNames.add(qName);
            cls = PM_AC88View.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_JC02View");
            cachedSerQNames.add(qName);
            cls = PM_JC02View.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "RealSynView");
            cachedSerQNames.add(qName);
            cls = RealSynView.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SA06AView");
            cachedSerQNames.add(qName);
            cls = SA06AView.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SS02View");
            cachedSerQNames.add(qName);
            cls = SS02View.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SS04View");
            cachedSerQNames.add(qName);
            cls = SS04View.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SynCountView");
            cachedSerQNames.add(qName);
            cls = SynCountView.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SynSA06AView");
            cachedSerQNames.add(qName);
            cls = SynSA06AView.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SYRealSynView");
            cachedSerQNames.add(qName);
            cls = SYRealSynView.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SYSynSA06AView");
            cachedSerQNames.add(qName);
            cls = SYSynSA06AView.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "UserView");
            cachedSerQNames.add(qName);
            cls = UserView.class;
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
                String key = (String) keys.nextElement();
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
                        Class cls = (Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            Class sf = (Class)
                                 cachedSerFactories.get(i);
                            Class df = (Class)
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
        catch (Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public CodeView[] nwws0010(UserView userView, CodeView codeView) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwws0010"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, codeView});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (CodeView[]) _resp;
            } catch (Exception _exception) {
                return (CodeView[]) org.apache.axis.utils.JavaUtils.convert(_resp, CodeView[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public PM_AB88View[] nwwssy1104(UserView userView, PM_AB88View pM_AB88View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy1104"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, pM_AB88View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (PM_AB88View[]) _resp;
            } catch (Exception _exception) {
                return (PM_AB88View[]) org.apache.axis.utils.JavaUtils.convert(_resp, PM_AB88View[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public PM_AB88View[] nwwssy1302(UserView userView, PM_AB88View pM_AB88View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy1302"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, pM_AB88View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (PM_AB88View[]) _resp;
            } catch (Exception _exception) {
                return (PM_AB88View[]) org.apache.axis.utils.JavaUtils.convert(_resp, PM_AB88View[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public PM_AB88View[] nwwssy1901(UserView userView, PM_AB88View pM_AB88View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy1901"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, pM_AB88View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (PM_AB88View[]) _resp;
            } catch (Exception _exception) {
                return (PM_AB88View[]) org.apache.axis.utils.JavaUtils.convert(_resp, PM_AB88View[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public PM_AB88View[] nwwssy1902(UserView userView, PM_AB88View pM_AB88View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy1902"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, pM_AB88View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (PM_AB88View[]) _resp;
            } catch (Exception _exception) {
                return (PM_AB88View[]) org.apache.axis.utils.JavaUtils.convert(_resp, PM_AB88View[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public PM_AC01View[] nwwssy1105(UserView userView, CodeView codeView) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy1105"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, codeView});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (PM_AC01View[]) _resp;
            } catch (Exception _exception) {
                return (PM_AC01View[]) org.apache.axis.utils.JavaUtils.convert(_resp, PM_AC01View[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public PM_AC01View[] nwwssy2101(UserView userView, PM_AC01View pM_AC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy2101"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, pM_AC01View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (PM_AC01View[]) _resp;
            } catch (Exception _exception) {
                return (PM_AC01View[]) org.apache.axis.utils.JavaUtils.convert(_resp, PM_AC01View[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public PM_AC01View[] nwwssy2102(UserView userView, PM_AC01View pM_AC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy2102"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, pM_AC01View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (PM_AC01View[]) _resp;
            } catch (Exception _exception) {
                return (PM_AC01View[]) org.apache.axis.utils.JavaUtils.convert(_resp, PM_AC01View[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public PM_AC01View[] nwwssy2103(UserView userView, PM_AC01View pM_AC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy2103"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, pM_AC01View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (PM_AC01View[]) _resp;
            } catch (Exception _exception) {
                return (PM_AC01View[]) org.apache.axis.utils.JavaUtils.convert(_resp, PM_AC01View[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public PM_AC01View[] nwwssy2107(UserView userView, PM_AC01View pM_AC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy2107"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, pM_AC01View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (PM_AC01View[]) _resp;
            } catch (Exception _exception) {
                return (PM_AC01View[]) org.apache.axis.utils.JavaUtils.convert(_resp, PM_AC01View[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public PM_AC88View[] nwwssy2104(UserView userView, PM_AC88View pM_AC88View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy2104"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, pM_AC88View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (PM_AC88View[]) _resp;
            } catch (Exception _exception) {
                return (PM_AC88View[]) org.apache.axis.utils.JavaUtils.convert(_resp, PM_AC88View[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public PM_JC02View[] nwwssy2105(UserView userView, PM_JC02View pM_JC02View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy2105"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, pM_JC02View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (PM_JC02View[]) _resp;
            } catch (Exception _exception) {
                return (PM_JC02View[]) org.apache.axis.utils.JavaUtils.convert(_resp, PM_JC02View[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public PM_JC02View[] nwwssy2106(UserView userView, PM_JC02View pM_JC02View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy2106"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, pM_JC02View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (PM_JC02View[]) _resp;
            } catch (Exception _exception) {
                return (PM_JC02View[]) org.apache.axis.utils.JavaUtils.convert(_resp, PM_JC02View[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public DailySynView nwws0402(UserView userView, DailySynView dailySynView) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwws0402"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, dailySynView});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (DailySynView) _resp;
            } catch (Exception _exception) {
                return (DailySynView) org.apache.axis.utils.JavaUtils.convert(_resp, DailySynView.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public PM_AB01View nwwssy1101(UserView userView, PM_AB01View pM_AB01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy1101"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, pM_AB01View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (PM_AB01View) _resp;
            } catch (Exception _exception) {
                return (PM_AB01View) org.apache.axis.utils.JavaUtils.convert(_resp, PM_AB01View.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public PM_JC02View nwwssy2901(UserView userView, PM_AC01View pM_AC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy2901"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, pM_AC01View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (PM_JC02View) _resp;
            } catch (Exception _exception) {
                return (PM_JC02View) org.apache.axis.utils.JavaUtils.convert(_resp, PM_JC02View.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public PM_JC02View nwwssy2902(UserView userView, PM_AC01View pM_AC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy2902"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, pM_AC01View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (PM_JC02View) _resp;
            } catch (Exception _exception) {
                return (PM_JC02View) org.apache.axis.utils.JavaUtils.convert(_resp, PM_JC02View.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ParamView nwwssy0002(UserView userView, ParamView paramView) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy0002"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, paramView});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ParamView) _resp;
            } catch (Exception _exception) {
                return (ParamView) org.apache.axis.utils.JavaUtils.convert(_resp, ParamView.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public SS02View nwwssy0003(UserView userView, SS02View sS02View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy0003"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, sS02View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (SS02View) _resp;
            } catch (Exception _exception) {
                return (SS02View) org.apache.axis.utils.JavaUtils.convert(_resp, SS02View.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public SS04View nwws0001(UserView userView, SS04View sS04View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwws0001"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, sS04View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (SS04View) _resp;
            } catch (Exception _exception) {
                return (SS04View) org.apache.axis.utils.JavaUtils.convert(_resp, SS04View.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public SYRealSynView nwws0401(UserView userView, RealSynView realSynView) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwws0401"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, realSynView});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (SYRealSynView) _resp;
            } catch (Exception _exception) {
                return (SYRealSynView) org.apache.axis.utils.JavaUtils.convert(_resp, SYRealSynView.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwws0301(UserView userView, SA06AView sA06AView) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwws0301"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, sA06AView});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwws0302(UserView userView, SA06AView sA06AView) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwws0302"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, sA06AView});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwwssy1301(UserView userView, PM_AB88View pM_AB88View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy1301"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, pM_AB88View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwwssy1311(UserView userView, PM_AB88View pM_AB88View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy1311"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, pM_AB88View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwwssy1701(UserView userView, PM_AB01View pM_AB01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy1701"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, pM_AB01View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwwssy2301(UserView userView, PM_AC01View pM_AC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy2301"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, pM_AC01View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwwssy2302(UserView userView, PM_AC01View[] pM_AC01Views) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy2302"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, pM_AC01Views});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwwssy2310(UserView userView, PM_JC02View pM_JC02View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy2310"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, pM_JC02View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwwssy2311(UserView userView, PM_JC02View pM_JC02View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy2311"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, pM_JC02View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwwssy2701(UserView userView, PM_AC01View pM_AC01View) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy2701"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, pM_AC01View});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwwssy2702(UserView userView, PM_AC01View[] pM_AC01Views) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy2702"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, pM_AC01Views});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void nwwssy2703(UserView userView, PM_AC01View[] pM_AC01Views) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://127.0.0.1:8001", "nwwssy2703"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {userView, pM_AC01Views});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
