package com.hzcf.operation.gen.mapper;

import com.hzcf.operation.gen.entity.RuleGroup;
import com.hzcf.operation.gen.entity.RuleGroupExample;
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

public interface RuleGroupMapper {
    @Delete({
        "delete from rule_group_name",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into rule_group_name (group_key, group_name, ",
        "group_describe, create_uid, ",
        "create_time, update_uid, ",
        "update_time, data_status, ",
        "state, sort, test_demo)",
        "values (#{groupKey,jdbcType=VARCHAR}, #{groupName,jdbcType=VARCHAR}, ",
        "#{groupDescribe,jdbcType=VARCHAR}, #{createUid,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateUid,jdbcType=INTEGER}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{dataStatus,jdbcType=INTEGER}, ",
        "#{state,jdbcType=INTEGER}, #{sort,jdbcType=INTEGER}, #{testDemo,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(RuleGroup record);

    @InsertProvider(type=RuleGroupSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(RuleGroup record);

    @SelectProvider(type=RuleGroupSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_key", property="groupKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="group_name", property="groupName", jdbcType=JdbcType.VARCHAR),
        @Result(column="group_describe", property="groupDescribe", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="test_demo", property="testDemo", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<RuleGroup> selectByExampleWithBLOBsWithRowbounds(RuleGroupExample example, RowBounds rowBounds);

    @SelectProvider(type=RuleGroupSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_key", property="groupKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="group_name", property="groupName", jdbcType=JdbcType.VARCHAR),
        @Result(column="group_describe", property="groupDescribe", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="test_demo", property="testDemo", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<RuleGroup> selectByExampleWithBLOBs(RuleGroupExample example);

    @SelectProvider(type=RuleGroupSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_key", property="groupKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="group_name", property="groupName", jdbcType=JdbcType.VARCHAR),
        @Result(column="group_describe", property="groupDescribe", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER)
    })
    List<RuleGroup> selectByExampleWithRowbounds(RuleGroupExample example, RowBounds rowBounds);

    @SelectProvider(type=RuleGroupSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_key", property="groupKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="group_name", property="groupName", jdbcType=JdbcType.VARCHAR),
        @Result(column="group_describe", property="groupDescribe", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER)
    })
    List<RuleGroup> selectByExample(RuleGroupExample example);

    @Select({
        "select",
        "id, group_key, group_name, group_describe, create_uid, create_time, update_uid, ",
        "update_time, data_status, state, sort, test_demo",
        "from rule_group_name",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_key", property="groupKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="group_name", property="groupName", jdbcType=JdbcType.VARCHAR),
        @Result(column="group_describe", property="groupDescribe", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="test_demo", property="testDemo", jdbcType=JdbcType.LONGVARCHAR)
    })
    RuleGroup selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RuleGroupSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RuleGroup record);

    @Update({
        "update rule_group_name",
        "set group_key = #{groupKey,jdbcType=VARCHAR},",
          "group_name = #{groupName,jdbcType=VARCHAR},",
          "group_describe = #{groupDescribe,jdbcType=VARCHAR},",
          "create_uid = #{createUid,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_uid = #{updateUid,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "data_status = #{dataStatus,jdbcType=INTEGER},",
          "state = #{state,jdbcType=INTEGER},",
          "sort = #{sort,jdbcType=INTEGER},",
          "test_demo = #{testDemo,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(RuleGroup record);

    @Update({
        "update rule_group_name",
        "set group_key = #{groupKey,jdbcType=VARCHAR},",
          "group_name = #{groupName,jdbcType=VARCHAR},",
          "group_describe = #{groupDescribe,jdbcType=VARCHAR},",
          "create_uid = #{createUid,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_uid = #{updateUid,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "data_status = #{dataStatus,jdbcType=INTEGER},",
          "state = #{state,jdbcType=INTEGER},",
          "sort = #{sort,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RuleGroup record);
}