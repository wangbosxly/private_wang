package com.thinkgem.jeesite.modules.ylbx.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 描述:
 * 用于封装批量提交的对象
 *
 * @author X_P
 * @create 2018-07-03 16:33
 */
public class YbPersonList implements Serializable{

    private static final long serialVersionUID = 5383871315714016438L;

    private List<YbPerson> list;

    @Override
    public String toString() {
        return "YbPersonList{" +
                "list=" + list +
                '}';
    }

    public List<YbPerson> getList() {
        return list;
    }

    public void setList(List<YbPerson> list) {
        this.list = list;
    }
}