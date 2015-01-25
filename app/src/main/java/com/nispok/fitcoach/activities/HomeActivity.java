package com.nispok.fitcoach.activities;

import android.os.Bundle;

import com.nispok.fitcoach.R;
import com.nispok.fitcoach.fragments.HomeFragment;

public class HomeActivity extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new HomeFragment(), HomeFragment.TAG)
                    .commit();
        }
    }

}
