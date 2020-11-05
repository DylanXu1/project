package com.chains.project.service.impl;
/**
 * @author xdx
 * @date 2020/10/28
 * @version 1.0
 */

import com.chains.project.mapper.ForumMapper;
import com.chains.project.model.dto.ForumDto;
import com.chains.project.model.pojo.SysMenu;
import com.chains.project.model.vo.ForumVo;
import com.chains.project.service.ForumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ForumServiceImpl implements ForumService {
    @Resource
    private ForumMapper forumMapper;

    @Override
    public List<ForumVo> forumList(Long itemId) {
        List<ForumVo> allForum = forumMapper.forumList(itemId);
        List<ForumVo> list = getForumList(allForum);
        return list;
    }

    /**
     * 找出一级菜单和二级菜单
     *
     * @param allForum
     * @return
     */
    private List<ForumVo> getForumList(List<ForumVo> allForum) {
        List<ForumVo> list = new ArrayList<ForumVo>();
        // 先找到所有的一级菜单
        for (int i = 0; i < allForum.size(); i++) {
            ForumVo forumVo = allForum.get(i);
            //一级菜单  没有父节点
            if (forumVo.getParentId() == 0) {
                list.add(forumVo);
            }
        }

        //查找二级菜单
        /**
         * 利用递归找出所有子菜单
         */
        for (ForumVo forumVo: list) {
            forumVo.setChildForum(getChild(forumVo.getForumId(),allForum));
        }
        return list;
    }

    /**
     * 找出子菜单
     * @param forumId
     * @param allForum
     * @return
     */
    private List<ForumVo> getChild(long forumId, List<ForumVo> allForum) {
        // 子菜单
        List<ForumVo> childList = new ArrayList<ForumVo>();

        for (ForumVo forum : allForum) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (forum.getParentId()!=0) {
                if (forum.getParentId() == forumId) {
                    childList.add(forum);
                }
            }
        }

        // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }

    /*增加主评论*/
    @Override
    public int addForum(ForumDto forumDto){
        return forumMapper.addForum(forumDto);
    }


}

