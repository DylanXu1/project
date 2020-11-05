package com.chains.project.controller;

import com.chains.project.model.dto.Shopping;
import com.chains.project.model.pojo.OrderGoods;
import com.chains.project.model.pojo.Orders;
import com.chains.project.service.OrdersService;
import com.chains.project.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xdx
 * @date 2020/8/11
 * @version 1.0
 */

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrdersService ordersService;

    /*根据用户查未支付订单列表（购物车）*/
    @RequestMapping("/shopping")
    public Result shoppingList(Long phone){
        System.out.println("前端的userId是："+phone);
        System.out.println(ordersService.shoppingList(phone));
        if(phone!=null){
            return Result.success(null,ordersService.shoppingList(phone));
        }
        return null;
    }
    /*根据用户查已支付订单列表,如果userId为空查全部*/
    @RequestMapping("/orderGoodsListByUser")
    public Result orderGoodsListByUser(Long phone){
        if(phone==null || phone.equals("")){
            return Result.success(null,ordersService.orderGoodsList());
        }
        return Result.success(null,ordersService.orderGoodsListByUser(phone));
    }

    /*加入商品到购物车*/
    @RequestMapping("/addOrer")
    public Result addOrders(Shopping shopping){
        System.out.println("接收到的购物车数据:======="+shopping);
        //Integer userId = shopping.getUserId();
        Long phone = shopping.getPhone();
        if(ordersService.ispay(phone)!=null){
            ordersService.addOrderGoods(shopping);
            return Result.success("加入购物车成功");
        }else {
            ordersService.addOrders(shopping);
            ordersService.addOrderGoods(shopping);
            return Result.success("加入购物车成功");
        }
       /* return Result.error("加入购物车失败");*/
    }

    /*删除购物车中的商品*/
    @RequestMapping("/delShopping")
    public Result delOrderGoods(int shoppingId){
        if(ordersService.orderGoodsCount(shoppingId)<=1){
            ordersService.delOrders(shoppingId);
        }
        ordersService.delOrderGoods(shoppingId);
        return Result.success("删除成功");
    }
   /* @RequestMapping("/delOrders")
    public Result delOrders(int shoppingId){
        return Result.success(null,ordersService.delOrders(shoppingId));
    }*/
   /*查一个用户下的多个订单所有商品*/


    /*加入商品到订单列表（无支付）*/
    @RequestMapping("/addOrerNP")
    public Result addOrerNP(Shopping shopping){
        System.out.println("无支付接收到的购物车数据:======="+shopping);
        int i = ordersService.addOrdersNP(shopping);
        int j = ordersService.addOrderGoodsNP(shopping);
        if(i!=0 && j!=0){
            return Result.success("加入我的商品列表成功");
        }
        return Result.success("加入我的商品列表失败");
    }


}
