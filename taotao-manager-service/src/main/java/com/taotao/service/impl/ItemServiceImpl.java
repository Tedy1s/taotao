package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.commo.pojo.EasyUIDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * function:
 * date:       2018/2/24 0024上午 09:36
 * author:     王小羊
 */

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {

        //设置分页信息
        PageHelper.startPage(page,rows);
        //执行分页查询
        TbItemExample example = new TbItemExample();
        List<TbItem> list = itemMapper.selectByExample(example);

        //获取总记录数
        PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
        long total = pageInfo.getTotal();

        //封装到EasyUIDataGridResult对象
        EasyUIDataGridResult result = new EasyUIDataGridResult(total,list);

        return result;
    }
}
