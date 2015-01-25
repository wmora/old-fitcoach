package com.nispok.fitcoach.models;

import java.io.Serializable;

public class Goal implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name = "";
    private int value = 0;
    private GoalType type = GoalType.ACTIVE_TIME;

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
}
