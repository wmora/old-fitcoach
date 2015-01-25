package com.nispok.fitcoach.models;

import com.nispok.fitcoach.R;

import java.io.Serializable;

import static com.nispok.fitcoach.utils.ResourcesUtils.getString;

public class GoalNotification implements Serializable {

    private static final long serialVersionUID = 1L;

    private Time time;
    private String message;

    public GoalNotification() {
        time = new Time();
        message = getString(R.string.goal_notification_message);
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
