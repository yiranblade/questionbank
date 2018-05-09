package com.questionbank.dto;

import java.util.List;

import com.questionbank.domain.Schedule;
import com.questionbank.domain.ScheduleInfo;
import com.questionbank.domain.SetMark;

public class ScheduleDto {
	
	private Schedule schedule;
	
	private List<ScheduleInfo> scheduleInfo;
	
	private List<SetMark> setMark;

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public List<ScheduleInfo> getScheduleInfo() {
		return scheduleInfo;
	}

	public void setScheduleInfo(List<ScheduleInfo> scheduleInfo) {
		this.scheduleInfo = scheduleInfo;
	}

	public List<SetMark> getSetMark() {
		return setMark;
	}

	public void setSetMark(List<SetMark> setMark) {
		this.setMark = setMark;
	}
	
	
	

}
