package com.taotao.service;

import com.taotao.commo.pojo.EasyUIDataGridResult;
import com.taotao.commo.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

/**
 * function:   商品显示
 * date:       2018/2/24 0024上午 09:34
 * author:     王小羊
 */
public interface ItemService {

    EasyUIDataGridResult getItemList(int page,int rows);

    TaotaoResult addItem(TbItem time,String desc);
}
