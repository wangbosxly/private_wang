/**
 * AccountInoutView.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thinkgem.jeesite.modules.ylbx.nw_ws.lss.entity;

public class AccountInoutView  extends BaseView  implements java.io.Serializable {
    private String AAE002;

    private String AAE036;

    private String HRZCLX;

    private String JGMC;

    private double SRZCJE;

    private String SZLX;

    public AccountInoutView() {
    }

    public AccountInoutView(
           String modelName,
           String AAE002,
           String AAE036,
           String HRZCLX,
           String JGMC,
           double SRZCJE,
           String SZLX) {
        super(
            modelName);
        this.AAE002 = AAE002;
        this.AAE036 = AAE036;
        this.HRZCLX = HRZCLX;
        this.JGMC = JGMC;
        this.SRZCJE = SRZCJE;
        this.SZLX = SZLX;
    }


    /**
     * Gets the AAE002 value for this AccountInoutView.
     * 
     * @return AAE002
     */
    public String getAAE002() {
        return AAE002;
    }


    /**
     * Sets the AAE002 value for this AccountInoutView.
     * 
     * @param AAE002
     */
    public void setAAE002(String AAE002) {
        this.AAE002 = AAE002;
    }


    /**
     * Gets the AAE036 value for this AccountInoutView.
     * 
     * @return AAE036
     */
    public String getAAE036() {
        return AAE036;
    }


    /**
     * Sets the AAE036 value for this AccountInoutView.
     * 
     * @param AAE036
     */
    public void setAAE036(String AAE036) {
        this.AAE036 = AAE036;
    }


    /**
     * Gets the HRZCLX value for this AccountInoutView.
     * 
     * @return HRZCLX
     */
    public String getHRZCLX() {
        return HRZCLX;
    }


    /**
     * Sets the HRZCLX value for this AccountInoutView.
     * 
     * @param HRZCLX
     */
    public void setHRZCLX(String HRZCLX) {
        this.HRZCLX = HRZCLX;
    }


    /**
     * Gets the JGMC value for this AccountInoutView.
     * 
     * @return JGMC
     */
    public String getJGMC() {
        return JGMC;
    }


    /**
     * Sets the JGMC value for this AccountInoutView.
     * 
     * @param JGMC
     */
    public void setJGMC(String JGMC) {
        this.JGMC = JGMC;
    }


    /**
     * Gets the SRZCJE value for this AccountInoutView.
     * 
     * @return SRZCJE
     */
    public double getSRZCJE() {
        return SRZCJE;
    }


    /**
     * Sets the SRZCJE value for this AccountInoutView.
     * 
     * @param SRZCJE
     */
    public void setSRZCJE(double SRZCJE) {
        this.SRZCJE = SRZCJE;
    }


    /**
     * Gets the SZLX value for this AccountInoutView.
     * 
     * @return SZLX
     */
    public String getSZLX() {
        return SZLX;
    }


    /**
     * Sets the SZLX value for this AccountInoutView.
     * 
     * @param SZLX
     */
    public void setSZLX(String SZLX) {
        this.SZLX = SZLX;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof AccountInoutView)) return false;
        AccountInoutView other = (AccountInoutView) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.AAE002==null && other.getAAE002()==null) || 
             (this.AAE002!=null &&
              this.AAE002.equals(other.getAAE002()))) &&
            ((this.AAE036==null && other.getAAE036()==null) || 
             (this.AAE036!=null &&
              this.AAE036.equals(other.getAAE036()))) &&
            ((this.HRZCLX==null && other.getHRZCLX()==null) || 
             (this.HRZCLX!=null &&
              this.HRZCLX.equals(other.getHRZCLX()))) &&
            ((this.JGMC==null && other.getJGMC()==null) || 
             (this.JGMC!=null &&
              this.JGMC.equals(other.getJGMC()))) &&
            this.SRZCJE == other.getSRZCJE() &&
            ((this.SZLX==null && other.getSZLX()==null) || 
             (this.SZLX!=null &&
              this.SZLX.equals(other.getSZLX())));
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
        if (getAAE002() != null) {
            _hashCode += getAAE002().hashCode();
        }
        if (getAAE036() != null) {
            _hashCode += getAAE036().hashCode();
        }
        if (getHRZCLX() != null) {
            _hashCode += getHRZCLX().hashCode();
        }
        if (getJGMC() != null) {
            _hashCode += getJGMC().hashCode();
        }
        _hashCode += new Double(getSRZCJE()).hashCode();
        if (getSZLX() != null) {
            _hashCode += getSZLX().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AccountInoutView.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AccountInoutView"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAE002");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAE002"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AAE036");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AAE036"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("HRZCLX");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "HRZCLX"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("JGMC");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "JGMC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SRZCJE");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SRZCJE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SZLX");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SZLX"));
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
