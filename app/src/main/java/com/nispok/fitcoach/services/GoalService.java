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

    public Goal createWaterGoal() {
        Goal waterGoal = new Goal();
        waterGoal.setId("water_goal");
        GoalNotification goalNotification = waterGoal.getNotification();
        Time time = new Time();
        time.setHour(14);
        time.setMinute(0);
        goalNotification.setTime(time);
        goalNotification.setMessage("Don't forget to drink 2 liters of water today!");
        AlarmService.getInstance().createAlarm(FitCoachIntent.RequestCode.WATER_REMINDER, waterGoal);
        return waterGoal;
    }
}
