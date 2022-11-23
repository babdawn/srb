package com.atguigu.common.handler;

import com.atguigu.common.exception.BusinessException;
import com.atguigu.common.result.R;
import com.atguigu.common.result.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /*
    * 每个具体的异常如果我们希望返回自定义的R对象，都需要一个异常处理器
    * 我们希望以后抛出的异常都能够被一个异常处理器处理
    * 同时在异常处理的业务代码中可以判断如何返回一个R对象（给他设置合适的code和message）
    *解决：
    *      -在可能出现异常的代码中，手动try catch抛出
    *       自定义类型的异常(将将来可能出现的所有异常都转换为一个类型的异常)
    *      -自定义类型的异常类  还需要拓展（携带异常处理器需要返回的R对象需要的code和message属性）
    * */
    //1.处理Exception异常的处理器
    public R exception(Exception e){
        log.error(ExceptionUtils.getStackTrace(e));
        return R.error();
    }

    //3.处理自定义类型异常的处理器
    @ExceptionHandler(value = BusinessException.class)
    public R exception(BusinessException e){
        log.error(ExceptionUtils.getStackTrace(e));
        return R.error().code(e.getCode()).message(e.getMessage());
    }
    //2.处理指定类型异常的处理器
    @ExceptionHandler(value = BadSqlGrammarException.class)
    public R exception(BadSqlGrammarException e){
        log.error(ExceptionUtils.getStackTrace(e));
        return R.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR_ERROR);
    }

    @ExceptionHandler(value = ArithmeticException.class)
    public R exception(ArithmeticException e){
        log.error(ExceptionUtils.getStackTrace(e));
        return R.setResult(ResultCodeEnum.SERVLET_ERROR);
    }
}
