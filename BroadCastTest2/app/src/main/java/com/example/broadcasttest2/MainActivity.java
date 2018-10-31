package com.example.broadcasttest2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private Intent intent;
    private AnotherBroadcastReceiver2 anotherBroadcastReceiver2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentFilter = new IntentFilter();
        intentFilter.addAction("MY Dynamic BROADCAST");
        intentFilter.setPriority(Integer.MAX_VALUE); //设定广播优先级 //it doesn't work
        anotherBroadcastReceiver2 = new AnotherBroadcastReceiver2();
        registerReceiver(anotherBroadcastReceiver2, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(anotherBroadcastReceiver2);
    }

    public class AnotherBroadcastReceiver2 extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("MY Dynamic BROADCAST".equals(intent.getAction())) {
                Toast.makeText(context, "receive in another broadcast receiver 2", Toast.LENGTH_SHORT).show();
            }
            abortBroadcast(); //截断广播 //it doesn't work
        }
    }
}
