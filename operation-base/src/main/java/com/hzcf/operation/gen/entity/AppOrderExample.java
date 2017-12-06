package com.hzcf.operation.gen.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppOrderExample {
    /**
     * hj_app_order
     */
    protected String orderByClause;

    /**
     * hj_app_order
     */
    protected boolean distinct;

    /**
     * hj_app_order
     */
    protected List<Criteria> oredCriteria;

    public AppOrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * hj_app_order 2017-12-06
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLike(String value) {
            addCriterion("task_id like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("task_id not like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<String> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<String> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeIsNull() {
            addCriterion("application_type is null");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeIsNotNull() {
            addCriterion("application_type is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeEqualTo(Integer value) {
            addCriterion("application_type =", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeNotEqualTo(Integer value) {
            addCriterion("application_type <>", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeGreaterThan(Integer value) {
            addCriterion("application_type >", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("application_type >=", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeLessThan(Integer value) {
            addCriterion("application_type <", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeLessThanOrEqualTo(Integer value) {
            addCriterion("application_type <=", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeIn(List<Integer> values) {
            addCriterion("application_type in", values, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeNotIn(List<Integer> values) {
            addCriterion("application_type not in", values, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeBetween(Integer value1, Integer value2) {
            addCriterion("application_type between", value1, value2, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("application_type not between", value1, value2, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeIsNull() {
            addCriterion("application_time is null");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeIsNotNull() {
            addCriterion("application_time is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeEqualTo(Date value) {
            addCriterion("application_time =", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeNotEqualTo(Date value) {
            addCriterion("application_time <>", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeGreaterThan(Date value) {
            addCriterion("application_time >", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("application_time >=", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeLessThan(Date value) {
            addCriterion("application_time <", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeLessThanOrEqualTo(Date value) {
            addCriterion("application_time <=", value, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeIn(List<Date> values) {
            addCriterion("application_time in", values, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeNotIn(List<Date> values) {
            addCriterion("application_time not in", values, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeBetween(Date value1, Date value2) {
            addCriterion("application_time between", value1, value2, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andApplicationTimeNotBetween(Date value1, Date value2) {
            addCriterion("application_time not between", value1, value2, "applicationTime");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNull() {
            addCriterion("id_card is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("id_card is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("id_card =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("id_card <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("id_card >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("id_card >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("id_card <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("id_card <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("id_card like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("id_card not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("id_card in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("id_card not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("id_card between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("id_card not between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andDecisionTypeIsNull() {
            addCriterion("decision_type is null");
            return (Criteria) this;
        }

        public Criteria andDecisionTypeIsNotNull() {
            addCriterion("decision_type is not null");
            return (Criteria) this;
        }

        public Criteria andDecisionTypeEqualTo(Byte value) {
            addCriterion("decision_type =", value, "decisionType");
            return (Criteria) this;
        }

        public Criteria andDecisionTypeNotEqualTo(Byte value) {
            addCriterion("decision_type <>", value, "decisionType");
            return (Criteria) this;
        }

        public Criteria andDecisionTypeGreaterThan(Byte value) {
            addCriterion("decision_type >", value, "decisionType");
            return (Criteria) this;
        }

        public Criteria andDecisionTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("decision_type >=", value, "decisionType");
            return (Criteria) this;
        }

        public Criteria andDecisionTypeLessThan(Byte value) {
            addCriterion("decision_type <", value, "decisionType");
            return (Criteria) this;
        }

        public Criteria andDecisionTypeLessThanOrEqualTo(Byte value) {
            addCriterion("decision_type <=", value, "decisionType");
            return (Criteria) this;
        }

        public Criteria andDecisionTypeIn(List<Byte> values) {
            addCriterion("decision_type in", values, "decisionType");
            return (Criteria) this;
        }

        public Criteria andDecisionTypeNotIn(List<Byte> values) {
            addCriterion("decision_type not in", values, "decisionType");
            return (Criteria) this;
        }

        public Criteria andDecisionTypeBetween(Byte value1, Byte value2) {
            addCriterion("decision_type between", value1, value2, "decisionType");
            return (Criteria) this;
        }

        public Criteria andDecisionTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("decision_type not between", value1, value2, "decisionType");
            return (Criteria) this;
        }

        public Criteria andDecisionDescIsNull() {
            addCriterion("decision_desc is null");
            return (Criteria) this;
        }

        public Criteria andDecisionDescIsNotNull() {
            addCriterion("decision_desc is not null");
            return (Criteria) this;
        }

        public Criteria andDecisionDescEqualTo(String value) {
            addCriterion("decision_desc =", value, "decisionDesc");
            return (Criteria) this;
        }

        public Criteria andDecisionDescNotEqualTo(String value) {
            addCriterion("decision_desc <>", value, "decisionDesc");
            return (Criteria) this;
        }

        public Criteria andDecisionDescGreaterThan(String value) {
            addCriterion("decision_desc >", value, "decisionDesc");
            return (Criteria) this;
        }

        public Criteria andDecisionDescGreaterThanOrEqualTo(String value) {
            addCriterion("decision_desc >=", value, "decisionDesc");
            return (Criteria) this;
        }

        public Criteria andDecisionDescLessThan(String value) {
            addCriterion("decision_desc <", value, "decisionDesc");
            return (Criteria) this;
        }

        public Criteria andDecisionDescLessThanOrEqualTo(String value) {
            addCriterion("decision_desc <=", value, "decisionDesc");
            return (Criteria) this;
        }

        public Criteria andDecisionDescLike(String value) {
            addCriterion("decision_desc like", value, "decisionDesc");
            return (Criteria) this;
        }

        public Criteria andDecisionDescNotLike(String value) {
            addCriterion("decision_desc not like", value, "decisionDesc");
            return (Criteria) this;
        }

        public Criteria andDecisionDescIn(List<String> values) {
            addCriterion("decision_desc in", values, "decisionDesc");
            return (Criteria) this;
        }

        public Criteria andDecisionDescNotIn(List<String> values) {
            addCriterion("decision_desc not in", values, "decisionDesc");
            return (Criteria) this;
        }

        public Criteria andDecisionDescBetween(String value1, String value2) {
            addCriterion("decision_desc between", value1, value2, "decisionDesc");
            return (Criteria) this;
        }

        public Criteria andDecisionDescNotBetween(String value1, String value2) {
            addCriterion("decision_desc not between", value1, value2, "decisionDesc");
            return (Criteria) this;
        }

        public Criteria andTimeUsedIsNull() {
            addCriterion("time_used is null");
            return (Criteria) this;
        }

        public Criteria andTimeUsedIsNotNull() {
            addCriterion("time_used is not null");
            return (Criteria) this;
        }

        public Criteria andTimeUsedEqualTo(BigDecimal value) {
            addCriterion("time_used =", value, "timeUsed");
            return (Criteria) this;
        }

        public Criteria andTimeUsedNotEqualTo(BigDecimal value) {
            addCriterion("time_used <>", value, "timeUsed");
            return (Criteria) this;
        }

        public Criteria andTimeUsedGreaterThan(BigDecimal value) {
            addCriterion("time_used >", value, "timeUsed");
            return (Criteria) this;
        }

        public Criteria andTimeUsedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("time_used >=", value, "timeUsed");
            return (Criteria) this;
        }

        public Criteria andTimeUsedLessThan(BigDecimal value) {
            addCriterion("time_used <", value, "timeUsed");
            return (Criteria) this;
        }

        public Criteria andTimeUsedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("time_used <=", value, "timeUsed");
            return (Criteria) this;
        }

        public Criteria andTimeUsedIn(List<BigDecimal> values) {
            addCriterion("time_used in", values, "timeUsed");
            return (Criteria) this;
        }

        public Criteria andTimeUsedNotIn(List<BigDecimal> values) {
            addCriterion("time_used not in", values, "timeUsed");
            return (Criteria) this;
        }

        public Criteria andTimeUsedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("time_used between", value1, value2, "timeUsed");
            return (Criteria) this;
        }

        public Criteria andTimeUsedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("time_used not between", value1, value2, "timeUsed");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    /**
     * hj_app_order
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * hj_app_order 2017-12-06
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}