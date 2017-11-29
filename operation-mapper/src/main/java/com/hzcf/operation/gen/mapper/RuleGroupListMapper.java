package com.hzcf.operation.gen.mapper;

import com.hzcf.operation.gen.entity.RuleGroupList;
import com.hzcf.operation.gen.entity.RuleGroupListExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface RuleGroupListMapper {
    @Delete({
        "delete from rule_group",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into rule_group (id, rule_id, ",
        "group_id, state, ",
        "create_uid, create_time, ",
        "update_uid, update_time, ",
        "data_status, test_demo)",
        "values (#{id,jdbcType=INTEGER}, #{ruleId,jdbcType=INTEGER}, ",
        "#{groupId,jdbcType=INTEGER}, #{state,jdbcType=INTEGER}, ",
        "#{createUid,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateUid,jdbcType=INTEGER}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{dataStatus,jdbcType=INTEGER}, #{testDemo,jdbcType=LONGVARCHAR})"
    })
    int insert(RuleGroupList record);

    @InsertProvider(type=RuleGroupListSqlProvider.class, method="insertSelective")
    int insertSelective(RuleGroupList record);

    @SelectProvider(type=RuleGroupListSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rule_id", property="ruleId", jdbcType=JdbcType.INTEGER),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="test_demo", property="testDemo", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<RuleGroupList> selectByExampleWithBLOBsWithRowbounds(RuleGroupListExample example, RowBounds rowBounds);

    @SelectProvider(type=RuleGroupListSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rule_id", property="ruleId", jdbcType=JdbcType.INTEGER),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="test_demo", property="testDemo", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<RuleGroupList> selectByExampleWithBLOBs(RuleGroupListExample example);

    @SelectProvider(type=RuleGroupListSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rule_id", property="ruleId", jdbcType=JdbcType.INTEGER),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER)
    })
    List<RuleGroupList> selectByExampleWithRowbounds(RuleGroupListExample example, RowBounds rowBounds);

    @SelectProvider(type=RuleGroupListSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rule_id", property="ruleId", jdbcType=JdbcType.INTEGER),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER)
    })
    List<RuleGroupList> selectByExample(RuleGroupListExample example);

    @Select({
        "select",
        "id, rule_id, group_id, state, create_uid, create_time, update_uid, update_time, ",
        "data_status, test_demo",
        "from rule_group",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rule_id", property="ruleId", jdbcType=JdbcType.INTEGER),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="test_demo", property="testDemo", jdbcType=JdbcType.LONGVARCHAR)
    })
    RuleGroupList selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RuleGroupListSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RuleGroupList record);

    @Update({
        "update rule_group",
        "set rule_id = #{ruleId,jdbcType=INTEGER},",
          "group_id = #{groupId,jdbcType=INTEGER},",
          "state = #{state,jdbcType=INTEGER},",
          "create_uid = #{createUid,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_uid = #{updateUid,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "data_status = #{dataStatus,jdbcType=INTEGER},",
          "test_demo = #{testDemo,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(RuleGroupList record);

    @Update({
        "update rule_group",
        "set rule_id = #{ruleId,jdbcType=INTEGER},",
          "group_id = #{groupId,jdbcType=INTEGER},",
          "state = #{state,jdbcType=INTEGER},",
          "create_uid = #{createUid,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_uid = #{updateUid,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "data_status = #{dataStatus,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RuleGroupList record);
}