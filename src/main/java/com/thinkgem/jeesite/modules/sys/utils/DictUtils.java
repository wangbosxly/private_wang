/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.utils;

import java.util.List;
import java.util.Map;

import com.thinkgem.jeesite.modules.nwws.client.MedicalInterfaceUtils;
import com.thinkgem.jeesite.modules.nwws.client.port.NwwsPort;


import lss.nw_ws.valueobject.CodeView;
import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.utils.CacheUtils;
import com.thinkgem.jeesite.common.utils.SpringContextHolder;
import com.thinkgem.jeesite.modules.sys.dao.DictDao;
import com.thinkgem.jeesite.modules.sys.entity.Dict;

/**
 * 字典工具类
 * @author ThinkGem
 * @version 2013-5-29
 */
public class DictUtils {
	
	private static DictDao dictDao = SpringContextHolder.getBean(DictDao.class);

	public static final String CACHE_DICT_MAP = "dictMap";
	
	public static String getDictLabel(String value, String type, String defaultValue){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(value)){
			for (Dict dict : getDictList(type)){
				if (type.equals(dict.getType()) && value.equals(dict.getValue())){
					return dict.getLabel();
				}
			}
		}
		return defaultValue;
	}
	
	public static String getDictLabels(String values, String type, String defaultValue){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(values)){
			List<String> valueList = Lists.newArrayList();
			for (String value : StringUtils.split(values, ",")){
				valueList.add(getDictLabel(value, type, defaultValue));
			}
			return StringUtils.join(valueList, ",");
		}
		return defaultValue;
	}

	public static String getDictValue(String label, String type, String defaultLabel){
		if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(label)){
			for (Dict dict : getDictList(type)){
				if (type.equals(dict.getType()) && label.equals(dict.getLabel())){
					return dict.getValue();
				}
			}
		}
		return defaultLabel;
	}
	
	public static List<Dict> getDictList(String type){
		@SuppressWarnings("unchecked")
		Map<String, List<Dict>> dictMap = (Map<String, List<Dict>>)CacheUtils.get(CACHE_DICT_MAP);
		if (dictMap==null){
			dictMap = Maps.newHashMap();
			for (Dict dict : dictDao.findAllList(new Dict())){
				List<Dict> dictList = dictMap.get(dict.getType());
				if (dictList != null){
					dictList.add(dict);
				}else{
					dictMap.put(dict.getType(), Lists.newArrayList(dict));
				}
			}
			// 获取网报接口字典项（医疗、工伤、生育）
//			try {
//				NwwsPort port = MedicalInterfaceUtils.getPort();
//				CodeView[] codeview =  port.nwws0010(null, null);
//				if(codeview != null){
//					for(int i = 0;i<codeview.length;i++){
//						String code_type = codeview[i].getCODE_TYPE();
//						List<Dict> dictList = dictMap.get(code_type);
//						Dict dict = new Dict();
//						dict.setType(code_type);
//						dict.setValue(codeview[i].getVALUE());
//						dict.setLabel(codeview[i].getNAME());
//						if(codeview[i].getSORT() != null && !"".equals(codeview[i].getSORT())){
//							dict.setSort(Integer.parseInt(codeview[i].getSORT()));
//						}
//
//						if (dictList != null){
//							dictList.add(dict);
//						}else{
//							dictMap.put(code_type, Lists.newArrayList(dict));
//						}
//					}
//				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
/*			
			// 获取网报接口字典项（失业保险）
			try {
				UneNwwsServicePort sy_port = MedicalInterfaceUtils.getSyPort();
				com.thinkgem.jeesite.modules.nwws.syentity.CodeView[] sy_codeview =  sy_port.nwws0010(null, null);
				if(sy_codeview != null){
					for(int i = 0;i<sy_codeview.length;i++){
						String code_type = sy_codeview[i].getCODE_TYPE()+"_2";
						List<Dict> sy_dictList = dictMap.get(code_type);
						Dict sy_dict = new Dict();
						sy_dict.setType(code_type);
						sy_dict.setValue(sy_codeview[i].getVALUE());
						sy_dict.setLabel(sy_codeview[i].getNAME());
						if(sy_codeview[i].getSORT() != null && !"".equals(sy_codeview[i].getSORT())){
							sy_dict.setSort(Integer.parseInt(sy_codeview[i].getSORT()));
						}

						if (sy_dictList != null){
							sy_dictList.add(sy_dict);
						}else{
							dictMap.put(code_type, Lists.newArrayList(sy_dict));
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}*/			
			
			CacheUtils.put(CACHE_DICT_MAP, dictMap);
		}
		List<Dict> dictList = dictMap.get(type);
		if (dictList == null){
			dictList = Lists.newArrayList();
		}
		return dictList;
	}
	
	/**
	 * 返回字典列表（JSON）
	 * @param type
	 * @return
	 */
	public static String getDictListJson(String type){
		return JsonMapper.toJsonString(getDictList(type));
	}
	
}
