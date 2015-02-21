package com.nispok.fitcoach.services;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.content.Context;

public class SystemService {

    /**
     * Returns a system-level {@link android.app.AlarmManager} for receiving intents at the
     * time of your choosing.
     *
     * @param context
     * @return a system-level {@link android.app.AlarmManager}
     */
    public static AlarmManager getAlarmSystemService(Context context) {
        return (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    }

    /**
     * Returns a system-level {@link android.app.NotificationManager} for telling the user that
     * something has happened in the background.
     *
     * @param context
     * @return a system-level {@link android.app.NotificationManager}
     */
    public static NotificationManager getNotificationSystemService(Context context) {
        return (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }
}
