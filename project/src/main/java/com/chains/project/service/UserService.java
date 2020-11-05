package com.chains.project.service;

import com.chains.project.model.dto.OrgDto;
import com.chains.project.model.dto.UserInfoDto;
import com.chains.project.model.vo.StudentVo;
import com.chains.project.model.pojo.Org;
import com.chains.project.model.pojo.Student;
import com.chains.project.model.pojo.User;
import com.chains.project.model.vo.TeacherVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xdx
 * @date 2020/8/26
 * @version 1.0
 */


public interface UserService {
    int addUser(User user);
    User getUser(Long phone);
    int stopTeam(Integer userSerial);
    /* int addUser(User user);*/

    List orgList(int page, int limit, int startItem);
    int addOrg(User user);

    List teacherListByOid(String parentId, int page, int limit, int startItem);
    int addTeacher(User user);

    List<StudentVo> studentListByT(String userId, int page, int limit, int startItem);
    int addStudent(User user);

    int changeImg(String userId,String img);
    int changePassword(UserInfoDto userInfoDto);
}
