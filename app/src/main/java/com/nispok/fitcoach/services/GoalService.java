package com.nispok.fitcoach.services;

import com.nispok.fitcoach.intents.FitCoachIntent;
import com.nispok.fitcoach.models.Goal;
import com.nispok.fitcoach.models.GoalNotification;
import com.nispok.fitcoach.models.Time;

public class GoalService extends BaseService {

    private static GoalService instance;

    public static GoalService getInstance() {
        if (instance == null) {
            instance = new GoalService();
        }
        return instance;
    }

    /**
     * Creates a goal of drinking water everyday and schedules a notification at a fixed time
     *
     * @return the created {@link com.nispok.fitcoach.models.Goal}
     */
    public Goal createWaterGoal() {
        Goal waterGoal = new Goal();
        waterGoal.setId("water_goal");
        GoalNotification goalNotification = waterGoal.getNotification();
        Time time = new Time();
        time.setHour(14);
        time.setMinute(0);
        goalNotification.setTime(time);
        goalNotification.setTitle("Drink water!");
        goalNotification.setMessage("Remember to drink 2 liters of water!");
        AlarmService.getInstance().createAlarm(FitCoachIntent.RequestCode.WATER_REMINDER, waterGoal);
        return waterGoal;
    }
}
