package com.jwrench.friday.interest;

import java.util.List;
import java.util.Map;

public interface InterestRepository {
    List<Map<String, Object>> getInterests();
}
