package com.xzsd.app.register.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.register.entity.Register;
import com.xzsd.app.register.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 用户新增
 * @author zsx
 * @date 2020-04-20
 */
@RestController
@RequestMapping("register")
public class RegisterController {
    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Resource
    private RegisterService registerService;

    /**
     * 注册用户
     * @param register
     * @return
     * @author zsx
     * @date 2020-04-20
     */
    @PostMapping("clientRegister")
    public AppResponse registerUser(Register register){
        try {
            return registerService.registerUser(register);
        }catch (Exception e){
            logger.error("注册用户失败！");
            System.out.println(e.toString());
            throw e;
        }
    }
}
