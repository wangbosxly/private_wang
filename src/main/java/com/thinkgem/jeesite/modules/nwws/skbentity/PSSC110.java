/**
 * PSSC110.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thinkgem.jeesite.modules.nwws.skbentity;

public class PSSC110  extends BaseView  implements java.io.Serializable {
    private java.lang.String AAC002;

    private java.lang.String AAE011;

    private java.lang.String AAE036;

    private java.lang.String AAZ500;

    private java.lang.String BAZ344;

    public PSSC110() {
    }

    public PSSC110(
           java.lang.String modelName,
           java.lang.String AAC002,
           java.lang.String AAE011,
           java.lang.String AAE036,
           java.lang.String AAZ500,
           java.lang.String BAZ344) {
        super(
            modelName);
        this.AAC002 = AAC002;
        this.AAE011 = AAE011;
        this.AAE036 = AAE036;
        this.AAZ500 = AAZ500;
        this.BAZ344 = BAZ344;
    }


    /**
     * Gets the AAC002 value for this PSSC110.
     * 
     * @return AAC002
     */
    public java.lang.String getAAC002() {
        return AAC002;
    }


    /**
     * Sets the AAC002 value for this PSSC110.
     * 
     * @param AAC002
     */
    public void setAAC002(java.lang.String AAC002) {
        this.AAC002 = AAC002;
    }


    /**
     * Gets the AAE011 value for this PSSC110.
     * 
     * @return AAE011
     */
    public java.lang.String getAAE011() {
        return AAE011;
    }


    /**
     * Sets the AAE011 value for this PSSC110.
     * 
     * @param AAE011
     */
    public void setAAE011(java.lang.String AAE011) {
        this.AAE011 = AAE011;
    }


    /**
     * Gets the AAE036 value for this PSSC110.
     * 
     * @return AAE036
     */
    public java.lang.String getAAE036() {
        return AAE036;
    }


    /**
     * Sets the AAE036 value for this PSSC110.
     * 
     * @param AAE036
     */
    public void setAAE036(java.lang.String AAE036) {
        this.AAE036 = AAE036;
    }


    /**
     * Gets the AAZ500 value for this PSSC110.
     * 
     * @return AAZ500
     */
    public java.lang.String getAAZ500() {
        return AAZ500;
    }


    /**
     * Sets the AAZ500 value for this PSSC110.
     * 
     * @param AAZ500
     */
    public void setAAZ500(java.lang.String AAZ500) {
        this.AAZ500 = AAZ500;
    }


    /**
     * Gets the BAZ344 value for this PSSC110.
     * 
     * @return BAZ344
     */
    public java.lang.String getBAZ344() {
        return BAZ344;
    }


    /**
     * Sets the BAZ344 value for this PSSC110.
     * 
     * @param BAZ344
     */
    public void setBAZ344(java.lang.String BAZ344) {
        this.BAZ344 = BAZ344;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PSSC110)) return false;
        PSSC110 other = (PSSC110) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.AAC002==null && other.getAAC002()==null) || 
             (this.AAC002!=null &&
              this.AAC002.equals(other.getAAC002()))) &&
            ((this.AAE011==null && other.getAAE011()==null) || 
             (this.AAE011!=null &&
              this.AAE011.equals(other.getAAE011()))) &&
            ((this.AAE036==null && other.getAAE036()==null) || 
             (this.AAE036!=null &&
              this.AAE036.equals(other.getAAE036()))) &&
            ((this.AAZ500==null && other.getAAZ500()==null) || 
             (this.AAZ500!=null &&
              this.AAZ500.equals(other.getAAZ500()))) &&
            ((this.BAZ344==null && other.getBAZ344()==null) || 
             (this.BAZ344!=null &&
              this.BAZ344.equals(other.getBAZ344())));
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
        if (getAAC002() != null) {
            _hashCode += getAAC002().hashCode();
        }
        if (getAAE011() != null) {
            _hashCode += getAAE011().hashCode();
        }
        if (getAAE036() != null) {
            _hashCode += getAAE036().hashCode();
        }
        if (getAAZ500() != null) {
            _hashCode += getAAZ500().hashCode();
        }
        if (getBAZ344() != null) {
            _hashCode += getBAZ344().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PSSC110.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("java:lss.socialsecurity.card.valueobject", "PSSC110"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAC002");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.socialsecurity.card.valueobject", "AAC002"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAE011");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.socialsecurity.card.valueobject", "AAE011"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAE036");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.socialsecurity.card.valueobject", "AAE036"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAZ500");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.socialsecurity.card.valueobject", "AAZ500"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAZ344");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.socialsecurity.card.valueobject", "BAZ344"));
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
