package com.xzsd.pc.hotgoods.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.hotgoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotgoods.entity.HotGoodsShowNumber;
import com.xzsd.pc.hotgoods.service.HotGoodsService;
import com.xzsd.pc.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 增删改查
 * @author zsx
 * @date 2020-04-15
 */
@RestController
@RequestMapping("/hotGoods")
public class HotGoodsController {

    private static final Logger logger = LoggerFactory.getLogger(HotGoodsController.class);

    @Resource
    private HotGoodsService hotGoodsService;

    /**
     * 新增热门商品
     * @param hotGoodsInfo
     * @return
     * @author zsx
     * @date 2020-04-15
     */
    @PostMapping("addHotGoods")
    public AppResponse addHotGoods(HotGoodsInfo hotGoodsInfo){
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            hotGoodsInfo.setCreateUser(userId);
            return hotGoodsService.addHotGoods(hotGoodsInfo);
        }catch (Exception e){
            logger.error("新增热门商品失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询热门商品详情
     * @param hotGoodsId
     * @return
     * @author zsx
     * @date 2020-04-15
     */
    @PostMapping("getHotGoods")
    public AppResponse getHotGoodsById(String hotGoodsId){
        try {
            return hotGoodsService.getHotGoodsById(hotGoodsId);
        }catch (Exception e){
            logger.error("查询热门商品详情失败");
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 修改热门商品信息
     * @param hotGoodsInfo
     * @return
     * @author zsx
     * @date 2020-04-15
     */
    @PostMapping("updateHotGoods")
    public AppResponse updateHotGoods(HotGoodsInfo hotGoodsInfo){
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            hotGoodsInfo.setCreateUser(userId);
            return hotGoodsService.updateHotGoods(hotGoodsInfo);
        }catch (Exception e){
            logger.error("修改热门商品信息失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询热门商品列表（分页）
     * @param hotGoodsInfo
     * @return
     * @author zsx
     * @date 2020-04-15
     */
    @PostMapping("listHotGoods")
    public AppResponse getListHotGoods(HotGoodsInfo hotGoodsInfo){
        try {
            return hotGoodsService.getListHotGoods(hotGoodsInfo);
        }catch (Exception e){
            logger.error("查询热门商品列表失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询热门商品展示数量
     * @return
     */
    @PostMapping("getHotGoodsShowNum")
    public AppResponse getHotGoodsShowNumber(){
        try {
            return hotGoodsService.getHotGoodsShowNumber();
        }catch (Exception e){
            logger.error("查询热门商品展示数量成功");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改热门位商品展示数量
     * @param hotGoodsShowNumber
     * @return
     * @author zsx
     * @date 2020-04-15
     */
    @PostMapping("updateHotGoodsShowNum")
    public AppResponse modifyShowNumber(HotGoodsShowNumber hotGoodsShowNumber){
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            hotGoodsShowNumber.setUpdateUser(userId);
            return hotGoodsService.modifyShowNumber(hotGoodsShowNumber);
        }catch (Exception e){
            logger.error("修改热门位商品展示数量失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除热门位商品
     * @param hotGoodsId
     * @return
     * @author zsx
     * @date 2020-04-15
     */
    @PostMapping("deleteHotGoods")
    public AppResponse deleteHotGoods(String hotGoodsId){
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return hotGoodsService.deleteHotGoods(hotGoodsId, userId);
        }catch (Exception e){
            logger.error("删除热门位商品失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
