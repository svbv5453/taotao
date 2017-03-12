package com.sh.ssm.taotao.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sh.ssm.common.pojo.TaotaoResult;
import com.sh.ssm.common.utils.IDUtils;
import com.sh.ssm.taotao.admin.mapper.TbItemDescMapper;
import com.sh.ssm.taotao.admin.mapper.TbItemMapper;
import com.sh.ssm.taotao.admin.mapper.TbItemParamItemMapper;
import com.sh.ssm.taotao.admin.po.TbItem;
import com.sh.ssm.taotao.admin.po.TbItemDesc;
import com.sh.ssm.taotao.admin.po.TbItemExample;
import com.sh.ssm.taotao.admin.po.TbItemParamItem;
import com.sh.ssm.taotao.admin.pojo.EasyUiDataGridResult;
import com.sh.ssm.taotao.admin.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 */
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private TbItemMapper tbItemMapper;

    @Autowired
    private TbItemDescMapper tbItemDescMapper;

    @Autowired
    private TbItemParamItemMapper tbItemParamItemMapper;

    public EasyUiDataGridResult getItemList(Integer page, Integer rows) {
        //分页处理
        PageHelper.startPage(page, rows);
        //执行查询语句
        TbItemExample example = new TbItemExample();
        List<TbItem> list = tbItemMapper.selectByExample(example);
        //取出查询的结果
        PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
        //将查询结果放在EasyUiDataGridResult对象中
        EasyUiDataGridResult result = new EasyUiDataGridResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(list);

        return result;
    }

    public TaotaoResult addItem(TbItem tbItem, String descItem, String itemParams) {
        /**
         * 补全tbItem和tbItemDesc以及tbItemParam的字段
         */
        Long itemId = IDUtils.genItemId();
        tbItem.setId(itemId);
        //商品状态，1-正常，2-下架，3-删除
        tbItem.setStatus((byte) 1);
        Date date = new Date();
        tbItem.setCreated(date);
        tbItem.setUpdated(date);
        tbItemMapper.insert(tbItem);

        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemId(itemId);
        tbItemDesc.setItemDesc(descItem);
        tbItemDesc.setCreated(date);
        tbItemDesc.setUpdated(date);
        tbItemDescMapper.insert(tbItemDesc);

        TbItemParamItem tbItemParamItem = new TbItemParamItem();
        tbItemParamItem.setItemId(itemId);
        tbItemParamItem.setParamData(itemParams);
        tbItemParamItem.setCreated(date);
        tbItemParamItem.setUpdated(date);
        tbItemParamItemMapper.insert(tbItemParamItem);

        return TaotaoResult.ok();
    }
}
