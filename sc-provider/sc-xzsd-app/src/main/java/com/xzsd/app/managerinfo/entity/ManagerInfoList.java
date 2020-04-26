package com.xzsd.app.managerinfo.entity;

import java.util.List;

/**
 * @Description 封装数据
 * @author zsx
 * @date 2020/04/25
 */
public class ManagerInfoList {
    /**
     * 司机信息集合
     */
    private List<ManagerInfo> list;

    public List<ManagerInfo> getList() {
        return list;
    }

    public void setList(List<ManagerInfo> list) {
        this.list = list;
    }
}
