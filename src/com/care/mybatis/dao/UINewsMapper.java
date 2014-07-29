package com.care.mybatis.dao;

import com.care.mybatis.bean.UINews;
import com.care.mybatis.bean.UINewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UINewsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ui_news
     *
     * @mbggenerated Mon May 19 22:20:36 CST 2014
     */
    int countByExample(UINewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ui_news
     *
     * @mbggenerated Mon May 19 22:20:36 CST 2014
     */
    int deleteByExample(UINewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ui_news
     *
     * @mbggenerated Mon May 19 22:20:36 CST 2014
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ui_news
     *
     * @mbggenerated Mon May 19 22:20:36 CST 2014
     */
    int insert(UINews record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ui_news
     *
     * @mbggenerated Mon May 19 22:20:36 CST 2014
     */
    int insertSelective(UINews record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ui_news
     *
     * @mbggenerated Mon May 19 22:20:36 CST 2014
     */
    List<UINews> selectByExampleWithBLOBs(UINewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ui_news
     *
     * @mbggenerated Mon May 19 22:20:36 CST 2014
     */
    List<UINews> selectByExample(UINewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ui_news
     *
     * @mbggenerated Mon May 19 22:20:36 CST 2014
     */
    UINews selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ui_news
     *
     * @mbggenerated Mon May 19 22:20:36 CST 2014
     */
    int updateByExampleSelective(@Param("record") UINews record, @Param("example") UINewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ui_news
     *
     * @mbggenerated Mon May 19 22:20:36 CST 2014
     */
    int updateByExampleWithBLOBs(@Param("record") UINews record, @Param("example") UINewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ui_news
     *
     * @mbggenerated Mon May 19 22:20:36 CST 2014
     */
    int updateByExample(@Param("record") UINews record, @Param("example") UINewsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ui_news
     *
     * @mbggenerated Mon May 19 22:20:36 CST 2014
     */
    int updateByPrimaryKeySelective(UINews record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ui_news
     *
     * @mbggenerated Mon May 19 22:20:36 CST 2014
     */
    int updateByPrimaryKeyWithBLOBs(UINews record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ui_news
     *
     * @mbggenerated Mon May 19 22:20:36 CST 2014
     */
    int updateByPrimaryKey(UINews record);
}