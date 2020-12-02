package com.github.chenxdGit.common.config.storage;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

/**
 * 阿里云文件存储
 * @author 陈晓东
 *
 */
@ConfigurationProperties(prefix = "jh.storage")
public class AliyunStorage implements Storage {
	
	 
    private final Log logger = LogFactory.getLog(AliyunStorage.class);

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String baseUrl;
    

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    /**
     * 获取阿里云OSS客户端对象
     *
     * @return ossClient
     */
    private OSS getOSSClient() {
        return  new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }
    
    public void setBaseUrl(String  baseUrl) {
          this.baseUrl = baseUrl;
    }


    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * 阿里云OSS对象存储简单上传实现
     */
    @Override
    public void store(InputStream inputStream, long contentLength, String contentType, String keyName) throws Exception{
        OSS ossClient = getOSSClient();
		try {
            ossClient.putObject(bucketName, keyName, inputStream);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw ex;
        }finally {
        	ossClient.shutdown();
		}

    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public Path load(String keyName) {
        return null;
    }

    @Override
    public Resource loadAsResource(String keyName) {
        try {
            URL url = new URL(getBaseUrl() + keyName);
            Resource resource = new UrlResource(url);
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                return null;
            }
        } catch (MalformedURLException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public void delete(String keyName) {
        try {
            getOSSClient().deleteObject(bucketName, keyName);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

    }

    @Override
    public String generateUrl(String keyName) {
        return getBaseUrl() + keyName;
    }
}
