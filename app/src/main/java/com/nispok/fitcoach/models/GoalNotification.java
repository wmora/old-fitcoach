package com.nispok.fitcoach.models;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKeyAction;
import com.raizlabs.android.dbflow.annotation.ForeignKeyReference;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.cache.BaseCacheableModel;

import java.io.Serializable;

@Table
public class GoalNotification extends BaseCacheableModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(columnType = Column.PRIMARY_KEY_AUTO_INCREMENT)
    Long id = 0l;

    @Column(columnType = Column.FOREIGN_KEY, onDelete = ForeignKeyAction.CASCADE,
            onUpdate = ForeignKeyAction.CASCADE,
            references = {@ForeignKeyReference(columnType = Long.class,
                    columnName = "timeId", foreignColumnName = "id")})
    Time time;

    @Column(notNull = true)
    String title;

    @Column(notNull = true)
    String message;

    public GoalNotification() {
        super();
    }

    public Long getId() {
        return id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
