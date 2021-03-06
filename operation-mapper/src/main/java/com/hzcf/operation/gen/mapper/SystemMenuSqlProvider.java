package com.hzcf.operation.gen.mapper;

import com.hzcf.operation.gen.entity.SystemMenu;
import com.hzcf.operation.gen.entity.SystemMenuExample.Criteria;
import com.hzcf.operation.gen.entity.SystemMenuExample.Criterion;
import com.hzcf.operation.gen.entity.SystemMenuExample;
import java.util.List;
import org.apache.ibatis.jdbc.SQL;

public class SystemMenuSqlProvider {

    public String insertSelective(SystemMenu record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("system_menu");

        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }

        if (record.getModuleTitle() != null) {
            sql.VALUES("module_title", "#{moduleTitle,jdbcType=VARCHAR}");
        }

        if (record.getModuleCode() != null) {
            sql.VALUES("module_code", "#{moduleCode,jdbcType=VARCHAR}");
        }

        if (record.getModuleIcon() != null) {
            sql.VALUES("module_icon", "#{moduleIcon,jdbcType=VARCHAR}");
        }

        if (record.getModuleSpread() != null) {
            sql.VALUES("module_spread", "#{moduleSpread,jdbcType=VARCHAR}");
        }

        if (record.getParentId() != null) {
            sql.VALUES("parent_id", "#{parentId,jdbcType=INTEGER}");
        }

        if (record.getCreateUid() != null) {
            sql.VALUES("create_uid", "#{createUid,jdbcType=INTEGER}");
        }

        if (record.getUpdateUid() != null) {
            sql.VALUES("update_uid", "#{updateUid,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=DATE}");
        }

        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=DATE}");
        }

        if (record.getDataStatus() != null) {
            sql.VALUES("data_status", "#{dataStatus,jdbcType=INTEGER}");
        }

        return sql.toString();
    }

    public String selectByExample(SystemMenuExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("module_title");
        sql.SELECT("module_code");
        sql.SELECT("module_icon");
        sql.SELECT("module_spread");
        sql.SELECT("parent_id");
        sql.SELECT("create_uid");
        sql.SELECT("update_uid");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.SELECT("data_status");
        sql.FROM("system_menu");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SystemMenu record) {
        SQL sql = new SQL();
        sql.UPDATE("system_menu");

        if (record.getModuleTitle() != null) {
            sql.SET("module_title = #{moduleTitle,jdbcType=VARCHAR}");
        }

        if (record.getModuleCode() != null) {
            sql.SET("module_code = #{moduleCode,jdbcType=VARCHAR}");
        }

        if (record.getModuleIcon() != null) {
            sql.SET("module_icon = #{moduleIcon,jdbcType=VARCHAR}");
        }

        if (record.getModuleSpread() != null) {
            sql.SET("module_spread = #{moduleSpread,jdbcType=VARCHAR}");
        }

        if (record.getParentId() != null) {
            sql.SET("parent_id = #{parentId,jdbcType=INTEGER}");
        }

        if (record.getCreateUid() != null) {
            sql.SET("create_uid = #{createUid,jdbcType=INTEGER}");
        }

        if (record.getUpdateUid() != null) {
            sql.SET("update_uid = #{updateUid,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=DATE}");
        }

        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=DATE}");
        }

        if (record.getDataStatus() != null) {
            sql.SET("data_status = #{dataStatus,jdbcType=INTEGER}");
        }

        sql.WHERE("id = #{id,jdbcType=INTEGER}");

        return sql.toString();
    }

    protected void applyWhere(SQL sql, SystemMenuExample example, boolean includeExamplePhrase) {
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