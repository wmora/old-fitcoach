package com.nispok.fitcoach;

import android.app.Application;

public class FitCoach extends Application {

    private static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static Application getApplication() {
        return application;
    }

}
