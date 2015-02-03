package com.nispok.fitcoach.services;

import android.app.Activity;
import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
public class BaseServiceTest {

    private static class TestBaseService extends BaseService {
        // Used for testing base class
    }

    @Test
    public void testGetContextShouldReturnContext() {
        Context context = TestBaseService.getContext();
        assertNotNull(context);
    }

    @Test
    public void testContextShouldNotBeActivityContext() {
        Context context = TestBaseService.getContext();
        assertFalse(context instanceof Activity);
    }

}
