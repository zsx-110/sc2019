package com.xzsd.pc.menu.service;

import com.xzsd.pc.menu.dao.MenuDao;
import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 实现类
 * @Author zsx
 * @Date 2020-04-09
 */
@Service
public class MenuService {

    @Resource
    private MenuDao menuDao;

    /**
     * 新增菜单
     *
     * @param menuInfo
     * @return
     * @Author zsx
     * @Date 2020-04-09
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addMenu(MenuInfo menuInfo) {

        // 新增菜单
        int count = menuDao.addMenu(menuInfo);
        if (0 == count) {
            return AppResponse.success("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }


    /**
     * 删除菜单
     *
     * @param menuCode
     * @param menuId
     * @return
     * @Author zsx
     * @Date 2020-04-09
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteMenu(String menuCode, String menuId) {
        List<String> listCode = Arrays.asList(menuCode.split(","));
        // 删除用户
        int count = menuDao.deleteMenu(listCode, menuId);
        if (0 == count) {
            return AppResponse.bizError("删除失败，请重试！");
        }
        return AppResponse.success("删除成功！");
    }

    /**
     * 修改菜单
     *
     * @param menuInfo
     * @return
     * @Author zsx
     * @Date 2020-04-09
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateMenu(MenuInfo menuInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 修改菜单信息
        int count = menuDao.updateMenu(menuInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }


    /**
     * 查询菜单详情
     *
     * @param menuCode
     * @return
     * @Author zsx
     * @Date 2020-04-09
     */
    public AppResponse getMenuByMenuCode(String menuCode) {
        MenuInfo userInfo = menuDao.getMenuByMenuCode(menuCode);
        return AppResponse.success("查询成功！", userInfo);
    }

}