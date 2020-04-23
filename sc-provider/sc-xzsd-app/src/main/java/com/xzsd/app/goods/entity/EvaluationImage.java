package com.xzsd.app.goods.entity;

/**
 * 评价图片实体类
 * @author zsx
 * @data 2020/04/22
 */
public class EvaluationImage {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 评价图片
     */
    private String imagePath;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
