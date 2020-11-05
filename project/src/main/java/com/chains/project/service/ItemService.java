package com.chains.project.service;

import com.chains.project.model.pojo.Item;
import com.chains.project.model.pojo.SysMenu;
import com.chains.project.model.vo.ItemVo;
import com.chains.project.model.vo.SysMenuVo;

import java.util.List;

/**
 * @author xdx
 * @date 2020/7/23
 * @version 1.0
 */

public interface ItemService {
   //List menusitemList();
    /*主菜单的增删改查*//*
 /*  List menusList();
  int addMenus(Menus menus);
  int changeMenus(Menus menus);
  int delMenus(int menusId);

  *//*子菜单的增删改查*/
    List itemList();
    Item itemDetal(int item);
    int addItem(ItemVo itemVo) throws Exception;
    /*int changeItem(Item item);
    int delItem(int itemId);*/

    //(作废,DB查询递归列表)
    //List sysMenuList();

    int addSysMenu(SysMenu sysMenu);
    int editSysmenu(SysMenuVo sysMenuVo);

    /*菜单列表树*/
    List<SysMenu> listMenu();
    //List<TreeMenu> listMenu();



}
