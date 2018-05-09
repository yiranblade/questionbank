package com.questionbank.service;

import java.util.List;

import com.questionbank.domain.SchedulePaper;
import com.questionbank.dto.ScheduleDto;

public interface ScheduleService {
	public boolean addSchedule(ScheduleDto scheduleDto);
	public boolean deleteScheduleByScheduleId(Integer scheduleId);
	public boolean updateSchedule(ScheduleDto scheduleDto);
	public List<ScheduleDto> getAllScheduleDto();
	public SchedulePaper generateSchedulePaperByScheduleId(Integer scheduleId);
}
