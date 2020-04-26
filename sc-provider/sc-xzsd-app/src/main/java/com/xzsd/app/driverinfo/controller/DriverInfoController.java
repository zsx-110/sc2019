package com.xzsd.app.driverinfo.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.driverinfo.entity.DriverInfo;
import com.xzsd.app.driverinfo.service.DriverInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 查询负责送货的所有门店
 * @author zsx
 * @date 2020/04/26
 */
@RestController
@RequestMapping("driverHome")
public class DriverInfoController {
    private static final Logger logger = LoggerFactory.getLogger(DriverInfoController.class);

    @Resource
    private DriverInfoService driverInfoService;

    /**
     * 查询负责送货的所有门店
     * @param driverInfo
     * @return
     * @author zsx
     * @date 2020/04/26
     */
    @PostMapping("listDriverStores")
    public AppResponse getListStoreInfo(DriverInfo driverInfo){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            driverInfo.setUserId(userId);
            return driverInfoService.getListStoreInfo(driverInfo);
        }catch (Exception e){
            logger.error("查询负责送货的所有门店失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
