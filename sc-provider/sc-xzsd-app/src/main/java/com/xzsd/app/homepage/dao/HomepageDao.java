package com.xzsd.app.homepage.dao;

import com.xzsd.app.homepage.entity.HotGoods;
import com.xzsd.app.homepage.entity.HotGoodsVO;
import com.xzsd.app.homepage.entity.Slideshow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description 首页
 * @author zsx
 * @data 2020/04/21
 */
@Mapper
public interface HomepageDao {
    /**
     * 查询首页轮播图
     *
     * @return
     */
    List<Slideshow> getListSlideshow();

    /**
     * 查询热门位商品
     *
     * @param hotGoods
     * @return
     */
    List<HotGoodsVO> getListHotGoods(HotGoods hotGoods);

    /**
     * 查询首页轮播图展示的数量
     * @return
     */
    int getSlideshowNumber();
}
