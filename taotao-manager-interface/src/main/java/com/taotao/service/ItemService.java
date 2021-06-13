package com.taotao.service;

import com.taotao.commo.pojo.EasyUIDataGridResult;

/**
 * function:
 * date:       2018/2/24 0024上午 09:34
 * author:     王小羊
 */
public interface ItemService {

    EasyUIDataGridResult getItemList(int page,int rows);
}
