package com.jwrench.friday.interest;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class Interest {

    private String title;
    private String note;
    private int minutes;
    private Date startDate;
    private Date stopDate;

    public Interest(String title, String note, int minutes, Date startDate, Date stopDate) {
        this.title = title;
        this.note = note;
        this.minutes = minutes;
        this.startDate = startDate;
        this.stopDate = stopDate;
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }

    public int getMinutes() {
        return minutes;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getStopDate() {
        return stopDate;
    }

    public Map<String, Object> createRecordMap() {
        Map<String, Object> record = new LinkedHashMap<>();

        record.put("title", getTitle());
        record.put("note", getNote());
        record.put("minutes", getMinutes());
        record.put("start_date", getStartDate());
        record.put("stop_date", getStopDate());

        return record;
    }

}
