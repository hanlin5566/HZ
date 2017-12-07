package com.hzcf.operation.gen.mapper;

import com.hzcf.operation.gen.entity.SystemRole;
import com.hzcf.operation.gen.entity.SystemRoleExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface SystemRoleMapper {
    @Delete({
        "delete from system_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into system_role (id, role_name, ",
        "parent_id, comments, ",
        "data_status, create_uid, ",
        "update_uid, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=INTEGER}, #{roleName,jdbcType=VARCHAR}, ",
        "#{parentId,jdbcType=INTEGER}, #{comments,jdbcType=VARCHAR}, ",
        "#{dataStatus,jdbcType=INTEGER}, #{createUid,jdbcType=INTEGER}, ",
        "#{updateUid,jdbcType=INTEGER}, #{createTime,jdbcType=DATE}, ",
        "#{updateTime,jdbcType=DATE})"
    })
    @Options(useGeneratedKeys=true)
    void insert(SystemRole record);

    @InsertProvider(type=SystemRoleSqlProvider.class, method="insertSelective")
    int insertSelective(SystemRole record);

    @SelectProvider(type=SystemRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="comments", property="comments", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.DATE)
    })
    List<SystemRole> selectByExampleWithRowbounds(SystemRoleExample example, RowBounds rowBounds);

    @SelectProvider(type=SystemRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="comments", property="comments", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.DATE)
    })
    List<SystemRole> selectByExample(SystemRoleExample example);

    @Select({
        "select",
        "id, role_name, parent_id, comments, data_status, create_uid, update_uid, create_time, ",
        "update_time",
        "from system_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="comments", property="comments", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.DATE)
    })
    SystemRole selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SystemRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SystemRole record);

    @Update({
        "update system_role",
        "set role_name = #{roleName,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=INTEGER},",
          "comments = #{comments,jdbcType=VARCHAR},",
          "data_status = #{dataStatus,jdbcType=INTEGER},",
          "create_uid = #{createUid,jdbcType=INTEGER},",
          "update_uid = #{updateUid,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=DATE},",
          "update_time = #{updateTime,jdbcType=DATE}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SystemRole record);
}