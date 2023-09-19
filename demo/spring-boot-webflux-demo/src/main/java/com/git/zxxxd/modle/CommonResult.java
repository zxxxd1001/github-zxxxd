package com.git.zxxxd.modle;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommonResult implements Serializable {

    public static Integer CODE_SUCCESS = 0;

    /**
     * 错误码
     */
    private Integer code;
    /**
     * 错误提示
     */
    private String message;
    /**
     * 返回数据
     */
    private Object data;

    public static CommonResult error(CommonResult result) {
        return error(result.getCode(), result.getMessage());
    }

    public static CommonResult error(Integer code, String message) {
//        Assert.isTrue(!CODE_SUCCESS.equals(code), "code 必须是错误的！");
        CommonResult result = new CommonResult();
        result.code = code;
        result.message = message;
        return result;
    }

    public static CommonResult success(Object data) {
        CommonResult result = new CommonResult();
        result.code = CODE_SUCCESS;
        result.data = data;
        result.message = "";
        return result;
    }

}
