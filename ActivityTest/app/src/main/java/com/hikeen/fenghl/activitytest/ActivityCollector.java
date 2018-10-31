package com.hikeen.fenghl.activitytest;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {

    public static final String TAG = "ActivityCollector";

    public static List<Activity> activities = new ArrayList<>();

    protected static void addActivity(Activity activity) {
        activities.add(activity);
        Log.d(TAG, "addActivity: ");
    }

    protected static void removeActivity(Activity activity) {
        activities.remove(activity);
        Log.d(TAG, "removeActivity: ");
    }

    protected static void finishAll() {
        for(Activity activity : activities) {
            if(!activity.isFinishing()) {
                activity.finish();
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        Log.d(TAG, "finishAll: ");
    }
}
