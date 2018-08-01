package com.thinkgem.jeesite.modules.sybx.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import net.vsame.url2sql.utils.PostParam;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.*;

public class PostHelper {

    //	private final static String SERVER_HOST = "http://10.189.187.223:8088";//测试
    //private final static String SERVER_HOST = "https://bj.imeth.cn/pansky";//测试
    //private final static String SERVER_HOST = "http://10.189.129.180:7003/pansky";//测试
    //private final static String SERVER_HOST = "http://10.189.131.174:9091/pansky";//正式
    //private final static String APP_ID = "SY_WSSB_XY"; 正式
    //private final static String SECRET_KEY = "QlvDI7pq9NOQ9qi4opU98pyQoLqkz19X";正式
    private final static String SERVER_HOST = "http://10.189.139.30:7001/pansky";//测试
    private final static String APP_ID = "admin";
    private final static String SECRET_KEY = "xZs2h71M49Sa7I75Yf11yFp32nyPYjUD";
	/**
	 * 返回API对应的 JSONObject，如果code!=0, 直接抛出异常信息。
	 * @param apipath
	 * @param params
	 * @return
	 */
	public static JSONObject send(String apipath, List<PostParam> params){
//		params.add(new PostParam("_charset", "string", "")); 
		params.add(new PostParam("appId", null, APP_ID));
		//生成签名
		Map<String, String[]> map = new HashMap<String, String[]>();
		for(PostParam p : params) {
			if(p.getIn() != null) {
				continue ;//文件不参与签名运算
			}
			map.put(p.getName(), new String[]{p.getValue()});
		}
		params.add(new PostParam("sig", null, makeSignature(map)));
		
		String json = HttpsUtils.post(SERVER_HOST + apipath, params, Charset.forName("UTF-8"));
		return JSON.parseObject(json);
	}
	
	
	/**
	 * 生成签名
	 * @param params
	 * @return
	 */
	public static String makeSignature(Map<String, String[]> params) {
		return makeSignature(params, SECRET_KEY);
	}

	/**
	 * 生成签名
	 * 
	 * @param params
	 * @param secretKey
	 * @return
	 */
	public static String makeSignature(Map<String, String[]> params, String secretKey) {
		// 排除 signature
		ArrayList<String> list = new ArrayList<String>(params.size() * 3 / 2);// 尽量避免重新分配内存空间
		for (Map.Entry<String, String[]> e : params.entrySet()) {
			if ("sig".equals(e.getKey())) {
				continue;
			}
			for (String str : e.getValue()) {
				list.add(e.getKey() + "=" + encodeUrl(str));
			}
		}

		// 字典排序
		String[] array = list.toArray(new String[] {});
		Arrays.sort(array, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				//return o1.compareTo(o2);
				return o1.toLowerCase().compareTo(o2.toLowerCase());
			}
		});

		// 生成原始字符串
		StringBuffer sb = new StringBuffer();
		for (String str : array) {
			sb.append(str).append("&");
		}
		sb.append(secretKey);

		// Md5
		System.out.println(EncryptionUtils.md5(sb.toString()));
		return EncryptionUtils.md5(sb.toString());
	}
	
	/**
	 * URL编码 (符合FRC1738规范)
	 * 
	 * @param input 待编码的字符串
	 * @return 编码后的字符串
	 * @throws OpensnsException 不支持指定编码时抛出异常。
	 */
	private static String encodeUrl(String input) {
		try {
			return URLEncoder.encode(input, "UTF-8").replace("+", "%20")
					.replace("*", "%2A");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}


}
