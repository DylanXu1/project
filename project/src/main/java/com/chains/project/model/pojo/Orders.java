package com.chains.project.model.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author xdx
 * @date 2020/8/11
 * @version 1.0
 */

@Data
public class Orders {
    private int ordersId;
    private int userId;
    private int payWay;
    private Date payDate;
    private int isPay;
    private int isDelete;
    private List<OrderGoods> orderGoods;
}
