package com.jwrench.friday;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

public class DateFragment extends DialogFragment {

    private DatePickerDialog.OnDateSetListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar now = Calendar.getInstance();

        return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) listener,
                now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
    }

    public void setDateSelectedListener(DatePickerDialog.OnDateSetListener listener) {
        this.listener = listener;
    }
}
