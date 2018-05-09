package com.questionbank.dao;

import com.questionbank.domain.Paper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface PaperMapper {
    @Delete({
        "delete from paper",
        "where paper_id = #{paperId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer paperId);

    @Insert({
        "insert into paper (paper_id, subject_id, ",
        "teacher_id, content, createtime, ",
        "schedule_id)",
        "values (#{paperId,jdbcType=INTEGER}, #{subjectId,jdbcType=INTEGER}, ",
        "#{teacherId,jdbcType=CHAR}, #{content,jdbcType=CHAR}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{scheduleId,jdbcType=INTEGER})"
    })
    int insert(Paper record);

    int insertSelective(Paper record);

    @Select({
        "select",
        "paper_id, subject_id, teacher_id, content, createtime, schedule_id",
        "from paper",
        "where paper_id = #{paperId,jdbcType=INTEGER}"
    })
    @ResultMap("com.questionbank.dao.PaperMapper.BaseResultMap")
    Paper selectByPrimaryKey(Integer paperId);

    @Select({
    	"select LAST_INSERT_ID()"
    })
    int selectLastId();
    int updateByPrimaryKeySelective(Paper record);

    @Update({
        "update paper",
        "set subject_id = #{subjectId,jdbcType=INTEGER},",
          "teacher_id = #{teacherId,jdbcType=CHAR},",
          "content = #{content,jdbcType=CHAR},",
          "createtime = #{createtime,jdbcType=TIMESTAMP},",
          "schedule_id = #{scheduleId,jdbcType=INTEGER}",
        "where paper_id = #{paperId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Paper record);
}