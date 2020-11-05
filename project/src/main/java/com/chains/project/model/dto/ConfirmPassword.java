package com.chains.project.model.dto;

import lombok.Data;

/**
 * @author xdx
 * @date 2020/10/27
 * @version 1.0
 */

@Data
public class ConfirmPassword {
    private String phone;
    private String password;
    private String passwordnew;
}
