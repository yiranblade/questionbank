package com.questionbank.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.questionbank.domain.QuestionType;
import com.questionbank.domain.ScheduleInfo;

public interface QuestionTypeMapper {
    @Delete({
        "delete from questiontype",
        "where questiontype_id = #{questiontypeId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer questiontypeId);

    @Insert({
        "insert into questiontype (questiontype_id, type, ",
        "level, subject_id, ",
        "teacher_id, createtime, ",
        "indicator, lastuse_time)",
        "values (#{questiontypeId,jdbcType=INTEGER}, #{type,jdbcType=INTEGER}, ",
        "#{level,jdbcType=INTEGER}, #{subjectId,jdbcType=INTEGER}, ",
        "#{teacherId,jdbcType=CHAR}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{indicator,jdbcType=CHAR}, #{lastuseTime,jdbcType=TIMESTAMP})"
    })
    int insert(QuestionType record);

    int insertSelective(QuestionType record);

    @Select({
        "select",
        "questiontype_id, type, level, subject_id, teacher_id, createtime, indicator, ",
        "lastuse_time",
        "from questiontype",
        "where questiontype_id = #{questiontypeId,jdbcType=INTEGER}"
    })
    @ResultMap("com.questionbank.dao.QuestionTypeMapper.BaseResultMap")
    QuestionType selectByPrimaryKey(Integer questiontypeId);
    
    @Select({
    	"select",
    	"questiontype_id, type, level, subject_id, teacher_id, createtime, indicator, ",
        "lastuse_time",
        "from questiontype",
        "where level=#{level,jdbcType=INTEGER} and type=#{type,jdbcType=INTEGER}",
        "and indicator=#{indicator,jdbcType=CHAR}",
        "order by lastuse_time asc"
    })
    @ResultMap("com.questionbank.dao.QuestionTypeMapper.BaseResultMap")
    List<QuestionType> selectQuestionTypeByScheduleInfo(ScheduleInfo scheduleInfo);
    
    @Select({
    	"select",
    	"questiontype_id, type, level, subject_id, teacher_id, createtime, indicator, ",
        "lastuse_time",
        "from questiontype",
        "where type=#{type,jdbcType=INTEGER}"
    })
    @ResultMap("com.questionbank.dao.QuestionTypeMapper.BaseResultMap")
    List<QuestionType> selectQuestionTypeByType(Integer type);
    
    @Select({
    	"select LAST_INSERT_ID()"
    })
    int selectLastId();
    
    
    int updateByPrimaryKeySelective(QuestionType record);

    @Update({
        "update questiontype",
        "set type = #{type,jdbcType=INTEGER},",
          "level = #{level,jdbcType=INTEGER},",
          "subject_id = #{subjectId,jdbcType=INTEGER},",
          "teacher_id = #{teacherId,jdbcType=CHAR},",
          "createtime = #{createtime,jdbcType=TIMESTAMP},",
          "indicator = #{indicator,jdbcType=CHAR},",
          "lastuse_time = #{lastuseTime,jdbcType=TIMESTAMP}",
        "where questiontype_id = #{questiontypeId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(QuestionType record);
}