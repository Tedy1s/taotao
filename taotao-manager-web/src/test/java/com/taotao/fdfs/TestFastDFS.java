package com.taotao.fdfs;

import com.taotao.utils.FastDFSClient;
import org.csource.fastdfs.*;
import org.junit.Test;

/**
 * function:    FastDFS分布式图片上传 技术的测试
 * date:       2018/2/25 0025下午 07:30
 * author:     王小羊
 */
public class TestFastDFS {

    @Test
    public void test() throws Exception{

        //1.加载配置文件,client.conf,文件的内容就是tracker服务的地址
        ClientGlobal.init("F:\\taotao\\taotao\\taotao-manager-web\\src\\main\\resources\\resource\\client.conf");
        //2.创建一个trackerClient的对象
        TrackerClient trackerClient = new TrackerClient();
        //3.使用trackerClient对象创建一个连接,获得一个trackerServer对象
        TrackerServer trackerServer = trackerClient.getConnection();
        //4.创建一个StorageServer的引用,值为null
        StorageServer storageServer = null;
        //5.创建一个StorageClient的对象,需要两个对象,一个trackrServer一个StorageServer对象
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        //6.使用storageClinet对象上传图片
        String[] strings = storageClient.upload_file("F:\\图片收藏\\照片\\S61206-202540.jpg", "jpg", null);
        //7.反hi数组,包含组名和图片的路径
        for(String s : strings){
            System.out.println(s);
        }

    }

    /**
     *   将上面的方法封装成FastDFSClient对象
     *
     */
    @Test
    public void test2() throws Exception{
        FastDFSClient fastDFSClient = new FastDFSClient("F:\\taotao\\taotao\\taotao-manager-web\\src\\main\\resources\\resource\\client.conf");
        String s = fastDFSClient.uploadFile("F:\\图片收藏\\照片\\S70522-155647.jpg");
        System.out.println(s);
    }

}
