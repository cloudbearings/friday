package com.jwrench.friday.interest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InterestListPresenter {

    private InterestListView view;
    private InterestStore store;

    public InterestListPresenter(InterestListView view, InterestStore store) {
        this.view = view;
        this.store = store;
    }

    public void onViewCreation() {
        List<Map<String, Object>> viewData = new ArrayList<>();
        String[] fields = new String[]{"title","note","minutes", "time_unit"};

        for (Interest interest: store.getInterests()) {
            viewData.add(interest.createRecordMap());
        }

        view.showInterestList(viewData, fields);
    };
}
