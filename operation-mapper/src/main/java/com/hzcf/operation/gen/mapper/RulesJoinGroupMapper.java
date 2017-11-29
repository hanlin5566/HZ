package com.hzcf.operation.gen.mapper;

import com.hzcf.operation.gen.entity.Rules;
import com.hzcf.operation.gen.entity.RulesExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface RulesJoinGroupMapper {

    @Select({
        "select r.* from rule_group rg left JOIN rule r on rg.rule_id=r.id ",
        "where rg.group_id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rule_key", property="ruleKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="rule_name", property="ruleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="rule_describe", property="ruleDescribe", jdbcType=JdbcType.VARCHAR),
        @Result(column="var_group_id", property="varGroupId", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER)
    })
    List<Rules> selectRulesJoinRuleGroup(Integer id);

}