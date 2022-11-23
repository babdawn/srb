package com.atguigu.srb.core.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.atguigu.srb.core.pojo.entity.Dict;
import com.alibaba.excel.event.AnalysisEventListener;
import com.atguigu.srb.core.mapper.DictMapper;
import com.atguigu.srb.core.pojo.entity.excel.DictData;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

public class DictExcelDataListener extends AnalysisEventListener<DictData> {
    public DictExcelDataListener(DictMapper baseMapper){
        this.dictMapper = baseMapper;
    }
    DictMapper dictMapper;
    @Override
    public void invoke(DictData dictData, AnalysisContext analysisContext) {
        Integer count = dictMapper.selectCount(new LambdaQueryWrapper<Dict>()
                .eq(Dict::getId, dictData.getId()));
        if (count == 0){
            Dict dict = new Dict();
            dict.setId(Long.parseLong(dictData.getId()));
            dict.setDictCode(dict.getDictCode());
            dict.setName(dictData.getName());
            if (dictData.getValue()!=null){
                dict.setValue(Integer.parseInt(dictData.getValue()));
            }
            dict.setParentId(Long.parseLong(dictData.getParentId()));
            dictMapper.insert(dict);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
