package com.example.androidthreadtest;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int UPDATE_TEXT = 1;

    private TextView textView;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) { //此时的 handleMessage 是在主线程中运行的
            super.handleMessage(msg);
            switch(msg.what) {
                case UPDATE_TEXT:
                    textView.setText("Nice to meet you !"); // 在这里可以进行UI操作
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text_view);
        Button changeText = (Button) findViewById(R.id.change_text);
        changeText.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.change_text:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //textView.setText("Nice to meet you ?"); // 在子线程中更新UI，会导致程序崩溃
                        // 可是当我把  TextView 的 这个属性设定为 android:layout_width="match_parent" 时，在子线程中更新UI也不会崩溃，这是为何？
                        Message msg = new Message();
                        msg.what = UPDATE_TEXT;
                        handler.sendMessage(msg); // 将Message消息发送出去
                    }
                }).start();
                break;
            default:
                break;
        }
    }
}
