package com.jwrench.friday.interest;

public class InterestFactory {

    public static InterestListPresenter buildInterestListPresenter(InterestListView view, InterestRepository repository) {
        return new InterestListPresenter(view, new InterestStore(repository));
    }
}
