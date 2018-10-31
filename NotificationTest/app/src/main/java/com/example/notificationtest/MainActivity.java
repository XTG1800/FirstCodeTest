package com.example.notificationtest;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "channel_01";
            String channelName = "弹窗";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }
*/
        Button sendNoticeButton = (Button) findViewById(R.id.send_notice);
        sendNoticeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.send_notice:
                Intent intent = new Intent(this, NotificationActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    //书上的例子在 Android 8 不显示通知，需要以下适配
                    NotificationChannel mChannel =new NotificationChannel("channel_01","消息推送", NotificationManager.IMPORTANCE_HIGH);
                    notificationManager.createNotificationChannel(mChannel);//创建一个通知渠道
                }

                Notification notification = new NotificationCompat.Builder(this, "default")
                        .setContentTitle("This is content title")
                        //.setContentText("THIS IS CONTENT TEXT")
                        //用于显示通知长文字
                        .setContentText("THIS IS CONTENT TEXT. i wish i had told you that this is a content text layout which is used for testing notification pending intent.")
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("THIS IS CONTENT TEXT. i wish i had told you that this is a content text layout which is used for testing notification pending intent."))
                        //用于在通知显示一张图片
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.big_image)))
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .setChannelId("channel_01") //Android 8 需要设定 Channel ID
                        .setContentIntent(pendingIntent) //设定按下通知后的意图
                        //.setAutoCancel(true) //通知按下后消失
                        //.setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg"))) //设定通知提示音
                        //.setVibrate(new long[] {0, 1000, 1000, 1000}) //设定通知震动提示 //不过此需要权限，需要在清单文件添加权限
                        //.setLights(Color.GREEN, 1000, 1000) //设定前置LED提示灯
                        //.setDefaults(NotificationCompat.DEFAULT_ALL) //设定默认通知提醒，包括铃声、震动等
                        //.setPriority(NotificationCompat.PRIORITY_MAX) //PRIORITY_MAX在 Android 8 已被弃用
                        .build();
                notificationManager.notify(1,notification);
                break;
            default:
                break;
        }
    }
}
