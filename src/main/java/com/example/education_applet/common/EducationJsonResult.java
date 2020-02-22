package com.example.education_applet.common;

public class EducationJsonResult<T> {
    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    private String ok; // 不使用


    public static EducationJsonResult build(Integer status, String msg, Object data) {
        return new EducationJsonResult(status, msg, data);
    }

    public static EducationJsonResult ok(Object data) {
        return new EducationJsonResult(data);
    }

    public static EducationJsonResult ok() {
        return new EducationJsonResult(null);
    }

    public static EducationJsonResult errorMsg(String msg) {
        return new EducationJsonResult(500, msg, null);
    }

    public static EducationJsonResult errorMap(Object data) {
        return new EducationJsonResult(501, "error", data);
    }

    public static EducationJsonResult errorTokenMsg(String msg) {
        return new EducationJsonResult(502, msg, null);
    }

    public static EducationJsonResult errorException(String msg) {
        return new EducationJsonResult(555, msg, null);
    }

    public EducationJsonResult() {

    }

    public EducationJsonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public EducationJsonResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }
}

