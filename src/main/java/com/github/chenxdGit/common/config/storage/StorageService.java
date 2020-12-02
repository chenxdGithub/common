package com.github.chenxdGit.common.config.storage;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.stream.Stream;

import com.github.chenxdGit.common.util.CharUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import com.github.chenxdGit.common.dto.StorageDto;



/**
 * 提供存储服务类，所有存储服务均由该类对外提供
 */
public class StorageService {
	 
	@Autowired
    private Storage storage;

    /**
     * 存储一个文件对象
     *
     * @param inputStream   文件输入流
     * @param contentLength 文件长度
     * @param contentType   文件类型
     * @param fileName      文件索引名
     * @throws Exception 
     */
    public StorageDto store(InputStream inputStream, long contentLength, String contentType, String fileName) throws Exception {
		String key = generateKey(fileName);
        storage.store(inputStream, contentLength, contentType, key);
        String url = generateUrl(key);
        StorageDto storageInfo = new StorageDto();
        storageInfo.setName(fileName);
        storageInfo.setSize((int) contentLength);
        storageInfo.setType(contentType);
        storageInfo.setKey(key);
        storageInfo.setUrl(url);
        return storageInfo;
    }

    private String generateKey(String originalFilename) {
    	Calendar cal = Calendar.getInstance();
    	int year = cal.get(Calendar.YEAR);
    	int month = cal.get(Calendar.MONTH) + 1;
    	int dom = cal.get(Calendar.DAY_OF_MONTH);
    	int index = originalFilename.lastIndexOf('.');
        String suffix = originalFilename.substring(index);
        String key  = CharUtil.getRandomString(20) + suffix;
        return year+"/"+month+"/"+ dom+"/"+key;
    }

    public Stream<Path> loadAll() {
        return storage.loadAll();
    }

    public Path load(String keyName) {
        return storage.load(keyName);
    }

    public Resource loadAsResource(String keyName) {
        return storage.loadAsResource(keyName);
    }

    public void delete(String keyName) {
        storage.delete(keyName);
    }

    private String generateUrl(String keyName) {
        return storage.generateUrl(keyName);
    }
}
