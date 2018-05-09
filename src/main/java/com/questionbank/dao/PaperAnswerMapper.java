package com.questionbank.dao;

import com.questionbank.domain.PaperAnswer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface PaperAnswerMapper {
    @Delete({
        "delete from paper_answer",
        "where paper_answerid = #{paperAnswerid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer paperAnswerid);

    @Insert({
        "insert into paper_answer (paper_answerid, paperid, ",
        "content, createtime)",
        "values (#{paperAnswerid,jdbcType=INTEGER}, #{paperid,jdbcType=INTEGER}, ",
        "#{content,jdbcType=CHAR}, #{createtime,jdbcType=TIMESTAMP})"
    })
    int insert(PaperAnswer record);

    int insertSelective(PaperAnswer record);

    @Select({
        "select",
        "paper_answerid, paperid, content, createtime",
        "from paper_answer",
        "where paper_answerid = #{paperAnswerid,jdbcType=INTEGER}"
    })
    @ResultMap("com.questionbank.dao.PaperAnswerMapper.BaseResultMap")
    PaperAnswer selectByPrimaryKey(Integer paperAnswerid);

    @Select({
        "select",
        "paper_answerid, paperid, content, createtime",
        "from paper_answer",
        "where paperid = #{paperId,jdbcType=INTEGER}"
    })
    @ResultMap("com.questionbank.dao.PaperAnswerMapper.BaseResultMap")
    PaperAnswer selectByPaperId(Integer paperId);
    
    int updateByPrimaryKeySelective(PaperAnswer record);

    @Update({
        "update paper_answer",
        "set paperid = #{paperid,jdbcType=INTEGER},",
          "content = #{content,jdbcType=CHAR},",
          "createtime = #{createtime,jdbcType=TIMESTAMP}",
        "where paper_answerid = #{paperAnswerid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PaperAnswer record);
}