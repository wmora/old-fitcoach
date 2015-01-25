package com.nispok.fitcoach.models;

import java.io.Serializable;

public class Goal implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name = "";
    private int value = 0;

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
}
