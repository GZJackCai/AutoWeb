package com.care.mybatis.dao;

import com.care.mybatis.bean.UserFavorite;
import com.care.mybatis.bean.UserFavoriteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserFavoriteMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_favorite
     *
     * @mbggenerated Mon May 19 22:20:36 CST 2014
     */
    int countByExample(UserFavoriteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_favorite
     *
     * @mbggenerated Mon May 19 22:20:36 CST 2014
     */
    int deleteByExample(UserFavoriteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_favorite
     *
     * @mbggenerated Mon May 19 22:20:36 CST 2014
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_favorite
     *
     * @mbggenerated Mon May 19 22:20:36 CST 2014
     */
    int insert(UserFavorite record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_favorite
     *
     * @mbggenerated Mon May 19 22:20:36 CST 2014
     */
    int insertSelective(UserFavorite record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_favorite
     *
     * @mbggenerated Mon May 19 22:20:36 CST 2014
     */
    List<UserFavorite> selectByExample(UserFavoriteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_favorite
     *
     * @mbggenerated Mon May 19 22:20:36 CST 2014
     */
    UserFavorite selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_favorite
     *
     * @mbggenerated Mon May 19 22:20:36 CST 2014
     */
    int updateByExampleSelective(@Param("record") UserFavorite record, @Param("example") UserFavoriteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_favorite
     *
     * @mbggenerated Mon May 19 22:20:36 CST 2014
     */
    int updateByExample(@Param("record") UserFavorite record, @Param("example") UserFavoriteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_favorite
     *
     * @mbggenerated Mon May 19 22:20:36 CST 2014
     */
    int updateByPrimaryKeySelective(UserFavorite record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_favorite
     *
     * @mbggenerated Mon May 19 22:20:36 CST 2014
     */
    int updateByPrimaryKey(UserFavorite record);
}