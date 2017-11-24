package com.hzcf.operation.gen.entity;

import com.hzcf.operation.base.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * system_menu 
 * @author huhanlin 2017-11-23
 */
public class SystemMenu {
    /**
     * system_menu 主键ID
     */
    private Integer id;

    /**
     * 模块Title
     */
    private String moduleTitle;

    /**
     * 模块对应的url
     */
    private String moduleHref;

    /**
     * 模块对应的图标
     */
    private String moduleIcon;

    /**
     * 是否默认展开，子节点该属性不起作用
     */
    private String moduleSpread;

    /**
     * 父ID
     */
    private Integer parentId;

    /**
     * 创建人
     */
    private Integer createUid;

    /**
     * 修改人
     */
    private Integer updateUid;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = DateUtils.ISO_DATE)
    private Date createTime;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = DateUtils.ISO_DATE)
    private Date updateTime;

    /**
     * 数据状态（0.未知，1.正常，-1.删除）
     */
    private Integer dataStatus;

    /**
     * system_menu 主键ID
     * @return id system_menu 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * system_menu 主键ID
     * @param id system_menu 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 模块Title
     * @return module_title 模块Title
     */
    public String getModuleTitle() {
        return moduleTitle;
    }

    /**
     * 模块Title
     * @param moduleTitle 模块Title
     */
    public void setModuleTitle(String moduleTitle) {
        this.moduleTitle = moduleTitle == null ? null : moduleTitle.trim();
    }

    /**
     * 模块对应的url
     * @return module_href 模块对应的url
     */
    public String getModuleHref() {
        return moduleHref;
    }

    /**
     * 模块对应的url
     * @param moduleHref 模块对应的url
     */
    public void setModuleHref(String moduleHref) {
        this.moduleHref = moduleHref == null ? null : moduleHref.trim();
    }

    /**
     * 模块对应的图标
     * @return module_icon 模块对应的图标
     */
    public String getModuleIcon() {
        return moduleIcon;
    }

    /**
     * 模块对应的图标
     * @param moduleIcon 模块对应的图标
     */
    public void setModuleIcon(String moduleIcon) {
        this.moduleIcon = moduleIcon == null ? null : moduleIcon.trim();
    }

    /**
     * 是否默认展开，子节点该属性不起作用
     * @return module_spread 是否默认展开，子节点该属性不起作用
     */
    public String getModuleSpread() {
        return moduleSpread;
    }

    /**
     * 是否默认展开，子节点该属性不起作用
     * @param moduleSpread 是否默认展开，子节点该属性不起作用
     */
    public void setModuleSpread(String moduleSpread) {
        this.moduleSpread = moduleSpread == null ? null : moduleSpread.trim();
    }

    /**
     * 父ID
     * @return parent_id 父ID
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 父ID
     * @param parentId 父ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 创建人
     * @return create_uid 创建人
     */
    public Integer getCreateUid() {
        return createUid;
    }

    /**
     * 创建人
     * @param createUid 创建人
     */
    public void setCreateUid(Integer createUid) {
        this.createUid = createUid;
    }

    /**
     * 修改人
     * @return update_uid 修改人
     */
    public Integer getUpdateUid() {
        return updateUid;
    }

    /**
     * 修改人
     * @param updateUid 修改人
     */
    public void setUpdateUid(Integer updateUid) {
        this.updateUid = updateUid;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间
     * @return update_time 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 数据状态（0.未知，1.正常，-1.删除）
     * @return data_status 数据状态（0.未知，1.正常，-1.删除）
     */
    public Integer getDataStatus() {
        return dataStatus;
    }

    /**
     * 数据状态（0.未知，1.正常，-1.删除）
     * @param dataStatus 数据状态（0.未知，1.正常，-1.删除）
     */
    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }
}