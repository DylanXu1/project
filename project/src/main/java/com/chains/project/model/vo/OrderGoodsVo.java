package com.chains.project.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author xdx
 * @date 2020/8/11
 * @version 1.0
 */

@Data
public class OrderGoodsVo {
    private int shoppingId;
    private int goodsId;
    private int ordersId;
    private String goodsTitle;
    private String goodsImgmain;
    private String developer;
    private Double goodsPrice;
    private String userId;
    private String userName;
    private int payWay;
    private Date payDate;
    private int isDelete;

}
