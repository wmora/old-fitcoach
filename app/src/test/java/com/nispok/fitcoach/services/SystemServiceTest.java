package com.nispok.fitcoach.services;

import android.app.AlarmManager;
import android.app.NotificationManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static junit.framework.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
public class SystemServiceTest {

    @Test
    public void testGetAlarmSystemServiceShouldReturnAlarmManager() {
        AlarmManager alarmManager = SystemService.getAlarmSystemService(Robolectric.application);
        assertNotNull(alarmManager);
    }

    @Test
    public void testGetNotificationSystemServiceShouldReturnNotificationManager() {
        NotificationManager notificationManager = SystemService
                .getNotificationSystemService(Robolectric.application);
        assertNotNull(notificationManager);
    }

}
