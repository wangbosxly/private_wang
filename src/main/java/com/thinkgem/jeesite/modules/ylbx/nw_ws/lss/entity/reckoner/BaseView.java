/**
 * BaseView.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thinkgem.jeesite.modules.ylbx.nw_ws.lss.entity.reckoner;

public class BaseView  implements java.io.Serializable {
    private String modelName;

    public BaseView() {
    }

    public BaseView(
           String modelName) {
           this.modelName = modelName;
    }


    /**
     * Gets the modelName value for this BaseView.
     * 
     * @return modelName
     */
    public String getModelName() {
        return modelName;
    }


    /**
     * Sets the modelName value for this BaseView.
     * 
     * @param modelName
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof BaseView)) return false;
        BaseView other = (BaseView) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.modelName==null && other.getModelName()==null) || 
             (this.modelName!=null &&
              this.modelName.equals(other.getModelName())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getModelName() != null) {
            _hashCode += getModelName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BaseView.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("java:lss.medicare.reckoner.valueobject", "BaseView"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modelName");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.medicare.reckoner.valueobject", "modelName"));
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
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
