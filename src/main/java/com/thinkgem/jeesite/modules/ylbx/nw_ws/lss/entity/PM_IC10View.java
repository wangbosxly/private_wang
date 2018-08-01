/**
 * PM_IC10View.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thinkgem.jeesite.modules.ylbx.nw_ws.lss.entity;

public class PM_IC10View  extends BaseView  implements java.io.Serializable {
    private String AAC001;

    private String AAC002;

    private String AAC003;

    private String AIC142;

    private String AIC162;

    public PM_IC10View() {
    }

    public PM_IC10View(
           String modelName,
           String AAC001,
           String AAC002,
           String AAC003,
           String AIC142,
           String AIC162) {
        super(
            modelName);
        this.AAC001 = AAC001;
        this.AAC002 = AAC002;
        this.AAC003 = AAC003;
        this.AIC142 = AIC142;
        this.AIC162 = AIC162;
    }


    /**
     * Gets the AAC001 value for this PM_IC10View.
     * 
     * @return AAC001
     */
    public String getAAC001() {
        return AAC001;
    }


    /**
     * Sets the AAC001 value for this PM_IC10View.
     * 
     * @param AAC001
     */
    public void setAAC001(String AAC001) {
        this.AAC001 = AAC001;
    }


    /**
     * Gets the AAC002 value for this PM_IC10View.
     * 
     * @return AAC002
     */
    public String getAAC002() {
        return AAC002;
    }


    /**
     * Sets the AAC002 value for this PM_IC10View.
     * 
     * @param AAC002
     */
    public void setAAC002(String AAC002) {
        this.AAC002 = AAC002;
    }


    /**
     * Gets the AAC003 value for this PM_IC10View.
     * 
     * @return AAC003
     */
    public String getAAC003() {
        return AAC003;
    }


    /**
     * Sets the AAC003 value for this PM_IC10View.
     * 
     * @param AAC003
     */
    public void setAAC003(String AAC003) {
        this.AAC003 = AAC003;
    }


    /**
     * Gets the AIC142 value for this PM_IC10View.
     * 
     * @return AIC142
     */
    public String getAIC142() {
        return AIC142;
    }


    /**
     * Sets the AIC142 value for this PM_IC10View.
     * 
     * @param AIC142
     */
    public void setAIC142(String AIC142) {
        this.AIC142 = AIC142;
    }


    /**
     * Gets the AIC162 value for this PM_IC10View.
     * 
     * @return AIC162
     */
    public String getAIC162() {
        return AIC162;
    }


    /**
     * Sets the AIC162 value for this PM_IC10View.
     * 
     * @param AIC162
     */
    public void setAIC162(String AIC162) {
        this.AIC162 = AIC162;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof PM_IC10View)) return false;
        PM_IC10View other = (PM_IC10View) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.AAC001==null && other.getAAC001()==null) || 
             (this.AAC001!=null &&
              this.AAC001.equals(other.getAAC001()))) &&
            ((this.AAC002==null && other.getAAC002()==null) || 
             (this.AAC002!=null &&
              this.AAC002.equals(other.getAAC002()))) &&
            ((this.AAC003==null && other.getAAC003()==null) || 
             (this.AAC003!=null &&
              this.AAC003.equals(other.getAAC003()))) &&
            ((this.AIC142==null && other.getAIC142()==null) || 
             (this.AIC142!=null &&
              this.AIC142.equals(other.getAIC142()))) &&
            ((this.AIC162==null && other.getAIC162()==null) || 
             (this.AIC162!=null &&
              this.AIC162.equals(other.getAIC162())));
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
        if (getAAC001() != null) {
            _hashCode += getAAC001().hashCode();
        }
        if (getAAC002() != null) {
            _hashCode += getAAC002().hashCode();
        }
        if (getAAC003() != null) {
            _hashCode += getAAC003().hashCode();
        }
        if (getAIC142() != null) {
            _hashCode += getAIC142().hashCode();
        }
        if (getAIC162() != null) {
            _hashCode += getAIC162().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PM_IC10View.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "PM_IC10View"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAC001");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAC001"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAC002");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAC002"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAC003");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAC003"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AIC142");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AIC142"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AIC162");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AIC162"));
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
