package com.chains.project.model.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author xdx
 * @date 2020/7/29
 * @version 1.0
 */

@Data
public class Image {
    private int imageId;
    private int itemId;
    private String imgAdd;
    private String videoAdd;
    private int imgType;
    private Date createTime;
    private int isDelete;

}
