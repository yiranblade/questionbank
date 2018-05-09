package com.questionbank.dao;

import com.questionbank.domain.Choice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ChoiceMapper {
    @Delete({
        "delete from choice",
        "where choice_id = #{choiceId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer choiceId);

    @Delete({
        "delete from choice",
        "where questiontype_id = #{questionTypeId,jdbcType=INTEGER}"
    })
    int deleteByQuestionTypeId(Integer questionTypeId);
    
    @Insert({
        "insert into choice (choice_id, choice_one, ",
        "choice_two, choice_three, ",
        "choice_four, answer, questiontype_id, ",
        "content)",
        "values (#{choiceId,jdbcType=INTEGER}, #{choiceOne,jdbcType=CHAR}, ",
        "#{choiceTwo,jdbcType=CHAR}, #{choiceThree,jdbcType=CHAR}, ",
        "#{choiceFour,jdbcType=CHAR}, #{answer,jdbcType=CHAR}, #{questiontypeId,jdbcType=INTEGER}, ",
        "#{content,jdbcType=LONGVARCHAR})"
    })
    int insert(Choice record);

    int insertSelective(Choice record);

    @Select({
        "select",
        "choice_id, choice_one, choice_two, choice_three, choice_four, answer, questiontype_id, ",
        "content",
        "from choice",
        "where choice_id = #{choiceId,jdbcType=INTEGER}"
    })
    @ResultMap("com.questionbank.dao.ChoiceMapper.ResultMapWithBLOBs")
    Choice selectByPrimaryKey(Integer choiceId);

    @Select({
        "select",
        "choice_id, choice_one, choice_two, choice_three, choice_four, answer, questiontype_id, ",
        "content",
        "from choice",
        "where questiontype_id = #{questionTypeId,jdbcType=INTEGER}"
    })
    @ResultMap("com.questionbank.dao.ChoiceMapper.ResultMapWithBLOBs")
    Choice selectChoiceByQuestionTypeId(Integer questionTypeId);
    
    int updateByPrimaryKeySelective(Choice record);

    @Update({
        "update choice",
        "set choice_one = #{choiceOne,jdbcType=CHAR},",
          "choice_two = #{choiceTwo,jdbcType=CHAR},",
          "choice_three = #{choiceThree,jdbcType=CHAR},",
          "choice_four = #{choiceFour,jdbcType=CHAR},",
          "answer = #{answer,jdbcType=CHAR},",
          "questiontype_id = #{questiontypeId,jdbcType=INTEGER},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where choice_id = #{choiceId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Choice record);

    @Update({
        "update choice",
        "set choice_one = #{choiceOne,jdbcType=CHAR},",
          "choice_two = #{choiceTwo,jdbcType=CHAR},",
          "choice_three = #{choiceThree,jdbcType=CHAR},",
          "choice_four = #{choiceFour,jdbcType=CHAR},",
          "answer = #{answer,jdbcType=CHAR},",
          "questiontype_id = #{questiontypeId,jdbcType=INTEGER}",
        "where choice_id = #{choiceId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Choice record);
}