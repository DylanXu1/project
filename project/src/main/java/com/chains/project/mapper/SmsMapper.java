package com.chains.project.mapper;

import com.chains.project.model.dto.ConfirmPassword;
import com.chains.project.model.pojo.Org;
import com.chains.project.model.pojo.Student;
import com.chains.project.model.pojo.Teacher;
import com.chains.project.model.pojo.User;
import com.chains.project.model.vo.OrgVo;
import com.chains.project.model.vo.SmsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xdx
 * @version 1.0
 * @date 2020/8/26
 */
@Mapper
public interface SmsMapper {
    SmsVo getSmsvo(@Param("phone")Long phone);
    Integer getLogin(@Param("phone")String phone, @Param("password")String password);
    int addsmsVo(@Param("phone")String phone, @Param("password")String password);

    /*修改密码*/
    int changePassword(ConfirmPassword confirmPassword);

    //根据手机号返回一个对象（企业、老师，学生）
   /* OrgVo getOrg(@Param("userType")long userType,@Param("phone")long phone);
    Teacher getTeacher(@Param("phone")long phone);
    Student getStudent(@Param("phone")long phone);
    User getUser(@Param("phone")long phone);*/
}
