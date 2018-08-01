/**
 * PM_KC61View.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thinkgem.jeesite.modules.ylbx.nw_ws.lss.entity;

public class PM_KC61View  extends BaseView  implements java.io.Serializable {
    private String AAC002_1;

    private String AAC002_2;

    private String AAC003_1;

    private String AAC003_2;

    private String AAE011;

    public PM_KC61View() {
    }

    public PM_KC61View(
           String modelName,
           String AAC002_1,
           String AAC002_2,
           String AAC003_1,
           String AAC003_2,
           String AAE011) {
        super(
            modelName);
        this.AAC002_1 = AAC002_1;
        this.AAC002_2 = AAC002_2;
        this.AAC003_1 = AAC003_1;
        this.AAC003_2 = AAC003_2;
        this.AAE011 = AAE011;
    }


    /**
     * Gets the AAC002_1 value for this PM_KC61View.
     * 
     * @return AAC002_1
     */
    public String getAAC002_1() {
        return AAC002_1;
    }


    /**
     * Sets the AAC002_1 value for this PM_KC61View.
     * 
     * @param AAC002_1
     */
    public void setAAC002_1(String AAC002_1) {
        this.AAC002_1 = AAC002_1;
    }


    /**
     * Gets the AAC002_2 value for this PM_KC61View.
     * 
     * @return AAC002_2
     */
    public String getAAC002_2() {
        return AAC002_2;
    }


    /**
     * Sets the AAC002_2 value for this PM_KC61View.
     * 
     * @param AAC002_2
     */
    public void setAAC002_2(String AAC002_2) {
        this.AAC002_2 = AAC002_2;
    }


    /**
     * Gets the AAC003_1 value for this PM_KC61View.
     * 
     * @return AAC003_1
     */
    public String getAAC003_1() {
        return AAC003_1;
    }


    /**
     * Sets the AAC003_1 value for this PM_KC61View.
     * 
     * @param AAC003_1
     */
    public void setAAC003_1(String AAC003_1) {
        this.AAC003_1 = AAC003_1;
    }


    /**
     * Gets the AAC003_2 value for this PM_KC61View.
     * 
     * @return AAC003_2
     */
    public String getAAC003_2() {
        return AAC003_2;
    }


    /**
     * Sets the AAC003_2 value for this PM_KC61View.
     * 
     * @param AAC003_2
     */
    public void setAAC003_2(String AAC003_2) {
        this.AAC003_2 = AAC003_2;
    }


    /**
     * Gets the AAE011 value for this PM_KC61View.
     * 
     * @return AAE011
     */
    public String getAAE011() {
        return AAE011;
    }


    /**
     * Sets the AAE011 value for this PM_KC61View.
     * 
     * @param AAE011
     */
    public void setAAE011(String AAE011) {
        this.AAE011 = AAE011;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof PM_KC61View)) return false;
        PM_KC61View other = (PM_KC61View) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.AAC002_1==null && other.getAAC002_1()==null) || 
             (this.AAC002_1!=null &&
              this.AAC002_1.equals(other.getAAC002_1()))) &&
            ((this.AAC002_2==null && other.getAAC002_2()==null) || 
             (this.AAC002_2!=null &&
              this.AAC002_2.equals(other.getAAC002_2()))) &&
            ((this.AAC003_1==null && other.getAAC003_1()==null) || 
             (this.AAC003_1!=null &&
              this.AAC003_1.equals(other.getAAC003_1()))) &&
            ((this.AAC003_2==null && other.getAAC003_2()==null) || 
             (this.AAC003_2!=null &&
              this.AAC003_2.equals(other.getAAC003_2()))) &&
            ((this.AAE011==null && other.getAAE011()==null) || 
             (this.AAE011!=null &&
              this.AAE011.equals(other.getAAE011())));
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
        if (getAAC002_1() != null) {
            _hashCode += getAAC002_1().hashCode();
        }
        if (getAAC002_2() != null) {
            _hashCode += getAAC002_2().hashCode();
        }
        if (getAAC003_1() != null) {
            _hashCode += getAAC003_1().hashCode();
        }
        if (getAAC003_2() != null) {
            _hashCode += getAAC003_2().hashCode();
        }
        if (getAAE011() != null) {
            _hashCode += getAAE011().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PM_KC61View.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_KC61View"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAC002_1");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAC002_1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAC002_2");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAC002_2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAC003_1");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAC003_1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAC003_2");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAC003_2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAE011");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAE011"));
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
