package com.nispok.fitcoach.models;

import java.io.Serializable;

public class Goal implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id = "";
    private String name = "";
    private int value = 0;
    private GoalType type = GoalType.ACTIVE_TIME;
    private GoalFrequency frequency = GoalFrequency.DAILY;
    private GoalNotification notification = new GoalNotification();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param name the name of this {@link com.nispok.fitcoach.models.Goal}
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the name of this {@link com.nispok.fitcoach.models.Goal}
     */
    public String getName() {
        return name;
    }

    /**
     * @param value the value of this {@link com.nispok.fitcoach.models.Goal}
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * @return the value of this {@link com.nispok.fitcoach.models.Goal}
     */
    public int getValue() {
        return value;
    }

    /**
     * @return type of goal
     */
    public GoalType getType() {
        return type;
    }

    /**
     * @param type type of goal
     */
    public void setType(GoalType type) {
        this.type = type;
    }

    /**
     * @return frequency for this {@link com.nispok.fitcoach.models.Goal}
     */
    public GoalFrequency getFrequency() {
        return frequency;
    }

    /**
     * @param frequency frequency for this {@link com.nispok.fitcoach.models.Goal}
     */
    public void setFrequency(GoalFrequency frequency) {
        this.frequency = frequency;
    }

    public String getValueText() {
        return value + " " + type.getUnitText();
    }

    public GoalNotification getNotification() {
        return notification;
    }

    public void setNotification(GoalNotification notifications) {
        this.notification = notifications;
    }

    /**
     * Saves this {@link com.nispok.fitcoach.models.Goal} in local persistence
     */
    public void save() {
        //TODO: Implement me!
    }
}
