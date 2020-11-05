package com.chains.project.service;

import com.chains.project.model.dto.ConfirmPassword;
import com.chains.project.model.vo.SmsVo;
import org.apache.ibatis.annotations.Param;

/**
 * @author xdx
 * @date 2020/8/26
 * @version 1.0
 */


public interface SmsService {
    SmsVo getSmsvo(Long phone);
    Integer getLogin(String phone, String password);
    int addsmsVo(String phone, String password);
    /*修改密码*/
    int changePassword(ConfirmPassword confirmPassword);
}
