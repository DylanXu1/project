package com.chains.project.mapper;

import com.chains.project.model.pojo.Item;
import com.chains.project.model.pojo.SysMenu;
import com.chains.project.model.vo.ItemVo;
import com.chains.project.model.vo.SysMenuVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xdx
 * @date 2020/7/22
 * @version 1.0
 */

@Mapper
public interface ItemMapper {

    //子菜单的增删改查
    List itemList();    //all子菜单
    Item itemDetal(int item);
    int addItem(ItemVo itemVo);

    //根据父id添加菜单
    int addSysMenu(SysMenu sysMenu);
    //编辑菜单
    int editSysmenu(SysMenuVo sysMenuVo);
    //递归查询菜单
    List<SysMenu> queryMenuList();
    //List<TreeMenu> queryMenuList();



}
