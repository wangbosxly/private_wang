/**
 * KA02KA03KA04View.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thinkgem.jeesite.modules.ylbx.nw_ws.lss.entity;

import com.thinkgem.jeesite.modules.ylbx.nw_ws.lss.entity.reckoner.KA02View;
import com.thinkgem.jeesite.modules.ylbx.nw_ws.lss.entity.reckoner.KA03View;
import com.thinkgem.jeesite.modules.ylbx.nw_ws.lss.entity.reckoner.KA04View;

public class KA02KA03KA04View  extends BaseView  implements java.io.Serializable {
    private String AKA213;

    private KA02View[] KA02View;

    private KA03View[] KA03View;

    private KA04View[] KA04View;

    private String mlbm;

    private String mlmc;

    public KA02KA03KA04View() {
    }

    public KA02KA03KA04View(
           String modelName,
           String AKA213,
           KA02View[] KA02View,
           KA03View[] KA03View,
           KA04View[] KA04View,
           String mlbm,
           String mlmc) {
        super(
            modelName);
        this.AKA213 = AKA213;
        this.KA02View = KA02View;
        this.KA03View = KA03View;
        this.KA04View = KA04View;
        this.mlbm = mlbm;
        this.mlmc = mlmc;
    }


    /**
     * Gets the AKA213 value for this KA02KA03KA04View.
     * 
     * @return AKA213
     */
    public String getAKA213() {
        return AKA213;
    }


    /**
     * Sets the AKA213 value for this KA02KA03KA04View.
     * 
     * @param AKA213
     */
    public void setAKA213(String AKA213) {
        this.AKA213 = AKA213;
    }


    /**
     * Gets the KA02View value for this KA02KA03KA04View.
     * 
     * @return KA02View
     */
    public KA02View[] getKA02View() {
        return KA02View;
    }


    /**
     * Sets the KA02View value for this KA02KA03KA04View.
     * 
     * @param KA02View
     */
    public void setKA02View(KA02View[] KA02View) {
        this.KA02View = KA02View;
    }


    /**
     * Gets the KA03View value for this KA02KA03KA04View.
     * 
     * @return KA03View
     */
    public KA03View[] getKA03View() {
        return KA03View;
    }


    /**
     * Sets the KA03View value for this KA02KA03KA04View.
     * 
     * @param KA03View
     */
    public void setKA03View(KA03View[] KA03View) {
        this.KA03View = KA03View;
    }


    /**
     * Gets the KA04View value for this KA02KA03KA04View.
     * 
     * @return KA04View
     */
    public KA04View[] getKA04View() {
        return KA04View;
    }


    /**
     * Sets the KA04View value for this KA02KA03KA04View.
     * 
     * @param KA04View
     */
    public void setKA04View(KA04View[] KA04View) {
        this.KA04View = KA04View;
    }


    /**
     * Gets the mlbm value for this KA02KA03KA04View.
     * 
     * @return mlbm
     */
    public String getMlbm() {
        return mlbm;
    }


    /**
     * Sets the mlbm value for this KA02KA03KA04View.
     * 
     * @param mlbm
     */
    public void setMlbm(String mlbm) {
        this.mlbm = mlbm;
    }


    /**
     * Gets the mlmc value for this KA02KA03KA04View.
     * 
     * @return mlmc
     */
    public String getMlmc() {
        return mlmc;
    }


    /**
     * Sets the mlmc value for this KA02KA03KA04View.
     * 
     * @param mlmc
     */
    public void setMlmc(String mlmc) {
        this.mlmc = mlmc;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof KA02KA03KA04View)) return false;
        KA02KA03KA04View other = (KA02KA03KA04View) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.AKA213==null && other.getAKA213()==null) || 
             (this.AKA213!=null &&
              this.AKA213.equals(other.getAKA213()))) &&
            ((this.KA02View==null && other.getKA02View()==null) || 
             (this.KA02View!=null &&
              java.util.Arrays.equals(this.KA02View, other.getKA02View()))) &&
            ((this.KA03View==null && other.getKA03View()==null) || 
             (this.KA03View!=null &&
              java.util.Arrays.equals(this.KA03View, other.getKA03View()))) &&
            ((this.KA04View==null && other.getKA04View()==null) || 
             (this.KA04View!=null &&
              java.util.Arrays.equals(this.KA04View, other.getKA04View()))) &&
            ((this.mlbm==null && other.getMlbm()==null) || 
             (this.mlbm!=null &&
              this.mlbm.equals(other.getMlbm()))) &&
            ((this.mlmc==null && other.getMlmc()==null) || 
             (this.mlmc!=null &&
              this.mlmc.equals(other.getMlmc())));
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
        if (getAKA213() != null) {
            _hashCode += getAKA213().hashCode();
        }
        if (getKA02View() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getKA02View());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getKA02View(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getKA03View() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getKA03View());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getKA03View(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getKA04View() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getKA04View());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getKA04View(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getMlbm() != null) {
            _hashCode += getMlbm().hashCode();
        }
        if (getMlmc() != null) {
            _hashCode += getMlmc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(KA02KA03KA04View.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "KA02KA03KA04View"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AKA213");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "AKA213"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("KA02View");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "KA02View"));
        elemField.setXmlType(new javax.xml.namespace.QName("java:lss.medicare.reckoner.valueobject", "KA02View"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("KA03View");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "KA03View"));
        elemField.setXmlType(new javax.xml.namespace.QName("java:lss.medicare.reckoner.valueobject", "KA03View"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("KA04View");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "KA04View"));
        elemField.setXmlType(new javax.xml.namespace.QName("java:lss.medicare.reckoner.valueobject", "KA04View"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mlbm");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "mlbm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mlmc");
        elemField.setXmlName(new javax.xml.namespace.QName("java:lss.nw_ws.valueobject", "mlmc"));
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
