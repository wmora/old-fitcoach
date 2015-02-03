package com.nispok.fitcoach.services;

import android.app.AlarmManager;
import android.content.Context;

public class SystemService extends BaseService {

    /**
     * Returns a system-level {@link android.app.AlarmManager} for receiving intents at the
     * time of your choosing.
     *
     * @return the {@link android.app.AlarmManager}
     */
    public static AlarmManager getAlarmSystemService() {
        return (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
    }
}
