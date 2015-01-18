package com.nispok.fitcoach.activities;

import android.support.v7.widget.Toolbar;
import android.test.ActivityInstrumentationTestCase2;

import com.nispok.fitcoach.R;

public class ToolbarActivityTest extends ActivityInstrumentationTestCase2<WelcomeActivity> {

    public ToolbarActivityTest() {
        super(WelcomeActivity.class);
    }

    public void testToolbarActivityShouldAddToolbarWhenCreated() {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);

        assertNotNull(toolbar);
    }
}
