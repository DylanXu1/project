package com.chains.project.service.impl;

import com.chains.project.mapper.OrdersMapper;
import com.chains.project.model.dto.Shopping;
import com.chains.project.model.pojo.OrderGoods;
import com.chains.project.model.pojo.Orders;
import com.chains.project.model.vo.OrderGoodsVo;
import com.chains.project.service.OrdersService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xdx
 * @date 2020/8/11
 * @version 1.0
 */

@Service
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersMapper ordersMapper;

    @Override
    public List<Shopping> shoppingList(Long phone){
        return ordersMapper.shoppingList(phone);
    }

    @Override
    public List<OrderGoodsVo> orderGoodsListByUser(Long phone){
        return ordersMapper.orderGoodsListByUser(phone);
    }

    @Override
    public List<OrderGoodsVo> orderGoodsList(){
        return ordersMapper.orderGoodsList();
    }

    @Override
    public int addOrders(Shopping shopping){
        return ordersMapper.addOrders(shopping);
    }
    @Override
    public Integer ispay(Long phone){
        return ordersMapper.ispay(phone);
    }
    @Override
    public int addOrderGoods(Shopping shopping){
        //Integer userId = shopping.getUserId();
        Long phone = shopping.getPhone();
        /*先查询出ordersId,再将ordersId赋值给shopping*/
        Integer ordersId = ordersMapper.ispay(phone);
        shopping.setOrdersId(ordersId);
        return ordersMapper.addOrderGoods(shopping);
    }

    @Override
    public int addOrdersNP(Shopping shopping){
        return ordersMapper.addOrdersNP(shopping);
    }
    @Override
    public int addOrderGoodsNP(Shopping shopping){
        return ordersMapper.addOrderGoodsNP(shopping);
    }


    @Override
    public int delOrderGoods(int shoppingId){
        return ordersMapper.delOrderGoods(shoppingId);
    }
    @Override
    public int orderGoodsCount(int shoppingId){
        return ordersMapper.orderGoodsCount(shoppingId);
    }
    @Override
    public int delOrders(int shoppingId){
        return ordersMapper.delOrders(shoppingId);
    }

}
