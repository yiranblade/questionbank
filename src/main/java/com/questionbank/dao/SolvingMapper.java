package com.questionbank.dao;

import com.questionbank.domain.Solving;
import com.questionbank.domain.SolvingWithBLOBs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SolvingMapper {
    @Delete({
        "delete from solving",
        "where solving_id = #{solvingId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer solvingId);

    
    @Delete({
        "delete from solving",
        "where questiontype_id = #{questionTypeId,jdbcType=INTEGER}"
    })
    int deleteByQuestionTypeId(Integer questionTypeId);
    @Insert({
        "insert into solving (solving_id, questiontype_id, ",
        "content, answer)",
        "values (#{solvingId,jdbcType=INTEGER}, #{questiontypeId,jdbcType=INTEGER}, ",
        "#{content,jdbcType=LONGVARCHAR}, #{answer,jdbcType=LONGVARCHAR})"
    })
    int insert(SolvingWithBLOBs record);

    int insertSelective(SolvingWithBLOBs record);

    @Select({
        "select",
        "solving_id, questiontype_id, content, answer",
        "from solving",
        "where solving_id = #{solvingId,jdbcType=INTEGER}"
    })
    @ResultMap("com.questionbank.dao.SolvingMapper.ResultMapWithBLOBs")
    SolvingWithBLOBs selectByPrimaryKey(Integer solvingId);

    @Select({
        "select",
        "solving_id, questiontype_id, content, answer",
        "from solving",
        "where questiontype_id = #{questionTypeId,jdbcType=INTEGER}"
    })
    @ResultMap("com.questionbank.dao.SolvingMapper.ResultMapWithBLOBs")
    SolvingWithBLOBs selectByQuestionTypeId(Integer questionTypeId);
    
    int updateByPrimaryKeySelective(SolvingWithBLOBs record);

    @Update({
        "update solving",
        "set questiontype_id = #{questiontypeId,jdbcType=INTEGER},",
          "content = #{content,jdbcType=LONGVARCHAR},",
          "answer = #{answer,jdbcType=LONGVARCHAR}",
        "where solving_id = #{solvingId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(SolvingWithBLOBs record);

    @Update({
        "update solving",
        "set questiontype_id = #{questiontypeId,jdbcType=INTEGER}",
        "where solving_id = #{solvingId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Solving record);
}