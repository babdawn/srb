package com.atguigu.common.utils;

import com.atguigu.common.exception.BusinessException;
import com.atguigu.common.result.ResultCodeEnum;

public class Assert {
    //断言  如果 传入的对象为空  抛出自定义异常
    public static void notNull(Object obj, ResultCodeEnum codeEnum){
        if (obj==null){
            throw new BusinessException(codeEnum);
        }
    }

    public static void notNull(Object obj,Integer code ,String message){
        if (obj==null){
            throw new BusinessException(code, message);
        }
    }
    //断言，如果传入的boolean类型值为false，抛出自定义异常
    public static void notTrue(boolean flag,ResultCodeEnum codeEnum){
        if (!flag){
            //flag为false
            throw new BusinessException(codeEnum);
        }
    }

    public static void notTrue(boolean flag,Integer code,String message){
        if (!flag){
            throw new BusinessException(code, message);
        }
    }
}
