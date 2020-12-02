package com.github.chenxdGit.common.util;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.github.chenxdGit.common.config.storage.StorageService;
import com.github.chenxdGit.common.dto.StorageDto;

/**
 * 文件处理工具类
 * @author 陈晓东
 *
 */
public class FileUtil {

 /**
  * 上传url中的文件到oss
  * @param urlStr
  * @return
  * @throws Exception
  */
    public static  String  uploadFormUrl(String urlStr) throws Exception {
    	StorageService storageService= ApplicationContextAwareHelper.getBeanByType(StorageService.class);
    	URL url = new URL(urlStr);
    	//创建http链接
    	HttpURLConnection conn = (HttpURLConnection)url.openConnection();
    	//设置超时间为3秒
        conn.setConnectTimeout(3*1000);
        //防止屏蔽程序抓取而返回403错误
         conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
    	 //得到输入流
         InputStream inputStream = conn.getInputStream();
         //截取链接中的文件名
    	String fileName= urlStr.substring(urlStr.lastIndexOf("/")+1);
    	//请求OSS方法
    	StorageDto store = storageService.store(inputStream, -1, "", fileName);
    	return store.getUrl();
    }
 
}
