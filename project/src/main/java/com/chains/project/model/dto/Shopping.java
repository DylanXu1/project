package com.chains.project.model.dto;

import lombok.Data;

/**
 * @author xdx
 * @date 2020/8/12
 * @version 1.0
 */

@Data
public class Shopping {
    private Integer shoppingId;
    private String userId;
    private Integer ordersId;
    private Long phone;
    private Integer payWay;
    private Integer payDate;
    private Integer isPay;
    private Integer goodsId;
    private String goodsTitle;
    private String ordergoodsId; /*单商品订单号，特定随机*/
    private String payId; /*单商品订单号，特定随机*/

    /*goodsId*/
   /* private Integer itemId;*/
    private String developer;
    private String goodsImgmain;
    private Double goodsPrice;


}
