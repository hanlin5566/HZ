package com.hzcf.operation.gen.mapper;

import com.hzcf.operation.gen.entity.QueryLog;
import com.hzcf.operation.gen.entity.QueryLogExample;
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

public interface QueryLogMapper {
    @Delete({
        "delete from hj_query_log",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into hj_query_log (order_no, user_name, ",
        "user_id, query_time, ",
        "query_his, query_hi, ",
        "time_used, return_time, ",
        "interface_parent_type, interface_type, ",
        "state, id_card, name, ",
        "mobile, ip_address)",
        "values (#{orderNo,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
        "#{userId,jdbcType=VARCHAR}, #{queryTime,jdbcType=TIMESTAMP}, ",
        "#{queryHis,jdbcType=VARCHAR}, #{queryHi,jdbcType=VARCHAR}, ",
        "#{timeUsed,jdbcType=INTEGER}, #{returnTime,jdbcType=TIMESTAMP}, ",
        "#{interfaceParentType,jdbcType=VARCHAR}, #{interfaceType,jdbcType=VARCHAR}, ",
        "#{state,jdbcType=INTEGER}, #{idCard,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{mobile,jdbcType=VARCHAR}, #{ipAddress,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(QueryLog record);

    @InsertProvider(type=QueryLogSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(QueryLog record);

    @SelectProvider(type=QueryLogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="order_no", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="query_time", property="queryTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="query_his", property="queryHis", jdbcType=JdbcType.VARCHAR),
        @Result(column="query_hi", property="queryHi", jdbcType=JdbcType.VARCHAR),
        @Result(column="time_used", property="timeUsed", jdbcType=JdbcType.INTEGER),
        @Result(column="return_time", property="returnTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="interface_parent_type", property="interfaceParentType", jdbcType=JdbcType.VARCHAR),
        @Result(column="interface_type", property="interfaceType", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="id_card", property="idCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="ip_address", property="ipAddress", jdbcType=JdbcType.VARCHAR)
    })
    List<QueryLog> selectByExampleWithRowbounds(QueryLogExample example, RowBounds rowBounds);

    @SelectProvider(type=QueryLogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="order_no", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="query_time", property="queryTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="query_his", property="queryHis", jdbcType=JdbcType.VARCHAR),
        @Result(column="query_hi", property="queryHi", jdbcType=JdbcType.VARCHAR),
        @Result(column="time_used", property="timeUsed", jdbcType=JdbcType.INTEGER),
        @Result(column="return_time", property="returnTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="interface_parent_type", property="interfaceParentType", jdbcType=JdbcType.VARCHAR),
        @Result(column="interface_type", property="interfaceType", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="id_card", property="idCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="ip_address", property="ipAddress", jdbcType=JdbcType.VARCHAR)
    })
    List<QueryLog> selectByExample(QueryLogExample example);

    @Select({
        "select",
        "id, order_no, user_name, user_id, query_time, query_his, query_hi, time_used, ",
        "return_time, interface_parent_type, interface_type, state, id_card, name, mobile, ",
        "ip_address",
        "from hj_query_log",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="order_no", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="query_time", property="queryTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="query_his", property="queryHis", jdbcType=JdbcType.VARCHAR),
        @Result(column="query_hi", property="queryHi", jdbcType=JdbcType.VARCHAR),
        @Result(column="time_used", property="timeUsed", jdbcType=JdbcType.INTEGER),
        @Result(column="return_time", property="returnTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="interface_parent_type", property="interfaceParentType", jdbcType=JdbcType.VARCHAR),
        @Result(column="interface_type", property="interfaceType", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.INTEGER),
        @Result(column="id_card", property="idCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="ip_address", property="ipAddress", jdbcType=JdbcType.VARCHAR)
    })
    QueryLog selectByPrimaryKey(Integer id);

    @UpdateProvider(type=QueryLogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(QueryLog record);

    @Update({
        "update hj_query_log",
        "set order_no = #{orderNo,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=VARCHAR},",
          "query_time = #{queryTime,jdbcType=TIMESTAMP},",
          "query_his = #{queryHis,jdbcType=VARCHAR},",
          "query_hi = #{queryHi,jdbcType=VARCHAR},",
          "time_used = #{timeUsed,jdbcType=INTEGER},",
          "return_time = #{returnTime,jdbcType=TIMESTAMP},",
          "interface_parent_type = #{interfaceParentType,jdbcType=VARCHAR},",
          "interface_type = #{interfaceType,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=INTEGER},",
          "id_card = #{idCard,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "ip_address = #{ipAddress,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(QueryLog record);
}