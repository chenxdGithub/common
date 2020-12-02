package com.github.chenxdGit.common.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
/**
 * 字符串工具类
 * @author 陈晓东
 *
 */
public class StringUtil extends StringUtils {
	
	
	public static String getMD5String(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }
	
    /**
    * 驼峰 转下划线
    * @param camelCase
    * @return
    */
   public static String toLine(String camelCase){
       Pattern humpPattern = Pattern.compile("[A-Z]");
       Matcher matcher = humpPattern.matcher(camelCase);
       StringBuffer sb = new StringBuffer();
       while(matcher.find()){
           matcher.appendReplacement(sb, "_"+matcher.group(0).toLowerCase());
       }
       matcher.appendTail(sb);
       return sb.toString();
   }
	
	 	public static String filter(String str){
	        if(str == null || str.length() == 0){
	            return "";
	        }
	        StringBuffer sb = new StringBuffer();
	        for(int i=0;i<str.length();i++){
	            int ch = str.charAt(i);
	            int min = Integer.parseInt("E001", 16);
	            int max = Integer.parseInt("E537", 16);
	            if(ch >= min && ch <= max){
	                sb.append("");
	            }else{
	                sb.append((char)ch);
	            }
	        }
	        return sb.toString();
	    }

	    /**
	     * 过滤昵称特殊表情
	     */
	    public static String filterName(String name) {
	    	  if(isNoneEmpty(name)){
	    		  return name;
		        }
	        Pattern patter = Pattern.compile("[a-zA-Z0-9\u4e00-\u9fa5]");
	        Matcher match = patter.matcher(name);

	        StringBuffer buffer = new StringBuffer();

	        while (match.find()) {
	            buffer.append(match.group());
	        }
	        String str=buffer.toString();
	        String newName=filter(str);
	        return newName;
	    }


	/**
	 * 判断为空
	 * @param object
	 * @return
	 */
	public static boolean isNull(Object object){
		String b=String.valueOf(object);
		if(b!=null) {
			 b = b.trim();
		}
		String a = new String();
		if(b==null|| b.equals("") || b.equals(a) || b.equals("null")){
			return true;
		}
		return false;
	}

	/**
	 * 判断为非空
	 * @param object
	 * @return
	 */
	public static boolean isNotNull(Object object){
		return !isNull(object);
	}

	public static void main(String[]args){
		Object b="              ";
		System.out.println(isNull(b));
	}
}