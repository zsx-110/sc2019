package com.xzsd.app.goods.entity;

import java.util.List;

/**
 * @Description 封装数据
 * @author zsx
 * @data 2020/04/22
 */
public class FirstCategoryList {
    /**
     * 商品一级分类集合
     */
    private List<GoodsCategory> oneClassifyList;

    public List<GoodsCategory> getOneClassifyList() {
        return oneClassifyList;
    }

    public void setOneClassifyList(List<GoodsCategory> oneClassifyList) {
        this.oneClassifyList = oneClassifyList;
    }

}
