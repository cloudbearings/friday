package com.jwrench.friday.interest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class InterestStore {

    private InterestRepository repository;

    public InterestStore(InterestRepository repository) {
        this.repository = repository;
    }

    public List<Interest> getInterests() {
        List<Interest> interests = new ArrayList<>();
        List<Map<String, Object>> data = repository.getInterests();

        for (Map<String, Object> interestData: data) {
            interests.add(new Interest(
                    (String) interestData.get("title"),
                    (String) interestData.get("note"),
                    (Integer) interestData.get("minutes"),
                    new Date((Long) interestData.get("start_date")),
                    new Date((Long) interestData.get("stop_date"))
            ));
        }

        return interests;
    }
}
