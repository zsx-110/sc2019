package com.xzsd.app.driverinfo.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.driverinfo.dao.DriverInfoDao;
import com.xzsd.app.driverinfo.entity.DriverInfo;
import com.xzsd.app.driverinfo.entity.DriverInfoList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @author zsx
 * @date 2020/04/26
 */
@Service
public class DriverInfoService {
    @Resource
    private DriverInfoDao driverInfoDao;

    /**
     * 查询当前司机负责送货的门店信息
     * @param driverInfo
     * @return
     * @author zsx
     * @date 2020/04/26
     */
    public AppResponse getListStoreInfo(DriverInfo driverInfo){
        List<DriverInfo> listStoreInfo = driverInfoDao.getListStoreInfo(driverInfo);
        if(listStoreInfo.size() == 0){
            return AppResponse.versionError("当前司机账号没有绑定门店");
        }
        for (int i = 0; i < listStoreInfo.size(); i++) {
            listStoreInfo.get(i).setAddress(listStoreInfo.get(i).getProvinceName()
                    + listStoreInfo.get(i).getCityName() + listStoreInfo.get(i).getAreaName()
                    + listStoreInfo.get(i).getAddress());
        }
        DriverInfoList driverInfoList = new DriverInfoList();
        driverInfoList.setList(listStoreInfo);
        return AppResponse.success("查询门店信息成功", driverInfoList);
    }
}
