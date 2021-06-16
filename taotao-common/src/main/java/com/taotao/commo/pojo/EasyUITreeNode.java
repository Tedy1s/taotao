package com.taotao.commo.pojo;

import java.io.Serializable;

/**
 * function:    树状显示工具
 * date:       2018/2/25 0025下午 05:01
 * author:     王小羊
 */
public class EasyUITreeNode implements Serializable{

    //节点Id
    private long id;
    //节点名称
    private String text;
    //节点状态 open:叶子节点,closed:父节点
    private String state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
