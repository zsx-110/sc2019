package com.xzsd.pc.menu.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.menu.service.MenuService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Description menu增删改查
 * @Author zsx
 * @Date 2020-04-09
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Resource
    private MenuService menuService;


    /**
     * 新增菜单
     * @param menuInfo
     * @return AppResponse
     * @author zsx
     * @Date 2020-04-09
     */
    @PostMapping("addMenu")
    public AppResponse addMenu(MenuInfo menuInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            menuInfo.setCreateUser(userId);
            AppResponse appResponse = menuService.addMenu(menuInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("菜单新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 删除菜单
     * @param menuCode
     * @return AppResponse
     * @author zsx
     * @Date 2020-04-09
     */
    @PostMapping("deleteMenu")
    public AppResponse deleteMenu(String menuCode) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return menuService.deleteMenu(menuCode,userId);
        } catch (Exception e) {
            logger.error("菜单删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改菜单
     * @param menuInfo
     * @return AppResponse
     * @author zsx
     * @Date 2020-04-09
     */
    @PostMapping("updateMenu")
    public AppResponse updateMenu(MenuInfo menuInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            menuInfo.setCreateUser(userId);
            menuInfo.setLastModifiedBy(userId);
            return menuService.updateMenu(menuInfo);
        } catch (Exception e) {
            logger.error("修改菜单信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 查询菜单详情
     * @param menuCode
     * @return AppResponse
     * @author zsx
     * @Date 2020-04-09
     */
    @RequestMapping(value = "getMenuByMenuCode")
    public AppResponse getMenuByMenuCode(String menuCode) {
        try {
            return menuService.getMenuByMenuCode(menuCode);
        } catch (Exception e) {
            logger.error("菜单查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
