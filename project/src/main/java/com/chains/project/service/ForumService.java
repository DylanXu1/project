package com.chains.project.service;

import com.chains.project.model.dto.ForumDto;
import com.chains.project.model.vo.ForumVo;

import java.util.List;

/**
 * @author xdx
 * @version 1.0
 * @date 2020/10/28
 */
public interface ForumService {

    //递归查询评论
    List<ForumVo> forumList(Long itemId);
    int addForum(ForumDto forumDto);

   // List forumSonList(Long forumId);
}
