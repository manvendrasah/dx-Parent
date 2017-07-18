package com.xseed.dx.parent.utils;

import android.util.Log;

/**
 * Created by Manvendra Sah on 15/07/17.
 */

public final class Logger {
    private Logger() {

    }

    public static void log(String msg) {
        Log.d("Parent", "AISS > " + msg);
    }

    public static void logError(String msg) {
        Log.e("Parent", "AISS > " + msg);
    }
}