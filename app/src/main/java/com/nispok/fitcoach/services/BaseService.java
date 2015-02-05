package com.nispok.fitcoach.services;

import android.content.Context;

import static com.nispok.fitcoach.FitCoach.getApplication;

/**
 * A service that provides an application context to use. All non-Android services should extend
 * from this class if a {@link android.content.Context} is needed
 */
public abstract class BaseService {

    protected Context context;

    protected BaseService() {
        context = getApplication();
    }

}
