package com.chains.project.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author xdx
 * @date 2020/8/27
 * @version 1.0
 */

@Data
public class ItemVo {
    private String itemId;
    private String parentId;
    private String itemName;
    private String title;
    private String imgMain;
    private String introduce;
    private String originalPrice;
    private String price;
    private String developer;
}
