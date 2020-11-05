package com.chains.project.controller;

import com.chains.project.mapper.UserMapper;
import com.chains.project.model.dto.OrgDto;
import com.chains.project.model.dto.UserInfoDto;
import com.chains.project.model.pojo.Org;
import com.chains.project.model.pojo.Student;
import com.chains.project.model.pojo.Teacher;
import com.chains.project.model.pojo.User;
import com.chains.project.service.UserService;
import com.chains.project.util.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xdx
 * @date 2020/8/26
 * @version 1.0
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;

   /* @RequestMapping("/getUser")
    public Result getUser(Long phone){
        return Result.success(null,userService.getUser(phone));
    }*/

    @RequestMapping("/addUser")
    public Result addUser(User user){
        System.out.println("创建用户收到的user是："+user);
        int i = userService.addUser(user);
        if(user==null){
            return Result.error("参数错误");
        }if(i==1){
            return Result.success("添加成功");
        }
        return Result.error("用户已存在");
    }

    @PostMapping("/stopTeam")
    public Result stopTeam(Integer userSerial){
        System.out.println("删除对象的id是："+userSerial);
        return Result.success(null,userService.stopTeam(userSerial));
    }

    @RequestMapping("/orgList")
    public Result orgList(String parentId ,Integer page,Integer limit){
        System.out.println(parentId);
        if(parentId.equals("1000")){
            long count =userMapper.orgListCount();
            int startItem = (page-1)*limit;
            return Result.success(count,userService.orgList(page,limit,startItem));
        }
        return Result.error("请重新登录");
    }

    @PostMapping("/addOrg")
    public Result addOrg(User user){
        System.out.println("收到企业对象为："+user);
        int i = userService.addOrg(user);
        if(user==null){
            return Result.error("参数错误");
        }if(i==1){
            return Result.success("添加成功");
        }
        return Result.error("用户已存在");
    }




    @RequestMapping("/teacherListByOid")
    public Result teacherListByOid(String parentId ,Integer page, Integer limit){
        if(page==null||limit==null){
            page=1;limit=1000;
            int startItem = (page-1)*limit;
            List li = userService.teacherListByOid(parentId,page,limit,startItem);
            long count =userMapper.teacherListCount(parentId);
            return Result.success(count,li);
        }if(page!=null&&limit!=null){
            int startItem = (page-1)*limit;
            long count =userMapper.teacherListCount(parentId);
            List li = userService.teacherListByOid(parentId,page,limit,startItem);
            return Result.success(count,li);
        }
        return Result.error("连接异常，请刷新页面");
    }

    //添加教师
    @PostMapping("/addTeacher")
    public Result addTeacher(User user){
        int i = userService.addTeacher(user);
        if(user==null){
            return Result.error("参数错误");
        }if(i==1){
            return Result.success("添加成功");
        }
        return Result.error("用户已存在");
    }

    //根据企业teacherId查询学生列表（教师端）
    @RequestMapping("/studentListByT")
    public Result studentListByT(String userId,Integer page, Integer limit){
        if(userId!=null){
            long count = userMapper.studentListByTCount(userId);
            //long count = (long)co;
            int startItem = (page-1)*limit;
            List li = userService.studentListByT(userId,page,limit,startItem);
            return Result.success(count,li);
        }
        return Result.error("连接异常，请刷新页面");
    }

    //添加学生（需要添加企业orgId）
    @PostMapping("/addStudent")
    public Result addStudent(User user){
        System.out.println("收到的user是："+user);
        int i = userService.addStudent(user);
        if(user==null){
            return Result.error("参数错误");
        }if(i==1){
            return Result.success("添加成功");
        }
        return Result.error("用户已存在");
    }

    @RequestMapping("/changeImg")
    public Result changeImg(String userId,String img){
        System.out.println("对象的userId是："+userId+"=====img是："+img);
        int i = userService.changeImg(userId,img);
        System.out.println(i);
        if(i>0){
            return Result.success(null,i);
        }
        return Result.error("修改失败");
    }

    /*@RequestMapping("/changeImgCo")
    public Result changeImgCo(Integer userSerial,String img){
        System.out.println("对象的userId是："+userSerial+"=====img是："+img);
        int i = userMapper.changeImgCo(userSerial,img);
        System.out.println(i);
        if(i>0){
            return Result.success(null,i);
        }
        return Result.error("修改失败");
    }*/


    @RequestMapping("/changepassword")
    public Result changepassword(UserInfoDto userInfoDto){
        System.out.println("userInfoDto是："+userInfoDto);
        return Result.success(null,userService.changePassword(userInfoDto));
    }
}
