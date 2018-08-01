/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.CacheUtils;
import com.thinkgem.jeesite.common.utils.PostHelperUtils;
import com.thinkgem.jeesite.modules.gsbx.nw_ws.lss.port.Nw_wsPort;
import com.thinkgem.jeesite.modules.sys.dao.DictDao;
import com.thinkgem.jeesite.modules.sys.entity.Dict;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.RemoteException;
import java.util.List;

/**
 * 字典Service
 *
 * @author ThinkGem
 * @version 2014-05-16
 */
@Service
@Transactional(readOnly = true)
public class DictService extends CrudService<DictDao, Dict> {
    @Autowired
    Nw_wsPort gsPort;

    @Autowired
    com.thinkgem.jeesite.modules.ylbx.nw_ws.lss.port.Nw_wsPort ybPort;
    /**
     * 查询字段类型列表
     *
     * @return
     */
    public List<String> findTypeList() {
        return dao.findTypeList(new Dict());
    }

    @Transactional(readOnly = false)
    public void save(Dict dict) {
        super.save(dict);
        CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
    }


    @Transactional(readOnly = false)
    public void delete(Dict dict) {
        super.delete(dict);
        CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
    }

    public List<Dict> getPostTemplateJson(Dict dict) {
        return dao.getPostTemplateJson(dict);
    }


    public boolean refresh(String CODE_TYPE) throws RemoteException {
        String[] code = CODE_TYPE.split("_");
        if (code.length != 2) {
            return false;
        }
        JSONObject json = new JSONObject();
        json.put("CODE_TYPE", code[0]);
        String s = "";
        if ("GS".equals(code[1])) {
            s = gsPort.nwws0010(json.toString());
        } else if ("YB".equals(code[1])) {
            JSONArray jsonArray =new JSONArray();
            jsonArray.add(json);
            s = ybPort.nwws0010(jsonArray.toString());
        } else {
            return false;
        }
        JSONObject jsonObject = JSONObject.parseObject(s);
        JSONArray jsonArray = PostHelperUtils.toJSONArray(jsonObject, "RETLIST");
        for (Object o : jsonArray) {
            JSONObject j = (JSONObject) o;
            Dict dict = new Dict();
            dict.setValue(j.getString("VALUE"));
            dict.setType(j.getString("CODE_TYPE") + "_"+code[1]);
            dict.setLabel(j.getString("NAME"));
            dict.setParentId(j.getString("PARENT_CODE"));
            //如果接口传递的排序参数不是数字的话就保存为1
            try {
                dict.setSort(Integer.parseInt(j.getString("SORT")));
            } catch (NumberFormatException e) {
                dict.setSort(1);
            }
            dict.setDescription(j.getString("MATCHING") == null ? "X" : j.getString("MATCHING"));
            List<Dict> list = dao.getBynameAndType(dict);
            if (list.size() > 0) {
                String id = list.get(0).getId();
                dict.setId(id);
            }
            save(dict);
        }
        return true;

    }

}
