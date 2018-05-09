package com.questionbank.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.questionbank.domain.Subject;

public interface SubjectMapper {
    @Delete({
        "delete from subject",
        "where subject_id = #{subjectId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer subjectId);

    @Insert({
        "insert into subject (subject_id, subject_name, ",
        "profession_id)",
        "values (#{subjectId,jdbcType=INTEGER}, #{subjectName,jdbcType=CHAR}, ",
        "#{professionId,jdbcType=INTEGER})"
    })
    int insert(Subject record);

    int insertSelective(Subject record);

    @Select({
        "select",
        "subject_id, subject_name, profession_id",
        "from subject",
        "where subject_id = #{subjectId,jdbcType=INTEGER}"
    })
    @ResultMap("com.questionbank.dao.SubjectMapper.BaseResultMap")
    Subject selectByPrimaryKey(Integer subjectId);

    @Select({
    	"select",
        "subject_id, subject_name, profession_id",
        "from subject"
    })
    @ResultMap("com.questionbank.dao.SubjectMapper.BaseResultMap")
    List<Subject> selectAll();
    int updateByPrimaryKeySelective(Subject record);

    @Update({
        "update subject",
        "set subject_name = #{subjectName,jdbcType=CHAR},",
          "profession_id = #{professionId,jdbcType=INTEGER}",
        "where subject_id = #{subjectId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Subject record);
}