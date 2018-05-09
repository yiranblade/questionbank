package com.questionbank.domain;

public class ScheduleInfo {
    private Integer scheduleinfoId;

    private Integer scheduleId;

    private Integer type;

    private Integer orders;

    private Integer level;

    private String indicator;

    private Integer indicatorLevel;

    private String createtime;

    public Integer getScheduleinfoId() {
        return scheduleinfoId;
    }

    public void setScheduleinfoId(Integer scheduleinfoId) {
        this.scheduleinfoId = scheduleinfoId;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

  
    

    public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public Integer getIndicatorLevel() {
        return indicatorLevel;
    }

    public void setIndicatorLevel(Integer indicatorLevel) {
        this.indicatorLevel = indicatorLevel;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}