package com.hzcf.operation.gen.entity;

import com.hzcf.operation.base.enums.DataStatus;
import com.hzcf.operation.base.enums.DerivedVarStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DerivedVariableExample {
    /**
     * derived_var
     */
    protected String orderByClause;

    /**
     * derived_var
     */
    protected boolean distinct;

    /**
     * derived_var
     */
    protected List<Criteria> oredCriteria;

    public DerivedVariableExample() {
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
     * derived_var 2017-11-24
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

        public Criteria andVarIdIsNull() {
            addCriterion("var_id is null");
            return (Criteria) this;
        }

        public Criteria andVarIdIsNotNull() {
            addCriterion("var_id is not null");
            return (Criteria) this;
        }

        public Criteria andVarIdEqualTo(Integer value) {
            addCriterion("var_id =", value, "varId");
            return (Criteria) this;
        }

        public Criteria andVarIdNotEqualTo(Integer value) {
            addCriterion("var_id <>", value, "varId");
            return (Criteria) this;
        }

        public Criteria andVarIdGreaterThan(Integer value) {
            addCriterion("var_id >", value, "varId");
            return (Criteria) this;
        }

        public Criteria andVarIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("var_id >=", value, "varId");
            return (Criteria) this;
        }

        public Criteria andVarIdLessThan(Integer value) {
            addCriterion("var_id <", value, "varId");
            return (Criteria) this;
        }

        public Criteria andVarIdLessThanOrEqualTo(Integer value) {
            addCriterion("var_id <=", value, "varId");
            return (Criteria) this;
        }

        public Criteria andVarIdIn(List<Integer> values) {
            addCriterion("var_id in", values, "varId");
            return (Criteria) this;
        }

        public Criteria andVarIdNotIn(List<Integer> values) {
            addCriterion("var_id not in", values, "varId");
            return (Criteria) this;
        }

        public Criteria andVarIdBetween(Integer value1, Integer value2) {
            addCriterion("var_id between", value1, value2, "varId");
            return (Criteria) this;
        }

        public Criteria andVarIdNotBetween(Integer value1, Integer value2) {
            addCriterion("var_id not between", value1, value2, "varId");
            return (Criteria) this;
        }

        public Criteria andVarRetNameIsNull() {
            addCriterion("var_ret_name is null");
            return (Criteria) this;
        }

        public Criteria andVarRetNameIsNotNull() {
            addCriterion("var_ret_name is not null");
            return (Criteria) this;
        }

        public Criteria andVarRetNameEqualTo(String value) {
            addCriterion("var_ret_name =", value, "varRetName");
            return (Criteria) this;
        }

        public Criteria andVarRetNameNotEqualTo(String value) {
            addCriterion("var_ret_name <>", value, "varRetName");
            return (Criteria) this;
        }

        public Criteria andVarRetNameGreaterThan(String value) {
            addCriterion("var_ret_name >", value, "varRetName");
            return (Criteria) this;
        }

        public Criteria andVarRetNameGreaterThanOrEqualTo(String value) {
            addCriterion("var_ret_name >=", value, "varRetName");
            return (Criteria) this;
        }

        public Criteria andVarRetNameLessThan(String value) {
            addCriterion("var_ret_name <", value, "varRetName");
            return (Criteria) this;
        }

        public Criteria andVarRetNameLessThanOrEqualTo(String value) {
            addCriterion("var_ret_name <=", value, "varRetName");
            return (Criteria) this;
        }

        public Criteria andVarRetNameLike(String value) {
            addCriterion("var_ret_name like", value, "varRetName");
            return (Criteria) this;
        }

        public Criteria andVarRetNameNotLike(String value) {
            addCriterion("var_ret_name not like", value, "varRetName");
            return (Criteria) this;
        }

        public Criteria andVarRetNameIn(List<String> values) {
            addCriterion("var_ret_name in", values, "varRetName");
            return (Criteria) this;
        }

        public Criteria andVarRetNameNotIn(List<String> values) {
            addCriterion("var_ret_name not in", values, "varRetName");
            return (Criteria) this;
        }

        public Criteria andVarRetNameBetween(String value1, String value2) {
            addCriterion("var_ret_name between", value1, value2, "varRetName");
            return (Criteria) this;
        }

        public Criteria andVarRetNameNotBetween(String value1, String value2) {
            addCriterion("var_ret_name not between", value1, value2, "varRetName");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andVarRecNameIsNull() {
            addCriterion("var_rec_name is null");
            return (Criteria) this;
        }

        public Criteria andVarRecNameIsNotNull() {
            addCriterion("var_rec_name is not null");
            return (Criteria) this;
        }

        public Criteria andVarRecNameEqualTo(String value) {
            addCriterion("var_rec_name =", value, "varRecName");
            return (Criteria) this;
        }

        public Criteria andVarRecNameNotEqualTo(String value) {
            addCriterion("var_rec_name <>", value, "varRecName");
            return (Criteria) this;
        }

        public Criteria andVarRecNameGreaterThan(String value) {
            addCriterion("var_rec_name >", value, "varRecName");
            return (Criteria) this;
        }

        public Criteria andVarRecNameGreaterThanOrEqualTo(String value) {
            addCriterion("var_rec_name >=", value, "varRecName");
            return (Criteria) this;
        }

        public Criteria andVarRecNameLessThan(String value) {
            addCriterion("var_rec_name <", value, "varRecName");
            return (Criteria) this;
        }

        public Criteria andVarRecNameLessThanOrEqualTo(String value) {
            addCriterion("var_rec_name <=", value, "varRecName");
            return (Criteria) this;
        }

        public Criteria andVarRecNameLike(String value) {
            addCriterion("var_rec_name like", value, "varRecName");
            return (Criteria) this;
        }

        public Criteria andVarRecNameNotLike(String value) {
            addCriterion("var_rec_name not like", value, "varRecName");
            return (Criteria) this;
        }

        public Criteria andVarRecNameIn(List<String> values) {
            addCriterion("var_rec_name in", values, "varRecName");
            return (Criteria) this;
        }

        public Criteria andVarRecNameNotIn(List<String> values) {
            addCriterion("var_rec_name not in", values, "varRecName");
            return (Criteria) this;
        }

        public Criteria andVarRecNameBetween(String value1, String value2) {
            addCriterion("var_rec_name between", value1, value2, "varRecName");
            return (Criteria) this;
        }

        public Criteria andVarRecNameNotBetween(String value1, String value2) {
            addCriterion("var_rec_name not between", value1, value2, "varRecName");
            return (Criteria) this;
        }

        public Criteria andVarTypeIsNull() {
            addCriterion("var_type is null");
            return (Criteria) this;
        }

        public Criteria andVarTypeIsNotNull() {
            addCriterion("var_type is not null");
            return (Criteria) this;
        }

        public Criteria andVarTypeEqualTo(Integer value) {
            addCriterion("var_type =", value, "varType");
            return (Criteria) this;
        }

        public Criteria andVarTypeNotEqualTo(Integer value) {
            addCriterion("var_type <>", value, "varType");
            return (Criteria) this;
        }

        public Criteria andVarTypeGreaterThan(Integer value) {
            addCriterion("var_type >", value, "varType");
            return (Criteria) this;
        }

        public Criteria andVarTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("var_type >=", value, "varType");
            return (Criteria) this;
        }

        public Criteria andVarTypeLessThan(Integer value) {
            addCriterion("var_type <", value, "varType");
            return (Criteria) this;
        }

        public Criteria andVarTypeLessThanOrEqualTo(Integer value) {
            addCriterion("var_type <=", value, "varType");
            return (Criteria) this;
        }

        public Criteria andVarTypeIn(List<Integer> values) {
            addCriterion("var_type in", values, "varType");
            return (Criteria) this;
        }

        public Criteria andVarTypeNotIn(List<Integer> values) {
            addCriterion("var_type not in", values, "varType");
            return (Criteria) this;
        }

        public Criteria andVarTypeBetween(Integer value1, Integer value2) {
            addCriterion("var_type between", value1, value2, "varType");
            return (Criteria) this;
        }

        public Criteria andVarTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("var_type not between", value1, value2, "varType");
            return (Criteria) this;
        }

        public Criteria andVarDataTypeIsNull() {
            addCriterion("var_data_type is null");
            return (Criteria) this;
        }

        public Criteria andVarDataTypeIsNotNull() {
            addCriterion("var_data_type is not null");
            return (Criteria) this;
        }

        public Criteria andVarDataTypeEqualTo(String value) {
            addCriterion("var_data_type =", value, "varDataType");
            return (Criteria) this;
        }

        public Criteria andVarDataTypeNotEqualTo(String value) {
            addCriterion("var_data_type <>", value, "varDataType");
            return (Criteria) this;
        }

        public Criteria andVarDataTypeGreaterThan(String value) {
            addCriterion("var_data_type >", value, "varDataType");
            return (Criteria) this;
        }

        public Criteria andVarDataTypeGreaterThanOrEqualTo(String value) {
            addCriterion("var_data_type >=", value, "varDataType");
            return (Criteria) this;
        }

        public Criteria andVarDataTypeLessThan(String value) {
            addCriterion("var_data_type <", value, "varDataType");
            return (Criteria) this;
        }

        public Criteria andVarDataTypeLessThanOrEqualTo(String value) {
            addCriterion("var_data_type <=", value, "varDataType");
            return (Criteria) this;
        }

        public Criteria andVarDataTypeLike(String value) {
            addCriterion("var_data_type like", value, "varDataType");
            return (Criteria) this;
        }

        public Criteria andVarDataTypeNotLike(String value) {
            addCriterion("var_data_type not like", value, "varDataType");
            return (Criteria) this;
        }

        public Criteria andVarDataTypeIn(List<String> values) {
            addCriterion("var_data_type in", values, "varDataType");
            return (Criteria) this;
        }

        public Criteria andVarDataTypeNotIn(List<String> values) {
            addCriterion("var_data_type not in", values, "varDataType");
            return (Criteria) this;
        }

        public Criteria andVarDataTypeBetween(String value1, String value2) {
            addCriterion("var_data_type between", value1, value2, "varDataType");
            return (Criteria) this;
        }

        public Criteria andVarDataTypeNotBetween(String value1, String value2) {
            addCriterion("var_data_type not between", value1, value2, "varDataType");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIsNull() {
            addCriterion("default_value is null");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIsNotNull() {
            addCriterion("default_value is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultValueEqualTo(String value) {
            addCriterion("default_value =", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotEqualTo(String value) {
            addCriterion("default_value <>", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueGreaterThan(String value) {
            addCriterion("default_value >", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueGreaterThanOrEqualTo(String value) {
            addCriterion("default_value >=", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLessThan(String value) {
            addCriterion("default_value <", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLessThanOrEqualTo(String value) {
            addCriterion("default_value <=", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLike(String value) {
            addCriterion("default_value like", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotLike(String value) {
            addCriterion("default_value not like", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIn(List<String> values) {
            addCriterion("default_value in", values, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotIn(List<String> values) {
            addCriterion("default_value not in", values, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueBetween(String value1, String value2) {
            addCriterion("default_value between", value1, value2, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotBetween(String value1, String value2) {
            addCriterion("default_value not between", value1, value2, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andVarGroupIdIsNull() {
            addCriterion("var_group_id is null");
            return (Criteria) this;
        }

        public Criteria andVarGroupIdIsNotNull() {
            addCriterion("var_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andVarGroupIdEqualTo(Integer value) {
            addCriterion("var_group_id =", value, "varGroupId");
            return (Criteria) this;
        }

        public Criteria andVarGroupIdNotEqualTo(Integer value) {
            addCriterion("var_group_id <>", value, "varGroupId");
            return (Criteria) this;
        }

        public Criteria andVarGroupIdGreaterThan(Integer value) {
            addCriterion("var_group_id >", value, "varGroupId");
            return (Criteria) this;
        }

        public Criteria andVarGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("var_group_id >=", value, "varGroupId");
            return (Criteria) this;
        }

        public Criteria andVarGroupIdLessThan(Integer value) {
            addCriterion("var_group_id <", value, "varGroupId");
            return (Criteria) this;
        }

        public Criteria andVarGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("var_group_id <=", value, "varGroupId");
            return (Criteria) this;
        }

        public Criteria andVarGroupIdIn(List<Integer> values) {
            addCriterion("var_group_id in", values, "varGroupId");
            return (Criteria) this;
        }

        public Criteria andVarGroupIdNotIn(List<Integer> values) {
            addCriterion("var_group_id not in", values, "varGroupId");
            return (Criteria) this;
        }

        public Criteria andVarGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("var_group_id between", value1, value2, "varGroupId");
            return (Criteria) this;
        }

        public Criteria andVarGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("var_group_id not between", value1, value2, "varGroupId");
            return (Criteria) this;
        }

        public Criteria andClazzNameIsNull() {
            addCriterion("clazz_name is null");
            return (Criteria) this;
        }

        public Criteria andClazzNameIsNotNull() {
            addCriterion("clazz_name is not null");
            return (Criteria) this;
        }

        public Criteria andClazzNameEqualTo(String value) {
            addCriterion("clazz_name =", value, "clazzName");
            return (Criteria) this;
        }

        public Criteria andClazzNameNotEqualTo(String value) {
            addCriterion("clazz_name <>", value, "clazzName");
            return (Criteria) this;
        }

        public Criteria andClazzNameGreaterThan(String value) {
            addCriterion("clazz_name >", value, "clazzName");
            return (Criteria) this;
        }

        public Criteria andClazzNameGreaterThanOrEqualTo(String value) {
            addCriterion("clazz_name >=", value, "clazzName");
            return (Criteria) this;
        }

        public Criteria andClazzNameLessThan(String value) {
            addCriterion("clazz_name <", value, "clazzName");
            return (Criteria) this;
        }

        public Criteria andClazzNameLessThanOrEqualTo(String value) {
            addCriterion("clazz_name <=", value, "clazzName");
            return (Criteria) this;
        }

        public Criteria andClazzNameLike(String value) {
            addCriterion("clazz_name like", value, "clazzName");
            return (Criteria) this;
        }

        public Criteria andClazzNameNotLike(String value) {
            addCriterion("clazz_name not like", value, "clazzName");
            return (Criteria) this;
        }

        public Criteria andClazzNameIn(List<String> values) {
            addCriterion("clazz_name in", values, "clazzName");
            return (Criteria) this;
        }

        public Criteria andClazzNameNotIn(List<String> values) {
            addCriterion("clazz_name not in", values, "clazzName");
            return (Criteria) this;
        }

        public Criteria andClazzNameBetween(String value1, String value2) {
            addCriterion("clazz_name between", value1, value2, "clazzName");
            return (Criteria) this;
        }

        public Criteria andClazzNameNotBetween(String value1, String value2) {
            addCriterion("clazz_name not between", value1, value2, "clazzName");
            return (Criteria) this;
        }

        public Criteria andClazzPathIsNull() {
            addCriterion("clazz_path is null");
            return (Criteria) this;
        }

        public Criteria andClazzPathIsNotNull() {
            addCriterion("clazz_path is not null");
            return (Criteria) this;
        }

        public Criteria andClazzPathEqualTo(String value) {
            addCriterion("clazz_path =", value, "clazzPath");
            return (Criteria) this;
        }

        public Criteria andClazzPathNotEqualTo(String value) {
            addCriterion("clazz_path <>", value, "clazzPath");
            return (Criteria) this;
        }

        public Criteria andClazzPathGreaterThan(String value) {
            addCriterion("clazz_path >", value, "clazzPath");
            return (Criteria) this;
        }

        public Criteria andClazzPathGreaterThanOrEqualTo(String value) {
            addCriterion("clazz_path >=", value, "clazzPath");
            return (Criteria) this;
        }

        public Criteria andClazzPathLessThan(String value) {
            addCriterion("clazz_path <", value, "clazzPath");
            return (Criteria) this;
        }

        public Criteria andClazzPathLessThanOrEqualTo(String value) {
            addCriterion("clazz_path <=", value, "clazzPath");
            return (Criteria) this;
        }

        public Criteria andClazzPathLike(String value) {
            addCriterion("clazz_path like", value, "clazzPath");
            return (Criteria) this;
        }

        public Criteria andClazzPathNotLike(String value) {
            addCriterion("clazz_path not like", value, "clazzPath");
            return (Criteria) this;
        }

        public Criteria andClazzPathIn(List<String> values) {
            addCriterion("clazz_path in", values, "clazzPath");
            return (Criteria) this;
        }

        public Criteria andClazzPathNotIn(List<String> values) {
            addCriterion("clazz_path not in", values, "clazzPath");
            return (Criteria) this;
        }

        public Criteria andClazzPathBetween(String value1, String value2) {
            addCriterion("clazz_path between", value1, value2, "clazzPath");
            return (Criteria) this;
        }

        public Criteria andClazzPathNotBetween(String value1, String value2) {
            addCriterion("clazz_path not between", value1, value2, "clazzPath");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(DerivedVarStatus value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(DerivedVarStatus value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(DerivedVarStatus value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(DerivedVarStatus value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(DerivedVarStatus value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(DerivedVarStatus value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<DerivedVarStatus> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<DerivedVarStatus> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(DerivedVarStatus value1, DerivedVarStatus value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(DerivedVarStatus value1, DerivedVarStatus value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andDeployTimeIsNull() {
            addCriterion("deploy_time is null");
            return (Criteria) this;
        }

        public Criteria andDeployTimeIsNotNull() {
            addCriterion("deploy_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeployTimeEqualTo(Date value) {
            addCriterion("deploy_time =", value, "deployTime");
            return (Criteria) this;
        }

        public Criteria andDeployTimeNotEqualTo(Date value) {
            addCriterion("deploy_time <>", value, "deployTime");
            return (Criteria) this;
        }

        public Criteria andDeployTimeGreaterThan(Date value) {
            addCriterion("deploy_time >", value, "deployTime");
            return (Criteria) this;
        }

        public Criteria andDeployTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deploy_time >=", value, "deployTime");
            return (Criteria) this;
        }

        public Criteria andDeployTimeLessThan(Date value) {
            addCriterion("deploy_time <", value, "deployTime");
            return (Criteria) this;
        }

        public Criteria andDeployTimeLessThanOrEqualTo(Date value) {
            addCriterion("deploy_time <=", value, "deployTime");
            return (Criteria) this;
        }

        public Criteria andDeployTimeIn(List<Date> values) {
            addCriterion("deploy_time in", values, "deployTime");
            return (Criteria) this;
        }

        public Criteria andDeployTimeNotIn(List<Date> values) {
            addCriterion("deploy_time not in", values, "deployTime");
            return (Criteria) this;
        }

        public Criteria andDeployTimeBetween(Date value1, Date value2) {
            addCriterion("deploy_time between", value1, value2, "deployTime");
            return (Criteria) this;
        }

        public Criteria andDeployTimeNotBetween(Date value1, Date value2) {
            addCriterion("deploy_time not between", value1, value2, "deployTime");
            return (Criteria) this;
        }

        public Criteria andDataStatusIsNull() {
            addCriterion("data_status is null");
            return (Criteria) this;
        }

        public Criteria andDataStatusIsNotNull() {
            addCriterion("data_status is not null");
            return (Criteria) this;
        }

        public Criteria andDataStatusEqualTo(DataStatus value) {
            addCriterion("data_status =", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotEqualTo(DataStatus value) {
            addCriterion("data_status <>", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusGreaterThan(DataStatus value) {
            addCriterion("data_status >", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusGreaterThanOrEqualTo(DataStatus value) {
            addCriterion("data_status >=", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusLessThan(DataStatus value) {
            addCriterion("data_status <", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusLessThanOrEqualTo(DataStatus value) {
            addCriterion("data_status <=", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusIn(List<DataStatus> values) {
            addCriterion("data_status in", values, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotIn(List<DataStatus> values) {
            addCriterion("data_status not in", values, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusBetween(DataStatus value1, DataStatus value2) {
            addCriterion("data_status between", value1, value2, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotBetween(DataStatus value1, DataStatus value2) {
            addCriterion("data_status not between", value1, value2, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andCreateUidIsNull() {
            addCriterion("create_uid is null");
            return (Criteria) this;
        }

        public Criteria andCreateUidIsNotNull() {
            addCriterion("create_uid is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUidEqualTo(Integer value) {
            addCriterion("create_uid =", value, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidNotEqualTo(Integer value) {
            addCriterion("create_uid <>", value, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidGreaterThan(Integer value) {
            addCriterion("create_uid >", value, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_uid >=", value, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidLessThan(Integer value) {
            addCriterion("create_uid <", value, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidLessThanOrEqualTo(Integer value) {
            addCriterion("create_uid <=", value, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidIn(List<Integer> values) {
            addCriterion("create_uid in", values, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidNotIn(List<Integer> values) {
            addCriterion("create_uid not in", values, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidBetween(Integer value1, Integer value2) {
            addCriterion("create_uid between", value1, value2, "createUid");
            return (Criteria) this;
        }

        public Criteria andCreateUidNotBetween(Integer value1, Integer value2) {
            addCriterion("create_uid not between", value1, value2, "createUid");
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

        public Criteria andUpdateUidIsNull() {
            addCriterion("update_uid is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUidIsNotNull() {
            addCriterion("update_uid is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUidEqualTo(Integer value) {
            addCriterion("update_uid =", value, "updateUid");
            return (Criteria) this;
        }

        public Criteria andUpdateUidNotEqualTo(Integer value) {
            addCriterion("update_uid <>", value, "updateUid");
            return (Criteria) this;
        }

        public Criteria andUpdateUidGreaterThan(Integer value) {
            addCriterion("update_uid >", value, "updateUid");
            return (Criteria) this;
        }

        public Criteria andUpdateUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_uid >=", value, "updateUid");
            return (Criteria) this;
        }

        public Criteria andUpdateUidLessThan(Integer value) {
            addCriterion("update_uid <", value, "updateUid");
            return (Criteria) this;
        }

        public Criteria andUpdateUidLessThanOrEqualTo(Integer value) {
            addCriterion("update_uid <=", value, "updateUid");
            return (Criteria) this;
        }

        public Criteria andUpdateUidIn(List<Integer> values) {
            addCriterion("update_uid in", values, "updateUid");
            return (Criteria) this;
        }

        public Criteria andUpdateUidNotIn(List<Integer> values) {
            addCriterion("update_uid not in", values, "updateUid");
            return (Criteria) this;
        }

        public Criteria andUpdateUidBetween(Integer value1, Integer value2) {
            addCriterion("update_uid between", value1, value2, "updateUid");
            return (Criteria) this;
        }

        public Criteria andUpdateUidNotBetween(Integer value1, Integer value2) {
            addCriterion("update_uid not between", value1, value2, "updateUid");
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
     * derived_var
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * derived_var 2017-11-24
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