package com.nispok.fitcoach.activities;

import android.content.Intent;
import android.os.Bundle;

import com.nispok.fitcoach.R;
import com.nispok.fitcoach.fragments.WelcomeFragment;

import static com.nispok.fitcoach.preferences.SettingsManager.isAuthorizedForGoogleFit;

public class WelcomeActivity extends GoogleFitnessClientActivity
        implements WelcomeFragment.WelcomeFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (isAuthorizedForGoogleFit()) {
            goToGoalSetupActivity();
        }

        setTitle(R.string.welcome);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new WelcomeFragment())
                    .commit();
        }
    }

    @Override
    protected void onConnectionSuccess() {
        goToGoalSetupActivity();
    }

    private void goToGoalSetupActivity() {
        Intent intent = new Intent(getApplicationContext(), GoogleFitGoalSetupActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected boolean shouldConnectOnStart() {
        return isAuthorizedForGoogleFit();
    }

    @Override
    public void onSignIn() {
        googleApiClient.connect();
    }

    @Override
    public void onSignInSkipped() {
        // User doesn't want to use Google Fit :(
        finish();
    }
}
