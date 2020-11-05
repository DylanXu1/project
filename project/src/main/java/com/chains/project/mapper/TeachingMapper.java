package com.chains.project.mapper;


import com.chains.project.model.vo.TeacherVo;
import com.chains.project.model.vo.TeachingVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeachingMapper {
    //分类列表
    List getCategoryList(Integer groupId);

    //自动标题列表
    List getclauseList();
    List getclauseListBycat(String categoryId);

    //文章详情
    TeachingVo teachDetail(Integer teachId);
    //查询当前文章的上一篇及下一篇
    List<TeachingVo> teachOtherDetail(Integer teachId);
}
