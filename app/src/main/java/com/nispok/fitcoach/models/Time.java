package com.nispok.fitcoach.models;

import java.io.Serializable;

public class Time implements Serializable {

    private static final long serialVersionUID = 1L;

    private int hour = 19;
    private int minute = 0;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    @Override
    public String toString() {
        return String.format("%d:2%d", hour, minute);
    }
}
