package com.xzsd.pc.menu.entity;



import java.util.Date;

/**
 * @Description 菜单实体类
 * @Author zsx
 * @Date 2020-04-09
 */

public class MenuInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 菜单编号
     */
    private String menuCode;
    /**
     * 菜单路径
     */
    private String menuRoute;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 备注
     */
    private String Remarks;
    /**
     * 是否菜单 菜单0 目录1
     */
    private int isMenu;



    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDeleted;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 创建者
     */
    private String createUser;
    /**
     * 更新时间
     */
    private Date gmtModified;
    /**
     * 更新者
     */
    private String lastModifiedBy;
    /**
     * 版本号
     */
    private String version;

    public MenuInfo() {
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) { this.version = version; }

    public String getMenuCode() { return menuCode; }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuRoute() {
        return menuRoute;
    }

    public void setMenuRoute(String menuRoute) {
        this.menuRoute = menuRoute;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public int getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(int isMenu) {
        this.isMenu = isMenu;
    }
}
