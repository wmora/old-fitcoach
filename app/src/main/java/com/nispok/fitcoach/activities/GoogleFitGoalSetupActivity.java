package com.nispok.fitcoach.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_google_fit_goal_setup, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
