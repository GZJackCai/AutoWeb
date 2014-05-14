package com.care.mybatis.bean;

import java.util.ArrayList;
import java.util.List;

public class AutoExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table auto
	 * @mbggenerated  Wed May 14 23:52:52 CST 2014
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table auto
	 * @mbggenerated  Wed May 14 23:52:52 CST 2014
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table auto
	 * @mbggenerated  Wed May 14 23:52:52 CST 2014
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table auto
	 * @mbggenerated  Wed May 14 23:52:52 CST 2014
	 */
	public AutoExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table auto
	 * @mbggenerated  Wed May 14 23:52:52 CST 2014
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table auto
	 * @mbggenerated  Wed May 14 23:52:52 CST 2014
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table auto
	 * @mbggenerated  Wed May 14 23:52:52 CST 2014
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table auto
	 * @mbggenerated  Wed May 14 23:52:52 CST 2014
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table auto
	 * @mbggenerated  Wed May 14 23:52:52 CST 2014
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table auto
	 * @mbggenerated  Wed May 14 23:52:52 CST 2014
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table auto
	 * @mbggenerated  Wed May 14 23:52:52 CST 2014
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table auto
	 * @mbggenerated  Wed May 14 23:52:52 CST 2014
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table auto
	 * @mbggenerated  Wed May 14 23:52:52 CST 2014
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table auto
	 * @mbggenerated  Wed May 14 23:52:52 CST 2014
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table auto
	 * @mbggenerated  Wed May 14 23:52:52 CST 2014
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
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

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andImgIsNull() {
			addCriterion("img is null");
			return (Criteria) this;
		}

		public Criteria andImgIsNotNull() {
			addCriterion("img is not null");
			return (Criteria) this;
		}

		public Criteria andImgEqualTo(String value) {
			addCriterion("img =", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgNotEqualTo(String value) {
			addCriterion("img <>", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgGreaterThan(String value) {
			addCriterion("img >", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgGreaterThanOrEqualTo(String value) {
			addCriterion("img >=", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgLessThan(String value) {
			addCriterion("img <", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgLessThanOrEqualTo(String value) {
			addCriterion("img <=", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgLike(String value) {
			addCriterion("img like", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgNotLike(String value) {
			addCriterion("img not like", value, "img");
			return (Criteria) this;
		}

		public Criteria andImgIn(List<String> values) {
			addCriterion("img in", values, "img");
			return (Criteria) this;
		}

		public Criteria andImgNotIn(List<String> values) {
			addCriterion("img not in", values, "img");
			return (Criteria) this;
		}

		public Criteria andImgBetween(String value1, String value2) {
			addCriterion("img between", value1, value2, "img");
			return (Criteria) this;
		}

		public Criteria andImgNotBetween(String value1, String value2) {
			addCriterion("img not between", value1, value2, "img");
			return (Criteria) this;
		}

		public Criteria andLinkIsNull() {
			addCriterion("link is null");
			return (Criteria) this;
		}

		public Criteria andLinkIsNotNull() {
			addCriterion("link is not null");
			return (Criteria) this;
		}

		public Criteria andLinkEqualTo(String value) {
			addCriterion("link =", value, "link");
			return (Criteria) this;
		}

		public Criteria andLinkNotEqualTo(String value) {
			addCriterion("link <>", value, "link");
			return (Criteria) this;
		}

		public Criteria andLinkGreaterThan(String value) {
			addCriterion("link >", value, "link");
			return (Criteria) this;
		}

		public Criteria andLinkGreaterThanOrEqualTo(String value) {
			addCriterion("link >=", value, "link");
			return (Criteria) this;
		}

		public Criteria andLinkLessThan(String value) {
			addCriterion("link <", value, "link");
			return (Criteria) this;
		}

		public Criteria andLinkLessThanOrEqualTo(String value) {
			addCriterion("link <=", value, "link");
			return (Criteria) this;
		}

		public Criteria andLinkLike(String value) {
			addCriterion("link like", value, "link");
			return (Criteria) this;
		}

		public Criteria andLinkNotLike(String value) {
			addCriterion("link not like", value, "link");
			return (Criteria) this;
		}

		public Criteria andLinkIn(List<String> values) {
			addCriterion("link in", values, "link");
			return (Criteria) this;
		}

		public Criteria andLinkNotIn(List<String> values) {
			addCriterion("link not in", values, "link");
			return (Criteria) this;
		}

		public Criteria andLinkBetween(String value1, String value2) {
			addCriterion("link between", value1, value2, "link");
			return (Criteria) this;
		}

		public Criteria andLinkNotBetween(String value1, String value2) {
			addCriterion("link not between", value1, value2, "link");
			return (Criteria) this;
		}

		public Criteria andBrandIsNull() {
			addCriterion("brand is null");
			return (Criteria) this;
		}

		public Criteria andBrandIsNotNull() {
			addCriterion("brand is not null");
			return (Criteria) this;
		}

		public Criteria andBrandEqualTo(Integer value) {
			addCriterion("brand =", value, "brand");
			return (Criteria) this;
		}

		public Criteria andBrandNotEqualTo(Integer value) {
			addCriterion("brand <>", value, "brand");
			return (Criteria) this;
		}

		public Criteria andBrandGreaterThan(Integer value) {
			addCriterion("brand >", value, "brand");
			return (Criteria) this;
		}

		public Criteria andBrandGreaterThanOrEqualTo(Integer value) {
			addCriterion("brand >=", value, "brand");
			return (Criteria) this;
		}

		public Criteria andBrandLessThan(Integer value) {
			addCriterion("brand <", value, "brand");
			return (Criteria) this;
		}

		public Criteria andBrandLessThanOrEqualTo(Integer value) {
			addCriterion("brand <=", value, "brand");
			return (Criteria) this;
		}

		public Criteria andBrandIn(List<Integer> values) {
			addCriterion("brand in", values, "brand");
			return (Criteria) this;
		}

		public Criteria andBrandNotIn(List<Integer> values) {
			addCriterion("brand not in", values, "brand");
			return (Criteria) this;
		}

		public Criteria andBrandBetween(Integer value1, Integer value2) {
			addCriterion("brand between", value1, value2, "brand");
			return (Criteria) this;
		}

		public Criteria andBrandNotBetween(Integer value1, Integer value2) {
			addCriterion("brand not between", value1, value2, "brand");
			return (Criteria) this;
		}

		public Criteria andVolumeIsNull() {
			addCriterion("volume is null");
			return (Criteria) this;
		}

		public Criteria andVolumeIsNotNull() {
			addCriterion("volume is not null");
			return (Criteria) this;
		}

		public Criteria andVolumeEqualTo(Float value) {
			addCriterion("volume =", value, "volume");
			return (Criteria) this;
		}

		public Criteria andVolumeNotEqualTo(Float value) {
			addCriterion("volume <>", value, "volume");
			return (Criteria) this;
		}

		public Criteria andVolumeGreaterThan(Float value) {
			addCriterion("volume >", value, "volume");
			return (Criteria) this;
		}

		public Criteria andVolumeGreaterThanOrEqualTo(Float value) {
			addCriterion("volume >=", value, "volume");
			return (Criteria) this;
		}

		public Criteria andVolumeLessThan(Float value) {
			addCriterion("volume <", value, "volume");
			return (Criteria) this;
		}

		public Criteria andVolumeLessThanOrEqualTo(Float value) {
			addCriterion("volume <=", value, "volume");
			return (Criteria) this;
		}

		public Criteria andVolumeIn(List<Float> values) {
			addCriterion("volume in", values, "volume");
			return (Criteria) this;
		}

		public Criteria andVolumeNotIn(List<Float> values) {
			addCriterion("volume not in", values, "volume");
			return (Criteria) this;
		}

		public Criteria andVolumeBetween(Float value1, Float value2) {
			addCriterion("volume between", value1, value2, "volume");
			return (Criteria) this;
		}

		public Criteria andVolumeNotBetween(Float value1, Float value2) {
			addCriterion("volume not between", value1, value2, "volume");
			return (Criteria) this;
		}

		public Criteria andTypeIsNull() {
			addCriterion("type is null");
			return (Criteria) this;
		}

		public Criteria andTypeIsNotNull() {
			addCriterion("type is not null");
			return (Criteria) this;
		}

		public Criteria andTypeEqualTo(Integer value) {
			addCriterion("type =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(Integer value) {
			addCriterion("type <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(Integer value) {
			addCriterion("type >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("type >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(Integer value) {
			addCriterion("type <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(Integer value) {
			addCriterion("type <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<Integer> values) {
			addCriterion("type in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<Integer> values) {
			addCriterion("type not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(Integer value1, Integer value2) {
			addCriterion("type between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("type not between", value1, value2, "type");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table auto
	 * @mbggenerated  Wed May 14 23:52:52 CST 2014
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table auto
     *
     * @mbggenerated do_not_delete_during_merge Sat May 03 15:51:52 CST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}