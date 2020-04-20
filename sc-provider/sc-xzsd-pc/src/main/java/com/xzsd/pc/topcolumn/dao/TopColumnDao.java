package com.xzsd.pc.topcolumn.dao;

import com.xzsd.pc.topcolumn.entity.TopColumn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description 顶部栏查询
 * @author zsx
 * @date 2020-04-16
 */
@Mapper
public interface TopColumnDao {
    /**
     * 查询顶部栏
     * @param loginUserId
     * @return
     */
    TopColumn getTopColumn(@Param("loginUserId") String loginUserId);
}
