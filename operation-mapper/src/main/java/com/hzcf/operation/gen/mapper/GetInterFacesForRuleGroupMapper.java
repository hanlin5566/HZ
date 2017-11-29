package com.hzcf.operation.gen.mapper;

import com.hzcf.operation.gen.entity.DerivedVariable;
import com.hzcf.operation.gen.entity.DerivedVariableGroup;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

public interface GetInterFacesForRuleGroupMapper {
    @Select({
            "SELECT dvg.query_iface as query_iface ",
                    " FROM " ,
                    " rule_group rg ",
                    " LEFT JOIN rule r on rg.rule_id=r.id ",
                    " LEFT JOIN derived_var_group dvg on r.var_group_id = dvg.var_group_id " ,
                    " where rg.group_id =#{groupId,jdbcType=INTEGER} GROUP BY dvg.query_iface"
    })
    @Results({
            @Result(column="query_iface", property="queryIface", jdbcType=JdbcType.VARCHAR)
    })
    List<Map<String,Object>> getMap(Integer groupId);

}