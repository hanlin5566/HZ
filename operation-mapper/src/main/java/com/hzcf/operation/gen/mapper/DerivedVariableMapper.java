package com.hzcf.operation.gen.mapper;

import com.hzcf.operation.gen.entity.DerivedVariable;
import com.hzcf.operation.gen.entity.DerivedVariableExample;
import com.hzcf.operation.gen.entity.DerivedVariableWithBLOBs;
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

public interface DerivedVariableMapper {
    @Delete({
        "delete from derived_var",
        "where var_id = #{varId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer varId);

    @Insert({
        "insert into derived_var (var_ret_name, description, ",
        "var_rec_name, var_type, ",
        "var_data_type, default_value, ",
        "var_group_id, clazz_name, ",
        "state, deploy_time, ",
        "data_status, create_uid, ",
        "create_time, update_uid, ",
        "update_time, class_file, ",
        "clazz_path, test_demo)",
        "values (#{varRetName,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{varRecName,jdbcType=VARCHAR}, #{varType,jdbcType=INTEGER}, ",
        "#{varDataType,jdbcType=VARCHAR}, #{defaultValue,jdbcType=VARCHAR}, ",
        "#{varGroupId,jdbcType=INTEGER}, #{clazzName,jdbcType=VARCHAR}, ",
        "#{state,jdbcType=INTEGER}, #{deployTime,jdbcType=TIMESTAMP}, ",
        "#{dataStatus,jdbcType=INTEGER}, #{createUid,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateUid,jdbcType=INTEGER}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{classFile,jdbcType=LONGVARBINARY}, ",
        "#{clazzPath,jdbcType=LONGVARBINARY}, #{testDemo,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="varId", before=false, resultType=Integer.class)
    int insert(DerivedVariableWithBLOBs record);

    @InsertProvider(type=DerivedVariableSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="varId", before=false, resultType=Integer.class)
    int insertSelective(DerivedVariableWithBLOBs record);

    @SelectProvider(type=DerivedVariableSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="var_id", property="varId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="var_ret_name", property="varRetName", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="var_rec_name", property="varRecName", jdbcType=JdbcType.VARCHAR),
        @Result(column="var_type", property="varType", jdbcType=JdbcType.INTEGER),
        @Result(column="var_data_type", property="varDataType", jdbcType=JdbcType.VARCHAR),
        @Result(column="default_value", property="defaultValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="var_group_id", property="varGroupId", jdbcType=JdbcType.INTEGER),
        @Result(column="clazz_name", property="clazzName", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="deploy_time", property="deployTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="class_file", property="classFile", jdbcType=JdbcType.LONGVARBINARY),
        @Result(column="clazz_path", property="clazzPath", jdbcType=JdbcType.LONGVARBINARY),
        @Result(column="test_demo", property="testDemo", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<DerivedVariableWithBLOBs> selectByExampleWithBLOBsWithRowbounds(DerivedVariableExample example, RowBounds rowBounds);

    @SelectProvider(type=DerivedVariableSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="var_id", property="varId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="var_ret_name", property="varRetName", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="var_rec_name", property="varRecName", jdbcType=JdbcType.VARCHAR),
        @Result(column="var_type", property="varType", jdbcType=JdbcType.INTEGER),
        @Result(column="var_data_type", property="varDataType", jdbcType=JdbcType.VARCHAR),
        @Result(column="default_value", property="defaultValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="var_group_id", property="varGroupId", jdbcType=JdbcType.INTEGER),
        @Result(column="clazz_name", property="clazzName", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="deploy_time", property="deployTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="class_file", property="classFile", jdbcType=JdbcType.LONGVARBINARY),
        @Result(column="clazz_path", property="clazzPath", jdbcType=JdbcType.LONGVARBINARY),
        @Result(column="test_demo", property="testDemo", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<DerivedVariableWithBLOBs> selectByExampleWithBLOBs(DerivedVariableExample example);

    @SelectProvider(type=DerivedVariableSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="var_id", property="varId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="var_ret_name", property="varRetName", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="var_rec_name", property="varRecName", jdbcType=JdbcType.VARCHAR),
        @Result(column="var_type", property="varType", jdbcType=JdbcType.INTEGER),
        @Result(column="var_data_type", property="varDataType", jdbcType=JdbcType.VARCHAR),
        @Result(column="default_value", property="defaultValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="var_group_id", property="varGroupId", jdbcType=JdbcType.INTEGER),
        @Result(column="clazz_name", property="clazzName", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="deploy_time", property="deployTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<DerivedVariable> selectByExampleWithRowbounds(DerivedVariableExample example, RowBounds rowBounds);

    @SelectProvider(type=DerivedVariableSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="var_id", property="varId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="var_ret_name", property="varRetName", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="var_rec_name", property="varRecName", jdbcType=JdbcType.VARCHAR),
        @Result(column="var_type", property="varType", jdbcType=JdbcType.INTEGER),
        @Result(column="var_data_type", property="varDataType", jdbcType=JdbcType.VARCHAR),
        @Result(column="default_value", property="defaultValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="var_group_id", property="varGroupId", jdbcType=JdbcType.INTEGER),
        @Result(column="clazz_name", property="clazzName", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="deploy_time", property="deployTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<DerivedVariable> selectByExample(DerivedVariableExample example);

    @Select({
        "select",
        "var_id, var_ret_name, description, var_rec_name, var_type, var_data_type, default_value, ",
        "var_group_id, clazz_name, state, deploy_time, data_status, create_uid, create_time, ",
        "update_uid, update_time, class_file, clazz_path, test_demo",
        "from derived_var",
        "where var_id = #{varId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="var_id", property="varId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="var_ret_name", property="varRetName", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="var_rec_name", property="varRecName", jdbcType=JdbcType.VARCHAR),
        @Result(column="var_type", property="varType", jdbcType=JdbcType.INTEGER),
        @Result(column="var_data_type", property="varDataType", jdbcType=JdbcType.VARCHAR),
        @Result(column="default_value", property="defaultValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="var_group_id", property="varGroupId", jdbcType=JdbcType.INTEGER),
        @Result(column="clazz_name", property="clazzName", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="deploy_time", property="deployTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_status", property="dataStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_uid", property="createUid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_uid", property="updateUid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="class_file", property="classFile", jdbcType=JdbcType.LONGVARBINARY),
        @Result(column="clazz_path", property="clazzPath", jdbcType=JdbcType.LONGVARBINARY),
        @Result(column="test_demo", property="testDemo", jdbcType=JdbcType.LONGVARCHAR)
    })
    DerivedVariableWithBLOBs selectByPrimaryKey(Integer varId);

    @UpdateProvider(type=DerivedVariableSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(DerivedVariableWithBLOBs record);

    @Update({
        "update derived_var",
        "set var_ret_name = #{varRetName,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "var_rec_name = #{varRecName,jdbcType=VARCHAR},",
          "var_type = #{varType,jdbcType=INTEGER},",
          "var_data_type = #{varDataType,jdbcType=VARCHAR},",
          "default_value = #{defaultValue,jdbcType=VARCHAR},",
          "var_group_id = #{varGroupId,jdbcType=INTEGER},",
          "clazz_name = #{clazzName,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=INTEGER},",
          "deploy_time = #{deployTime,jdbcType=TIMESTAMP},",
          "data_status = #{dataStatus,jdbcType=INTEGER},",
          "create_uid = #{createUid,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_uid = #{updateUid,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "class_file = #{classFile,jdbcType=LONGVARBINARY},",
          "clazz_path = #{clazzPath,jdbcType=LONGVARBINARY},",
          "test_demo = #{testDemo,jdbcType=LONGVARCHAR}",
        "where var_id = #{varId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(DerivedVariableWithBLOBs record);

    @Update({
        "update derived_var",
        "set var_ret_name = #{varRetName,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "var_rec_name = #{varRecName,jdbcType=VARCHAR},",
          "var_type = #{varType,jdbcType=INTEGER},",
          "var_data_type = #{varDataType,jdbcType=VARCHAR},",
          "default_value = #{defaultValue,jdbcType=VARCHAR},",
          "var_group_id = #{varGroupId,jdbcType=INTEGER},",
          "clazz_name = #{clazzName,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=INTEGER},",
          "deploy_time = #{deployTime,jdbcType=TIMESTAMP},",
          "data_status = #{dataStatus,jdbcType=INTEGER},",
          "create_uid = #{createUid,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_uid = #{updateUid,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where var_id = #{varId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(DerivedVariable record);
}