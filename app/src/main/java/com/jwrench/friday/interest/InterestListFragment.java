package com.jwrench.friday.interest;

import android.os.Bundle;
import android.app.ListFragment;
import android.widget.ArrayAdapter;

import com.jwrench.friday.R;

import java.util.List;

public class InterestListFragment extends ListFragment {

    private InterestRepository repository;

    public InterestListFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createDataProvider(getInterests());
    }

    public void setRepository(InterestRepository repository) {
        this.repository = repository;
    }

    private List<String> getInterests() {
        return repository.getInterests();
    }

    private void createDataProvider(List<String> interests) {
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, interests));
    }

}
