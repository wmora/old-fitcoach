package com.nispok.fitcoach.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.nispok.fitcoach.services.GoalService;

/**
 * This BroadcastReceiver automatically starts all configured alarms when the device is rebooted
 */
public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            GoalService.getInstance().createWaterGoal();
        }
    }

}
