package com.taotao.controller;

import com.taotao.commo.pojo.EasyUIDataGridResult;
import com.taotao.commo.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * function:    页面表现层
 * date:       2018/2/24 0024下午 10:50
 * author:     王小羊
 */
@Controller
public class ItemController {


    @Autowired
    private ItemService itemService;

    /**
     * 商品分页
     */
    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult showList(Integer page, Integer rows) {
        EasyUIDataGridResult result = itemService.getItemList(page, rows);
        return result;

    }

    /**
     *   添加商品
     *
     */
    @RequestMapping("/item/save")
    @ResponseBody
    public TaotaoResult seveItem(TbItem item,String desc){
        TaotaoResult taotaoResult = itemService.addItem(item, desc);
        return taotaoResult;
    }
}
