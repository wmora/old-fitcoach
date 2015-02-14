package com.nispok.fitcoach.services;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

import com.nispok.fitcoach.R;
import com.nispok.fitcoach.intents.FitCoachIntent;
import com.nispok.fitcoach.models.Goal;

public class NotificationService extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public NotificationService() {
        super(NotificationService.class.getName());
    }

    /**
     * Creates a notification based on the {@link com.nispok.fitcoach.models.Goal} included in the
     * {@link android.content.Intent}. The {@link android.app.Notification} will not open the app
     * and can only be dismissed
     *
     * @param intent
     */
    @Override
    protected void onHandleIntent(Intent intent) {
        Goal goal = (Goal) intent.getExtras().getSerializable(FitCoachIntent.Extra.GOAL);

        if (goal == null) {
            return;
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentTitle(goal.getNotification().getTitle())
                .setContentText(goal.getNotification().getMessage())
                .setDefaults(Notification.DEFAULT_ALL);

        PendingIntent dummyIntent = PendingIntent.getActivity(this, 0, new Intent(),
                PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(dummyIntent);

        NotificationManager notificationManager = SystemService.getInstance()
                .getNotificationSystemService();

        notificationManager.notify(goal.getId().hashCode(), builder.build());
    }
}
