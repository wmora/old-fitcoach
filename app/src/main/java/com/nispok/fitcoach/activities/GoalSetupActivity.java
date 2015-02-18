package com.nispok.fitcoach.activities;

import android.content.Intent;
import android.os.Bundle;

import com.nispok.fitcoach.R;
import com.nispok.fitcoach.dialogs.GoalDialogFragment;
import com.nispok.fitcoach.fragments.GoalSetupFragment;
import com.nispok.fitcoach.models.Goal;

public class GoalSetupActivity extends GoogleFitnessClientActivity
        implements GoalDialogFragment.GoalDialogFragmentInterface,
        GoalSetupFragment.GoogleFitGoalSetupFragmentInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new GoalSetupFragment(),
                            GoalSetupFragment.TAG)
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
    public void onGoalSetupFinished() {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onGoalChanged(Goal goal) {
        GoalSetupFragment f = (GoalSetupFragment) getSupportFragmentManager().
                findFragmentByTag(GoalSetupFragment.TAG);

        if (f != null) {
            f.onGoalChanged(goal);
        }
    }
}
