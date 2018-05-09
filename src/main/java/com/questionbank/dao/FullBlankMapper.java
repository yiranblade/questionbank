package com.questionbank.dao;

import com.questionbank.domain.FullBlank;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface FullBlankMapper {
    @Delete({
        "delete from fullblank",
        "where fullblank_id = #{fullblankId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer fullblankId);

    @Delete({
        "delete from fullblank",
        "where questiontype_id = #{questionTypeId,jdbcType=INTEGER}"
    })
    int deleteByQuestionTypeId(Integer questionTypeId);
    @Insert({
        "insert into fullblank (fullblank_id, answer, ",
        "questiontype_id, content)",
        "values (#{fullblankId,jdbcType=INTEGER}, #{answer,jdbcType=CHAR}, ",
        "#{questiontypeId,jdbcType=INTEGER}, #{content,jdbcType=LONGVARCHAR})"
    })
    int insert(FullBlank record);

    int insertSelective(FullBlank record);

    @Select({
        "select",
        "fullblank_id, answer, questiontype_id, content",
        "from fullblank",
        "where fullblank_id = #{fullblankId,jdbcType=INTEGER}"
    })
    @ResultMap("com.questionbank.dao.FullBlankMapper.ResultMapWithBLOBs")
    FullBlank selectByPrimaryKey(Integer fullblankId);

    
    @Select({
        "select",
        "fullblank_id, answer, questiontype_id, content",
        "from fullblank",
        "where questiontype_id = #{questionTypeId,jdbcType=INTEGER}"
    })
    @ResultMap("com.questionbank.dao.FullBlankMapper.ResultMapWithBLOBs")
    FullBlank selectFullBlankByQuestionTypeId(Integer questionTypeId);
    
    int updateByPrimaryKeySelective(FullBlank record);

    @Update({
        "update fullblank",
        "set answer = #{answer,jdbcType=CHAR},",
          "questiontype_id = #{questiontypeId,jdbcType=INTEGER},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where fullblank_id = #{fullblankId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(FullBlank record);

    @Update({
        "update fullblank",
        "set answer = #{answer,jdbcType=CHAR},",
          "questiontype_id = #{questiontypeId,jdbcType=INTEGER}",
        "where fullblank_id = #{fullblankId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(FullBlank record);
}