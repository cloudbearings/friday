package com.jwrench.friday.interest;

import android.os.Bundle;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.jwrench.friday.R;

import java.util.List;
import java.util.Map;

public class InterestListFragment extends ListFragment implements InterestListView {

    private InterestListPresenter presenter;

    private List<Map<String, Object>> interests;

    private int[] listItemViews;

    public InterestListFragment() {
        listItemViews = new int[]{R.id.interest_item_title, R.id.interest_item_note, R.id.interest_item_minutes};
    }

    public void setPresenter(InterestListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  super.onCreateView(inflater, container, savedInstanceState);

        presenter.onViewCreation();

        return view;
    }

    @Override
    public void showInterestList(List<Map<String, Object>> interests, String[] fields) {
        this.interests = interests;

        setListAdapter(new SimpleAdapter(getActivity(), this.interests, R.layout.interest_list_item, fields, listItemViews));
    }
}
