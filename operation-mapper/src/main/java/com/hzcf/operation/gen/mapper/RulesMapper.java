package com.hzcf.operation.gen.mapper;

import com.hzcf.operation.gen.entity.Rules;
import com.hzcf.operation.gen.entity.RulesExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface RulesMapper {
    @Delete({
        "delete from rule",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into rule (rule_key, rule_name, ",
        "rule_describe, var_group_id, ",
        "type, score, create_uid, ",
        "create_time, update_uid, ",
        "update_time, data_status, ",
        "rule_code)",
        "values (#{ruleKey,jdbcType=VARCHAR}, #{ruleName,jdbcType=VARCHAR}, ",
        "#{ruleDescribe,jdbcType=VARCHAR}, #{varGroupId,jdbcType=INTEGER}, ",
        "#{type,jdbcType=TINYINT}, #{score,jdbcType=INTEGER}, #{createUid,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateUid,jdbcType=INTEGER}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{dataStatus,jdbcType=INTEGER}, ",
        "#{ruleCode,jdbcType=LONGVARBINARY})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Rules record);

    @InsertProvider(type=RulesSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Rules record);

    @SelectProvider(type=RulesSqlProvider.class, method="selectByExampleWithBLOBs")
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
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="rule_code", property="ruleCode", jdbcType=JdbcType.LONGVARBINARY)
    })
    List<Rules> selectByExampleWithBLOBsWithRowbounds(RulesExample example, RowBounds rowBounds);

    @SelectProvider(type=RulesSqlProvider.class, method="selectByExampleWithBLOBs")
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
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="rule_code", property="ruleCode", jdbcType=JdbcType.LONGVARBINARY)
    })
    List<Rules> selectByExampleWithBLOBs(RulesExample example);

    @SelectProvider(type=RulesSqlProvider.class, method="selectByExample")
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
    List<Rules> selectByExampleWithRowbounds(RulesExample example, RowBounds rowBounds);

    @SelectProvider(type=RulesSqlProvider.class, method="selectByExample")
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
    List<Rules> selectByExample(RulesExample example);

    @Select({
        "select",
        "id, rule_key, rule_name, rule_describe, var_group_id, type, score, create_uid, ",
        "create_time, update_uid, update_time, data_status, rule_code",
        "from rule",
        "where id = #{id,jdbcType=INTEGER}"
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
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="rule_code", property="ruleCode", jdbcType=JdbcType.LONGVARBINARY)
    })
    Rules selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RulesSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Rules record);

    @Update({
        "update rule",
        "set rule_key = #{ruleKey,jdbcType=VARCHAR},",
          "rule_name = #{ruleName,jdbcType=VARCHAR},",
          "rule_describe = #{ruleDescribe,jdbcType=VARCHAR},",
          "var_group_id = #{varGroupId,jdbcType=INTEGER},",
          "type = #{type,jdbcType=TINYINT},",
          "score = #{score,jdbcType=INTEGER},",
          "create_uid = #{createUid,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_uid = #{updateUid,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "data_status = #{dataStatus,jdbcType=INTEGER},",
          "rule_code = #{ruleCode,jdbcType=LONGVARBINARY}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Rules record);

    @Update({
        "update rule",
        "set rule_key = #{ruleKey,jdbcType=VARCHAR},",
          "rule_name = #{ruleName,jdbcType=VARCHAR},",
          "rule_describe = #{ruleDescribe,jdbcType=VARCHAR},",
          "var_group_id = #{varGroupId,jdbcType=INTEGER},",
          "type = #{type,jdbcType=TINYINT},",
          "score = #{score,jdbcType=INTEGER},",
          "create_uid = #{createUid,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_uid = #{updateUid,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "data_status = #{dataStatus,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Rules record);
}