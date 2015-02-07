package com.nispok.fitcoach.receivers;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

import com.nispok.fitcoach.services.NotificationService;

/**
 * When an alarm fires, this WakefulBroadcastReceiver receives the broadcast Intent
 * and then starts the IntentService {@code NotificationService} to do some work.
 */
public class AlarmReceiver extends WakefulBroadcastReceiver {

    /**
     * Starts the notification service, which will handle the actual work based on the broadcast
     * Intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent service = new Intent(context, NotificationService.class);
        startWakefulService(context, service);
    }

}
