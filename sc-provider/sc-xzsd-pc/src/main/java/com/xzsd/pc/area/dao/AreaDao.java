package com.xzsd.pc.area.dao;


import com.xzsd.pc.area.entity.AreaInfo;
import com.xzsd.pc.area.entity.AreaVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @ClassName AreaDao
 * @Description Area
 * @author zsx
 * @date 2020-04-18
 */
@Mapper
public interface AreaDao {

    /**
     * 查询省市区
     * @param areaInfo
     * @return
     */
    List<AreaVO> getListArea(AreaInfo areaInfo);
}
