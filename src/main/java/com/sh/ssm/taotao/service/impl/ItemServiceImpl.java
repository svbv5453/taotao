package com.sh.ssm.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sh.ssm.common.pojo.TaotaoResult;
import com.sh.ssm.common.utils.IDUtils;
import com.sh.ssm.taotao.mapper.TbItemDescMapper;
import com.sh.ssm.taotao.mapper.TbItemMapper;
import com.sh.ssm.taotao.po.TbItem;
import com.sh.ssm.taotao.po.TbItemDesc;
import com.sh.ssm.taotao.po.TbItemExample;
import com.sh.ssm.taotao.service.ItemService;
import com.sh.ssm.taotao.pojo.EasyUiDataGridResult;
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

    public TaotaoResult addItem(TbItem tbItem, String descItem) {
        /**
         * 补全tbItem和tbItemDesc的字段
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

        return TaotaoResult.ok();
    }
}
