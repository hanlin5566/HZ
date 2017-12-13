package com.hzcf.operation.gen.mapper;

import com.hzcf.operation.gen.entity.QueryLog;
import com.hzcf.operation.gen.entity.QueryLogExample.Criteria;
import com.hzcf.operation.gen.entity.QueryLogExample.Criterion;
import com.hzcf.operation.gen.entity.QueryLogExample;
import java.util.List;
import org.apache.ibatis.jdbc.SQL;

public class QueryLogSqlProvider {

    public String insertSelective(QueryLog record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("hj_query_log");
        
        if (record.getLogId() != null) {
            sql.VALUES("log_id", "#{logId,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderNo() != null) {
            sql.VALUES("order_no", "#{orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getQueryTime() != null) {
            sql.VALUES("query_time", "#{queryTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQueryHis() != null) {
            sql.VALUES("query_his", "#{queryHis,jdbcType=VARCHAR}");
        }
        
        if (record.getQueryHi() != null) {
            sql.VALUES("query_hi", "#{queryHi,jdbcType=VARCHAR}");
        }
        
        if (record.getTimeUsed() != null) {
            sql.VALUES("time_used", "#{timeUsed,jdbcType=INTEGER}");
        }
        
        if (record.getReturnTime() != null) {
            sql.VALUES("return_time", "#{returnTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getInterfaceParentType() != null) {
            sql.VALUES("interface_parent_type", "#{interfaceParentType,jdbcType=VARCHAR}");
        }
        
        if (record.getInterfaceType() != null) {
            sql.VALUES("interface_type", "#{interfaceType,jdbcType=VARCHAR}");
        }
        
        if (record.getState() != null) {
            sql.VALUES("state", "#{state,jdbcType=INTEGER}");
        }
        
        if (record.getIdCard() != null) {
            sql.VALUES("id_card", "#{idCard,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.VALUES("mobile", "#{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getIpAddress() != null) {
            sql.VALUES("ip_address", "#{ipAddress,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(QueryLogExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("log_id");
        sql.SELECT("order_no");
        sql.SELECT("user_name");
        sql.SELECT("user_id");
        sql.SELECT("query_time");
        sql.SELECT("query_his");
        sql.SELECT("query_hi");
        sql.SELECT("time_used");
        sql.SELECT("return_time");
        sql.SELECT("interface_parent_type");
        sql.SELECT("interface_type");
        sql.SELECT("state");
        sql.SELECT("id_card");
        sql.SELECT("name");
        sql.SELECT("mobile");
        sql.SELECT("ip_address");
        sql.FROM("hj_query_log");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(QueryLog record) {
        SQL sql = new SQL();
        sql.UPDATE("hj_query_log");
        
        if (record.getLogId() != null) {
            sql.SET("log_id = #{logId,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderNo() != null) {
            sql.SET("order_no = #{orderNo,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getQueryTime() != null) {
            sql.SET("query_time = #{queryTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQueryHis() != null) {
            sql.SET("query_his = #{queryHis,jdbcType=VARCHAR}");
        }
        
        if (record.getQueryHi() != null) {
            sql.SET("query_hi = #{queryHi,jdbcType=VARCHAR}");
        }
        
        if (record.getTimeUsed() != null) {
            sql.SET("time_used = #{timeUsed,jdbcType=INTEGER}");
        }
        
        if (record.getReturnTime() != null) {
            sql.SET("return_time = #{returnTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getInterfaceParentType() != null) {
            sql.SET("interface_parent_type = #{interfaceParentType,jdbcType=VARCHAR}");
        }
        
        if (record.getInterfaceType() != null) {
            sql.SET("interface_type = #{interfaceType,jdbcType=VARCHAR}");
        }
        
        if (record.getState() != null) {
            sql.SET("state = #{state,jdbcType=INTEGER}");
        }
        
        if (record.getIdCard() != null) {
            sql.SET("id_card = #{idCard,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.SET("mobile = #{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getIpAddress() != null) {
            sql.SET("ip_address = #{ipAddress,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, QueryLogExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}