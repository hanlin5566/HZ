package com.hzcf.operation.gen.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hzcf.operation.base.enums.DataStatus;
import com.hzcf.operation.base.serialize.EnumJsonSerializer;
import com.hzcf.operation.base.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * cbd_user_role 
 * @author huhanlin 2017-11-23
 */
public class UserRole {
    /**
     * 用户ID
     */
    private String userid;

    /**
     * 角色Id
     */
    private String roleid;

    /**
     * 是否删除 0未删除 1已删除
     */
    private String isdeleted;

    /**
     * 是否可用
     */
    @JsonSerialize(using = EnumJsonSerializer.class)
    private DataStatus isvalid;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = DateUtils.ISO_DATE)
    private Date updatetime;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = DateUtils.ISO_DATE)
    private Date createtime;

    /**
     * 修改人
     */
    private String updateperson;

    /**
     * 创建人
     */
    private String createperson;

    /**
     * 
     * @return userId 
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 
     * @param userid 
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * 
     * @return roleId 
     */
    public String getRoleid() {
        return roleid;
    }

    /**
     * 
     * @param roleid 
     */
    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    /**
     * 是否删除 0未删除 1已删除
     * @return isDeleted 是否删除 0未删除 1已删除
     */
    public String getIsdeleted() {
        return isdeleted;
    }

    /**
     * 是否删除 0未删除 1已删除
     * @param isdeleted 是否删除 0未删除 1已删除
     */
    public void setIsdeleted(String isdeleted) {
        this.isdeleted = isdeleted == null ? null : isdeleted.trim();
    }

    /**
     * 
     * @return isValid 
     */
    public DataStatus getIsvalid() {
        return isvalid;
    }

    /**
     * 
     * @param isvalid 
     */
    public void setIsvalid(DataStatus isvalid) {
        this.isvalid = isvalid;
    }

    /**
     * 
     * @return updateTime 
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 
     * @param updatetime 
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 
     * @return createTime 
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 
     * @param createtime 
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 
     * @return updatePerson 
     */
    public String getUpdateperson() {
        return updateperson;
    }

    /**
     * 
     * @param updateperson 
     */
    public void setUpdateperson(String updateperson) {
        this.updateperson = updateperson == null ? null : updateperson.trim();
    }

    /**
     * 
     * @return createPerson 
     */
    public String getCreateperson() {
        return createperson;
    }

    /**
     * 
     * @param createperson 
     */
    public void setCreateperson(String createperson) {
        this.createperson = createperson == null ? null : createperson.trim();
    }
}