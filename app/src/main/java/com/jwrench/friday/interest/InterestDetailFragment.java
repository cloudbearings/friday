package com.jwrench.friday.interest;

import android.app.DatePickerDialog;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.jwrench.friday.DateFragment;
import com.jwrench.friday.R;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;

public class InterestDetailFragment extends Fragment {

    private EditText startDate;
    private EditText stopDate;
    private NumberPicker minutesPicker;
    private Spinner spinner;

    public InterestDetailFragment() {
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        startDate = (EditText) getActivity().findViewById(R.id.detail_start_date);
        stopDate = (EditText) getActivity().findViewById(R.id.detail_stop_date);
        minutesPicker = (NumberPicker) getActivity().findViewById(R.id.detail_minutes_picker);
        spinner = (Spinner) getActivity().findViewById(R.id.detail_minutes_spinner);

        if (startDate.getText().toString().isEmpty()) {
            startDate.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_action_time, 0, 0, 0);
            startDate.setHint("");
        }

        if (stopDate.getText().toString().isEmpty()) {
            stopDate.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_action_time, 0, 0, 0);
            stopDate.setHint("");
        }


        minutesPicker.setDisplayedValues(getMinutePickerValues());
        minutesPicker.setWrapSelectorWheel(true);


        setupDateViewListeners();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_interest_detail, container, false);

        return view;
    }

    private String[] getMinutePickerValues() {
        int max = 600;
        int min = 5;
        int increment = 5;
        int noValues = (max-min)/increment;
        String[] values = new String[noValues];

        int lastValue = 5;
        for (int i = 0; i < noValues; i++) {
            values[i] = lastValue + " min";
            lastValue += increment;
        }

        minutesPicker.setMinValue(0);
        minutesPicker.setMaxValue(values.length-1);

        return values;
    }

    private void setupDatePicker(final EditText caller) {
        showDatePicker(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, monthOfYear, dayOfMonth);

                DateFormat format = DateFormat.getDateInstance();

                caller.setText(format.format(calendar.getTime()));
                caller.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        });
    }

    private void showDatePicker(DatePickerDialog.OnDateSetListener dateSelectedListener) {
        DateFragment dateFragment = new DateFragment();
        dateFragment.setDateSelectedListener(dateSelectedListener);
        dateFragment.show(getFragmentManager(), "DATE_PICKER");
    }

    private void setupDateViewListeners() {
        startDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    setupDatePicker(startDate);
            }
        });

        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupDatePicker(startDate);
            }
        });

        stopDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    setupDatePicker(stopDate);
            }
        });

        stopDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupDatePicker(stopDate);
            }
        });
    }

}
