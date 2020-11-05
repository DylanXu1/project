package com.chains.project.model.vo;

import com.chains.project.model.pojo.SysMenu;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author xdx
 * @date 2020/8/25
 * @version 1.0
 */

@Data
public class SysMenuVo {
    private String sysId;
    private String menuName;
    private Date updateTime;
    // 菜单顺序
    private int sortOrder;
}
