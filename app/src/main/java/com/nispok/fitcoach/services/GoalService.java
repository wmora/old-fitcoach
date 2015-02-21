package com.nispok.fitcoach.services;

import com.nispok.fitcoach.events.BusProvider;
import com.nispok.fitcoach.events.GoalEvents;
import com.nispok.fitcoach.models.Goal;
import com.nispok.fitcoach.models.GoalNotification;
import com.nispok.fitcoach.models.Time;
import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

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

        save(waterGoal);

        return waterGoal;
    }

    /**
     * Gets a {@link com.nispok.fitcoach.models.Goal} with the given {@code id}
     *
     * @param id goal ID
     * @return a {@link com.nispok.fitcoach.models.Goal} with the given ID, {@code null} otherwise
     */
    public Goal get(long id) {
        return new Select().from(Goal.class)
                .where(Condition.column("id").is(id))
                .querySingle();
    }

    /**
     * Returns all goals
     *
     * @return all {@link com.nispok.fitcoach.models.Goal}s
     */
    public List<Goal> getAll() {
        return new Select().from(Goal.class).queryList();
    }

    /**
     * Saves a {@link com.nispok.fitcoach.models.Goal} and dispatches a
     * {@link com.nispok.fitcoach.events.GoalEvents.GoalSavedEvent}
     *
     * @param goal the {@link com.nispok.fitcoach.models.Goal} to be saved
     */
    public void save(Goal goal) {
        goal.save(false);
        BusProvider.bus().post(new GoalEvents.GoalSavedEvent(goal));
    }
}
