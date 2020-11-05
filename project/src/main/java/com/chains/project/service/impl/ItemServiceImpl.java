package com.chains.project.service.impl;

import com.chains.project.mapper.ImageMapper;
import com.chains.project.mapper.ItemMapper;
import com.chains.project.model.pojo.Image;
import com.chains.project.model.pojo.Item;
import com.chains.project.model.pojo.SysMenu;
import com.chains.project.model.vo.ItemVo;
import com.chains.project.model.vo.SysMenuVo;
import com.chains.project.service.FindFileService;
import com.chains.project.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xdx
 * @date 2020/7/23
 * @version 1.0
 */

@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private ItemMapper itemMapper;
    @Resource
    private FindFileService findFileService;
    @Resource
    private ImageMapper imageMapepr;




    /*子菜单的增删改查*/
    @Override
    public List itemList(){
        return itemMapper.itemList();
    }
    @Override
    public Item itemDetal(int itemId){
        return itemMapper.itemDetal(itemId);
    }

    /*添加项目Item同时加入图片*/
    @Override
    public int addItem(ItemVo itemVo) throws Exception {  /*findFileService.getFiles()抛出了异常，此方法引入了getFiles方法所以需要抛出异常*/
        int i = itemMapper.addItem(itemVo);  /*存入项目*/
        int itemId =Integer.parseInt(itemVo.getItemId());
        List li = findFileService.getFiles("F:/OTA/image/"+itemId);  /*根据path查找文件名（url）列表*/
        for(Object fileName:li){
            Image image = new Image();
            image.setItemId(itemId);
            image.setImgAdd(fileName.toString());
            imageMapepr.addImage(image);  /*存入项目的图片*/
        }
        return i;
    }



    @Override
    public int addSysMenu(SysMenu sysMenu){
        return itemMapper.addSysMenu(sysMenu);
    }

    @Override
    public int editSysmenu(SysMenuVo sysMenuVo){
        return itemMapper.editSysmenu(sysMenuVo);
    }

    /*菜单列表树*/
    public List<SysMenu> listMenu() {
        List<SysMenu> rootMenus = itemMapper.queryMenuList();
        List<SysMenu> list = getMenuList(rootMenus);
        return list;
    }

    /**
     * 找出一级菜单和二级菜单
     * @param rootMenus
     * @return
     */
    private List<SysMenu> getMenuList(List<SysMenu> rootMenus){
        List<SysMenu> list = new ArrayList<SysMenu>();
        // 先找到所有的一级菜单
        for (int i=0;i<rootMenus.size();i++){
            SysMenu menu = rootMenus.get(i);
            //一级菜单  没有父节点
            if (menu.getParentId()==0){
                list.add(menu);
            }
        }

        //查找二级菜单
        /**
         * 利用递归找出所有子菜单
         */
        for (SysMenu sysMenu: list) {
            sysMenu.setChildMenus(getChild(sysMenu.getSysId(),rootMenus));
        }
        return list;
    }

    /**
     * 找出子菜单
     * @param itemId
     * @param rootMenu
     * @return
     */
    private List<SysMenu> getChild(int itemId, List<SysMenu> rootMenu) {
        // 子菜单
        List<SysMenu> childList = new ArrayList<SysMenu>();

        for (SysMenu menu : rootMenu) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (menu.getParentId()!=0) {
                if (menu.getParentId() == itemId) {
                    childList.add(menu);
                }
            }
        }

        // 把子菜单的子菜单再循环一遍
        for (SysMenu menu : childList) {// 没有url子菜单还有子菜单
            /*if (StringUtils.isEmpty(menu.getUrl())) {*/  /*通过判断url是否为空，为空则继续遍历*/
            // 递归
            menu.setChildMenus(getChild(menu.getSysId(), rootMenu));
            /* }*/
        }

        // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }

        return childList;
    }



     /* @Override
    public List menusitemList(){
        return  itemMapper.menusitemList();
    }*/
    /*主菜单的增删改查*/
    /*@Override
    public List menusList(){
        return itemMapper.menusList();
    }
    @Override
    public int addMenus(Menus menus){
        return itemMapper.addMenus(menus);
    }
    @Override
    public int changeMenus(Menus menus){
        return itemMapper.changeMenus(menus);
    }
    @Override
    public int delMenus(int menusId){
        return itemMapper.delMenus(menusId);
    }*/


     /* @Override
    public int changeItem(Item item){
        return itemMapper.changeItem(item);
    }
    @Override
    public int delItem(int itemId){
        return itemMapper.delItem(itemId);
    }*/



    /*@Override
    public List sysMenuList(){
        return itemMapper.sysMenuList();
    }*/



}
