package com.sh.ssm.taotao.admin.service.impl;

import com.sh.ssm.taotao.admin.mapper.TbItemCatMapper;
import com.sh.ssm.taotao.admin.po.TbItemCat;
import com.sh.ssm.taotao.admin.po.TbItemCatExample;
import com.sh.ssm.taotao.admin.pojo.EasyUiTreeNode;
import com.sh.ssm.taotao.admin.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;
    public List<EasyUiTreeNode> getItemCatList(long parentId) {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
        List<EasyUiTreeNode> resultList = new ArrayList<EasyUiTreeNode>();

        for (TbItemCat itemCat : list) {
            EasyUiTreeNode easyUiTreeNode = new EasyUiTreeNode();
            easyUiTreeNode.setId(itemCat.getId());
            easyUiTreeNode.setText(itemCat.getName());
            easyUiTreeNode.setState(itemCat.getIsParent() ? "closed" : "open");
            resultList.add(easyUiTreeNode);
        }

        return resultList;
    }
}
