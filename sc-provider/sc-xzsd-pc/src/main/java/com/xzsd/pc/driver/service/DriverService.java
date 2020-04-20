package com.xzsd.pc.driver.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.driver.dao.DriverDao;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.entity.DriverVO;
import com.xzsd.pc.util.PasswordUtils;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 司机的实现类
 * @author zsx
 * @date 2020-04-18
 */
@Service
public class DriverService {

    @Resource
    private DriverDao driverDao;

    /**
     * demo 新增用户
     * @param driverInfo
     * @return
     * @author zsx
     * @date 2020-04-18
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addDriver(DriverInfo driverInfo){
        // 校验司机账号和手机号是否存在
        int countDriverAccount = driverDao.countDriverAccount(driverInfo);
        if(countDriverAccount != 0){
            return AppResponse.versionError("账号已存在，请重新输入");
        }
        // 校验手机号是否存在
        int countPhone = driverDao.countPhone(driverInfo);
        if(0 != countPhone){
            return AppResponse.versionError("手机号已存在，请重新输入");
        }
        driverInfo.setDriverId(StringUtil.getCommonCode(2));
        driverInfo.setIsDelete(0);
        driverInfo.setDriverInfoId(StringUtil.getCommonCode(2));
        //密码加密
        String password = driverInfo.getUserPassword();
        String pwd = PasswordUtils.generatePassword(password);
        driverInfo.setUserPassword(pwd);
        //新增司机
        int count = driverDao.addDriver(driverInfo);
        int num = driverDao.addDriverArea(driverInfo);
        if(count == 0 && num == 0){
            return AppResponse.versionError("新增失败！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * demo 查询司机详情
     * @param driverId
     * @return
     * @author zsx
     * @date 2020-04-18
     */
    public AppResponse getDriverById(String driverId){
        DriverVO driverInfo = driverDao.getDriverById(driverId);
        if(driverInfo == null){
            return AppResponse.versionError("查询失败");
        }
        return AppResponse.success("查询成功", driverInfo);
    }

    /**
     * 修改司机信息
     * @param driverInfo
     * @return
     * @author zsx
     * @date 2020-04-18
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateDriver(DriverInfo driverInfo){
        DriverVO driver = driverDao.getDriverById(driverInfo.getDriverId());
        //判断当前账号是否是当前要修改的账号
        if(driver.getUserAcct().equals(driverInfo.getUserAcct()) == false){
            //校验账号是否存在
            int count = driverDao.countDriverAccount(driverInfo);
            if(count != 0){
                return AppResponse.versionError("该司机账号已存在，请重新输入！");
            }
        }
        //判断当前手机号是否是修改
        if(driver.getPhone().equals(driverInfo.getPhone()) == false){
            // 校验手机号是否存在
            int countPhone = driverDao.countPhone(driverInfo);
            if(0 != countPhone){
                return AppResponse.versionError("手机号已存在，请重新输入");
            }
        }
        //判断密码有没有修改
        if(driver.getUserPassword().equals(driverInfo.getUserPassword()) == false){
            //密码加密
            String password = driverInfo.getUserPassword();
            String pwd = PasswordUtils.generatePassword(password);
            driverInfo.setUserPassword(pwd);
        }
        //修改司机信息
        int count= driverDao.updateDriver(driverInfo);
        int driverArea = driverDao.updateDriverArea(driverInfo);
        if(count == 0 || driverArea == 0) {
            return AppResponse.versionError("修改失败");
        }
        return AppResponse.success("修改成功");
    }

    /**
     * 查询司机列表（分页）
     * @param driverInfo
     * @return
     * @author zsx
     * @date 2020-04-18
     */
    public AppResponse getListDriver(DriverInfo driverInfo){
        PageHelper.startPage(driverInfo.getPageNum(), driverInfo.getPageSize());
        List<DriverVO> listDriver = null;
        if("2".equals(driverInfo.getRole())){
            listDriver = driverDao.getListDriverByStore(driverInfo);
        }else if("0".equals(driverInfo.getRole()) || "1".equals(driverInfo.getRole())){
            listDriver = driverDao.getListDriverByAdmin(driverInfo);
        }
        PageInfo<DriverVO> pageData = new PageInfo<DriverVO>(listDriver);
        return AppResponse.success("查询成功！", pageData);
    }

    /**
     * 删除司机信息
     * @param driverId
     * @return
     * @author zsx
     * @date 2020-04-18
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteDriverById(String driverId, String loginId){
        List<String> listDriverId = Arrays.asList(driverId.split(","));
        int count = driverDao.deleteDriverById(listDriverId, loginId);
        int num = driverDao.deleteDriverAreaById(listDriverId, loginId);
        if(count == 0 && num == 0){
            return AppResponse.versionError("删除失败！");
        }
        return AppResponse.success("删除成功！");
    }
}
