package com.nispok.fitcoach.databases;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = FitCoachDatabase.NAME, version = FitCoachDatabase.VERSION,
        foreignKeysSupported = true, backupEnabled = true)
public class FitCoachDatabase {

    public static final String NAME = "FitCoach";
    public static final int VERSION = 1;

}
