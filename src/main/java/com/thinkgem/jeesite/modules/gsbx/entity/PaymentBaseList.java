package com.thinkgem.jeesite.modules.gsbx.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * 描述:
 * 用于封装批量提交
 *
 * @author X_P
 * @create 2018-06-12 19:58
 */

public class PaymentBaseList implements Serializable {
    private static final long serialVersionUID = -1945969568120629093L;
    private List<GsPaymentBase> list;

    @Override
    public String toString() {
        return "PaymentBaseList{" +
                "list=" + list +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentBaseList that = (PaymentBaseList) o;
        return Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {

        return Objects.hash(list);
    }

    public List<GsPaymentBase> getList() {
        return list;
    }

    public void setList(List<GsPaymentBase> list) {
        this.list = list;
    }
}