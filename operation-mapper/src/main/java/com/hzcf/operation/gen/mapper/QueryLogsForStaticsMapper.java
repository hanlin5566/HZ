package com.hzcf.operation.gen.mapper;

import com.hzcf.operation.base.entity.QueryLogExt;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

public interface QueryLogsForStaticsMapper {
    @Select({
            "SELECT query_hi,count(*) as c",
                    " FROM hj_query_log WHERE ",
                    " query_time >= #{startTime,jdbcType=VARCHAR}",
                    " AND query_time < #{endTime,jdbcType=VARCHAR}",
                    " GROUP BY query_hi"
    })
    @Results({
            @Result(column="query_hi", property="queryHi", jdbcType=JdbcType.VARCHAR),
            @Result(column="c", property="c", jdbcType=JdbcType.INTEGER)
    })
    List<Map<String,Object>> staticByHi(QueryLogExt queryLogExt);

    @Select({
            "SELECT\n" +
                    "\tCASE WHEN time_used < 3000 THEN \"[0,3s)\"\n" +
                    "WHEN time_used >= 3000 AND time_used < 5000 THEN \"[3,5s)\"\n" +
                    "WHEN time_used >= 5000 AND time_used < 10000 THEN\t\"[5,10s)\"\n" +
                    "WHEN time_used > 10000 THEN\t\"10s以上\" END AS u,\n" +
                    " count(*) AS c FROM hj_query_log\n" +
                    "WHERE query_time >= #{startTime,jdbcType=VARCHAR} AND query_time < #{endTime,jdbcType=VARCHAR} "
    })
    @Results({
            @Result(column="u", property="u", jdbcType=JdbcType.VARCHAR),
            @Result(column="c", property="c", jdbcType=JdbcType.INTEGER)
    })
    List<Map<String,Object>> staticByTimeUsed(QueryLogExt queryLogExt);


    @Select({
            "SELECT  CASE state\n" +
                    "        WHEN  0 or 1 THEN \"异常\"\n" +
                    "        WHEN  2 THEN \"有数据\"\n" +
                    "        WHEN  3 THEN \"无数据\"\n" +
                    "        WHEN  4 THEN \"历史数据\"\n" +
                    "        ELSE  \"异常\"\n" +
                    "        END  AS s,\n" +
                    "        count(*) AS c",
            " FROM hj_query_log WHERE ",
            " query_time >= #{startTime,jdbcType=VARCHAR}",
            " AND query_time < #{endTime,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="s", property="s", jdbcType=JdbcType.VARCHAR),
            @Result(column="c", property="c", jdbcType=JdbcType.INTEGER)
    })
    List<Map<String,Object>> staticState(QueryLogExt queryLogExt);

}