package com.sh.ssm.taotao.admin.service;

import com.sh.ssm.common.pojo.TaotaoResult;
import com.sh.ssm.taotao.admin.po.TbItem;
import com.sh.ssm.taotao.admin.pojo.EasyUiDataGridResult;

/**
 * Created by Administrator on 2017/2/23.
 */
public interface ItemService {

    public EasyUiDataGridResult getItemList(Integer page, Integer rows);

    public TaotaoResult addItem(TbItem tbItem, String descItem, String itemParams);
}
