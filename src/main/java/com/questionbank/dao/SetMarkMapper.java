package com.questionbank.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.questionbank.domain.SetMark;

public interface SetMarkMapper {
    @Delete({
        "delete from setmark",
        "where setmark_id = #{setmarkId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer setmarkId);

    @Delete({
        "delete from setmark",
        "where schedule_id = #{scheduleId,jdbcType=INTEGER}"
    })
    int deleteByScheduleId(Integer scheduleId);
    
    @Insert({
        "insert into setmark (setmark_id, type, ",
        "count, mark, createtime, ",
        "schedule_id)",
        "values (#{setmarkId,jdbcType=INTEGER}, #{type,jdbcType=INTEGER}, ",
        "#{count,jdbcType=INTEGER}, #{mark,jdbcType=INTEGER}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{scheduleId,jdbcType=INTEGER})"
    })
    int insert(SetMark record);

    int insertSelective(SetMark record);

    @Select({
        "select",
        "setmark_id, type, count, mark, createtime, schedule_id",
        "from setmark",
        "where setmark_id = #{setmarkId,jdbcType=INTEGER}"
    })
    @ResultMap("com.questionbank.dao.SetMarkMapper.BaseResultMap")
    SetMark selectByPrimaryKey(Integer setmarkId);

    @Select({
        "select",
        "setmark_id, type, count, mark, createtime, schedule_id",
        "from setmark",
        "where schedule_id = #{scheduleId,jdbcType=INTEGER}"
    })
    @ResultMap("com.questionbank.dao.SetMarkMapper.BaseResultMap")
    List<SetMark> selectByScheduleId(Integer scheduleId);
    
    
    int updateByPrimaryKeySelective(SetMark record);

    @Update({
        "update setmark",
        "set type = #{type,jdbcType=INTEGER},",
          "count = #{count,jdbcType=INTEGER},",
          "mark = #{mark,jdbcType=INTEGER},",
          "createtime = #{createtime,jdbcType=TIMESTAMP},",
          "schedule_id = #{scheduleId,jdbcType=INTEGER}",
        "where setmark_id = #{setmarkId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SetMark record);
}