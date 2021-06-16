package com.taotao.controller;

import com.taotao.commo.utils.JsonUtils;
import com.taotao.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * function:    用FastDFS上传图片
 * date:       2018/2/25 0025下午 08:15
 * author:     王小羊
 */
@Controller
public class PictureController {

    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;

    @RequestMapping(value = "/pic/upload",produces = MediaType.TEXT_PLAIN_VALUE + ";charset=utf-8")
    @ResponseBody
    public String imageUplode(MultipartFile uploadFile){
        try {
            //获得页面传过来的文件
            //获取文件的内容
            byte[] content = uploadFile.getBytes();
            //获取文件的名称
            String filename = uploadFile.getOriginalFilename();
            //获取文件的后缀名
            String ext = filename.substring(0, filename.lastIndexOf(".") + 1);
            //上传文件到服务器
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
            String url = fastDFSClient.uploadFile(content, ext);
            //封装数据返回结果
            Map result = new HashMap();
            result.put("error",0);
            result.put("url",IMAGE_SERVER_URL + url);
            return JsonUtils.objectToJson(result);
        } catch (Exception e) {
            e.printStackTrace();
            //封装错误信息
            Map result = new HashMap();
            result.put("error", 1);
            result.put("message", "图片上传出错");
            return JsonUtils.objectToJson(result);
        }

    }



}
