package com.chains.project.mapper;

import com.chains.project.model.dto.Shopping;
import com.chains.project.model.pojo.OrderGoods;
import com.chains.project.model.pojo.Orders;
import com.chains.project.model.vo.OrderGoodsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xdx
 * @date 2020/8/11
 * @version 1.0
 */

@Mapper
public interface OrdersMapper {
    /*根据用户手机查未支付订单列表（购物车）*/
    List<Shopping> shoppingList(Long phone);
    /*根据用户查已支付订单列表*/
    List<OrderGoodsVo> orderGoodsListByUser(Long phone);
    /*全部已支付订单列表*/
    List<OrderGoodsVo> orderGoodsList();

    /*将商品加入购物车*/
    int addOrders(Shopping shopping);
    Integer ispay(Long phone);/*查是否有未支付的订单*/
    int addOrderGoods(Shopping Shopping);

    /*将商品加入订单列表（无支付）*/
    int addOrdersNP(Shopping shopping);
    int addOrderGoodsNP(Shopping shopping);

    /*删除购物车中的商品*/
    int delOrderGoods(int shoppingId);
    int orderGoodsCount(int shoppingId);  /*查询当前订单下的产品数*/
    int delOrders(int shoppingId); /*根据订单内的商品删除订单*/
}
