package com.nispok.fitcoach.services;

import com.nispok.fitcoach.models.Goal;
import com.nispok.fitcoach.models.GoalNotification;
import com.nispok.fitcoach.models.Time;
import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

public class GoalService {

    /**
     * Creates a goal of drinking water everyday and schedules a notification at a fixed time
     *
     * @return the created {@link com.nispok.fitcoach.models.Goal}
     */
    public static Goal createWaterGoal() {
        Goal waterGoal = new Goal();
        GoalNotification goalNotification = new GoalNotification();
        Time time = new Time();
        time.setHour(14);
        time.setMinute(0);
        goalNotification.setTime(time);
        goalNotification.setTitle("Drink water!");
        goalNotification.setMessage("Remember to drink 2 liters of water!");
        waterGoal.setName("Drink 2 liters of water");
        waterGoal.setValue(2.0);
        waterGoal.setNotification(goalNotification);
        waterGoal.save(false);

        return waterGoal;
    }

    /**
     * Gets a {@link com.nispok.fitcoach.models.Goal} with the given {@code id}
     *
     * @param id goal ID
     * @return a {@link com.nispok.fitcoach.models.Goal} with the given ID, {@code null} otherwise
     */
    public static Goal get(long id) {
        return new Select().from(Goal.class)
                .where(Condition.column("id").is(id))
                .querySingle();
    }

    /**
     * Returns all goals
     *
     * @return all {@link com.nispok.fitcoach.models.Goal}s
     */
    public static List<Goal> getAll() {
        return new Select().from(Goal.class).queryList();
    }

}
