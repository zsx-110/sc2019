package com.xzsd.app.driverinfo.dao;

import com.xzsd.app.driverinfo.entity.DriverInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description 查店长信息列表
 * @author zsx
 * @date 2020/04/26
 */
@Mapper
public interface DriverInfoDao {
    /**
     * 查店长信息列表
     * @param driverInfo
     * @return
     */
    List<DriverInfo> getListStoreInfo(DriverInfo driverInfo);
}
