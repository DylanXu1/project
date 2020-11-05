package com.chains.project.model.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author xdx
 * @date 2020/8/11
 * @version 1.0
 */

@Data
public class OrderGoods {
    private int goodsId;
    private int ordersId;
    private String goodsTitle;
    private String goodsImgmain;
    private Double goodsPrice;
    private int isDelete;

}
