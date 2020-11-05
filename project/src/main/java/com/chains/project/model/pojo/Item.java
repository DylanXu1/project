package com.chains.project.model.pojo;
/**
 * @author xdx
 * @date 2020/7/20
 * @version 1.0
 */

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Item {
    private int itemId;
    private String itemName;
    private String title;
    private String imgMain;
    private String introduce;
    private double originalPrice;
    private double Price;
    private String developer;
    private Date issuingData;
    private int isDelete;
    private List<Image> image;

}
