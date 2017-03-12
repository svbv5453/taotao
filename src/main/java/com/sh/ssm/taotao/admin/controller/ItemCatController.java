package com.sh.ssm.taotao.admin.controller;

import com.sh.ssm.taotao.admin.pojo.EasyUiTreeNode;
import com.sh.ssm.taotao.admin.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 */
@Controller
@RequestMapping("/rest/item/cat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUiTreeNode> getItemCatList(@RequestParam(value="id", defaultValue = "0") Long parentId) {
        return itemCatService.getItemCatList(parentId);
    }

}
