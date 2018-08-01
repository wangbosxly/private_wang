package com.thinkgem.jeesite.modules.sybx.sysyjsl.web;
import java.io.File;
import java.net.URL;

/**
 * 获取文件路径测试类
 * @description 
 * @since 
 * @author njx
 * @version 1.0
 */
public class GetPath {  
    public static void getPath(){  
        //方式一  
        System.out.println(System.getProperty("user.dir"));  
        //方式二  
        File directory = new File("");//设定为当前文件夹  
        try{  
            System.out.println(directory.getCanonicalPath());//获取标准的路径  
            System.out.println(directory.getAbsolutePath());//获取绝对路径  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
        //方式三  
        System.out.println(GetPath.class.getResource("/"));
        System.out.println(GetPath.class.getResource(""));
        //方式4  
        System.out.println(GetPath.class.getClassLoader().getResource(""));
        System.out.println(GetPath.class.getClassLoader().getResource("report.jasper"));
    }
    
    public static String getPackagePath(String filename)  
    {  
        String result=null;  
        URL urlpath=GetPath.class.getResource("");
        String path=urlpath.toString();  
        if(path.startsWith("file"))  
        {  
            path=path.substring(5);  
        }  
        path.replace("/", File.separator);  
        result=path+filename;  
        return result;  
    }     
    
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        GetPath.getPath();
        String fileAddress= GetPath.getPackagePath("report.jasper");
        System.out.println("report.jasper文件所在地址=====:"+fileAddress);
    }  
}