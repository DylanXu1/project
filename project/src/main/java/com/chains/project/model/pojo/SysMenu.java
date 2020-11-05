package com.chains.project.model.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author xdx
 * @date 2020/8/19
 * @version 1.0
 */

@Data
public class SysMenu {
    private int sysId;
    private int parentId;
    private String menuName;
    private Date createTime;
    private Date updateTime;
    private String url;
    // 菜单图标
    private String icon;
    // 菜单顺序
    private int sortOrder;
    private int isDelete;
    // 子菜单
    private List<SysMenu> childMenus;
}
