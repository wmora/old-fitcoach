package com.nispok.fitcoach.activities;

import android.os.Bundle;

import com.nispok.fitcoach.R;
import com.nispok.fitcoach.fragments.WelcomeFragment;


public class WelcomeActivity extends GoogleFitnessClientActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
}
