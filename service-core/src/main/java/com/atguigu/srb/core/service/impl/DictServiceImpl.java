package com.atguigu.srb.core.service.impl;

import com.alibaba.excel.EasyExcel;
import com.atguigu.common.exception.BusinessException;
import com.atguigu.common.result.ResultCodeEnum;
import com.atguigu.srb.core.listener.DictExcelDataListener;
import com.atguigu.srb.core.mapper.DictMapper;
import com.atguigu.srb.core.pojo.entity.Dict;
import com.atguigu.srb.core.pojo.entity.excel.DictData;
import com.atguigu.srb.core.service.DictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author Atguigu
 * @since 2022-11-19
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    @Override
    public void importDicts(MultipartFile excel) {
        try {
            InputStream inputStream = excel.getInputStream();
            EasyExcel.read(inputStream)
                    .sheet(0)
                    .head(DictData.class)
                    .registerReadListener(new DictExcelDataListener(baseMapper))
                    .doRead();
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(ResultCodeEnum.UPLOAD_ERROR,e);
        }
    }
}
