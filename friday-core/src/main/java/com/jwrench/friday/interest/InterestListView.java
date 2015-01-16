package com.jwrench.friday.interest;

import java.util.List;
import java.util.Map;

public interface InterestListView {
    void showInterestList(List<Map<String, Object>> interests, String[] fields);
}
