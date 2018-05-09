package com.questionbank.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.questionbank.domain.ScheduleInfo;

public interface ScheduleInfoMapper {
    @Delete({
        "delete from schedule_info",
        "where scheduleinfo_id = #{scheduleinfoId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer scheduleinfoId);

    @Delete({
        "delete from schedule_info",
        "where schedule_id = #{scheduleId,jdbcType=INTEGER}"
    })
    int deleteByScheduleId(Integer scheduleId);
    
    @Insert({
        "insert into schedule_info (scheduleinfo_id, schedule_id, ",
        "type, orders, level, ",
        "indicator, indicator_level, ",
        "createtime)",
        "values (#{scheduleinfoId,jdbcType=INTEGER}, #{scheduleId,jdbcType=INTEGER}, ",
        "#{type,jdbcType=INTEGER}, #{orders,jdbcType=INTEGER}, #{level,jdbcType=INTEGER}, ",
        "#{indicator,jdbcType=CHAR}, #{indicatorLevel,jdbcType=INTEGER}, ",
        "#{createtime,jdbcType=TIMESTAMP})"
    })
    int insert(ScheduleInfo record);

    int insertSelective(ScheduleInfo record);

    @Select({
        "select",
        "scheduleinfo_id, schedule_id, type, orders, level, indicator, indicator_level, ",
        "createtime",
        "from schedule_info",
        "where scheduleinfo_id = #{scheduleinfoId,jdbcType=INTEGER}"
    })
    @ResultMap("com.questionbank.dao.ScheduleInfoMapper.BaseResultMap")
    ScheduleInfo selectByPrimaryKey(Integer scheduleinfoId);

    @Select({
        "select",
        "scheduleinfo_id, schedule_id, type, orders, level, indicator, indicator_level, ",
        "createtime",
        "from schedule_info",
        "where schedule_id = #{scheduleId,jdbcType=INTEGER}"
    })
    @ResultMap("com.questionbank.dao.ScheduleInfoMapper.BaseResultMap")
    List<ScheduleInfo> selectByScheduleId(Integer scheduleId);
    
    int updateByPrimaryKeySelective(ScheduleInfo record);

    @Update({
        "update schedule_info",
        "set schedule_id = #{scheduleId,jdbcType=INTEGER},",
          "type = #{type,jdbcType=INTEGER},",
          "orders = #{orders,jdbcType=INTEGER},",
          "level = #{level,jdbcType=INTEGER},",
          "indicator = #{indicator,jdbcType=CHAR},",
          "indicator_level = #{indicatorLevel,jdbcType=INTEGER},",
          "createtime = #{createtime,jdbcType=TIMESTAMP}",
        "where scheduleinfo_id = #{scheduleinfoId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ScheduleInfo record);
}