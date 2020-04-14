package com.xzsd.pc.goods.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.util.AuthUtils;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Description增删改查GoodsInfo
 * @Author zsx
 * @Date 2020-04-13
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Resource
    private GoodsService goodsService;

    /**
     * 新增商品
     * @param goodsInfo
     * @return
     * @author zsx
     * @Date 2020-04-13
     */
    @PostMapping("addGoods")
    public com.neusoft.core.restful.AppResponse addGoods(GoodsInfo goodsInfo){
        try {
            //获取商品id
            String goodsId = AuthUtils.getCurrentGoodsId();
            goodsInfo.setCreateBy(goodsId);
            return goodsService.addGoods(goodsInfo);
        }catch (Exception e){
            logger.error("新增商品失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品详情
     * @param goodsId
     * @return
     * @author zsx
     * @Date 2020-04-13
     */
    @PostMapping("getGoods")
    public com.neusoft.core.restful.AppResponse getGoodsInfoById(String goodsId){
        try {
            return goodsService.getGoodsInfoById(goodsId);
        }catch (Exception e){
            logger.error("查询商品详情失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 获取商品分类
     * @param classifyId
     * @return
     * @author zsx
     * @Date 2020-04-13
     */
    @PostMapping("listGoodsClassify")
    public com.neusoft.core.restful.AppResponse getListGoodsCategory(String classifyId){
        try {
            return goodsService.getListGoodsCategory(classifyId);
        }catch (Exception e){
            logger.error("获取商品分类失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 更新商品信息
     * @param goodsInfo
     * @return
     * @author zsx
     * @Date 2020-04-13
     */
    @PostMapping("updateGoods")
    public com.neusoft.core.restful.AppResponse updateGoodsInfo(GoodsInfo goodsInfo){
        try {
            //获取商品id
            String goodsId = AuthUtils.getCurrentGoodsId();
            goodsInfo.setUpdateUser(goodsId);
            return goodsService.updateGoodsInfo(goodsInfo);
        }catch (Exception e){
            logger.error("更新商品失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品状态
     * @param goodsId
     * @param goodsStateId
     * @return
     * @author zsx
     * @Date 2020-04-13
     */
    @PostMapping("updateGoodsShelfState")
    public com.neusoft.core.restful.AppResponse updateGoodsStatus(String goodsId, String goodsStateId){
        try {
            return goodsService.updateGoodsStatus(goodsId, goodsStateId);
        }catch (Exception e){
            logger.error("修改商品状态失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品列表（分页）
     * @param goodsInfo
     * @return
     * @author zsx
     * @Date 2020-04-13
     */
    @PostMapping("listGoods")
    public com.neusoft.core.restful.AppResponse getListGoods(GoodsInfo goodsInfo){
        try {
            return goodsService.getListGoods(goodsInfo);
        }catch (Exception e){
            logger.error("查询商品列表失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除商品
     * @param goodsId
     * @return
     * @author zsx
     * @Date 2020-04-13
     */
    @PostMapping("deleteGoods")
    public AppResponse deleteGoods(String goodsId){
        try {
            //获取用户角色
            String userId = SecurityUtils.getCurrentUserId();
            return goodsService.deleteGoods(goodsId, userId);
        }catch (Exception e){
            logger.error("删除商品状态失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
