package com.thinkgem.jeesite.modules.sybx.util;

import net.vsame.url2sql.utils.PostParam;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;

/**
 * Http 访问工具类
 * @author 
 *
 */
public class HttpsUtils {
	
	static {
		try {
			HttpsUtils.httpsStatic();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 证书信任管理器（用于https请求）
	 */
	public static class MyX509TrustManager implements X509TrustManager {
		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
	}
	public static class MyHostnameVerifier implements HostnameVerifier {
		public boolean verify(String hostname, SSLSession session) {
			return true;//不校验 全返回true
		}
	}
	private static void httpsStatic() throws Exception {
		TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){  
            public X509Certificate[] getAcceptedIssuers(){return null;}  
            public void checkClientTrusted(X509Certificate[] certs, String authType){}  
            public void checkServerTrusted(X509Certificate[] certs, String authType){}  
        }};
		HttpsURLConnection.setDefaultHostnameVerifier(new MyHostnameVerifier());  
        SSLContext sc = SSLContext.getInstance("TLS");  
        sc.init(null, trustAllCerts, new SecureRandom());  
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	}

	/**
	 * GET请求 默认是 utf-8 编码
     * get("http://xxx.com/search", "a=bcd", "b=xxx");
	 * @param url
	 * @param params 请单个编写，内部会自动将等号后字符编码
	 * @return
	 */
	public static String get(String url, String... params){
		return get(url, Charset.forName("utf-8"), params);
	}
	
    /**
     * GET请求 默认是 utf-8 编码
     * get("http://xxx.com/search", "a=bcd", "b=xxx");
     * @param url
     * @param charset
     * @param params 请单个编写，内部会自动将等号后字符编码
     * @return
     */
    public static String get(String url, Charset charset, String... params) {
		String result = "";
		InputStream in = null;
		if (null != params && !params.equals("")) {
			if (url.contains("?")) {// 包含?,后面加&直接填加
				url += "&" + params;
			} else {
				url += "?" + params;
			}
		}
		
		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
            conn.setConnectTimeout(60000);
            conn.setReadTimeout(300000);

            // 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			
			conn.connect();
			in = conn.getInputStream();
			result = readInputStream(charset, in);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
			}
		}
		return result;
	}

    /**
     * POST请求 默认是 utf-8 编码
     * post("http://xxx.com/search", "a=bcd", "b=xxx");
     * @param url
     * @param params 请单个编写，内部会自动将等号后字符编码
     * @return
     */
    public static String post(String url, String... params){
		return post(url, Charset.forName("utf-8"), params);
	}

    /**
     * POST请求 默认是 utf-8 编码
     * post("http://xxx.com/search", "a=bcd", "b=xxx");
     * @param url
     * @param params 请单个编写，内部会自动将等号后字符编码
     * @return
     */
	public static String post(String url, Charset charset, String... params) {
		PrintWriter out = null;
		InputStream in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();

			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setConnectTimeout(60000);
            conn.setReadTimeout(300000);

			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			
			out = new PrintWriter(conn.getOutputStream());
			out.print(encodeParams(charset, params));
			out.flush();

			in = conn.getInputStream();
			result = readInputStream(charset, in);

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				try {
					if (out != null) {
						out.close();
					}
				} finally {
					if (in != null) {
						in.close();
					}
				}
			} catch (Exception ex) {
			}
		}
		return result;
	}
	
	public static String post(String url, List<PostParam> params, Charset charset) {
		
		String BOUNDARY = "---------7d4a6d158c9"; // 定义数据分隔线
		HttpURLConnection conn;
		OutputStream out;
		try {
			URL URI = new URL(url);
			conn = (HttpURLConnection) URI.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			conn.setRequestProperty("Charsert", charset.displayName());
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
			
			out = new DataOutputStream(conn.getOutputStream());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		byte[] end_data = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();// 定义最后数据分隔线
		
		int leng = params.size();
		for (int i = 0; i < leng; i++) {
			PostParam param = params.get(i);
			
			StringBuilder sb = new StringBuilder();
			sb.append("--");
			sb.append(BOUNDARY);
			sb.append("\r\n");
			
			sb.append("Content-Disposition: form-data;name=\""+ param.getName() +"\"");
			if(param.getIn() != null){
				//上传文件
				sb.append(";filename=\"" + param.getFileName() + "\"\r\n");
				sb.append("Content-Type:" + param.getContentType() + "\r\n\r\n");
				byte[] data = sb.toString().getBytes(charset);

				InputStream in = param.getIn();
				int bytes = 0;
				byte[] bufferOut = new byte[1024];
				
				try {
					out.write(data);
					while ((bytes = in.read(bufferOut)) != -1) {
						out.write(bufferOut, 0, bytes);
					}
					out.write("\r\n".getBytes());
				} catch (IOException e) {
					throw new RuntimeException(e);
				} finally {
					try {
						in.close();
					} catch (IOException e) {
					}
				}
			}else{
				//表单
				sb.append("\r\n");
				sb.append("Content-Type:" + param.getContentType() + "\r\n\r\n");
				
				sb.append(param.getValue() + "\r\n");
				byte[] data = sb.toString().getBytes(charset);
				try {
					out.write(data);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
		
		String result = null;
		try {
			out.write(end_data);
			out.flush();
			InputStream in = conn.getInputStream();
			result = readInputStream(charset, in);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				out.close();
			} catch (IOException e) {
			}
		}
		return result;

	}
	
	private static String readInputStream(Charset charset, InputStream in)
			throws IOException {
		byte[] bytes = new byte[1024];
		int length = -1;
		ByteArrayOutputStream byteOutput= new ByteArrayOutputStream();
		while ((length = in.read(bytes)) != -1) {
			byteOutput.write(bytes, 0, length);
		}
		return new String(byteOutput.toByteArray(), charset);
	}
	
    public static String encodeParams(String... params){
        return encodeParams(Charset.forName("utf-8"), params);
    }

    /**
     * 将等号后面的字符串编码
     * @param params
     * @return
     */
    private static String encodeParams(Charset charset, String... params){
        if(params == null || params.length == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for(String str : params) {
            int index = str.indexOf("=");
            if(index == -1) {
                sb.append(str);
            }else {
                try {
                    sb.append(str.substring(0, index)).append("=").append(URLEncoder.encode(str.substring(index + 1), charset.name()));
                } catch (UnsupportedEncodingException e) {//肯定不会出现
                }
            }

            sb.append("&");
        }
        if(sb.length() > 0) {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

	public static void main(String[] args) {
		
		String s = get("http://www.baidu.com", "");
		s = post("https://www.oschina.net/home/login", "");
		System.out.println(s);
	}

}
