package com.atguigu.srb.core.controller.api;


import com.atguigu.srb.core.pojo.entity.IntegralGrade;
import com.atguigu.srb.core.service.IntegralGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 积分等级表 前端控制器
 * </p>
 *
 *  RESTFUL风格：
 *      根据请求方式判断请求的意图
 *      get  直接访问 代表查询所有
 *      get +  {id}  根据id查询
 *      delete + {id}  删除数据
 *      put  请求体json  更新数据
 *      post  请求体json  新增数据
 * @author Atguigu
 * @since 2022-11-19
 */
@RestController
@Api(tags = "积分等级用户模块")
@RequestMapping("/api/integralGrade")
public class ApiIntegralGradeController {
    @Autowired
    IntegralGradeService integralGradeService;
    //积分等级管理CRUD接口
    //  get+ /integralGrade
    //1、查询所有积分等级
    @ApiOperation(value = "积分等级列表")
    @GetMapping
    public List<IntegralGrade> list(){
        List<IntegralGrade> grades = integralGradeService.list();
        return grades;
    }
    //2、根据id查询
    @ApiOperation(value = "id查询积分等级")
    @GetMapping("{id}")
    public IntegralGrade getById(@ApiParam(value = "id值",required = true) @PathVariable("id") String id){
        IntegralGrade integralGrade = integralGradeService.getById(id);

        return integralGrade;
    }

    //3、根据id删除
    @ApiOperation(value = "id删除积分等级")
    @DeleteMapping("{id}")
    public Boolean deleteById(@ApiParam(value = "id值",required = true) @PathVariable("id") String id){
        boolean b = integralGradeService.removeById(id);

        return b;
    }
    //4、更新
    @ApiOperation(value = "更新积分等级",notes = "必须提供id")
    @PutMapping
    public Boolean update(@RequestBody IntegralGrade integralGrade){
        boolean b = integralGradeService.updateById(integralGrade);
        return b;
    }
    //5、新增
    @ApiOperation(value = "新增积分等级")
    @PostMapping
    public Boolean save(@RequestBody IntegralGrade integralGrade){
        boolean b = integralGradeService.save(integralGrade);
        return b;
    }

}

