package com.example.yin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.yin.common.R;
import com.example.yin.model.domain.Consumer;
import com.example.yin.model.request.ConsumerRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

//定义接口---
//IService 是一个泛型接口，定义了一组通用的基础方法，包括常见的增删改查操作。用户可以根据自己的需求和业务逻辑在自定义的服务接口中继承IService接口
public interface ConsumerService extends IService<Consumer> {

    R addUser(ConsumerRequest registryRequest);

    R updateUserMsg(ConsumerRequest updateRequest);

    R updateUserAvator(MultipartFile avatorFile, int id);

    R updatePassword(ConsumerRequest updatePasswordRequest);

    boolean existUser(String username);

    boolean verityPasswd(String username, String password);

    R deleteUser(Integer id);

    R allUser();

    R userOfId(Integer id);

    R loginStatus(ConsumerRequest loginRequest, HttpSession session);
    R loginEmailStatus(ConsumerRequest loginRequest, HttpSession session);
    Consumer findByEmail (String email);
    R updatePassword01(ConsumerRequest updatePasswordRequest);
}
