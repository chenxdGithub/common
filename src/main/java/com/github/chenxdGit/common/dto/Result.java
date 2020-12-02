package com.github.chenxdGit.common.dto;

import java.util.HashMap;
import java.util.Map;
 
public class Result {

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 操作信息
     */
    private String msg;

    /**
     * 消息代码
     */
    private int code;

    /**
     * 数据
     */
    private Object data;

    public Result() {
    }

    public Result(String data) {
        this.data = data;
        this.success = true;
    }

    public Result(boolean success) {
        this.success = success;
    }

    public Result(Object data) {
        this.success = true;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 构建成功类型的返回值 {@link Result}
     *
     * @param msg 返回值信息
     * @return 默认的 返回值
     */
    public static Result success(String msg) {
        return success(msg, new Object());
    }

    /**
     * 构建成功类型的返回值 {@link Result}
     *
     * @param msg  返回值信息
     * @param data 返回值数据
     * @return .
     */
    public static Result success(String msg, Object data) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(0);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    /**
     * 构建失败类型的返回值
     *
     * @param code 错误码
     * @param msg  错误信息
     * @param data 数据
     * @return .
     */
    public static Result error(int code, String msg, Object data) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    /**
     * 构建失败类型的返回值
     *
     * @param code         错误码
     * @param msg          错误信息
     * @param dataErrorMsg 详细错误信息
     * @return .
     */
    public static Result error(int code, String msg, String dataErrorMsg) {
        Map<String, Object> map = new HashMap<>(1);
        map.put("error", dataErrorMsg);

        return error(code, msg, map);
    }
}
