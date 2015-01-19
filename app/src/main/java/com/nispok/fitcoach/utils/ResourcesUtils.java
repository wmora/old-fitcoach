package com.nispok.fitcoach.utils;

import android.support.annotation.StringRes;

import static com.nispok.fitcoach.FitCoach.getApplication;

/**
 * Util class to get resources from objects without a {@link android.content.Context} reference
 */
public class ResourcesUtils {

    /**
     * Return a localized string from the application's package's
     * default string table.
     *
     * @param resId Resource id for the string
     */
    public static String getString(@StringRes int resId) {
        return getApplication().getString(resId);
    }

}
