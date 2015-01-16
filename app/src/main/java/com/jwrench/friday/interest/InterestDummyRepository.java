package com.jwrench.friday.interest;

import java.util.ArrayList;
import java.util.List;

public class InterestDummyRepository implements InterestRepository {

    @Override
    public List<String> getInterests() {
        List<String> interests = new ArrayList<String>();
        interests.add("Writing - dummy");
        interests.add("Android - dummy");
        interests.add("Swimming - dummy");

        return interests;
    }
}
