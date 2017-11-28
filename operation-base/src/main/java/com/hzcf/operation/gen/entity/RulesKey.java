package com.hzcf.operation.gen.entity;

/**
 * rule 规则库
 * @author huhanlin 2017-11-28
 */
public class RulesKey {
    /**
     * 
     */
    private Integer id;

    /**
     * 所属数据源
     */
    private Integer varGroupId;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 所属数据源
     * @return var_group_id 所属数据源
     */
    public Integer getVarGroupId() {
        return varGroupId;
    }

    /**
     * 所属数据源
     * @param varGroupId 所属数据源
     */
    public void setVarGroupId(Integer varGroupId) {
        this.varGroupId = varGroupId;
    }
}