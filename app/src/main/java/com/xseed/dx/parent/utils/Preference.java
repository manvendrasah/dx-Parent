package com.xseed.dx.parent.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Single ton SharedPreference
 */
public final class Preference {

    private static final String FILENAME = "xseed_parent_preference";
    private static Preference instance = null;
    private final SharedPreferences sharedPrefrence;

    @SuppressWarnings("PMD.AvoidSynchronizedAtMethodLevel")
    public static synchronized Preference getInstance(Context context) {
        if (instance == null) {
            instance = new Preference(context);
        }
        return instance;
    }

    private Preference(Context context) {
        sharedPrefrence = context.getApplicationContext().getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
    }
}