/**
 * SynCountView.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thinkgem.jeesite.modules.ylbx.nw_ws.lss.entity;

public class SynCountView  extends BaseView  implements java.io.Serializable {
    private Integer cnt;

    private String finishDate;

    public SynCountView() {
    }

    public SynCountView(
           String modelName,
           Integer cnt,
           String finishDate) {
        super(
            modelName);
        this.cnt = cnt;
        this.finishDate = finishDate;
    }


    /**
     * Gets the cnt value for this SynCountView.
     * 
     * @return cnt
     */
    public Integer getCnt() {
        return cnt;
    }


    /**
     * Sets the cnt value for this SynCountView.
     * 
     * @param cnt
     */
    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }


    /**
     * Gets the finishDate value for this SynCountView.
     * 
     * @return finishDate
     */
    public String getFinishDate() {
        return finishDate;
    }


    /**
     * Sets the finishDate value for this SynCountView.
     * 
     * @param finishDate
     */
    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SynCountView)) return false;
        SynCountView other = (SynCountView) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cnt==null && other.getCnt()==null) || 
             (this.cnt!=null &&
              this.cnt.equals(other.getCnt()))) &&
            ((this.finishDate==null && other.getFinishDate()==null) || 
             (this.finishDate!=null &&
              this.finishDate.equals(other.getFinishDate())));
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
        if (getCnt() != null) {
            _hashCode += getCnt().hashCode();
        }
        if (getFinishDate() != null) {
            _hashCode += getFinishDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SynCountView.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SynCountView"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cnt");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "cnt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("finishDate");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "finishDate"));
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
