package com.questionbank.dao;

import com.questionbank.domain.ShortAnswer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ShortAnswerMapper {
    @Delete({
        "delete from short_answer",
        "where shortanswerid = #{shortanswerid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer shortanswerid);

    
    @Delete({
        "delete from short_answer",
        "where questiontype_id = #{questionTypeId,jdbcType=INTEGER}"
    })
    int deleteByQuestionTypeId(Integer questionTypeId);
    
    @Insert({
        "insert into short_answer (shortanswerid, answer, ",
        "questiontype_id, content)",
        "values (#{shortanswerid,jdbcType=INTEGER}, #{answer,jdbcType=CHAR}, ",
        "#{questiontypeId,jdbcType=INTEGER}, #{content,jdbcType=LONGVARCHAR})"
    })
    int insert(ShortAnswer record);

    int insertSelective(ShortAnswer record);

    @Select({
        "select",
        "shortanswerid, answer, questiontype_id, content",
        "from short_answer",
        "where shortanswerid = #{shortanswerid,jdbcType=INTEGER}"
    })
    @ResultMap("com.questionbank.dao.ShortAnswerMapper.ResultMapWithBLOBs")
    ShortAnswer selectByPrimaryKey(Integer shortanswerid);

    @Select({
        "select",
        "shortanswerid, answer, questiontype_id, content",
        "from short_answer",
        "where questiontype_id = #{questionTypeId,jdbcType=INTEGER}"
    })
    @ResultMap("com.questionbank.dao.ShortAnswerMapper.ResultMapWithBLOBs")
    ShortAnswer selectShortAnswerByQuestionTypeId(Integer questionTypeId);
    
    int updateByPrimaryKeySelective(ShortAnswer record);

    @Update({
        "update short_answer",
        "set answer = #{answer,jdbcType=CHAR},",
          "questiontype_id = #{questiontypeId,jdbcType=INTEGER},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where shortanswerid = #{shortanswerid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(ShortAnswer record);

    @Update({
        "update short_answer",
        "set answer = #{answer,jdbcType=CHAR},",
          "questiontype_id = #{questiontypeId,jdbcType=INTEGER}",
        "where shortanswerid = #{shortanswerid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ShortAnswer record);
}