package com.thinkgem.jeesite.modules.sybx.util;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class EncryptionUtils {
	
	public final static String md5(byte[] bytes) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(bytes);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public final static String md5(String str, String charset) {
		return md5(str.getBytes(Charset.forName(charset)));
	}
	
	public final static String md5(String str) {
		return md5(str, "utf-8");
	}

	
	/**
	 * 字典排序计算签名
	 * 
	 * @param params
	 * @param secretKey
	 * @return
	 */
	public static String makeSignature(Map<String, String[]> params,
			String secretKey) {
		// signature
		ArrayList<String> list = new ArrayList<String>(params.size() * 3 / 2);
		for (Map.Entry<String, String[]> e : params.entrySet()) {
			if ("sig".equals(e.getKey())) {
				continue;
			}
			for (String str : e.getValue()) {
				list.add(e.getKey() + "=" + str);
			}
		}

		System.out.println(list);
		//
		String[] array = list.toArray(new String[] {});
		Arrays.sort(array, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.toLowerCase().compareTo(o2.toLowerCase());
			}
		});

		System.out.println(Arrays.toString(array));
		//
		StringBuffer sb = new StringBuffer();
		for (String str : array) {
			sb.append(str).append("&");
		}
		sb.append("key="+secretKey);

		System.out.println(sb.toString());
		// Md5
		return EncryptionUtils.md5(sb.toString()).toUpperCase();
	}
	
	
	public static void main(String[] args) {
//		System.out.println(EncryptionUtils.md5("20121221"));
//		System.out.println(EncryptionUtils.md5("加密"));
//		System.out.println(EncryptionUtils.md5("8888888888888"));
//		System.out.println(EncryptionUtils.md5("version=1.0.0&charset=UTF-8&signMethod=MD5&payType=B2C&transType=01&merId=10001&orderNumber=20120618003233001&orderTime=&qid=&041902fb6f1e630ffb88d392348ec36e"));
//		System.out.println(EncryptionUtils.md5("appId=6103&timestamp=1474285477535&XCSAppVersion=1.0.0&XCSBrand=vivo&XCSBuildNumber=1&XCSBundleID=cn.com.pansky.sgss&XCSModel=vivo%20X6A&XCSSystemName=Android&XCSSystemVersion=5.0.2&XCSUdid=7afb6dd44885e9ec&pansky"));
//		System.out.println(EncryptionUtils.md5("appId=6103&timestamp=1474285124885&XCSAppVersion=1.0.0&XCSBrand=vivo&XCSBuildNumber=1&XCSBundleID=cn.com.pansky.sgss&XCSModel=vivo%20X6A&XCSSystemName=Android&XCSSystemVersion=5.0.2&XCSUdid=7afb6dd44885e9ec&pansky"));
//		System.out.println(EncryptionUtils.md5("appid=1&attach=1&auth_code=1&body=1&device_info=1&goods_tag=1&mch_id=1&nonce_str=1&out_trade_no=1&spbill_create_ip=1&time_expire=1&time_start=1&total_fee=1&key=1"));
	
//		Map<String, String[]> paramsMap = new HashMap<String, String[]>();
//        paramsMap.put("appid", new String[] { "wx2421b1c4370ec43b" });
//        paramsMap.put("attach", new String[] { "test" });
//        paramsMap.put("body", new String[] { "test" });
//        paramsMap.put("mch_id", new String[] { "10000100" });
//        paramsMap.put("nonce_str", new String[] { "1add1a30ac87aa2db72f57a2375d8fec" });
//        paramsMap.put("notify_url", new String[] { "http://wxpay.wxutil.com/pub_v2/pay/notify.v2.php" });
//        paramsMap.put("out_trade_no", new String[] { "123456" });
//        paramsMap.put("spbill_create_ip", new String[] { "10.189.139.32" });
//        paramsMap.put("total_fee", new String[] { "1" });
//        paramsMap.put("trade_type", new String[] { "APP" });
//
//		System.out.println(EncryptionUtils.makeSignature(paramsMap, "pansky"));
		
		System.out.println(EncryptionUtils.md5("w666666"));
	}
}
