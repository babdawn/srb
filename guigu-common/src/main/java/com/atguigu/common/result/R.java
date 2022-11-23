package com.atguigu.common.result;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R {
    private Integer code;
    private String message;
    private Map<String,Object> data = new HashMap<>();
    //构造器私有化
    private R(){

    }
    //1、返回默认成功的R对象
    public static R ok(){
        return R.setResult(ResultCodeEnum.SUCCESS);
    }
    //响应成功时,R.ok()可以返回一个r对象，如果需要向r的data中设置响应数据
    //可以提供一个专门的方法来接收要存入到data中的数据
    public R data(String key , Object val){
        this.data.put(key,val);
        return this;
    }
    //将map赋值给data
    public R data(Map<String,Object> map){
        this.data = map;
        return this;
    }
    //修改message属性值
    public R message(String message){
        this.message = message;
        return this;
    }
    //修改code值
    public R code(Integer code){
        this.code = code;
        return this;
    }
    //定义错误状态码，将来业务中执行出现该类型的错误时 返回的R对象就可以设置对应的状态码
    //2、返回默认失败的R对象
    public static R error(){
        return R.setResult(ResultCodeEnum.ERROR);
    }

    //使用枚举类对象 设置R的code和message的方法
    public static R setResult(ResultCodeEnum codeEnum){
        R r = new R();
        r.setCode(codeEnum.getCode());
        r.setMessage(codeEnum.getMessage());
        return r;
    }
}
