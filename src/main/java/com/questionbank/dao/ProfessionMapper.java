package com.questionbank.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.questionbank.domain.Profession;

public interface ProfessionMapper {
    @Delete({
        "delete from profession",
        "where profession_id = #{professionId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer professionId);

    @Insert({
        "insert into profession (profession_id, profession_name)",
        "values (#{professionId,jdbcType=INTEGER}, #{professionName,jdbcType=CHAR})"
    })
    int insert(Profession record);

    int insertSelective(Profession record);

    @Select({
        "select",
        "profession_id, profession_name",
        "from profession",
        "where profession_id = #{professionId,jdbcType=INTEGER}"
    })
    @ResultMap("com.questionbank.dao.ProfessionMapper.BaseResultMap")
    Profession selectByPrimaryKey(Integer professionId);

    @Select({
    	"select",
        "profession_id, profession_name",
        "from profession"
    })
    @ResultMap("com.questionbank.dao.ProfessionMapper.BaseResultMap")
    List<Profession> selectAll();
    int updateByPrimaryKeySelective(Profession record);

    @Update({
        "update profession",
        "set profession_name = #{professionName,jdbcType=CHAR}",
        "where profession_id = #{professionId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Profession record);
}