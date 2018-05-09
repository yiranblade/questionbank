package com.questionbank.dao;

import com.questionbank.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    @Delete({
        "delete from user",
        "where userName = #{userName,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String userName);

    @Insert({
        "insert into user (userId, userName, ",
        "userPassword, role)",
        "values (#{userid,jdbcType=INTEGER}, #{username,jdbcType=CHAR}, ",
        "#{userpassword,jdbcType=CHAR}, #{role,jdbcType=INTEGER})"
    })
    int insert(User record);

    int insertSelective(User record);

    @Select({
        "select",
        "userId, userName, userPassword, role",
        "from user",
        "where userId = #{userid,jdbcType=INTEGER}"
    })
    @ResultMap("com.questionbank.dao.UserMapper.BaseResultMap")
    User selectByPrimaryKey(Integer userid);

    @Select({
        "select",
        "userId, userName, userPassword, role",
        "from user",
        "where userName = #{userName,jdbcType=CHAR}"
    })
    @ResultMap("com.questionbank.dao.UserMapper.BaseResultMap")
    User selectByUserName(String userName);
    
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set userName = #{username,jdbcType=CHAR},",
          "userPassword = #{userpassword,jdbcType=CHAR},",
          "role = #{role,jdbcType=INTEGER}",
        "where userId = #{userid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}