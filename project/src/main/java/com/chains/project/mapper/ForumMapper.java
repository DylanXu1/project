package com.chains.project.mapper;

import com.chains.project.model.dto.ForumDto;
import com.chains.project.model.vo.ForumVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xdx
 * @version 1.0
 * @date 2020/10/28
 */
@Mapper
public interface ForumMapper {
    //递归查询评论
    List<ForumVo> forumList(Long itemId);

    //增加评论
    int addForum(ForumDto forumDto);


    //List forumSonList(Long forumId);
}
