package com.nispok.fitcoach.activities;

import android.os.Bundle;

import com.nispok.fitcoach.R;
import com.nispok.fitcoach.fragments.WelcomeFragment;

public class WelcomeActivity extends GoogleFitnessClientActivity
        implements WelcomeFragment.WelcomeFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.welcome);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new WelcomeFragment())
                    .commit();
        }
    }

    @Override
    protected boolean shouldConnectOnStart() {
        return false;
    }

    @Override
    public void onSignInSkipped() {
        // User doesn't want to use Google Fit :(
        finish();
    }
}
