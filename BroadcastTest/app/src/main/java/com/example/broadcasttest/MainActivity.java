package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;
    private ButtonPressReceiver buttonPressReceiver;

    private LocalReceiver localReceiver; //本地广播
    private LocalBroadcastManager localBroadcastManager; //本地广播

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        localBroadcastManager = LocalBroadcastManager.getInstance(this); // 本地广播 获取实例

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent("com.example.broadcasttest.MY_BROADCAST"); //do not work
                //sendBroadcast(intent); //do not work

                /******* 发送本地广播 start ********/
                Intent intent = new Intent("com.example.broadcasttest.LOCAL_BROADCAST");
                localBroadcastManager.sendBroadcast(intent);
                /******* end ********/

                /******* start 动态注册自定义广播 *************/
                /*
                intentFilter = new IntentFilter();
                intentFilter.addAction("MY Dynamic BROADCAST");
                //intentFilter.setPriority(100); //设定广播优先级 //it doesn't work
                buttonPressReceiver = new ButtonPressReceiver();
                registerReceiver(buttonPressReceiver, intentFilter);
                Intent intent = new Intent();
                intent.setAction("MY Dynamic BROADCAST");
                //intent.putExtra("myBroadcastMSG", "msg:666"); // make no sense? 不需要传递到其他Activity
                //sendBroadcast(intent); //标准广播
                sendBroadcast(intent, null); //有序广播
                */
                /******** end ***************/
            }
        });

        intentFilter = new IntentFilter();
        /*
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);
        */
        intentFilter.addAction("com.example.broadcasttest.LOCAL_BROADCAST");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver, intentFilter); //注册本地广播监听器
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
        unregisterReceiver(buttonPressReceiver);
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    public class NetworkChangeReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if(networkInfo != null && networkInfo.isAvailable()) {
                Toast.makeText(context, "network is available", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
            }
            //Toast.makeText(context, "network changes", Toast.LENGTH_SHORT).show();
        }
    }

    public class ButtonPressReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("MY Dynamic BROADCAST".equals(intent.getAction())) {
                Toast.makeText(context, "Button Press in class ButtonPressReceiver", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public class LocalReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "Receive Local Broadcast!", Toast.LENGTH_SHORT).show();
        }
    }
}
