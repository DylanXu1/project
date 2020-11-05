package com.chains.project.service.impl;
/**
 * @author xdx
 * @date 2020/8/26
 * @version 1.0
 */

import com.chains.project.mapper.SmsMapper;
import com.chains.project.mapper.UserMapper;
import com.chains.project.model.dto.OrgDto;
import com.chains.project.model.dto.UserInfoDto;
import com.chains.project.model.vo.StudentVo;
import com.chains.project.model.pojo.Org;
import com.chains.project.model.pojo.Student;
import com.chains.project.model.pojo.User;
import com.chains.project.model.vo.TeacherVo;
import com.chains.project.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private SmsMapper smsMapper;

    @Override
    public int addUser(User user){
        Integer userId = userMapper.getUserId(user.getPhone());
        int i = 0;
        if(userId!=null){
            return 0;
        }else{
            smsMapper.addsmsVo(String.valueOf(user.getPhone()),user.getPassword());
            i = userMapper.addUser(user);
        }
        return i;
    }

   @Override
    public User getUser(Long phone){
        return userMapper.getUser(phone);
    }

  /*   @Override
    public int addUser(User user){
        int u = userMapper.addUser(user);
        smsMapper.addsmsVo(String.valueOf(user.getPhone()),user.getPassword());
        return u;
    }*/

   @Override
   public int stopTeam(Integer userSerial){
       return userMapper.stopTeam(userSerial);
   }

    @Override
    public List orgList(int page, int limit, int startItem){
        return userMapper.orgList(page,limit,startItem);
    }

    @Override
    public int addOrg(User user){
        Integer userId = userMapper.getUserId(user.getPhone());
        int i = 0;
        if(userId!=null){
           return 0;
        }else{
            smsMapper.addsmsVo(String.valueOf(user.getPhone()),user.getPassword());
            i = userMapper.addOrg(user);
        }
        return i;
    }


    @Override
    public List teacherListByOid(String parentId, int page, int limit, int startItem){
        return userMapper.teacherListByOid(parentId,page,limit,startItem);
    }

    @Override
    public int addTeacher(User user){
        Integer userId = userMapper.getUserId(user.getPhone());
        int i = 0;
        if(userId!=null){
            return 0;
        }else{
            smsMapper.addsmsVo(String.valueOf(user.getPhone()),user.getPassword());
            i = userMapper.addTeacher(user);
        }
        return i;
    }

    @Override
    public List<StudentVo> studentListByT(String userId, int page, int limit, int startItem){
        return userMapper.studentListByT(userId,page,limit,startItem);
    }

    @Override
    public int addStudent(User user){
        Integer userId = userMapper.getUserId(user.getPhone());
        int i =0;
        if(userId!=null){
            return 0;
        }else{
            smsMapper.addsmsVo(String.valueOf(user.getPhone()),user.getPassword());
            i = userMapper.addStudent(user);
        }
        return i;
    }

    @Override
    public int changeImg(String userId,String img){
        System.out.println("实现层对象的userId是："+userId+"=====img是："+img);
       return userMapper.changeImg(userId,img);
    }

    @Override
    public int changePassword(UserInfoDto userInfoDto){
       return userMapper.changePassword(userInfoDto);
    }


}
