package com.nispok.fitcoach.models;

import android.support.annotation.StringRes;

import com.nispok.fitcoach.R;

import static com.nispok.fitcoach.utils.ResourcesUtils.getString;

public enum GoalType {

    ACTIVE_TIME(R.string.goal_type_unit_active_time);

    private int unitStringResId;

    GoalType(@StringRes int unitStringResId) {
        this.unitStringResId = unitStringResId;
    }

    public String getUnitText() {
        return getString(unitStringResId);
    }
}
