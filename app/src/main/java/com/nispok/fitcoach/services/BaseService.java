package com.nispok.fitcoach.services;

import android.content.Context;

import static com.nispok.fitcoach.FitCoach.getApplication;

/**
 * A service that provides an application context to use. All non-Android services shoul extend
 * from this class if a {@link android.content.Context} is needed
 */
public abstract class BaseService {

    private static Context context;

    /**
     * Provides the application context
     *
     * @return the application {@link android.content.Context}
     */
    protected static Context getContext() {
        if (context == null) {
            context = getApplication();
        }
        return context;
    }
}
