package com.jwrench.friday.interest;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.jwrench.friday.R;

public class InterestDetailFragment extends Fragment {

    public static final int IC_ACTION_TIME = R.drawable.ic_wrist_watch;

    private EditText duration;

    public InterestDetailFragment() {
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        duration = (EditText) getActivity().findViewById(R.id.detail_duration_edit);

        if (duration.getText().toString().isEmpty()) {
            duration.setCompoundDrawablesWithIntrinsicBounds(0, IC_ACTION_TIME, 0, 0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_interest_detail, container, false);

        return view;
    }

}
