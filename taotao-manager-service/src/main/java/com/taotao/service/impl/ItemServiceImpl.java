package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.commo.pojo.EasyUIDataGridResult;
import com.taotao.commo.pojo.TaotaoResult;
import com.taotao.commo.utils.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * function:    商品信息管理
 * date:       2018/2/24 0024上午 09:36
 * author:     王小羊
 */

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private TbItemMapper itemMapper;

    @Autowired
    private TbItemDescMapper itemDescMapper;

    /**
     *   分页显示商品信息
     *
     */
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

    /**
     *   添加商品信息
     *
     */
    @Override
    public TaotaoResult addItem(TbItem item, String desc) {
        //添加商品id
        long id = IDUtils.genItemId();
        item.setId(id);
        //添加上架时间
        Date date = new Date();
        item.setCreated(date);
        //添加修改时间
        item.setUpdated(date);
        //商品状态，1-正常，2-下架，3-删除
        item.setStatus((byte) 1);

        itemMapper.insert(item);

        //插入商品描述对象
        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemId(id);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(date);
        itemDesc.setUpdated(date);
        itemDescMapper.insert(itemDesc);

        return TaotaoResult.ok();
    }
}
