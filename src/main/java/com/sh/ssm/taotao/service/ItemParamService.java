package com.sh.ssm.taotao.service;

import com.sh.ssm.common.pojo.TaotaoResult;
import com.sh.ssm.taotao.pojo.EasyUiDataGridResult;

/**
 * @author JackSun.
 * @Date 2017/3/10 18:33.
 * @Version 1.0
 * @Description
 */
public interface ItemParamService {

    public EasyUiDataGridResult findAllItemParam(Integer page, Integer rows);

    public TaotaoResult getItemParamByCid(Long cid);

    public TaotaoResult addItemParam(Long cid, String paramData);

}
