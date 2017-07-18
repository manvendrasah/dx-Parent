package com.xseed.dx.parent.base;

import android.app.Application;

/**
 * Created by abhi on 06/12/16.
 */

public class ParentAppApplication extends Application {

    private static ParentAppApplication instance = null;

    public static ParentAppApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
