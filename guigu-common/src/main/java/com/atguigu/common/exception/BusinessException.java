package com.atguigu.common.exception;

import com.atguigu.common.result.ResultCodeEnum;
import lombok.Getter;
//自定有异常,选择出现的异常的范围，然后使用异常处理器抛出异常
@Getter
public class BusinessException extends RuntimeException{
    private Integer code;
    private String message;
    public BusinessException(Integer code,String message){
        this.code = code;
        this.message = message;
    }
    public BusinessException(Integer code,String message,Exception e){
        super(e);
        this.code = code;
        this.message = message;
    }
    public BusinessException(ResultCodeEnum resultCodeEnum){
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }

    public BusinessException(ResultCodeEnum resultCodeEnum,Exception e){
        super(e);
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }
}
