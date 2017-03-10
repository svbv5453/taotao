package com.sh.ssm.taotao.controller;

import com.sh.ssm.common.pojo.TaotaoResult;
import com.sh.ssm.taotao.po.TbItem;
import com.sh.ssm.taotao.service.ItemService;
import com.sh.ssm.taotao.pojo.EasyUiDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/2/23.
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/rest/item")
    @ResponseBody
    public EasyUiDataGridResult getItemList(Integer page, Integer rows) {
        return itemService.getItemList(page, rows);
    }

    @RequestMapping("/rest/item/save")
    @ResponseBody
    public TaotaoResult addItem(TbItem tbItem, String desc) {

        return  itemService.addItem(tbItem, desc);
    }

}
