package com.sh.ssm.taotao.controller;

import com.sh.ssm.common.pojo.TaotaoResult;
import com.sh.ssm.taotao.pojo.EasyUiDataGridResult;
import com.sh.ssm.taotao.service.ItemParamService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author JackSun.
 * @Date 2017/3/10 18:31.
 * @Version 1.0
 * @Description
 */
@Controller
public class ItemParamController {

    private static Logger logger = Logger.getLogger(ItemParamController.class);

    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping("/rest/item/param/list")
    @ResponseBody
    public EasyUiDataGridResult findAllItemParam(Integer page, Integer rows) {

        return itemParamService.findAllItemParam(page, rows);
    }

    @RequestMapping("/rest/item/param/{cid}")
    @ResponseBody
    public TaotaoResult getItemParamByCid(@PathVariable Long cid) {
        logger.debug("cid" + cid);
        return itemParamService.getItemParamByCid(cid);
    }

    @RequestMapping("/rest/item/param/save/{cid}")
    @ResponseBody
    public TaotaoResult addItemParam(@PathVariable Long cid, String paramData) {
        return itemParamService.addItemParam(cid, paramData);
    }
}
