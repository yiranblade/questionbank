package com.questionbank.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.questionbank.domain.Teacher;

public interface TeacherMapper {
    @Delete({
        "delete from teacher",
        "where teacher_id = #{teacherId,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String teacherId);

    @Insert({
        "insert into teacher (teacher_id, profession_id, ",
        "teacher_name)",
        "values (#{teacherId,jdbcType=CHAR}, #{professionId,jdbcType=INTEGER}, ",
        "#{teacherName,jdbcType=CHAR})"
    })
    int insert(Teacher record);

    int insertSelective(Teacher record);

    @Select({
        "select",
        "teacher_id, profession_id, teacher_name",
        "from teacher",
        "where teacher_id = #{teacherId,jdbcType=CHAR}"
    })
    @ResultMap("com.questionbank.dao.TeacherMapper.BaseResultMap")
    Teacher selectByPrimaryKey(String teacherId);
    
    @Select({
        "select",
        "teacher_id, profession_id, teacher_name",
        "from teacher"
    })
    @ResultMap("com.questionbank.dao.TeacherMapper.BaseResultMap")
    List<Teacher> selectAll();

    int updateByPrimaryKeySelective(Teacher record);

    @Update({
        "update teacher",
        "set profession_id = #{professionId,jdbcType=INTEGER},",
          "teacher_name = #{teacherName,jdbcType=CHAR}",
        "where teacher_id = #{teacherId,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(Teacher record);
}