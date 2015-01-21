package com.jwrench.friday.interest;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class InterestDummyRepository implements InterestRepository {

    @Override
    public List<Map<String, Object>> getInterests() {
        List<Map<String, Object>> interests = new ArrayList<Map<String, Object>>();

        Map<String, Object> interest1 = new HashMap<String, Object>();
        interest1.put("title", "Writing - dummy");
        interest1.put("note", "Practice writing short stories, doing writing course or writing stories for self publishing");
        interest1.put("minutes", Integer.valueOf(60));
        interests.add(interest1);

        Map<String, Object> interest2 = new HashMap<String, Object>();
        interest2.put("title", "Swimming - dummy");
        interest2.put("note", "Get fit, have fun, build strength, play with dogs etc. ");
        interest2.put("minutes", Integer.valueOf(15));
        interests.add(interest2);

        return interests;
    }
}
