package com.nispok.fitcoach.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.nispok.fitcoach.R;

import static com.nispok.fitcoach.FitCoach.getApplication;
import static com.nispok.fitcoach.utils.ResourcesUtils.getString;

public class SettingsManager {

    private static SharedPreferences settingsPreferences;

    private static SharedPreferences getSettingsPreferences() {
        if (settingsPreferences == null) {
            settingsPreferences = getApplication().getSharedPreferences(
                    getString(R.string.settings_key), Context.MODE_PRIVATE);
        }

        return settingsPreferences;
    }

    private static SharedPreferences.Editor getEditor() {
        return getSettingsPreferences().edit();
    }

    /**
     * @return if this app has been authorized by the user to connect to Google Fit
     */
    public static boolean isAuthorizedForGoogleFit() {
        return getSettingsPreferences().getBoolean(
                getString(R.string.settings_is_authorized_for_google_key), false);
    }

    /**
     * @param authorized true if this app has been authorized to connect to Google Fit
     */
    public static void setAuthorizedForGoogleFit(boolean authorized) {
        getEditor().putBoolean(getString(R.string.settings_is_authorized_for_google_key),
                authorized).commit();
    }

}
