package com.sh.ssm.taotao.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sh.ssm.common.pojo.TaotaoResult;
import com.sh.ssm.taotao.admin.mapper.TbItemParamMapper;
import com.sh.ssm.taotao.admin.po.TbItemParam;
import com.sh.ssm.taotao.admin.po.TbItemParamExample;
import com.sh.ssm.taotao.admin.pojo.EasyUiDataGridResult;
import com.sh.ssm.taotao.admin.service.ItemParamService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author JackSun.
 * @Date 2017/3/10 18:35.
 * @Version 1.0
 * @Description
 */
@Service
public class ItemParamServiceImpl implements ItemParamService{

    private static Logger logger = Logger.getLogger(ItemParamServiceImpl.class);

    @Autowired
    private TbItemParamMapper tbItemParamMapper;

    public EasyUiDataGridResult findAllItemParam(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);

        TbItemParamExample example = new TbItemParamExample();
        List<TbItemParam> tbItemParamList = tbItemParamMapper.selectByExampleWithBLOBs(example);

        PageInfo<TbItemParam> pageInfo = new PageInfo(tbItemParamList);

        EasyUiDataGridResult result = new EasyUiDataGridResult();
        result.setRows(tbItemParamList);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    public TaotaoResult getItemParamByCid(Long cid) {

        //条件查询
        TbItemParamExample example = new TbItemParamExample();
        TbItemParamExample.Criteria criteria = example.createCriteria();
        criteria.andItemCatIdEqualTo(cid);

        List<TbItemParam> tbItemParamList = tbItemParamMapper.selectByExampleWithBLOBs(example);
        if(tbItemParamList != null && tbItemParamList.size() > 0) {
            TbItemParam tbItemParam = tbItemParamList.get(0);
            return TaotaoResult.ok(tbItemParam);
        }

        return TaotaoResult.ok();
    }

    public TaotaoResult addItemParam(Long cid, String paramData) {
        TbItemParam tbItemParam = new TbItemParam();
        tbItemParam.setItemCatId(cid);
        tbItemParam.setParamData(paramData);
        Date date = new Date();
        tbItemParam.setCreated(date);
        tbItemParam.setUpdated(date);
        tbItemParamMapper.insert(tbItemParam);
        return TaotaoResult.ok();
    }
}
