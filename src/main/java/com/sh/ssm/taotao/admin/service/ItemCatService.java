package com.sh.ssm.taotao.admin.service;

import com.sh.ssm.taotao.admin.pojo.EasyUiTreeNode;

import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 */
public interface ItemCatService {

    List<EasyUiTreeNode> getItemCatList(long parentId);
}
