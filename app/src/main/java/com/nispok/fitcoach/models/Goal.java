package com.nispok.fitcoach.models;

import com.nispok.fitcoach.databases.FitCoachDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKeyAction;
import com.raizlabs.android.dbflow.annotation.ForeignKeyReference;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.cache.BaseCacheableModel;

import java.io.Serializable;

@Table(databaseName = FitCoachDatabase.NAME)
public class Goal extends BaseCacheableModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(columnType = Column.PRIMARY_KEY_AUTO_INCREMENT)
    Long id = 0l;

    @Column(notNull = true)
    String name;

    @Column
    Double value = 0.0;

    private GoalType type = GoalType.ACTIVE_TIME;

    private GoalFrequency frequency = GoalFrequency.DAILY;

    @Column(columnType = Column.FOREIGN_KEY, onDelete = ForeignKeyAction.CASCADE,
            onUpdate = ForeignKeyAction.CASCADE,
            references = {@ForeignKeyReference(columnType = Long.class,
                    columnName = "notificationId", foreignColumnName = "id")})
    GoalNotification notification = new GoalNotification();

    public Goal() {
        super();
    }

    public Long getId() {
        return id;
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
    public void setValue(Double value) {
        this.value = value;
    }

    /**
     * @return the value of this {@link com.nispok.fitcoach.models.Goal}
     */
    public Double getValue() {
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

    public void setNotification(GoalNotification notification) {
        this.notification = notification;
    }
}
