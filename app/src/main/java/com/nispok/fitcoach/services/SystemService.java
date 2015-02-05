package com.nispok.fitcoach.services;

import android.app.AlarmManager;
import android.content.Context;

public class SystemService extends BaseService {

    private static SystemService instance;

    public static SystemService getInstance() {
        if (instance == null) {
            instance = new SystemService();
        }
        return instance;
    }

    /**
     * Returns a system-level {@link android.app.AlarmManager} for receiving intents at the
     * time of your choosing.
     *
     * @return the {@link android.app.AlarmManager}
     */
    public AlarmManager getAlarmSystemService() {
        return (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    }
}
