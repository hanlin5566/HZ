package com.hzcf.operation.gen.mapper;

import com.hzcf.operation.gen.entity.DerivedVariableGroup;
import com.hzcf.operation.gen.entity.DerivedVariableGroupExample;
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

public interface DerivedVariableGroupMapper {
    @Delete({
        "delete from derived_var_group",
        "where var_group_id = #{varGroupId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer varGroupId);

    @Insert({
        "insert into derived_var_group (group_name, description, ",
        "query_iface, data_status, ",
        "create_uid, create_time, ",
        "update_uid, update_time)",
        "values (#{groupName,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{queryIface,jdbcType=VARCHAR}, #{dataStatus,jdbcType=INTEGER}, ",
        "#{createUid,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateUid,jdbcType=INTEGER}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="varGroupId", before=false, resultType=Integer.class)
    int insert(DerivedVariableGroup record);

    @InsertProvider(type=DerivedVariableGroupSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="varGroupId", before=false, resultType=Integer.class)
    int insertSelective(DerivedVariableGroup record);

    @SelectProvider(type=DerivedVariableGroupSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="var_group_id", property="varGroupId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_name", property="groupName", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="query_iface", property="queryIface", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<DerivedVariableGroup> selectByExampleWithRowbounds(DerivedVariableGroupExample example, RowBounds rowBounds);

    @SelectProvider(type=DerivedVariableGroupSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="var_group_id", property="varGroupId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_name", property="groupName", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="query_iface", property="queryIface", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<DerivedVariableGroup> selectByExample(DerivedVariableGroupExample example);

    @Select({
        "select",
        "var_group_id, group_name, description, query_iface, data_status, create_uid, ",
        "create_time, update_uid, update_time",
        "from derived_var_group",
        "where var_group_id = #{varGroupId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="var_group_id", property="varGroupId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_name", property="groupName", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="query_iface", property="queryIface", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    DerivedVariableGroup selectByPrimaryKey(Integer varGroupId);

    @UpdateProvider(type=DerivedVariableGroupSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(DerivedVariableGroup record);

    @Update({
        "update derived_var_group",
        "set group_name = #{groupName,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "query_iface = #{queryIface,jdbcType=VARCHAR},",
          "data_status = #{dataStatus,jdbcType=INTEGER},",
          "create_uid = #{createUid,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_uid = #{updateUid,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where var_group_id = #{varGroupId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(DerivedVariableGroup record);
}