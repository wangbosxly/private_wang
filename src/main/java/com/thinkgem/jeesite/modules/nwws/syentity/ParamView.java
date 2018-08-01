/**
 * ParamView.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thinkgem.jeesite.modules.nwws.syentity;

public class ParamView  extends BaseView  implements java.io.Serializable {
    private java.lang.String AAB034;

    private java.lang.String ERRORMESSAGE;

    private java.lang.String KEY;

    private java.lang.String NAME;

    private java.lang.String PARAM_TYPE;

    private java.lang.String SUCCEEFLAG;

    private java.lang.String VALUE;

    public ParamView() {
    }

    public ParamView(
           java.lang.String modelName,
           java.lang.String AAB034,
           java.lang.String ERRORMESSAGE,
           java.lang.String KEY,
           java.lang.String NAME,
           java.lang.String PARAM_TYPE,
           java.lang.String SUCCEEFLAG,
           java.lang.String VALUE) {
        super(
            modelName);
        this.AAB034 = AAB034;
        this.ERRORMESSAGE = ERRORMESSAGE;
        this.KEY = KEY;
        this.NAME = NAME;
        this.PARAM_TYPE = PARAM_TYPE;
        this.SUCCEEFLAG = SUCCEEFLAG;
        this.VALUE = VALUE;
    }


    /**
     * Gets the AAB034 value for this ParamView.
     * 
     * @return AAB034
     */
    public java.lang.String getAAB034() {
        return AAB034;
    }


    /**
     * Sets the AAB034 value for this ParamView.
     * 
     * @param AAB034
     */
    public void setAAB034(java.lang.String AAB034) {
        this.AAB034 = AAB034;
    }


    /**
     * Gets the ERRORMESSAGE value for this ParamView.
     * 
     * @return ERRORMESSAGE
     */
    public java.lang.String getERRORMESSAGE() {
        return ERRORMESSAGE;
    }


    /**
     * Sets the ERRORMESSAGE value for this ParamView.
     * 
     * @param ERRORMESSAGE
     */
    public void setERRORMESSAGE(java.lang.String ERRORMESSAGE) {
        this.ERRORMESSAGE = ERRORMESSAGE;
    }


    /**
     * Gets the KEY value for this ParamView.
     * 
     * @return KEY
     */
    public java.lang.String getKEY() {
        return KEY;
    }


    /**
     * Sets the KEY value for this ParamView.
     * 
     * @param KEY
     */
    public void setKEY(java.lang.String KEY) {
        this.KEY = KEY;
    }


    /**
     * Gets the NAME value for this ParamView.
     * 
     * @return NAME
     */
    public java.lang.String getNAME() {
        return NAME;
    }


    /**
     * Sets the NAME value for this ParamView.
     * 
     * @param NAME
     */
    public void setNAME(java.lang.String NAME) {
        this.NAME = NAME;
    }


    /**
     * Gets the PARAM_TYPE value for this ParamView.
     * 
     * @return PARAM_TYPE
     */
    public java.lang.String getPARAM_TYPE() {
        return PARAM_TYPE;
    }


    /**
     * Sets the PARAM_TYPE value for this ParamView.
     * 
     * @param PARAM_TYPE
     */
    public void setPARAM_TYPE(java.lang.String PARAM_TYPE) {
        this.PARAM_TYPE = PARAM_TYPE;
    }


    /**
     * Gets the SUCCEEFLAG value for this ParamView.
     * 
     * @return SUCCEEFLAG
     */
    public java.lang.String getSUCCEEFLAG() {
        return SUCCEEFLAG;
    }


    /**
     * Sets the SUCCEEFLAG value for this ParamView.
     * 
     * @param SUCCEEFLAG
     */
    public void setSUCCEEFLAG(java.lang.String SUCCEEFLAG) {
        this.SUCCEEFLAG = SUCCEEFLAG;
    }


    /**
     * Gets the VALUE value for this ParamView.
     * 
     * @return VALUE
     */
    public java.lang.String getVALUE() {
        return VALUE;
    }


    /**
     * Sets the VALUE value for this ParamView.
     * 
     * @param VALUE
     */
    public void setVALUE(java.lang.String VALUE) {
        this.VALUE = VALUE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ParamView)) return false;
        ParamView other = (ParamView) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.AAB034==null && other.getAAB034()==null) || 
             (this.AAB034!=null &&
              this.AAB034.equals(other.getAAB034()))) &&
            ((this.ERRORMESSAGE==null && other.getERRORMESSAGE()==null) || 
             (this.ERRORMESSAGE!=null &&
              this.ERRORMESSAGE.equals(other.getERRORMESSAGE()))) &&
            ((this.KEY==null && other.getKEY()==null) || 
             (this.KEY!=null &&
              this.KEY.equals(other.getKEY()))) &&
            ((this.NAME==null && other.getNAME()==null) || 
             (this.NAME!=null &&
              this.NAME.equals(other.getNAME()))) &&
            ((this.PARAM_TYPE==null && other.getPARAM_TYPE()==null) || 
             (this.PARAM_TYPE!=null &&
              this.PARAM_TYPE.equals(other.getPARAM_TYPE()))) &&
            ((this.SUCCEEFLAG==null && other.getSUCCEEFLAG()==null) || 
             (this.SUCCEEFLAG!=null &&
              this.SUCCEEFLAG.equals(other.getSUCCEEFLAG()))) &&
            ((this.VALUE==null && other.getVALUE()==null) || 
             (this.VALUE!=null &&
              this.VALUE.equals(other.getVALUE())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getAAB034() != null) {
            _hashCode += getAAB034().hashCode();
        }
        if (getERRORMESSAGE() != null) {
            _hashCode += getERRORMESSAGE().hashCode();
        }
        if (getKEY() != null) {
            _hashCode += getKEY().hashCode();
        }
        if (getNAME() != null) {
            _hashCode += getNAME().hashCode();
        }
        if (getPARAM_TYPE() != null) {
            _hashCode += getPARAM_TYPE().hashCode();
        }
        if (getSUCCEEFLAG() != null) {
            _hashCode += getSUCCEEFLAG().hashCode();
        }
        if (getVALUE() != null) {
            _hashCode += getVALUE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ParamView.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ParamView"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAB034");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAB034"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRORMESSAGE");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "ERRORMESSAGE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("KEY");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "KEY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NAME");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "NAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PARAM_TYPE");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PARAM_TYPE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SUCCEEFLAG");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SUCCEEFLAG"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VALUE");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "VALUE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
