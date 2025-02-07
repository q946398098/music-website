package com.example.yin.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

@TableName(value = "admin")
@Data
public class Admin {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String password;

//    @TableField("dt_deactivated") 一般是自动开启的，不需要自己加
    private Date dtDeactivated;

    private String dsPasswordHash;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
