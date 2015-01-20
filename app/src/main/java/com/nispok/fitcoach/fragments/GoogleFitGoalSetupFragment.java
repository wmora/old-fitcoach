package com.nispok.fitcoach.fragments;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.nispok.fitcoach.R;

public class GoogleFitGoalSetupFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_google_fit_goal_setup, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setFloatingLabelElevation(view);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setFloatingLabelElevation(View view) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return;
        }
        LinearLayout nameFloatingLabel = (LinearLayout) view.findViewById(R.id.name_floating_label);
        nameFloatingLabel.setElevation(getResources().getDimension(R.dimen.resting_elevation_low));
    }
}
