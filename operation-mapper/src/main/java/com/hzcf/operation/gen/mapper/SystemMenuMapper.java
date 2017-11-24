package com.hzcf.operation.gen.mapper;

import com.hzcf.operation.gen.entity.SystemMenu;
import com.hzcf.operation.gen.entity.SystemMenuExample;
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

public interface SystemMenuMapper {
    @Delete({
        "delete from system_menu",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into system_menu (id, module_title, ",
        "module_href, module_icon, ",
        "module_spread, parent_id, ",
        "create_uid, update_uid, ",
        "create_time, update_time, ",
        "data_status)",
        "values (#{id,jdbcType=INTEGER}, #{moduleTitle,jdbcType=VARCHAR}, ",
        "#{moduleHref,jdbcType=VARCHAR}, #{moduleIcon,jdbcType=VARCHAR}, ",
        "#{moduleSpread,jdbcType=VARCHAR}, #{parentId,jdbcType=INTEGER}, ",
        "#{createUid,jdbcType=INTEGER}, #{updateUid,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=DATE}, #{updateTime,jdbcType=DATE}, ",
        "#{dataStatus,jdbcType=INTEGER})"
    })
    int insert(SystemMenu record);

    @InsertProvider(type=SystemMenuSqlProvider.class, method="insertSelective")
    int insertSelective(SystemMenu record);

    @SelectProvider(type=SystemMenuSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="module_title", property="moduleTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_href", property="moduleHref", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_icon", property="moduleIcon", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_spread", property="moduleSpread", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.DATE),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER)
    })
    List<SystemMenu> selectByExampleWithRowbounds(SystemMenuExample example, RowBounds rowBounds);

    @SelectProvider(type=SystemMenuSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="module_title", property="moduleTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_href", property="moduleHref", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_icon", property="moduleIcon", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_spread", property="moduleSpread", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.DATE),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER)
    })
    List<SystemMenu> selectByExample(SystemMenuExample example);

    @Select({
        "select",
        "id, module_title, module_href, module_icon, module_spread, parent_id, create_uid, ",
        "update_uid, create_time, update_time, data_status",
        "from system_menu",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="module_title", property="moduleTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_href", property="moduleHref", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_icon", property="moduleIcon", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_spread", property="moduleSpread", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.DATE),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER)
    })
    SystemMenu selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SystemMenuSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SystemMenu record);

    @Update({
        "update system_menu",
        "set module_title = #{moduleTitle,jdbcType=VARCHAR},",
          "module_href = #{moduleHref,jdbcType=VARCHAR},",
          "module_icon = #{moduleIcon,jdbcType=VARCHAR},",
          "module_spread = #{moduleSpread,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=INTEGER},",
          "create_uid = #{createUid,jdbcType=INTEGER},",
          "update_uid = #{updateUid,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=DATE},",
          "update_time = #{updateTime,jdbcType=DATE},",
          "data_status = #{dataStatus,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SystemMenu record);
}