package com.questionbank.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.questionbank.domain.Schedule;

public interface ScheduleMapper {
    @Delete({
        "delete from schedule",
        "where schedule_id = #{scheduleId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer scheduleId);

    @Insert({
        "insert into schedule (schedule_id, profession_id, ",
        "subject_id, teacher_id, ",
        "grade, test_time, ab_type, ",
        "test_type, avg_record, ",
        "createtime, term)",
        "values (#{scheduleId,jdbcType=INTEGER}, #{professionId,jdbcType=INTEGER}, ",
        "#{subjectId,jdbcType=INTEGER}, #{teacherId,jdbcType=CHAR}, ",
        "#{grade,jdbcType=CHAR}, #{testTime,jdbcType=CHAR}, #{abType,jdbcType=TINYINT}, ",
        "#{testType,jdbcType=INTEGER}, #{avgRecord,jdbcType=INTEGER}, ",
        "#{createtime,jdbcType=TIMESTAMP}, #{term,jdbcType=CHAR})"
    })
    int insert(Schedule record);

    int insertSelective(Schedule record);

    @Select({
        "select",
        "schedule_id, profession_id, subject_id, teacher_id, grade, test_time, ab_type, ",
        "test_type, avg_record, createtime, term",
        "from schedule",
        "where schedule_id = #{scheduleId,jdbcType=INTEGER}"
    })
    @ResultMap("com.questionbank.dao.ScheduleMapper.BaseResultMap")
    Schedule selectByPrimaryKey(Integer scheduleId);
    
    
    @Select({
        "select * from schedule"
    })
    @ResultMap("com.questionbank.dao.ScheduleMapper.BaseResultMap")
    List<Schedule> selectAll();
    
    @Select({
    	"select LAST_INSERT_ID()"
    })
    int selectLastId();
    
    
    int updateByPrimaryKeySelective(Schedule record);

    @Update({
        "update schedule",
        "set profession_id = #{professionId,jdbcType=INTEGER},",
          "subject_id = #{subjectId,jdbcType=INTEGER},",
          "teacher_id = #{teacherId,jdbcType=CHAR},",
          "grade = #{grade,jdbcType=CHAR},",
          "test_time = #{testTime,jdbcType=CHAR},",
          "ab_type = #{abType,jdbcType=TINYINT},",
          "test_type = #{testType,jdbcType=INTEGER},",
          "avg_record = #{avgRecord,jdbcType=INTEGER},",
          "createtime = #{createtime,jdbcType=TIMESTAMP},",
          "term = #{term,jdbcType=CHAR}",
        "where schedule_id = #{scheduleId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Schedule record);
}