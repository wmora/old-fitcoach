package com.nispok.fitcoach.services;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.nispok.fitcoach.intents.FitCoachIntent;
import com.nispok.fitcoach.models.Goal;
import com.nispok.fitcoach.models.Time;
import com.nispok.fitcoach.receivers.AlarmReceiver;

import java.util.Calendar;

public class AlarmService {

    public static void createAlarm(Context context, int requestCode, Goal goal) {
        AlarmManager alarmManager = SystemService.getAlarmSystemService(context);
        PendingIntent alarmIntent = createAlarmPendingIntent(context, requestCode, goal);
        Calendar calendar = getAlarmCalendar(goal.getNotification().getTime());
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, alarmIntent);
    }

    private static PendingIntent createAlarmPendingIntent(Context context, int requestCode, Goal goal) {
        Intent intent = new Intent(context, AlarmReceiver.class);
        intent.putExtra(FitCoachIntent.Extra.GOAL_ID, goal.getId());
        return PendingIntent.getBroadcast(context, requestCode, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
    }

    protected static Calendar getAlarmCalendar(Time time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, time.getHour());
        calendar.set(Calendar.MINUTE, time.getMinute());

        if (calendar.getTimeInMillis() < System.currentTimeMillis()) {
            calendar.add(Calendar.DATE, 1);
        }

        return calendar;
    }

}
