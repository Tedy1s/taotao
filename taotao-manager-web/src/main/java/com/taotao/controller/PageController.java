package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * function:
 * date:       2018/2/24 0024下午 08:52
 * author:     王小羊
 */
@Controller
public class PageController {

    /**
     *   显示首页
     *
     */
    @RequestMapping("/")
    public String ShowIndex(){
        return "index";
    }

    /**
     *   显示商品页面
     *   商品添加页面
     *   商品规格参数页面
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }



}
