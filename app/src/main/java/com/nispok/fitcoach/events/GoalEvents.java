package com.nispok.fitcoach.events;

import com.nispok.fitcoach.models.Goal;

/**
 * {@link com.nispok.fitcoach.events.Event}s related to {@link com.nispok.fitcoach.models.Goal}s
 */
public class GoalEvents {

    /**
     * {@link com.nispok.fitcoach.events.Event} that indicates when a
     * {@link com.nispok.fitcoach.models.Goal} has been saved
     */
    public static class GoalSavedEvent extends Event<Goal> {
        public GoalSavedEvent(Goal result) {
            super(result);
        }
    }

}
