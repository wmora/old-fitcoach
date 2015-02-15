package com.nispok.fitcoach;

import android.app.Application;

import com.nispok.fitcoach.services.GoalService;
import com.crashlytics.android.Crashlytics;
import com.raizlabs.android.dbflow.config.FlowManager;

import io.fabric.sdk.android.Fabric;

public class FitCoach extends Application {

    private static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        FlowManager.init(this);
        application = this;
        GoalService.getInstance().createWaterGoal();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        FlowManager.destroy();
    }

    public static Application getApplication() {
        return application;
    }

}
