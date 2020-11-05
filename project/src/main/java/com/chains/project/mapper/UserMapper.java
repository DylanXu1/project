package com.chains.project.mapper;

import com.chains.project.model.dto.UserInfoDto;
import com.chains.project.model.vo.StudentVo;
import com.chains.project.model.pojo.User;
import com.chains.project.model.vo.TeacherVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xdx
 * @version 1.0
 * @date 2020/8/26
 */
@Mapper
public interface UserMapper {
    int addUser(User user);
    User getUser(Long phone);
    Integer getUserId(Long phone);
    /*禁用机构用户*/
    int stopTeam(@Param("userSerial")Integer userSerial);

    List<User> orgList(@Param("page")int page, @Param("limit")int limit, @Param("startItem")int startItem);
    int orgListCount();
    int addOrg(User user);


    List<TeacherVo> teacherListByOid(@Param("parentId")String parentId, @Param("page")int page, @Param("limit")int limit, @Param("startItem")int startItem);
    int teacherListCount(@Param("parentId")String parentId);
    int addTeacher(User user);


    List<StudentVo> studentListByT(@Param("userId")String userId, @Param("page")int page, @Param("limit")int limit, @Param("startItem")int startItem);
    int studentListByTCount(@Param("userId")String userId);
    int addStudent(User user);

    /*修改图像*/
    int changeImg(@Param("userId")String userId,@Param("img")String img);
   /* int changeImgCo(@Param("userSerial")Integer userSerial,@Param("img")String img);*/
    int changePassword(UserInfoDto userInfoDto);



}
