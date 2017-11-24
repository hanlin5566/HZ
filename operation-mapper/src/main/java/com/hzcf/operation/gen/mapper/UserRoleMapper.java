package com.hzcf.operation.gen.mapper;

import com.hzcf.operation.gen.entity.UserRole;
import com.hzcf.operation.gen.entity.UserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface UserRoleMapper {
    @Insert({
        "insert into cbd_user_role (userId, roleId, ",
        "isDeleted, isValid, updateTime, ",
        "createTime, updatePerson, ",
        "createPerson)",
        "values (#{userid,jdbcType=VARCHAR}, #{roleid,jdbcType=VARCHAR}, ",
        "#{isdeleted,jdbcType=CHAR}, #{isvalid,jdbcType=CHAR}, #{updatetime,jdbcType=DATE}, ",
        "#{createtime,jdbcType=DATE}, #{updateperson,jdbcType=VARCHAR}, ",
        "#{createperson,jdbcType=VARCHAR})"
    })
    int insert(UserRole record);

    @InsertProvider(type=UserRoleSqlProvider.class, method="insertSelective")
    int insertSelective(UserRole record);

    @SelectProvider(type=UserRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="userId", property="userid", jdbcType=JdbcType.VARCHAR),
        @Result(column="roleId", property="roleid", jdbcType=JdbcType.VARCHAR),
        @Result(column="isDeleted", property="isdeleted", jdbcType=JdbcType.CHAR),
        @Result(column="isValid", property="isvalid", jdbcType=JdbcType.CHAR),
        @Result(column="updateTime", property="updatetime", jdbcType=JdbcType.DATE),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.DATE),
        @Result(column="updatePerson", property="updateperson", jdbcType=JdbcType.VARCHAR),
        @Result(column="createPerson", property="createperson", jdbcType=JdbcType.VARCHAR)
    })
    List<UserRole> selectByExampleWithRowbounds(UserRoleExample example, RowBounds rowBounds);

    @SelectProvider(type=UserRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="userId", property="userid", jdbcType=JdbcType.VARCHAR),
        @Result(column="roleId", property="roleid", jdbcType=JdbcType.VARCHAR),
        @Result(column="isDeleted", property="isdeleted", jdbcType=JdbcType.CHAR),
        @Result(column="isValid", property="isvalid", jdbcType=JdbcType.CHAR),
        @Result(column="updateTime", property="updatetime", jdbcType=JdbcType.DATE),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.DATE),
        @Result(column="updatePerson", property="updateperson", jdbcType=JdbcType.VARCHAR),
        @Result(column="createPerson", property="createperson", jdbcType=JdbcType.VARCHAR)
    })
    List<UserRole> selectByExample(UserRoleExample example);
}