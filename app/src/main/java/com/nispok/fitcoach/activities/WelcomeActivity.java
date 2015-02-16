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
            goToHomeActivity();
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
        goToHomeActivity();
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
        goToHomeActivity();
    }

    private void goToHomeActivity() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
        finish();
    }
}
