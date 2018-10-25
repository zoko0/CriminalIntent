package bartek.criminalintent;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ciulkba4 on 25.10.2018.
 */

public class TimePickerFragment extends DialogFragment {

    private static final String ARG_TIME = "date";
    public static final String EXTRA_TIME = "bartek.criminalintent.date";

    private TimePicker mTimePicker;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_time, null);

        setupTimePicker(view);

        return new AlertDialog.Builder(getActivity()).setTitle(R.string.time_picker_title)
                .setView(view)
                .setPositiveButton(android.R.string.ok, (dialog, which) -> {
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                        int hour = mTimePicker.getHour();
                        int minute = mTimePicker.getMinute();
                        Time time = new Time(hour, minute, 0);
                        sendResult(Activity.RESULT_OK, time);
                    }
                }).create();
    }

    private void setupTimePicker(View view) {
        Time time = (Time) getArguments().getSerializable(ARG_TIME);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        mTimePicker = (TimePicker) view.findViewById(R.id.dialog_time_picker);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mTimePicker.setHour(hour);
            mTimePicker.setMinute(minute);
        }
    }

    private void sendResult(int resultCode, Time time) {
        if (getTargetFragment() == null) {
            return;
        }

        Intent intent = new Intent();
        intent.putExtra(EXTRA_TIME, time);
        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }

    public static TimePickerFragment newInstance(Date time) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_TIME, time);
        TimePickerFragment timePickerFragment = new TimePickerFragment();
        timePickerFragment.setArguments(args);
        return timePickerFragment;
    }
}
