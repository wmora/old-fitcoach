package com.nispok.fitcoach;

import android.app.Application;

import com.nispok.fitcoach.services.GoalService;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class FitCoach extends Application {

    private static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        application = this;
        GoalService.getInstance().createWaterGoal();
    }

    public static Application getApplication() {
        return application;
    }

}
