package com.taotao.service.impl;

import com.taotao.commo.pojo.EasyUITreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * function:
 * date:       2018/2/25 0025下午 05:08
 * author:     王小羊
 */

@Service
public class ItemCatServicceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<EasyUITreeNode> getCatList(long parnetId) {

        //创建查询条件
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parnetId);
        //执行查询
        List<TbItemCat> tbItemCats = itemCatMapper.selectByExample(example);
        //转换查询结果,因为需要的是List<EasyUITreeNode>
        List<EasyUITreeNode> list = new ArrayList<EasyUITreeNode>();
        for(TbItemCat itemCat : tbItemCats){
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(itemCat.getId());
            node.setText(itemCat.getName());
            node.setState(itemCat.getIsParent() ? "closed" : "open");
            list.add(node);
        }

        return list;
    }
}
