package com.devfuns.mapper;

import com.devfuns.model.article.Contents;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ContentsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_contents
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    int deleteByPrimaryKey(Integer cid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_contents
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    int insert(Contents record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_contents
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    int insertSelective(Contents record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_contents
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    Contents selectByPrimaryKey(Integer cid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_contents
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    int updateByPrimaryKeySelective(Contents record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_contents
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(Contents record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_contents
     *
     * @mbggenerated Wed Aug 29 20:14:14 CST 2018
     */
    int updateByPrimaryKey(Contents record);

    List<Contents> selectContentPage();
}