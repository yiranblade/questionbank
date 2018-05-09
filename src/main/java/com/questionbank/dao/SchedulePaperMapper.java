package com.questionbank.dao;

import com.questionbank.domain.SchedulePaper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SchedulePaperMapper {
    @Delete({
        "delete from schedule_paper",
        "where schedule_paperid = #{schedulePaperid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer schedulePaperid);

    @Insert({
        "insert into schedule_paper (schedule_paperid, scheduleid, ",
        "content, createtime)",
        "values (#{schedulePaperid,jdbcType=INTEGER}, #{scheduleid,jdbcType=INTEGER}, ",
        "#{content,jdbcType=CHAR}, #{createtime,jdbcType=TIMESTAMP})"
    })
    int insert(SchedulePaper record);

    int insertSelective(SchedulePaper record);

    @Select({
        "select",
        "schedule_paperid, scheduleid, content, createtime",
        "from schedule_paper",
        "where schedule_paperid = #{schedulePaperid,jdbcType=INTEGER}"
    })
    @ResultMap("com.questionbank.dao.SchedulePaperMapper.BaseResultMap")
    SchedulePaper selectByPrimaryKey(Integer schedulePaperid);

    int updateByPrimaryKeySelective(SchedulePaper record);

    @Update({
        "update schedule_paper",
        "set scheduleid = #{scheduleid,jdbcType=INTEGER},",
          "content = #{content,jdbcType=CHAR},",
          "createtime = #{createtime,jdbcType=TIMESTAMP}",
        "where schedule_paperid = #{schedulePaperid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SchedulePaper record);
}