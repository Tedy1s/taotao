package com.taotao.controller;

import com.taotao.commo.pojo.EasyUITreeNode;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * function:    商品分类管理
 * date:       2018/2/25 0025下午 06:15
 * author:     王小羊
 */
@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUITreeNode> getCatList(@RequestParam(value = "id",defaultValue = "0") Long parentId){
        List<EasyUITreeNode> list = itemCatService.getCatList(parentId);
        return list;
    }
}
