package com.example.yin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.yin.common.R;
import com.example.yin.mapper.AdminMapper;
import com.example.yin.model.domain.Admin;
import com.example.yin.model.request.AdminRequest;
import com.example.yin.service.AdminService;
import com.example.yin.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public R verityPasswd(AdminRequest adminRequest, HttpSession session)  {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",adminRequest.getUsername());
        try{
            queryWrapper.eq("ds_password_hash", Md5Util.md5(adminRequest.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        if (ifDeactivated(adminRequest)){
            return R.error("用户已被禁用");
        }
        if (adminMapper.selectCount(queryWrapper) > 0) {
            session.setAttribute("name", adminRequest.getUsername());
            return R.success("登录成功");
        } else {
            return R.error("用户名或密码错误");
        }
    }

    /**
     * @desc 检查是否禁用的用户
     * @param adminRequest
     */
    public Boolean ifDeactivated(AdminRequest adminRequest){
        QueryWrapper<Admin> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("name",adminRequest.getUsername());
        objectQueryWrapper.eq("password",adminRequest.getPassword());
        Admin admin = adminMapper.selectOne(objectQueryWrapper);
        if(admin.getDtDeactivated() != null){
            return true;
        }else{
            return false;
        }
    }
}
