package com.chains.project.controller;

import com.chains.project.model.pojo.Item;
import com.chains.project.model.pojo.SysMenu;
import com.chains.project.model.vo.ItemVo;
import com.chains.project.model.vo.SysMenuVo;
import com.chains.project.service.ItemService;
import com.chains.project.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xdx
 * @date 2020/7/23
 * @version 1.0
 */

@RestController
@RequestMapping("/item")
public class ItemController {
    @Resource
    private ItemService itemService;

    @RequestMapping("/sysMenuList")
    public Result listMenu(){
        return Result.success(null,itemService.listMenu());
    }

    @RequestMapping("/itemList")
    public Result itemList(){
        return Result.success(0L,itemService.itemList());
    }

    @RequestMapping("/itemDetail")
    public Result itemDetal(int itemId){
        Item item = itemService.itemDetal(itemId);
        return Result.success(0L,item);
    }

    @RequestMapping("/addItem")/*这个接口暂时不用，上传项目的时候会上传图片，使用的是上传图片的接口，同时会调用itemService.addItem(itemVo)方法*/
    public Result addItem(ItemVo itemVo) throws Exception {
        return Result.success(0L,itemService.addItem(itemVo));
    }


    @RequestMapping("/addSysMenu")
    public Result addSysMenu(SysMenu sysMenu){
        return Result.success(0L,itemService.addSysMenu(sysMenu));
    }

    @RequestMapping("/editSysmenu")
    public Result editSysmenu(SysMenuVo sysMenuVo){
        return Result.success(null,itemService.editSysmenu(sysMenuVo));
    }


}
