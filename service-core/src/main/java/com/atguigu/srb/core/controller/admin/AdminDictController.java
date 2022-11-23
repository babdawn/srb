package com.atguigu.srb.core.controller.admin;


import com.atguigu.common.result.R;
import com.atguigu.srb.core.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 数据字典 前端控制器
 * </p>
 *
 * @author Atguigu
 * @since 2022-11-19
 */
@Api(tags = "数据字典后台管理")
@RestController
@CrossOrigin
@RequestMapping("/admin/core/dict")
public class AdminDictController {
    /*
        GET方式和POST的区别
            get没有请求体
            浏览器提交请求时为了保证不会出现数据丢失，默认会对请求报文的首行 头数据使用URLEncode编码
            服务器接收请求后自动使用URLDecode解码
                如果使用请求体以外的报文提交文件 浏览器编码后文件数据就丢失了
            post可以用来提交文件
     */

    @Autowired
    DictService dictService;

    //前端提交一个数据字典的excel文件
    @ApiOperation(value = "批量导入数据字典")
    @PostMapping("import")
    public R importDicts( MultipartFile excel){//excel代表前端提交文件的表单项的name值
        dictService.importDicts(excel);
        return R.ok();
    }
}

