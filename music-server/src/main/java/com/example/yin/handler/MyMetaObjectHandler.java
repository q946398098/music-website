package com.example.yin.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * MetaObjectHandler 是 MyBatis-Plus 提供的一个接口，用来在插入或更新数据时，自动填充一些字段。
 * 简单来说，它就像一个“自动填表员”，帮你把一些常见的字段（比如创建时间、更新时间、操作人等）自动填好，省得你每次都手动写这些代码。
 * 在开发中，很多表都有类似的字段，比如：
 * 创建时间（create_time）：记录数据是啥时候创建的。
 * 更新时间（update_time）：记录数据是啥时候最后更新的。
 * 创建人（creator）：记录是谁创建了这条数据。
 * 更新人（modifier）：记录是谁最后更新了这条数据。
 * 如果每次插入或更新数据时，都要手动设置这些字段，不仅麻烦，还容易忘。MetaObjectHandler 就是为了解决这个问题，让这些字段的填充变得自动化。
 *
 *
 * 你需要在实体类的字段上，用 @TableField 注解标注哪些字段需要自动填充，以及在什么情况下填充。比如：
 *
 *@TableField(fill = FieldFill.INSERT) // 插入时自动填充
 *@TableField(fill = FieldFill.INSERT_UPDATE)
 *
 * Demo 可以觀察 Collect.java
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
