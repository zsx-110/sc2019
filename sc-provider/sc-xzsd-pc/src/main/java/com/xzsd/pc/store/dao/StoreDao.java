package com.xzsd.pc.store.dao;

import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.entity.StoreVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName StoreDao
 * @Description Store
 * @author zsx
 * @date 2020-04-17
 */
@Mapper
public interface StoreDao {
    /**
     * 统计营业执照编码数量
     * @param storeInfo 门店信息
     * @return
     */
    int countBusinessCode(StoreInfo storeInfo);

    /**
     * 校验是否出现重复的邀请码
     * @param storeInfo
     * @return
     */
    int countInviteCode(StoreInfo storeInfo);
    /**
     * 新增门店
     * @param storeInfo
     * @return
     */
    int addStore(StoreInfo storeInfo);

    /**
     * 查询店长编号
     * @param storeInfo
     * @return
     */
    StoreInfo getManagerId(StoreInfo storeInfo);

    /**
     * 查询门店详情信息
     * @param storeId
     * @return
     */
    StoreVO getStoreInfoById(@Param("storeId") String storeId);

    /**
     * 修改店详情信息
     * @param storeInfo
     * @return
     */
    int updateStore(StoreInfo storeInfo);

    /**
     * 店长查询自己门店信息
     * @param storeInfo
     * @return
     */
    List<StoreVO> getListStore(StoreInfo storeInfo);

    /**
     * 管理员查询所有门店信息
     * @param storeInfo
     * @return
     */
    List<StoreVO> getListStoreByAdmin(StoreInfo storeInfo);

    /**
     * 删除门店信息
     * @param listStoreId
     * @param loginUserId
     * @return
     */
    int deleteStoreById(@Param("listStoreId") List<String> listStoreId, @Param("loginUserId") String loginUserId);
}
