package com.nispok.fitcoach;

import android.app.Application;

import com.nispok.fitcoach.services.GoalService;

public class FitCoach extends Application {

    private static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        GoalService.getInstance().createWaterGoal();
    }

    public static Application getApplication() {
        return application;
    }

}
