/**
 * CodeView.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thinkgem.jeesite.modules.nwws.syentity;

public class CodeView  extends BaseView  implements java.io.Serializable {
    private java.lang.String CODE_TYPE;

    private java.lang.String MATCHING;

    private java.lang.String NAME;

    private java.lang.String PARENT_CODE;

    private java.lang.String SORT;

    private java.lang.String VALUE;

    public CodeView() {
    }

    public CodeView(
           java.lang.String modelName,
           java.lang.String CODE_TYPE,
           java.lang.String MATCHING,
           java.lang.String NAME,
           java.lang.String PARENT_CODE,
           java.lang.String SORT,
           java.lang.String VALUE) {
        super(
            modelName);
        this.CODE_TYPE = CODE_TYPE;
        this.MATCHING = MATCHING;
        this.NAME = NAME;
        this.PARENT_CODE = PARENT_CODE;
        this.SORT = SORT;
        this.VALUE = VALUE;
    }


    /**
     * Gets the CODE_TYPE value for this CodeView.
     * 
     * @return CODE_TYPE
     */
    public java.lang.String getCODE_TYPE() {
        return CODE_TYPE;
    }


    /**
     * Sets the CODE_TYPE value for this CodeView.
     * 
     * @param CODE_TYPE
     */
    public void setCODE_TYPE(java.lang.String CODE_TYPE) {
        this.CODE_TYPE = CODE_TYPE;
    }


    /**
     * Gets the MATCHING value for this CodeView.
     * 
     * @return MATCHING
     */
    public java.lang.String getMATCHING() {
        return MATCHING;
    }


    /**
     * Sets the MATCHING value for this CodeView.
     * 
     * @param MATCHING
     */
    public void setMATCHING(java.lang.String MATCHING) {
        this.MATCHING = MATCHING;
    }


    /**
     * Gets the NAME value for this CodeView.
     * 
     * @return NAME
     */
    public java.lang.String getNAME() {
        return NAME;
    }


    /**
     * Sets the NAME value for this CodeView.
     * 
     * @param NAME
     */
    public void setNAME(java.lang.String NAME) {
        this.NAME = NAME;
    }


    /**
     * Gets the PARENT_CODE value for this CodeView.
     * 
     * @return PARENT_CODE
     */
    public java.lang.String getPARENT_CODE() {
        return PARENT_CODE;
    }


    /**
     * Sets the PARENT_CODE value for this CodeView.
     * 
     * @param PARENT_CODE
     */
    public void setPARENT_CODE(java.lang.String PARENT_CODE) {
        this.PARENT_CODE = PARENT_CODE;
    }


    /**
     * Gets the SORT value for this CodeView.
     * 
     * @return SORT
     */
    public java.lang.String getSORT() {
        return SORT;
    }


    /**
     * Sets the SORT value for this CodeView.
     * 
     * @param SORT
     */
    public void setSORT(java.lang.String SORT) {
        this.SORT = SORT;
    }


    /**
     * Gets the VALUE value for this CodeView.
     * 
     * @return VALUE
     */
    public java.lang.String getVALUE() {
        return VALUE;
    }


    /**
     * Sets the VALUE value for this CodeView.
     * 
     * @param VALUE
     */
    public void setVALUE(java.lang.String VALUE) {
        this.VALUE = VALUE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CodeView)) return false;
        CodeView other = (CodeView) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.CODE_TYPE==null && other.getCODE_TYPE()==null) || 
             (this.CODE_TYPE!=null &&
              this.CODE_TYPE.equals(other.getCODE_TYPE()))) &&
            ((this.MATCHING==null && other.getMATCHING()==null) || 
             (this.MATCHING!=null &&
              this.MATCHING.equals(other.getMATCHING()))) &&
            ((this.NAME==null && other.getNAME()==null) || 
             (this.NAME!=null &&
              this.NAME.equals(other.getNAME()))) &&
            ((this.PARENT_CODE==null && other.getPARENT_CODE()==null) || 
             (this.PARENT_CODE!=null &&
              this.PARENT_CODE.equals(other.getPARENT_CODE()))) &&
            ((this.SORT==null && other.getSORT()==null) || 
             (this.SORT!=null &&
              this.SORT.equals(other.getSORT()))) &&
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
        if (getCODE_TYPE() != null) {
            _hashCode += getCODE_TYPE().hashCode();
        }
        if (getMATCHING() != null) {
            _hashCode += getMATCHING().hashCode();
        }
        if (getNAME() != null) {
            _hashCode += getNAME().hashCode();
        }
        if (getPARENT_CODE() != null) {
            _hashCode += getPARENT_CODE().hashCode();
        }
        if (getSORT() != null) {
            _hashCode += getSORT().hashCode();
        }
        if (getVALUE() != null) {
            _hashCode += getVALUE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CodeView.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "CodeView"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CODE_TYPE");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "CODE_TYPE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MATCHING");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "MATCHING"));
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
        elemField.setFieldName("PARENT_CODE");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PARENT_CODE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SORT");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SORT"));
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
