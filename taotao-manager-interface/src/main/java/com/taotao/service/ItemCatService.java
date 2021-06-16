package com.taotao.service;

import com.taotao.commo.pojo.EasyUITreeNode;

import java.util.List;

/**
 * function:    商品分类
 * date:       2018/2/25 0025下午 05:06
 * author:     王小羊
 */
public interface ItemCatService {

    List<EasyUITreeNode> getCatList(long parnetId);
}
