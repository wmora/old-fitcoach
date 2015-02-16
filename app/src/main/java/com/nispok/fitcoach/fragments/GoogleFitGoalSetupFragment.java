package com.nispok.fitcoach.fragments;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nispok.fitcoach.R;
import com.nispok.fitcoach.models.Goal;

public class GoogleFitGoalSetupFragment extends Fragment {

    public static final String TAG = GoogleFitGoalSetupFragment.class.getSimpleName();

    private static final String SAVED_GOAL = "SAVED_GOAL";

    private GoogleFitGoalSetupFragmentInterface listener;
    private View goalView;
    private EditText goalNameView;

    private Goal goal = new Goal();

    public interface GoogleFitGoalSetupFragmentInterface {
        public void onGoalValueSelected(Goal goal);
        public void onGoalSetupFinished();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (GoogleFitGoalSetupFragmentInterface) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement " + TAG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            goal = (Goal) savedInstanceState.getSerializable(SAVED_GOAL);
        }

        setHasOptionsMenu(true);

        return inflater.inflate(R.layout.fragment_google_fit_goal_setup, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setFloatingLabelElevation(view);
        setUpGoalNameView(view);
        setUpGoalView(view);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_google_fit_goal_setup, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save) {
            goal.save(false);
            listener.onGoalSetupFinished();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setFloatingLabelElevation(View view) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return;
        }
        LinearLayout nameFloatingLabel = (LinearLayout) view.findViewById(R.id.name_floating_label);
        nameFloatingLabel.setElevation(getResources().getDimension(R.dimen.resting_elevation_low));
    }

    private void setUpGoalNameView(View view) {
        goalNameView = (EditText) view.findViewById(R.id.goal_name);
        goalNameView.setText(goal.getName());
    }

    public void setUpGoalView(View view) {
        goalView = view.findViewById(R.id.goal);
        goalView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onGoalValueSelected(goal);
            }
        });
        updateGoalView();
    }

    private void updateGoalView() {
        TextView goalValue = (TextView) goalView.findViewById(R.id.goal_value);
        goalValue.setText(goal.getValueText());
    }

    public void onGoalChanged(Goal goal) {
        this.goal = goal;
        updateGoalView();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(SAVED_GOAL, goal);
    }

}
