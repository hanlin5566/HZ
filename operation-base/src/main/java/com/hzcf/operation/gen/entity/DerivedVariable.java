package com.hzcf.operation.gen.entity;

import com.hzcf.operation.base.enums.DataStatus;
import com.hzcf.operation.base.enums.DerivedVarStatus;
import java.util.Date;

/**
 * derived_var 变量管理表
 * @author huhanlin 2017-11-24
 */
public class DerivedVariable {
    /**
     * 变量主键
     */
    private Integer varId;

    /**
     * 返回-制定变量唯一标识（规则字段对应）
     */
    private String varRetName;

    /**
     * 变量描述
     */
    private String description;

    /**
     * 接收-接口变量名称，如果为衍生变量则=var_name
     */
    private String varRecName;

    /**
     * 变量类型（0.未知，1.直接变量，2.衍生变量）
     */
    private Integer varType;

    /**
     * 变量数据类型
     */
    private String varDataType;

    /**
     * 变量的默认值，如果变量值为空，则会取默认值返回。
     */
    private String defaultValue;

    /**
     * 变量数据源
     */
    private Integer varGroupId;

    /**
     * 变量需要加载的类名
     */
    private String clazzName;

    /**
     * 算法类保存的路径，新建与已编译时为本地地址，发布时为文件服务器地址。
     */
    private String clazzPath;

    /**
     * 变量状态(0:未知,1：已保存，2：通过编译，3：已发布）
     */
    @JsonSerialize(using = EnumJsonSerializer.class)
    private DerivedVarStatus state;

    /**
     * 发布日期
     */
    @DateTimeFormat(pattern = DateUtils.ISO_DATE)
    private Date deployTime;

    /**
     * 数据状态（0.未知，1.正常，-1.删除）
     */
    @JsonSerialize(using = EnumJsonSerializer.class)
    private DataStatus dataStatus;

    /**
     * 创建用户
     */
    private Integer createUid;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = DateUtils.ISO_DATE)
    private Date createTime;

    /**
     * 修改人
     */
    private Integer updateUid;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = DateUtils.ISO_DATE)
    private Date updateTime;

    /**
     * 变量的class文件，目前不支持内部类等，因为一个java文件有可能编译出多个class文件，放入一个字段回有问题。日后迁移至文件服务器时，可以用一个classList，动态按序加载class
     */
    private byte[] classFile;

    /**
     * 变量主键
     * @return var_id 变量主键
     */
    public Integer getVarId() {
        return varId;
    }

    /**
     * 变量主键
     * @param varId 变量主键
     */
    public void setVarId(Integer varId) {
        this.varId = varId;
    }

    /**
     * 返回-制定变量唯一标识（规则字段对应）
     * @return var_ret_name 返回-制定变量唯一标识（规则字段对应）
     */
    public String getVarRetName() {
        return varRetName;
    }

    /**
     * 返回-制定变量唯一标识（规则字段对应）
     * @param varRetName 返回-制定变量唯一标识（规则字段对应）
     */
    public void setVarRetName(String varRetName) {
        this.varRetName = varRetName == null ? null : varRetName.trim();
    }

    /**
     * 变量描述
     * @return description 变量描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 变量描述
     * @param description 变量描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 接收-接口变量名称，如果为衍生变量则=var_name
     * @return var_rec_name 接收-接口变量名称，如果为衍生变量则=var_name
     */
    public String getVarRecName() {
        return varRecName;
    }

    /**
     * 接收-接口变量名称，如果为衍生变量则=var_name
     * @param varRecName 接收-接口变量名称，如果为衍生变量则=var_name
     */
    public void setVarRecName(String varRecName) {
        this.varRecName = varRecName == null ? null : varRecName.trim();
    }

    /**
     * 变量类型（0.未知，1.直接变量，2.衍生变量）
     * @return var_type 变量类型（0.未知，1.直接变量，2.衍生变量）
     */
    public Integer getVarType() {
        return varType;
    }

    /**
     * 变量类型（0.未知，1.直接变量，2.衍生变量）
     * @param varType 变量类型（0.未知，1.直接变量，2.衍生变量）
     */
    public void setVarType(Integer varType) {
        this.varType = varType;
    }

    /**
     * 变量数据类型
     * @return var_data_type 变量数据类型
     */
    public String getVarDataType() {
        return varDataType;
    }

    /**
     * 变量数据类型
     * @param varDataType 变量数据类型
     */
    public void setVarDataType(String varDataType) {
        this.varDataType = varDataType == null ? null : varDataType.trim();
    }

    /**
     * 变量的默认值，如果变量值为空，则会取默认值返回。
     * @return default_value 变量的默认值，如果变量值为空，则会取默认值返回。
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * 变量的默认值，如果变量值为空，则会取默认值返回。
     * @param defaultValue 变量的默认值，如果变量值为空，则会取默认值返回。
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue == null ? null : defaultValue.trim();
    }

    /**
     * 变量数据源
     * @return var_group_id 变量数据源
     */
    public Integer getVarGroupId() {
        return varGroupId;
    }

    /**
     * 变量数据源
     * @param varGroupId 变量数据源
     */
    public void setVarGroupId(Integer varGroupId) {
        this.varGroupId = varGroupId;
    }

    /**
     * 变量需要加载的类名
     * @return clazz_name 变量需要加载的类名
     */
    public String getClazzName() {
        return clazzName;
    }

    /**
     * 变量需要加载的类名
     * @param clazzName 变量需要加载的类名
     */
    public void setClazzName(String clazzName) {
        this.clazzName = clazzName == null ? null : clazzName.trim();
    }

    /**
     * 算法类保存的路径，新建与已编译时为本地地址，发布时为文件服务器地址。
     * @return clazz_path 算法类保存的路径，新建与已编译时为本地地址，发布时为文件服务器地址。
     */
    public String getClazzPath() {
        return clazzPath;
    }

    /**
     * 算法类保存的路径，新建与已编译时为本地地址，发布时为文件服务器地址。
     * @param clazzPath 算法类保存的路径，新建与已编译时为本地地址，发布时为文件服务器地址。
     */
    public void setClazzPath(String clazzPath) {
        this.clazzPath = clazzPath == null ? null : clazzPath.trim();
    }

    /**
     * 变量状态(0:未知,1：已保存，2：通过编译，3：已发布）
     * @return state 变量状态(0:未知,1：已保存，2：通过编译，3：已发布）
     */
    public DerivedVarStatus getState() {
        return state;
    }

    /**
     * 变量状态(0:未知,1：已保存，2：通过编译，3：已发布）
     * @param state 变量状态(0:未知,1：已保存，2：通过编译，3：已发布）
     */
    public void setState(DerivedVarStatus state) {
        this.state = state;
    }

    /**
     * 发布日期
     * @return deploy_time 发布日期
     */
    public Date getDeployTime() {
        return deployTime;
    }

    /**
     * 发布日期
     * @param deployTime 发布日期
     */
    public void setDeployTime(Date deployTime) {
        this.deployTime = deployTime;
    }

    /**
     * 数据状态（0.未知，1.正常，-1.删除）
     * @return data_status 数据状态（0.未知，1.正常，-1.删除）
     */
    public DataStatus getDataStatus() {
        return dataStatus;
    }

    /**
     * 数据状态（0.未知，1.正常，-1.删除）
     * @param dataStatus 数据状态（0.未知，1.正常，-1.删除）
     */
    public void setDataStatus(DataStatus dataStatus) {
        this.dataStatus = dataStatus;
    }

    /**
     * 创建用户
     * @return create_uid 创建用户
     */
    public Integer getCreateUid() {
        return createUid;
    }

    /**
     * 创建用户
     * @param createUid 创建用户
     */
    public void setCreateUid(Integer createUid) {
        this.createUid = createUid;
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
     * 变量的class文件，目前不支持内部类等，因为一个java文件有可能编译出多个class文件，放入一个字段回有问题。日后迁移至文件服务器时，可以用一个classList，动态按序加载class
     * @return class_file 变量的class文件，目前不支持内部类等，因为一个java文件有可能编译出多个class文件，放入一个字段回有问题。日后迁移至文件服务器时，可以用一个classList，动态按序加载class
     */
    public byte[] getClassFile() {
        return classFile;
    }

    /**
     * 变量的class文件，目前不支持内部类等，因为一个java文件有可能编译出多个class文件，放入一个字段回有问题。日后迁移至文件服务器时，可以用一个classList，动态按序加载class
     * @param classFile 变量的class文件，目前不支持内部类等，因为一个java文件有可能编译出多个class文件，放入一个字段回有问题。日后迁移至文件服务器时，可以用一个classList，动态按序加载class
     */
    public void setClassFile(byte[] classFile) {
        this.classFile = classFile;
    }
}