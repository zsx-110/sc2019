package com.xzsd.pc.user.controller;


import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.service.UserService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Description增删改查DEMO
 * @Author zsx
 * @Date 2020-04-10
 */
@RestController
@RequestMapping("/demo")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    /**
     * demo 新增用户
     *
     * @param userInfo
     * @return AppResponse
     * @Author zsx
     * @Date 2020-04-10
     */
    @PostMapping("/saveUser")
    public AppResponse saveUser(UserInfo userInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            userInfo.setCreateBy(userId);
            AppResponse appResponse = userService.saveUser(userInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 用户列表(分页)
     *
     * @param userInfo
     * @return AppResponse
     * @Author zsx
     * @Date 2020-04-10
     */
    @RequestMapping(value = "listUsers")
    public AppResponse listUsers(UserInfo userInfo) {
        try {
            return userService.listUsers(userInfo);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除用户
     *
     * @param userCode
     * @return AppResponse
     * @Author zsx
     * @Date 2020-04-10
     */
    @PostMapping("deleteUser")
    public AppResponse deleteUser(String userCode) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return userService.deleteUser(userCode, userId);
        } catch (Exception e) {
            logger.error("用户删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改用户
     *
     * @param userInfo
     * @return AppResponse
     * @Author zsx
     * @Date 2020-04-10
     */
    @PostMapping("updateUser")
    public AppResponse updateUser(UserInfo userInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            userInfo.setCreateBy(userId);
            userInfo.setLastModifiedBy(userId);
            return userService.updateUser(userInfo);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 查询用户详情
     *
     * @param userCode
     * @return AppResponse
     * @Author zsx
     * @Date 2020-04-10
     */
    @RequestMapping(value = "getUserByUserCode")
    public AppResponse getUserByUserCode(String userCode) {
        try {
            return userService.getUserByUserCode(userCode);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
