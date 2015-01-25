package com.nispok.fitcoach.activities;

import android.os.Bundle;

import com.nispok.fitcoach.R;
import com.nispok.fitcoach.dialogs.GoalDialogFragment;
import com.nispok.fitcoach.fragments.GoogleFitGoalSetupFragment;
import com.nispok.fitcoach.models.Goal;

public class GoogleFitGoalSetupActivity extends GoogleFitnessClientActivity
        implements GoalDialogFragment.GoalDialogFragmentInterface,
        GoogleFitGoalSetupFragment.GoogleFitGoalSetupFragmentInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new GoogleFitGoalSetupFragment(),
                            GoogleFitGoalSetupFragment.TAG)
                    .commit();
        }
    }

    @Override
    protected void onConnectionSuccess() {

    }

    @Override
    public void onGoalValueSelected(Goal goal) {
        GoalDialogFragment fragment = GoalDialogFragment.newInstance(goal);
        fragment.show(getSupportFragmentManager(), GoalDialogFragment.TAG);
    }

    @Override
    public void onGoalChanged(Goal goal) {
        GoogleFitGoalSetupFragment f = (GoogleFitGoalSetupFragment) getSupportFragmentManager().
                findFragmentByTag(GoogleFitGoalSetupFragment.TAG);

        if (f != null) {
            f.onGoalChanged(goal);
        }
    }
}
