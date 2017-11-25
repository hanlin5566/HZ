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
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface RuleGroupListMapper {
    @Delete({
        "delete from rule_group_name",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into rule_group_name (group_key, group_name, ",
        "group_describe, create_uid, ",
        "create_time, update_uid, ",
        "update_time, data_status)",
        "values (#{groupKey,jdbcType=VARCHAR}, #{groupName,jdbcType=VARCHAR}, ",
        "#{groupDescribe,jdbcType=VARCHAR}, #{createUid,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateUid,jdbcType=INTEGER}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{dataStatus,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(RuleGroupList record);

    @InsertProvider(type=RuleGroupListSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(RuleGroupList record);

    @SelectProvider(type=RuleGroupListSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_key", property="groupKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="group_name", property="groupName", jdbcType=JdbcType.VARCHAR),
        @Result(column="group_describe", property="groupDescribe", jdbcType=JdbcType.VARCHAR),
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
        @Result(column="group_key", property="groupKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="group_name", property="groupName", jdbcType=JdbcType.VARCHAR),
        @Result(column="group_describe", property="groupDescribe", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER)
    })
    List<RuleGroupList> selectByExample(RuleGroupListExample example);

    @Select({
        "select",
        "id, group_key, group_name, group_describe, create_uid, create_time, update_uid, ",
        "update_time, data_status",
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
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER)
    })
    RuleGroupList selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RuleGroupListSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RuleGroupList record);

    @Update({
        "update rule_group_name",
        "set group_key = #{groupKey,jdbcType=VARCHAR},",
          "group_name = #{groupName,jdbcType=VARCHAR},",
          "group_describe = #{groupDescribe,jdbcType=VARCHAR},",
          "create_uid = #{createUid,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_uid = #{updateUid,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "data_status = #{dataStatus,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RuleGroupList record);
}