package com.nispok.fitcoach.services;

import android.app.AlarmManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static junit.framework.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
public class SystemServiceTest {

    @Test
    public void testGetAlarmSystemServiceShouldReturnAlarmManager() {
        AlarmManager alarmManager = SystemService.getInstance().getAlarmSystemService();
        assertNotNull(alarmManager);
    }

}
