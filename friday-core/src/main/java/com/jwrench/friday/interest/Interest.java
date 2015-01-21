package com.jwrench.friday.interest;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class Interest {

    private String title;
    private String note;
    private int minutes;

    public Interest(String title, String note, int minutes) {
        this.title = title;
        this.note = note;
        this.minutes = minutes;
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

    public Map<String, Object> createRecordMap() {
        Map<String, Object> record = new LinkedHashMap<>();

        record.put("title", getTitle());
        record.put("note", getNote());
        record.put("minutes", getMinutes());

        return record;
    }

}
