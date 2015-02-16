package com.nispok.fitcoach.models;

import com.nispok.fitcoach.databases.FitCoachDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.cache.BaseCacheableModel;

import java.io.Serializable;

@Table(value = Time.NAME, databaseName = FitCoachDatabase.NAME)
public class Time extends BaseCacheableModel implements Serializable {

    public static final String NAME = "GoalNotificationTime";

    private static final long serialVersionUID = 1L;

    @Column(columnType = Column.PRIMARY_KEY_AUTO_INCREMENT)
    Long id = 0l;

    @Column(notNull = true)
    Integer hour = 19;

    @Column(notNull = true)
    Integer minute = 0;

    public Time() {
        super();
    }

    public Long getId() {
        return id;
    }

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
