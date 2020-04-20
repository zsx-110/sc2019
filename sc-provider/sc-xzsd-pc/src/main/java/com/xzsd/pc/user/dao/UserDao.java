package com.xzsd.pc.user.dao;

import com.xzsd.pc.user.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName UserDao
 * @Description User
 * @Author zsx
 * @Date 2020-04-10
 */
public interface UserDao {
    /**
     * 统计用户账号数量
     * @param userInfo 用户信息
     * @return
     */
    int countUserAcct(UserInfo userInfo);

    /**
     * 获取登录者角色
     * @param loginUserId
     * @return
     */
    String getUserRole(@Param("loginUserId") String loginUserId);

    /**
     * 新增用户
     * @param userInfo 用户信息
     * @return
     */
    int saveUser(UserInfo userInfo);

    /**
     * 获取所有用户信息
     * @param userInfo 用户信息
     * @return 所有用户信息
     */
    List<UserInfo> listUsersByPage(UserInfo userInfo);

    /**
     * 删除用户信息
     * @param listCode 选中的用户编号集合
     * @param userId 更新人
     * @return
     */
    int deleteUser(List<String> listCode, @Param("userId") String userId);

    /**
     * 修改用户信息
     * @param userInfo 用户信息
     * @return 修改结果
     */
    int updateUser(UserInfo userInfo);

    /**
     * 查询用户信息
     * @param userCode 用户编号
     * @return 修改结果
     */
    UserInfo getUserByUserCode(@Param("userCode") String userCode);
}
