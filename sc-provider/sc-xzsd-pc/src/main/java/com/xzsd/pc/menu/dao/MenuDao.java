package com.xzsd.pc.menu.dao;

import com.xzsd.pc.menu.entity.MenuInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName MenuDao
 * @Description 菜单管理
 * @Author zsx
 * @Date 2020-04-09
 */
public interface MenuDao {
    /**
     * 新增菜单
     * @param menuInfo 菜单信息
     * @return
     */
    int addMenu(MenuInfo menuInfo);

    /**
     * 删除菜单信息
     * @param listCode 选中的菜单编号集合
     * @param menuId 更新菜单
     * @return
     */
    int deleteMenu(List<String> listCode, @Param("menuId") String menuId);

    /**
     * 修改菜单信息
     * @param menuInfo 菜单信息
     * @return 修改结果
     */
    int updateMenu(MenuInfo menuInfo);

    /**
     * 查询菜单信息
     * @param menuCode 菜单编号
     * @return 修改结果
     */
    MenuInfo getMenuByMenuCode(@Param("menuCode") String menuCode);
}
