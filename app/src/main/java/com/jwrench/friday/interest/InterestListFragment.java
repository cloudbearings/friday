package com.jwrench.friday.interest;

import android.os.Bundle;
import android.app.ListFragment;
import android.widget.ArrayAdapter;

import com.jwrench.friday.R;

import com.jwrench.friday.interest.dummy.DummyContent;

public class InterestListFragment extends ListFragment {

    public InterestListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<DummyContent.DummyItem>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, DummyContent.ITEMS));
    }

}
