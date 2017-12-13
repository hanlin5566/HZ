package com.hzcf.operation.gen.mapper;

import com.hzcf.operation.gen.entity.AppOrder;
import com.hzcf.operation.gen.entity.AppOrderExample;
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

public interface AppOrderMapper {
    @Delete({
        "delete from hj_app_order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into hj_app_order (log_id, task_id, ",
        "application_type, application_time, ",
        "id_card, decision_type, ",
        "decision_desc, time_used, ",
        "create_time, update_time)",
        "values (#{logId,jdbcType=VARCHAR}, #{taskId,jdbcType=VARCHAR}, ",
        "#{applicationType,jdbcType=INTEGER}, #{applicationTime,jdbcType=TIMESTAMP}, ",
        "#{idCard,jdbcType=VARCHAR}, #{decisionType,jdbcType=TINYINT}, ",
        "#{decisionDesc,jdbcType=VARCHAR}, #{timeUsed,jdbcType=DECIMAL}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(AppOrder record);

    @InsertProvider(type=AppOrderSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(AppOrder record);

    @SelectProvider(type=AppOrderSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="log_id", property="logId", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_id", property="taskId", jdbcType=JdbcType.VARCHAR),
        @Result(column="application_type", property="applicationType", jdbcType=JdbcType.INTEGER),
        @Result(column="application_time", property="applicationTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="id_card", property="idCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="decision_type", property="decisionType", jdbcType=JdbcType.TINYINT),
        @Result(column="decision_desc", property="decisionDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="time_used", property="timeUsed", jdbcType=JdbcType.DECIMAL),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AppOrder> selectByExampleWithRowbounds(AppOrderExample example, RowBounds rowBounds);

    @SelectProvider(type=AppOrderSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="log_id", property="logId", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_id", property="taskId", jdbcType=JdbcType.VARCHAR),
        @Result(column="application_type", property="applicationType", jdbcType=JdbcType.INTEGER),
        @Result(column="application_time", property="applicationTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="id_card", property="idCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="decision_type", property="decisionType", jdbcType=JdbcType.TINYINT),
        @Result(column="decision_desc", property="decisionDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="time_used", property="timeUsed", jdbcType=JdbcType.DECIMAL),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AppOrder> selectByExample(AppOrderExample example);

    @Select({
        "select",
        "id, log_id, task_id, application_type, application_time, id_card, decision_type, ",
        "decision_desc, time_used, create_time, update_time",
        "from hj_app_order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="log_id", property="logId", jdbcType=JdbcType.VARCHAR),
        @Result(column="task_id", property="taskId", jdbcType=JdbcType.VARCHAR),
        @Result(column="application_type", property="applicationType", jdbcType=JdbcType.INTEGER),
        @Result(column="application_time", property="applicationTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="id_card", property="idCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="decision_type", property="decisionType", jdbcType=JdbcType.TINYINT),
        @Result(column="decision_desc", property="decisionDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="time_used", property="timeUsed", jdbcType=JdbcType.DECIMAL),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    AppOrder selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AppOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AppOrder record);

    @Update({
        "update hj_app_order",
        "set log_id = #{logId,jdbcType=VARCHAR},",
          "task_id = #{taskId,jdbcType=VARCHAR},",
          "application_type = #{applicationType,jdbcType=INTEGER},",
          "application_time = #{applicationTime,jdbcType=TIMESTAMP},",
          "id_card = #{idCard,jdbcType=VARCHAR},",
          "decision_type = #{decisionType,jdbcType=TINYINT},",
          "decision_desc = #{decisionDesc,jdbcType=VARCHAR},",
          "time_used = #{timeUsed,jdbcType=DECIMAL},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AppOrder record);
}