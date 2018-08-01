/**
 * RealSynView.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thinkgem.jeesite.modules.gsbx.nw_ws.lss.entity;

public class RealSynView  implements java.io.Serializable {
    private String action;

    private String endDate;

    private String operDate;

    private   SynSA06AView[] results;

    private String startDate;

    public RealSynView() {
    }

    public RealSynView(
           String action,
           String endDate,
           String operDate,
             SynSA06AView[] results,
           String startDate) {
           this.action = action;
           this.endDate = endDate;
           this.operDate = operDate;
           this.results = results;
           this.startDate = startDate;
    }


    /**
     * Gets the action value for this RealSynView.
     * 
     * @return action
     */
    public String getAction() {
        return action;
    }


    /**
     * Sets the action value for this RealSynView.
     * 
     * @param action
     */
    public void setAction(String action) {
        this.action = action;
    }


    /**
     * Gets the endDate value for this RealSynView.
     * 
     * @return endDate
     */
    public String getEndDate() {
        return endDate;
    }


    /**
     * Sets the endDate value for this RealSynView.
     * 
     * @param endDate
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


    /**
     * Gets the operDate value for this RealSynView.
     * 
     * @return operDate
     */
    public String getOperDate() {
        return operDate;
    }


    /**
     * Sets the operDate value for this RealSynView.
     * 
     * @param operDate
     */
    public void setOperDate(String operDate) {
        this.operDate = operDate;
    }


    /**
     * Gets the results value for this RealSynView.
     * 
     * @return results
     */
    public   SynSA06AView[] getResults() {
        return results;
    }


    /**
     * Sets the results value for this RealSynView.
     * 
     * @param results
     */
    public void setResults(  SynSA06AView[] results) {
        this.results = results;
    }


    /**
     * Gets the startDate value for this RealSynView.
     * 
     * @return startDate
     */
    public String getStartDate() {
        return startDate;
    }


    /**
     * Sets the startDate value for this RealSynView.
     * 
     * @param startDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof RealSynView)) return false;
        RealSynView other = (RealSynView) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.action==null && other.getAction()==null) || 
             (this.action!=null &&
              this.action.equals(other.getAction()))) &&
            ((this.endDate==null && other.getEndDate()==null) || 
             (this.endDate!=null &&
              this.endDate.equals(other.getEndDate()))) &&
            ((this.operDate==null && other.getOperDate()==null) || 
             (this.operDate!=null &&
              this.operDate.equals(other.getOperDate()))) &&
            ((this.results==null && other.getResults()==null) || 
             (this.results!=null &&
              java.util.Arrays.equals(this.results, other.getResults()))) &&
            ((this.startDate==null && other.getStartDate()==null) || 
             (this.startDate!=null &&
              this.startDate.equals(other.getStartDate())));
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
        if (getAction() != null) {
            _hashCode += getAction().hashCode();
        }
        if (getEndDate() != null) {
            _hashCode += getEndDate().hashCode();
        }
        if (getOperDate() != null) {
            _hashCode += getOperDate().hashCode();
        }
        if (getResults() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getResults());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getResults(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStartDate() != null) {
            _hashCode += getStartDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RealSynView.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "RealSynView"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("action");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "action"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endDate");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "endDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operDate");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "operDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("results");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "results"));
        elemField.setXmlType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SynSA06AView"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startDate");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "startDate"));
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
