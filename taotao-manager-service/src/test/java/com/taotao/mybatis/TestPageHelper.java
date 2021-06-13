package com.taotao.mybatis;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * function:
 * date:       2018/2/24 0024下午 09:58
 * author:     王小羊
 */
public class TestPageHelper {

    @Test
    public void testpagehelper() throws Exception{
        //初始化spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application*.xml");
        //从spring容器中获得mapper对象
        TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
        //设置分页信息
        PageHelper.startPage(1,30);
        //建立查询条件
        TbItemExample example = new TbItemExample();
        //查询数据库
        List<TbItem> list = itemMapper.selectByExample(example);
        //输出结果
        System.out.println("总记录数:"+list.size());
        //获取分页结果
        PageInfo<TbItem> pageInfo= new PageInfo<TbItem>(list);

        System.out.println("总记录数:"+pageInfo.getTotal());
        System.out.println("总页数:"+pageInfo.getPages());
        System.out.println("当前页数:"+pageInfo.getPageNum());
        System.out.println("页面大小"+pageInfo.getPageSize());


    }



}
