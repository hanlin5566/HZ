package com.hzcf.operation.gen.mapper;

import com.hzcf.operation.gen.entity.RoleModule;
import com.hzcf.operation.gen.entity.RoleModuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface RoleModuleMapper {
    @Insert({
        "insert into cbd_role_module (moduleId, roleId, ",
        "isDeleted, isValid, updateTime, ",
        "createTime, updatePerson, ",
        "createPerson)",
        "values (#{moduleid,jdbcType=VARCHAR}, #{roleid,jdbcType=VARCHAR}, ",
        "#{isdeleted,jdbcType=CHAR}, #{isvalid,jdbcType=CHAR}, #{updatetime,jdbcType=DATE}, ",
        "#{createtime,jdbcType=DATE}, #{updateperson,jdbcType=VARCHAR}, ",
        "#{createperson,jdbcType=VARCHAR})"
    })
    int insert(RoleModule record);

    @InsertProvider(type=RoleModuleSqlProvider.class, method="insertSelective")
    int insertSelective(RoleModule record);

    @SelectProvider(type=RoleModuleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="moduleId", property="moduleid", jdbcType=JdbcType.VARCHAR),
        @Result(column="roleId", property="roleid", jdbcType=JdbcType.VARCHAR),
        @Result(column="isDeleted", property="isdeleted", jdbcType=JdbcType.CHAR),
        @Result(column="isValid", property="isvalid", jdbcType=JdbcType.CHAR),
        @Result(column="updateTime", property="updatetime", jdbcType=JdbcType.DATE),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.DATE),
        @Result(column="updatePerson", property="updateperson", jdbcType=JdbcType.VARCHAR),
        @Result(column="createPerson", property="createperson", jdbcType=JdbcType.VARCHAR)
    })
    List<RoleModule> selectByExampleWithRowbounds(RoleModuleExample example, RowBounds rowBounds);

    @SelectProvider(type=RoleModuleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="moduleId", property="moduleid", jdbcType=JdbcType.VARCHAR),
        @Result(column="roleId", property="roleid", jdbcType=JdbcType.VARCHAR),
        @Result(column="isDeleted", property="isdeleted", jdbcType=JdbcType.CHAR),
        @Result(column="isValid", property="isvalid", jdbcType=JdbcType.CHAR),
        @Result(column="updateTime", property="updatetime", jdbcType=JdbcType.DATE),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.DATE),
        @Result(column="updatePerson", property="updateperson", jdbcType=JdbcType.VARCHAR),
        @Result(column="createPerson", property="createperson", jdbcType=JdbcType.VARCHAR)
    })
    List<RoleModule> selectByExample(RoleModuleExample example);
}