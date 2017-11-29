package com.hzcf.operation.gen.mapper;

import com.hzcf.operation.gen.entity.RuleGroup;
import com.hzcf.operation.gen.entity.RuleGroupExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface RuleGroupDelByGroupIdMapper {
    @Delete({
        "delete from rule_group",
        "where group_id = #{id,jdbcType=INTEGER}"
    })
    int deleteByGroupId(Integer id);

}