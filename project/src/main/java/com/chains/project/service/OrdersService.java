package com.chains.project.service;

import com.chains.project.model.dto.Shopping;
import com.chains.project.model.pojo.OrderGoods;
import com.chains.project.model.pojo.Orders;
import com.chains.project.model.vo.OrderGoodsVo;

import java.util.List;

/**
 * @author xdx
 * @date 2020/8/11
 * @version 1.0
 */


public interface OrdersService {
    List<Shopping> shoppingList(Long phone);
    List<OrderGoodsVo> orderGoodsListByUser(Long phone);
    List<OrderGoodsVo> orderGoodsList();

    int addOrders(Shopping shopping);
    Integer ispay(Long phone);
    int addOrderGoods(Shopping Shopping);

    int addOrdersNP(Shopping shopping);
    int addOrderGoodsNP(Shopping shopping);

    int delOrderGoods(int shoppingId);
    int orderGoodsCount(int shoppingId);
    int delOrders(int shoppingId);
}
