package com.michael.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Michael Chu
 * @since 2020-03-16 10:30
 */
@Data
public class Result implements Serializable {

    /** 定义jackson对象 */
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /** 响应业务状态 */
    private Integer status;

    /** 响应消息 */
    private String msg;

    /** 响应中的数据 */
    private Object data;

    public static Result build(Integer status, String msg, Object data) {
        return new Result(status, msg, data);
    }

    public static Result ok(Object data) {
        return new Result(data);
    }

    public static Result ok() {
        return new Result(null);
    }

    public Result() {

    }

    public static Result build(Integer status, String msg) {
        return new Result(status, msg, null);
    }

    public Result(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Result(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    @Override
    public String toString() {
        return JsonUtils.objectToJson(this);
    }
}
