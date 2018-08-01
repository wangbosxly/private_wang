/**
 * DailySynView.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thinkgem.jeesite.modules.ylbx.nw_ws.lss.entity;

public class DailySynView  implements java.io.Serializable {
    private String action;

    private String endDate;

    private String operDate;

    private SynCountView[] results;

    private String startDate;

    private String synDate;

    public DailySynView() {
    }

    public DailySynView(
           String action,
           String endDate,
           String operDate,
           SynCountView[] results,
           String startDate,
           String synDate) {
           this.action = action;
           this.endDate = endDate;
           this.operDate = operDate;
           this.results = results;
           this.startDate = startDate;
           this.synDate = synDate;
    }


    /**
     * Gets the action value for this DailySynView.
     * 
     * @return action
     */
    public String getAction() {
        return action;
    }


    /**
     * Sets the action value for this DailySynView.
     * 
     * @param action
     */
    public void setAction(String action) {
        this.action = action;
    }


    /**
     * Gets the endDate value for this DailySynView.
     * 
     * @return endDate
     */
    public String getEndDate() {
        return endDate;
    }


    /**
     * Sets the endDate value for this DailySynView.
     * 
     * @param endDate
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


    /**
     * Gets the operDate value for this DailySynView.
     * 
     * @return operDate
     */
    public String getOperDate() {
        return operDate;
    }


    /**
     * Sets the operDate value for this DailySynView.
     * 
     * @param operDate
     */
    public void setOperDate(String operDate) {
        this.operDate = operDate;
    }


    /**
     * Gets the results value for this DailySynView.
     * 
     * @return results
     */
    public SynCountView[] getResults() {
        return results;
    }


    /**
     * Sets the results value for this DailySynView.
     * 
     * @param results
     */
    public void setResults(SynCountView[] results) {
        this.results = results;
    }


    /**
     * Gets the startDate value for this DailySynView.
     * 
     * @return startDate
     */
    public String getStartDate() {
        return startDate;
    }


    /**
     * Sets the startDate value for this DailySynView.
     * 
     * @param startDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }


    /**
     * Gets the synDate value for this DailySynView.
     * 
     * @return synDate
     */
    public String getSynDate() {
        return synDate;
    }


    /**
     * Sets the synDate value for this DailySynView.
     * 
     * @param synDate
     */
    public void setSynDate(String synDate) {
        this.synDate = synDate;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof DailySynView)) return false;
        DailySynView other = (DailySynView) obj;
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
              this.startDate.equals(other.getStartDate()))) &&
            ((this.synDate==null && other.getSynDate()==null) || 
             (this.synDate!=null &&
              this.synDate.equals(other.getSynDate())));
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
        if (getSynDate() != null) {
            _hashCode += getSynDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DailySynView.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "DailySynView"));
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
        elemField.setXmlType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "SynCountView"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startDate");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "startDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("synDate");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "synDate"));
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
