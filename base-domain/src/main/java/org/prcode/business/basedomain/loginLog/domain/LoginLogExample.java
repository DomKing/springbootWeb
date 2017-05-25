package org.prcode.business.basedomain.loginLog.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoginLogExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_login_log
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_login_log
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_login_log
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login_log
     *
     * @mbg.generated
     */
    public LoginLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login_log
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login_log
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login_log
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login_log
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login_log
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login_log
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login_log
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login_log
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login_log
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login_log
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_login_log
     *
     * @mbg.generated
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
            addCriterion("loginLog.f_id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("loginLog.f_id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("loginLog.f_id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("loginLog.f_id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("loginLog.f_id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("loginLog.f_id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("loginLog.f_id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("loginLog.f_id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("loginLog.f_id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("loginLog.f_id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("loginLog.f_id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("loginLog.f_id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("loginLog.f_id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("loginLog.f_id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("loginLog.f_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("loginLog.f_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("loginLog.f_user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("loginLog.f_user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("loginLog.f_user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("loginLog.f_user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("loginLog.f_user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("loginLog.f_user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("loginLog.f_user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("loginLog.f_user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("loginLog.f_user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("loginLog.f_user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("loginLog.f_user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("loginLog.f_user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserAccountIsNull() {
            addCriterion("loginLog.f_user_account is null");
            return (Criteria) this;
        }

        public Criteria andUserAccountIsNotNull() {
            addCriterion("loginLog.f_user_account is not null");
            return (Criteria) this;
        }

        public Criteria andUserAccountEqualTo(String value) {
            addCriterion("loginLog.f_user_account =", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotEqualTo(String value) {
            addCriterion("loginLog.f_user_account <>", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountGreaterThan(String value) {
            addCriterion("loginLog.f_user_account >", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountGreaterThanOrEqualTo(String value) {
            addCriterion("loginLog.f_user_account >=", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLessThan(String value) {
            addCriterion("loginLog.f_user_account <", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLessThanOrEqualTo(String value) {
            addCriterion("loginLog.f_user_account <=", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLike(String value) {
            addCriterion("loginLog.f_user_account like", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotLike(String value) {
            addCriterion("loginLog.f_user_account not like", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountIn(List<String> values) {
            addCriterion("loginLog.f_user_account in", values, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotIn(List<String> values) {
            addCriterion("loginLog.f_user_account not in", values, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountBetween(String value1, String value2) {
            addCriterion("loginLog.f_user_account between", value1, value2, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotBetween(String value1, String value2) {
            addCriterion("loginLog.f_user_account not between", value1, value2, "userAccount");
            return (Criteria) this;
        }

        public Criteria andSystemCodeIsNull() {
            addCriterion("loginLog.f_system_code is null");
            return (Criteria) this;
        }

        public Criteria andSystemCodeIsNotNull() {
            addCriterion("loginLog.f_system_code is not null");
            return (Criteria) this;
        }

        public Criteria andSystemCodeEqualTo(String value) {
            addCriterion("loginLog.f_system_code =", value, "systemCode");
            return (Criteria) this;
        }

        public Criteria andSystemCodeNotEqualTo(String value) {
            addCriterion("loginLog.f_system_code <>", value, "systemCode");
            return (Criteria) this;
        }

        public Criteria andSystemCodeGreaterThan(String value) {
            addCriterion("loginLog.f_system_code >", value, "systemCode");
            return (Criteria) this;
        }

        public Criteria andSystemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("loginLog.f_system_code >=", value, "systemCode");
            return (Criteria) this;
        }

        public Criteria andSystemCodeLessThan(String value) {
            addCriterion("loginLog.f_system_code <", value, "systemCode");
            return (Criteria) this;
        }

        public Criteria andSystemCodeLessThanOrEqualTo(String value) {
            addCriterion("loginLog.f_system_code <=", value, "systemCode");
            return (Criteria) this;
        }

        public Criteria andSystemCodeLike(String value) {
            addCriterion("loginLog.f_system_code like", value, "systemCode");
            return (Criteria) this;
        }

        public Criteria andSystemCodeNotLike(String value) {
            addCriterion("loginLog.f_system_code not like", value, "systemCode");
            return (Criteria) this;
        }

        public Criteria andSystemCodeIn(List<String> values) {
            addCriterion("loginLog.f_system_code in", values, "systemCode");
            return (Criteria) this;
        }

        public Criteria andSystemCodeNotIn(List<String> values) {
            addCriterion("loginLog.f_system_code not in", values, "systemCode");
            return (Criteria) this;
        }

        public Criteria andSystemCodeBetween(String value1, String value2) {
            addCriterion("loginLog.f_system_code between", value1, value2, "systemCode");
            return (Criteria) this;
        }

        public Criteria andSystemCodeNotBetween(String value1, String value2) {
            addCriterion("loginLog.f_system_code not between", value1, value2, "systemCode");
            return (Criteria) this;
        }

        public Criteria andSysAddTimeIsNull() {
            addCriterion("loginLog.f_sys_add_time is null");
            return (Criteria) this;
        }

        public Criteria andSysAddTimeIsNotNull() {
            addCriterion("loginLog.f_sys_add_time is not null");
            return (Criteria) this;
        }

        public Criteria andSysAddTimeEqualTo(Date value) {
            addCriterion("loginLog.f_sys_add_time =", value, "sysAddTime");
            return (Criteria) this;
        }

        public Criteria andSysAddTimeNotEqualTo(Date value) {
            addCriterion("loginLog.f_sys_add_time <>", value, "sysAddTime");
            return (Criteria) this;
        }

        public Criteria andSysAddTimeGreaterThan(Date value) {
            addCriterion("loginLog.f_sys_add_time >", value, "sysAddTime");
            return (Criteria) this;
        }

        public Criteria andSysAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("loginLog.f_sys_add_time >=", value, "sysAddTime");
            return (Criteria) this;
        }

        public Criteria andSysAddTimeLessThan(Date value) {
            addCriterion("loginLog.f_sys_add_time <", value, "sysAddTime");
            return (Criteria) this;
        }

        public Criteria andSysAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("loginLog.f_sys_add_time <=", value, "sysAddTime");
            return (Criteria) this;
        }

        public Criteria andSysAddTimeIn(List<Date> values) {
            addCriterion("loginLog.f_sys_add_time in", values, "sysAddTime");
            return (Criteria) this;
        }

        public Criteria andSysAddTimeNotIn(List<Date> values) {
            addCriterion("loginLog.f_sys_add_time not in", values, "sysAddTime");
            return (Criteria) this;
        }

        public Criteria andSysAddTimeBetween(Date value1, Date value2) {
            addCriterion("loginLog.f_sys_add_time between", value1, value2, "sysAddTime");
            return (Criteria) this;
        }

        public Criteria andSysAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("loginLog.f_sys_add_time not between", value1, value2, "sysAddTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdTimeIsNull() {
            addCriterion("loginLog.f_sys_upd_time is null");
            return (Criteria) this;
        }

        public Criteria andSysUpdTimeIsNotNull() {
            addCriterion("loginLog.f_sys_upd_time is not null");
            return (Criteria) this;
        }

        public Criteria andSysUpdTimeEqualTo(Date value) {
            addCriterion("loginLog.f_sys_upd_time =", value, "sysUpdTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdTimeNotEqualTo(Date value) {
            addCriterion("loginLog.f_sys_upd_time <>", value, "sysUpdTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdTimeGreaterThan(Date value) {
            addCriterion("loginLog.f_sys_upd_time >", value, "sysUpdTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("loginLog.f_sys_upd_time >=", value, "sysUpdTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdTimeLessThan(Date value) {
            addCriterion("loginLog.f_sys_upd_time <", value, "sysUpdTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdTimeLessThanOrEqualTo(Date value) {
            addCriterion("loginLog.f_sys_upd_time <=", value, "sysUpdTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdTimeIn(List<Date> values) {
            addCriterion("loginLog.f_sys_upd_time in", values, "sysUpdTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdTimeNotIn(List<Date> values) {
            addCriterion("loginLog.f_sys_upd_time not in", values, "sysUpdTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdTimeBetween(Date value1, Date value2) {
            addCriterion("loginLog.f_sys_upd_time between", value1, value2, "sysUpdTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdTimeNotBetween(Date value1, Date value2) {
            addCriterion("loginLog.f_sys_upd_time not between", value1, value2, "sysUpdTime");
            return (Criteria) this;
        }

        public Criteria andSysDelTimeIsNull() {
            addCriterion("loginLog.f_sys_del_time is null");
            return (Criteria) this;
        }

        public Criteria andSysDelTimeIsNotNull() {
            addCriterion("loginLog.f_sys_del_time is not null");
            return (Criteria) this;
        }

        public Criteria andSysDelTimeEqualTo(Date value) {
            addCriterion("loginLog.f_sys_del_time =", value, "sysDelTime");
            return (Criteria) this;
        }

        public Criteria andSysDelTimeNotEqualTo(Date value) {
            addCriterion("loginLog.f_sys_del_time <>", value, "sysDelTime");
            return (Criteria) this;
        }

        public Criteria andSysDelTimeGreaterThan(Date value) {
            addCriterion("loginLog.f_sys_del_time >", value, "sysDelTime");
            return (Criteria) this;
        }

        public Criteria andSysDelTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("loginLog.f_sys_del_time >=", value, "sysDelTime");
            return (Criteria) this;
        }

        public Criteria andSysDelTimeLessThan(Date value) {
            addCriterion("loginLog.f_sys_del_time <", value, "sysDelTime");
            return (Criteria) this;
        }

        public Criteria andSysDelTimeLessThanOrEqualTo(Date value) {
            addCriterion("loginLog.f_sys_del_time <=", value, "sysDelTime");
            return (Criteria) this;
        }

        public Criteria andSysDelTimeIn(List<Date> values) {
            addCriterion("loginLog.f_sys_del_time in", values, "sysDelTime");
            return (Criteria) this;
        }

        public Criteria andSysDelTimeNotIn(List<Date> values) {
            addCriterion("loginLog.f_sys_del_time not in", values, "sysDelTime");
            return (Criteria) this;
        }

        public Criteria andSysDelTimeBetween(Date value1, Date value2) {
            addCriterion("loginLog.f_sys_del_time between", value1, value2, "sysDelTime");
            return (Criteria) this;
        }

        public Criteria andSysDelTimeNotBetween(Date value1, Date value2) {
            addCriterion("loginLog.f_sys_del_time not between", value1, value2, "sysDelTime");
            return (Criteria) this;
        }

        public Criteria andSysAddUserIsNull() {
            addCriterion("loginLog.f_sys_add_user is null");
            return (Criteria) this;
        }

        public Criteria andSysAddUserIsNotNull() {
            addCriterion("loginLog.f_sys_add_user is not null");
            return (Criteria) this;
        }

        public Criteria andSysAddUserEqualTo(String value) {
            addCriterion("loginLog.f_sys_add_user =", value, "sysAddUser");
            return (Criteria) this;
        }

        public Criteria andSysAddUserNotEqualTo(String value) {
            addCriterion("loginLog.f_sys_add_user <>", value, "sysAddUser");
            return (Criteria) this;
        }

        public Criteria andSysAddUserGreaterThan(String value) {
            addCriterion("loginLog.f_sys_add_user >", value, "sysAddUser");
            return (Criteria) this;
        }

        public Criteria andSysAddUserGreaterThanOrEqualTo(String value) {
            addCriterion("loginLog.f_sys_add_user >=", value, "sysAddUser");
            return (Criteria) this;
        }

        public Criteria andSysAddUserLessThan(String value) {
            addCriterion("loginLog.f_sys_add_user <", value, "sysAddUser");
            return (Criteria) this;
        }

        public Criteria andSysAddUserLessThanOrEqualTo(String value) {
            addCriterion("loginLog.f_sys_add_user <=", value, "sysAddUser");
            return (Criteria) this;
        }

        public Criteria andSysAddUserLike(String value) {
            addCriterion("loginLog.f_sys_add_user like", value, "sysAddUser");
            return (Criteria) this;
        }

        public Criteria andSysAddUserNotLike(String value) {
            addCriterion("loginLog.f_sys_add_user not like", value, "sysAddUser");
            return (Criteria) this;
        }

        public Criteria andSysAddUserIn(List<String> values) {
            addCriterion("loginLog.f_sys_add_user in", values, "sysAddUser");
            return (Criteria) this;
        }

        public Criteria andSysAddUserNotIn(List<String> values) {
            addCriterion("loginLog.f_sys_add_user not in", values, "sysAddUser");
            return (Criteria) this;
        }

        public Criteria andSysAddUserBetween(String value1, String value2) {
            addCriterion("loginLog.f_sys_add_user between", value1, value2, "sysAddUser");
            return (Criteria) this;
        }

        public Criteria andSysAddUserNotBetween(String value1, String value2) {
            addCriterion("loginLog.f_sys_add_user not between", value1, value2, "sysAddUser");
            return (Criteria) this;
        }

        public Criteria andSysUpdUserIsNull() {
            addCriterion("loginLog.f_sys_upd_user is null");
            return (Criteria) this;
        }

        public Criteria andSysUpdUserIsNotNull() {
            addCriterion("loginLog.f_sys_upd_user is not null");
            return (Criteria) this;
        }

        public Criteria andSysUpdUserEqualTo(String value) {
            addCriterion("loginLog.f_sys_upd_user =", value, "sysUpdUser");
            return (Criteria) this;
        }

        public Criteria andSysUpdUserNotEqualTo(String value) {
            addCriterion("loginLog.f_sys_upd_user <>", value, "sysUpdUser");
            return (Criteria) this;
        }

        public Criteria andSysUpdUserGreaterThan(String value) {
            addCriterion("loginLog.f_sys_upd_user >", value, "sysUpdUser");
            return (Criteria) this;
        }

        public Criteria andSysUpdUserGreaterThanOrEqualTo(String value) {
            addCriterion("loginLog.f_sys_upd_user >=", value, "sysUpdUser");
            return (Criteria) this;
        }

        public Criteria andSysUpdUserLessThan(String value) {
            addCriterion("loginLog.f_sys_upd_user <", value, "sysUpdUser");
            return (Criteria) this;
        }

        public Criteria andSysUpdUserLessThanOrEqualTo(String value) {
            addCriterion("loginLog.f_sys_upd_user <=", value, "sysUpdUser");
            return (Criteria) this;
        }

        public Criteria andSysUpdUserLike(String value) {
            addCriterion("loginLog.f_sys_upd_user like", value, "sysUpdUser");
            return (Criteria) this;
        }

        public Criteria andSysUpdUserNotLike(String value) {
            addCriterion("loginLog.f_sys_upd_user not like", value, "sysUpdUser");
            return (Criteria) this;
        }

        public Criteria andSysUpdUserIn(List<String> values) {
            addCriterion("loginLog.f_sys_upd_user in", values, "sysUpdUser");
            return (Criteria) this;
        }

        public Criteria andSysUpdUserNotIn(List<String> values) {
            addCriterion("loginLog.f_sys_upd_user not in", values, "sysUpdUser");
            return (Criteria) this;
        }

        public Criteria andSysUpdUserBetween(String value1, String value2) {
            addCriterion("loginLog.f_sys_upd_user between", value1, value2, "sysUpdUser");
            return (Criteria) this;
        }

        public Criteria andSysUpdUserNotBetween(String value1, String value2) {
            addCriterion("loginLog.f_sys_upd_user not between", value1, value2, "sysUpdUser");
            return (Criteria) this;
        }

        public Criteria andSysDelUserIsNull() {
            addCriterion("loginLog.f_sys_del_user is null");
            return (Criteria) this;
        }

        public Criteria andSysDelUserIsNotNull() {
            addCriterion("loginLog.f_sys_del_user is not null");
            return (Criteria) this;
        }

        public Criteria andSysDelUserEqualTo(String value) {
            addCriterion("loginLog.f_sys_del_user =", value, "sysDelUser");
            return (Criteria) this;
        }

        public Criteria andSysDelUserNotEqualTo(String value) {
            addCriterion("loginLog.f_sys_del_user <>", value, "sysDelUser");
            return (Criteria) this;
        }

        public Criteria andSysDelUserGreaterThan(String value) {
            addCriterion("loginLog.f_sys_del_user >", value, "sysDelUser");
            return (Criteria) this;
        }

        public Criteria andSysDelUserGreaterThanOrEqualTo(String value) {
            addCriterion("loginLog.f_sys_del_user >=", value, "sysDelUser");
            return (Criteria) this;
        }

        public Criteria andSysDelUserLessThan(String value) {
            addCriterion("loginLog.f_sys_del_user <", value, "sysDelUser");
            return (Criteria) this;
        }

        public Criteria andSysDelUserLessThanOrEqualTo(String value) {
            addCriterion("loginLog.f_sys_del_user <=", value, "sysDelUser");
            return (Criteria) this;
        }

        public Criteria andSysDelUserLike(String value) {
            addCriterion("loginLog.f_sys_del_user like", value, "sysDelUser");
            return (Criteria) this;
        }

        public Criteria andSysDelUserNotLike(String value) {
            addCriterion("loginLog.f_sys_del_user not like", value, "sysDelUser");
            return (Criteria) this;
        }

        public Criteria andSysDelUserIn(List<String> values) {
            addCriterion("loginLog.f_sys_del_user in", values, "sysDelUser");
            return (Criteria) this;
        }

        public Criteria andSysDelUserNotIn(List<String> values) {
            addCriterion("loginLog.f_sys_del_user not in", values, "sysDelUser");
            return (Criteria) this;
        }

        public Criteria andSysDelUserBetween(String value1, String value2) {
            addCriterion("loginLog.f_sys_del_user between", value1, value2, "sysDelUser");
            return (Criteria) this;
        }

        public Criteria andSysDelUserNotBetween(String value1, String value2) {
            addCriterion("loginLog.f_sys_del_user not between", value1, value2, "sysDelUser");
            return (Criteria) this;
        }

        public Criteria andSysDelStateIsNull() {
            addCriterion("loginLog.f_sys_del_state is null");
            return (Criteria) this;
        }

        public Criteria andSysDelStateIsNotNull() {
            addCriterion("loginLog.f_sys_del_state is not null");
            return (Criteria) this;
        }

        public Criteria andSysDelStateEqualTo(Boolean value) {
            addCriterion("loginLog.f_sys_del_state =", value, "sysDelState");
            return (Criteria) this;
        }

        public Criteria andSysDelStateNotEqualTo(Boolean value) {
            addCriterion("loginLog.f_sys_del_state <>", value, "sysDelState");
            return (Criteria) this;
        }

        public Criteria andSysDelStateGreaterThan(Boolean value) {
            addCriterion("loginLog.f_sys_del_state >", value, "sysDelState");
            return (Criteria) this;
        }

        public Criteria andSysDelStateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("loginLog.f_sys_del_state >=", value, "sysDelState");
            return (Criteria) this;
        }

        public Criteria andSysDelStateLessThan(Boolean value) {
            addCriterion("loginLog.f_sys_del_state <", value, "sysDelState");
            return (Criteria) this;
        }

        public Criteria andSysDelStateLessThanOrEqualTo(Boolean value) {
            addCriterion("loginLog.f_sys_del_state <=", value, "sysDelState");
            return (Criteria) this;
        }

        public Criteria andSysDelStateIn(List<Boolean> values) {
            addCriterion("loginLog.f_sys_del_state in", values, "sysDelState");
            return (Criteria) this;
        }

        public Criteria andSysDelStateNotIn(List<Boolean> values) {
            addCriterion("loginLog.f_sys_del_state not in", values, "sysDelState");
            return (Criteria) this;
        }

        public Criteria andSysDelStateBetween(Boolean value1, Boolean value2) {
            addCriterion("loginLog.f_sys_del_state between", value1, value2, "sysDelState");
            return (Criteria) this;
        }

        public Criteria andSysDelStateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("loginLog.f_sys_del_state not between", value1, value2, "sysDelState");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_login_log
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table t_login_log
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Criteria andDeleted(boolean deleted) {
            return deleted ? andSysDelStateEqualTo(LoginLog.DEL_FLAG_OFF) : andSysDelStateNotEqualTo(LoginLog.DEL_FLAG_OFF);
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_login_log
     *
     * @mbg.generated
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