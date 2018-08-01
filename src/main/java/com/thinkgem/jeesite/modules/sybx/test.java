package com.thinkgem.jeesite.modules.sybx;

import com.alibaba.fastjson.JSONObject;
import com.thinkgem.jeesite.modules.sybx.util.PostHelper;
import net.vsame.url2sql.utils.PostParam;

import java.util.ArrayList;
import java.util.List;

public class test {
//	public static void test() throws Exception {
//		String url = "http://10.189.129.227:7901/UneNwwsService/UneNwwsService?WSDL"; 
//		UneNwwsService uneNwwsService_Impl = new UneNwwsService_Impl(url);
//		
//		JSONObject tempJO = new JSONObject(); 
//		tempJO.put("SAA015", "M4019"); 
//		tempJO.put("AAE011", "aa"); 
//		tempJO.put("BAA001", "610399"); 
//		tempJO.put("AAC003", "孙超"); 
//		tempJO.put("AAC002", "610331198710210012"); 
//		String retstring = JSONObject.toJSONString(tempJO); 
//		retstring = uneNwwsService_Impl.getUneNwwsServicePort().nwwssy2901(retstring); 
//		System.out.println("返回为：" +retstring);
//	}
	
	public static JSONObject test() {
		List<PostParam> params = new ArrayList<PostParam>();
		
		JSONObject json = new JSONObject();
//		json.put("SAA015", "M4019");
//		json.put("AAE011", "aa");
//		json.put("AAC003", "孙超");
//		json.put("AAC002", "610331198710210012");
        json.put("AAE170", "SY00000102");
//        json.put("AAB001", "10400000538");
//        json.put("BAA001", "610499");
//        json.put("AAB034", "610499");
//        json.put("AAE005", "1112123");
//        json.put("BAB811", "sy_001");
//        json.put("StartYM", "20170101");
//        json.put("EndYM", "20180314");
//        json.put("AAE140", "2");
//        json.put("AAB033", "3");
        json.put("BKB026", "61bbc611525cfc5c29c2183664402f8e");

		params.add(new PostParam("params", "string", json.toJSONString()));
		return PostHelper.send("/loseJob/unit/bindingCheckquery.json", params);
	}
	
	public static void main(String[] args) {
		JSONObject json = test();
		System.out.println(json);
	}


}