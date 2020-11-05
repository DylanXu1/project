package com.chains.project.model.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class TeachingVo {
    private int teachId;
    private int groupId;
    private String categoryId;
    private String categoryName;
    private String clauseTitle;
    private String clauseContent;
    private int viewCount;
   /* @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")*/
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;
    private int isDelete;


}
