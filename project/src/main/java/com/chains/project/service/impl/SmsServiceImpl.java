package com.chains.project.service.impl;

import com.chains.project.mapper.SmsMapper;
import com.chains.project.model.dto.ConfirmPassword;
import com.chains.project.model.vo.SmsVo;
import com.chains.project.service.SmsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xdx
 * @date 2020/8/26
 * @version 1.0
 */

@Service
public class SmsServiceImpl implements SmsService {
    @Resource
    private SmsMapper smsMapper;

    @Override
    public SmsVo getSmsvo(Long phone){
        return smsMapper.getSmsvo(phone);
    }

    @Override
    public Integer getLogin(String phone, String password){
        Integer i = smsMapper.getLogin(phone,password);
        if(i==null){
            return null;
        }
        return smsMapper.getLogin(phone,password);
    }

    @Override
    public int addsmsVo(String phone, String password){
        return smsMapper.addsmsVo(phone,password);
    }

    @Override
    public int changePassword(ConfirmPassword confirmPassword){
      return smsMapper.changePassword(confirmPassword);
    }

}
