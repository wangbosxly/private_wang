/**
 * SynSA06AView.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thinkgem.jeesite.modules.ylbx.nw_ws.lss.entity;

public class SynSA06AView  extends BaseView  implements java.io.Serializable {
    private String aab004;

    private String aab034;

    private String bus_Id;

    private String saa017;

    private String saa036;

    private String saa040;

    private String saa041;

    private String saa042;

    private String saa043;

    private String saa055;

    private String saa080;

    public SynSA06AView() {
    }

    public SynSA06AView(
           String modelName,
           String aab004,
           String aab034,
           String bus_Id,
           String saa017,
           String saa036,
           String saa040,
           String saa041,
           String saa042,
           String saa043,
           String saa055,
           String saa080) {
        super(
            modelName);
        this.aab004 = aab004;
        this.aab034 = aab034;
        this.bus_Id = bus_Id;
        this.saa017 = saa017;
        this.saa036 = saa036;
        this.saa040 = saa040;
        this.saa041 = saa041;
        this.saa042 = saa042;
        this.saa043 = saa043;
        this.saa055 = saa055;
        this.saa080 = saa080;
    }


    /**
     * Gets the aab004 value for this SynSA06AView.
     * 
     * @return aab004
     */
    public String getAab004() {
        return aab004;
    }


    /**
     * Sets the aab004 value for this SynSA06AView.
     * 
     * @param aab004
     */
    public void setAab004(String aab004) {
        this.aab004 = aab004;
    }


    /**
     * Gets the aab034 value for this SynSA06AView.
     * 
     * @return aab034
     */
    public String getAab034() {
        return aab034;
    }


    /**
     * Sets the aab034 value for this SynSA06AView.
     * 
     * @param aab034
     */
    public void setAab034(String aab034) {
        this.aab034 = aab034;
    }


    /**
     * Gets the bus_Id value for this SynSA06AView.
     * 
     * @return bus_Id
     */
    public String getBus_Id() {
        return bus_Id;
    }


    /**
     * Sets the bus_Id value for this SynSA06AView.
     * 
     * @param bus_Id
     */
    public void setBus_Id(String bus_Id) {
        this.bus_Id = bus_Id;
    }


    /**
     * Gets the saa017 value for this SynSA06AView.
     * 
     * @return saa017
     */
    public String getSaa017() {
        return saa017;
    }


    /**
     * Sets the saa017 value for this SynSA06AView.
     * 
     * @param saa017
     */
    public void setSaa017(String saa017) {
        this.saa017 = saa017;
    }


    /**
     * Gets the saa036 value for this SynSA06AView.
     * 
     * @return saa036
     */
    public String getSaa036() {
        return saa036;
    }


    /**
     * Sets the saa036 value for this SynSA06AView.
     * 
     * @param saa036
     */
    public void setSaa036(String saa036) {
        this.saa036 = saa036;
    }


    /**
     * Gets the saa040 value for this SynSA06AView.
     * 
     * @return saa040
     */
    public String getSaa040() {
        return saa040;
    }


    /**
     * Sets the saa040 value for this SynSA06AView.
     * 
     * @param saa040
     */
    public void setSaa040(String saa040) {
        this.saa040 = saa040;
    }


    /**
     * Gets the saa041 value for this SynSA06AView.
     * 
     * @return saa041
     */
    public String getSaa041() {
        return saa041;
    }


    /**
     * Sets the saa041 value for this SynSA06AView.
     * 
     * @param saa041
     */
    public void setSaa041(String saa041) {
        this.saa041 = saa041;
    }


    /**
     * Gets the saa042 value for this SynSA06AView.
     * 
     * @return saa042
     */
    public String getSaa042() {
        return saa042;
    }


    /**
     * Sets the saa042 value for this SynSA06AView.
     * 
     * @param saa042
     */
    public void setSaa042(String saa042) {
        this.saa042 = saa042;
    }


    /**
     * Gets the saa043 value for this SynSA06AView.
     * 
     * @return saa043
     */
    public String getSaa043() {
        return saa043;
    }


    /**
     * Sets the saa043 value for this SynSA06AView.
     * 
     * @param saa043
     */
    public void setSaa043(String saa043) {
        this.saa043 = saa043;
    }


    /**
     * Gets the saa055 value for this SynSA06AView.
     * 
     * @return saa055
     */
    public String getSaa055() {
        return saa055;
    }


    /**
     * Sets the saa055 value for this SynSA06AView.
     * 
     * @param saa055
     */
    public void setSaa055(String saa055) {
        this.saa055 = saa055;
    }


    /**
     * Gets the saa080 value for this SynSA06AView.
     * 
     * @return saa080
     */
    public String getSaa080() {
        return saa080;
    }


    /**
     * Sets the saa080 value for this SynSA06AView.
     * 
     * @param saa080
     */
    public void setSaa080(String saa080) {
        this.saa080 = saa080;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SynSA06AView)) return false;
        SynSA06AView other = (SynSA06AView) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.aab004==null && other.getAab004()==null) || 
             (this.aab004!=null &&
              this.aab004.equals(other.getAab004()))) &&
            ((this.aab034==null && other.getAab034()==null) || 
             (this.aab034!=null &&
              this.aab034.equals(other.getAab034()))) &&
            ((this.bus_Id==null && other.getBus_Id()==null) || 
             (this.bus_Id!=null &&
              this.bus_Id.equals(other.getBus_Id()))) &&
            ((this.saa017==null && other.getSaa017()==null) || 
             (this.saa017!=null &&
              this.saa017.equals(other.getSaa017()))) &&
            ((this.saa036==null && other.getSaa036()==null) || 
             (this.saa036!=null &&
              this.saa036.equals(other.getSaa036()))) &&
            ((this.saa040==null && other.getSaa040()==null) || 
             (this.saa040!=null &&
              this.saa040.equals(other.getSaa040()))) &&
            ((this.saa041==null && other.getSaa041()==null) || 
             (this.saa041!=null &&
              this.saa041.equals(other.getSaa041()))) &&
            ((this.saa042==null && other.getSaa042()==null) || 
             (this.saa042!=null &&
              this.saa042.equals(other.getSaa042()))) &&
            ((this.saa043==null && other.getSaa043()==null) || 
             (this.saa043!=null &&
              this.saa043.equals(other.getSaa043()))) &&
            ((this.saa055==null && other.getSaa055()==null) || 
             (this.saa055!=null &&
              this.saa055.equals(other.getSaa055()))) &&
            ((this.saa080==null && other.getSaa080()==null) || 
             (this.saa080!=null &&
              this.saa080.equals(other.getSaa080())));
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
        if (getAab004() != null) {
            _hashCode += getAab004().hashCode();
        }
        if (getAab034() != null) {
            _hashCode += getAab034().hashCode();
        }
        if (getBus_Id() != null) {
            _hashCode += getBus_Id().hashCode();
        }
        if (getSaa017() != null) {
            _hashCode += getSaa017().hashCode();
        }
        if (getSaa036() != null) {
            _hashCode += getSaa036().hashCode();
        }
        if (getSaa040() != null) {
            _hashCode += getSaa040().hashCode();
        }
        if (getSaa041() != null) {
            _hashCode += getSaa041().hashCode();
        }
        if (getSaa042() != null) {
            _hashCode += getSaa042().hashCode();
        }
        if (getSaa043() != null) {
            _hashCode += getSaa043().hashCode();
        }
        if (getSaa055() != null) {
            _hashCode += getSaa055().hashCode();
        }
        if (getSaa080() != null) {
            _hashCode += getSaa080().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SynSA06AView.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SynSA06AView"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aab004");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "aab004"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aab034");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "aab034"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bus_Id");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "bus_Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saa017");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "saa017"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saa036");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "saa036"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saa040");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "saa040"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saa041");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "saa041"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saa042");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "saa042"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saa043");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "saa043"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saa055");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "saa055"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saa080");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "saa080"));
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
