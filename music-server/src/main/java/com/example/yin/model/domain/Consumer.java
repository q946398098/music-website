package com.example.yin.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

@TableName(value = "consumer")
@Data
public class Consumer {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private Byte sex;

    private String phoneNum;

    @TableField(value = "email")
    private String email;
    // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // Date date = new Date();
    // String formattedDate = dateFormat.format(date);
    // String dateString = "2019-04-25 18:58:39";
    // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Date birth;

    private String introduction;

    private String location;

    private String avator;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
