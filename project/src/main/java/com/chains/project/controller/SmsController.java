package com.chains.project.controller;

import com.chains.project.mapper.SmsMapper;
import com.chains.project.mapper.UserMapper;
import com.chains.project.model.dto.ConfirmPassword;
import com.chains.project.model.pojo.User;
import com.chains.project.model.vo.SmsVo;
import com.chains.project.service.SmsService;
import com.chains.project.service.UserService;
import com.chains.project.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author xdx
 * @date 2020/8/26
 * @version 1.0
 */

@RestController
@RequestMapping("/login")
public class SmsController {
    @Resource
    private SmsService smsService;
    @Resource
    private SmsMapper smsMapper;
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;


    @RequestMapping("/registerVerify")
    public Result  getUser(Long phone){
        User user = userService.getUser(phone);
        System.out.println(user);
        if(user!=null){
            return Result.success(null,user);
        }
        return Result.success("用户不存在");
    }

    @RequestMapping("/getLogin")
    public Result getLogin(String phone, String password){
        Integer i = smsService.getLogin(phone,password);
        return Result.success(null,i);
    }

    @RequestMapping("/getSmsvo")
    public Result getSmsvo(Long phone){
        return Result.success(null,smsService.getSmsvo(phone));
    }

    @RequestMapping("/back_login")/*@RequestBody */
    public Result backLoginIn(SmsVo smsVo, HttpSession session, HttpServletRequest request ) {
        /*phone1 from web，phone2 from DB*/
        Long phone1 = Long.parseLong(smsVo.getPhone());
        Long password1 = Long.parseLong(smsVo.getPassword());
        String phone2 = smsService.getSmsvo(phone1).getPhone();
        String password2 = smsService.getSmsvo(phone1).getPassword();
        System.out.println(phone2 +"====="+ password2);
        User user = userService.getUser(phone1);
        System.out.println(user);
        if (Long.parseLong(phone2) == phone1 && Long.parseLong(password2) == password1) {
            session.setAttribute("loginUser", user);   //存入session
            if(user.getIsDelete()==0){
                return Result.success("登录成功", null, user);
            }
        } else {
            return Result.error("验证码错误");
        }
        return Result.error("登录失败");
    }

    @RequestMapping("/addsmsVo")
    public Result addsmsVo(Long phone,String password){
        return Result.success(null,smsService.addsmsVo(String.valueOf(phone),password));
    }

    @RequestMapping("/login")/*@RequestBody */
    public Result login(SmsVo smsVo, HttpSession session) {
        /*phone1 from web，phone2 from DB*/
        Long phone1 = Long.parseLong(smsVo.getPhone());
        Long password1 = Long.parseLong(smsVo.getPassword());
        System.out.println("登录手机是："+phone1+"登录密码是："+password1);
        String phone2 = smsService.getSmsvo(phone1).getPhone();
        String password2 = smsService.getSmsvo(phone1).getPassword();
        User user = userService.getUser(phone1);
        if (Long.parseLong(phone2) == phone1 && Long.parseLong(password2) == password1) {
            session.setAttribute("loginUser", user);   //存入session
            if(user.getIsDelete()==0){
                return Result.success("登录成功", null, user);
            }
        } else {
            return Result.error("密码错误");
        }
        return Result.error("登录失败");
    }

        /*修改密码*/
    @RequestMapping("/changePassword")
    public Result changePassword(ConfirmPassword confirmPassword){
        System.out.println("前端数据为："+confirmPassword);
        Long phoneweb = Long.valueOf(confirmPassword.getPhone());
        String passwordweb =  confirmPassword.getPassword(); /*页面原密码*/
        String passwordnewweb =  confirmPassword.getPasswordnew();  /*页面新密码*/
        Long phoneDb = Long.valueOf(smsMapper.getSmsvo(phoneweb).getPhone());
        String passwordDb =  smsMapper.getSmsvo(phoneweb).getPassword();  /*数据库密码*/
        System.out.println("phoneweb:"+phoneweb+"======passwordweb:"+passwordweb+"===========phoneDb:"+phoneDb+"======passwordDb："+passwordDb);
        if(passwordweb.equals(passwordDb)){
            int i = smsService.changePassword(confirmPassword);
            if(i>0){
                return Result.success("操作成功");
            }
            return Result.error("修改密码失败");
        }
        return Result.error("密码错误");
    }




}
