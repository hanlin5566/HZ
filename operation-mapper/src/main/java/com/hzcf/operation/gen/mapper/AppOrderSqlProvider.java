package com.hzcf.operation.gen.mapper;

import com.hzcf.operation.gen.entity.AppOrder;
import com.hzcf.operation.gen.entity.AppOrderExample.Criteria;
import com.hzcf.operation.gen.entity.AppOrderExample.Criterion;
import com.hzcf.operation.gen.entity.AppOrderExample;
import java.util.List;
import org.apache.ibatis.jdbc.SQL;

public class AppOrderSqlProvider {

    public String insertSelective(AppOrder record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("hj_app_order");
        
        if (record.getTaskId() != null) {
            sql.VALUES("task_id", "#{taskId,jdbcType=VARCHAR}");
        }
        
        if (record.getApplicationType() != null) {
            sql.VALUES("application_type", "#{applicationType,jdbcType=INTEGER}");
        }
        
        if (record.getApplicationTime() != null) {
            sql.VALUES("application_time", "#{applicationTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIdCard() != null) {
            sql.VALUES("id_card", "#{idCard,jdbcType=VARCHAR}");
        }
        
        if (record.getDecisionType() != null) {
            sql.VALUES("decision_type", "#{decisionType,jdbcType=TINYINT}");
        }
        
        if (record.getDecisionDesc() != null) {
            sql.VALUES("decision_desc", "#{decisionDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getTimeUsed() != null) {
            sql.VALUES("time_used", "#{timeUsed,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(AppOrderExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("task_id");
        sql.SELECT("application_type");
        sql.SELECT("application_time");
        sql.SELECT("id_card");
        sql.SELECT("decision_type");
        sql.SELECT("decision_desc");
        sql.SELECT("time_used");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.FROM("hj_app_order");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(AppOrder record) {
        SQL sql = new SQL();
        sql.UPDATE("hj_app_order");
        
        if (record.getTaskId() != null) {
            sql.SET("task_id = #{taskId,jdbcType=VARCHAR}");
        }
        
        if (record.getApplicationType() != null) {
            sql.SET("application_type = #{applicationType,jdbcType=INTEGER}");
        }
        
        if (record.getApplicationTime() != null) {
            sql.SET("application_time = #{applicationTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIdCard() != null) {
            sql.SET("id_card = #{idCard,jdbcType=VARCHAR}");
        }
        
        if (record.getDecisionType() != null) {
            sql.SET("decision_type = #{decisionType,jdbcType=TINYINT}");
        }
        
        if (record.getDecisionDesc() != null) {
            sql.SET("decision_desc = #{decisionDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getTimeUsed() != null) {
            sql.SET("time_used = #{timeUsed,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, AppOrderExample example, boolean includeExamplePhrase) {
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