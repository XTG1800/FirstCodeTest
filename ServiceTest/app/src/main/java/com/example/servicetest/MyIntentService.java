package com.example.servicetest;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("This is MyIntentService");
        Log.d("MyIntentService", "MyIntentService executed");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //这里应该处理服务的一些具体逻辑
        Log.d("MyIntentService", "Thread ID is " + Thread.currentThread().getId());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyIntentService", "onDestroy executed");
    }
}
