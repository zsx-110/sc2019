package com.xzsd.app.customerme.dao;

import com.xzsd.app.customerme.entity.CustomerMe;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description 邀请码修改
 * @author zsx
 * @date 2020/04/24
 */
@Mapper
public interface CustomerMeDao {
    /**
     * 修改邀请码
     * @param customerInfo
     * @return
     */
    int updateInviteCode(CustomerMe customerInfo);
}
