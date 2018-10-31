package com.hikeen.fenghl.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    public static final String TAG = "FirstActivity";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"你按下了 添加 !",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"你按下了 移除 !",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        //Log.d(TAG, "onCreate: ");
        Log.d(TAG, this.toString());
        Log.d(TAG, "Task ID is " + getTaskId());
        Log.d(TAG, "fenghl onCreate 222");

        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(FirstActivity.this,"你按下了 Button 1!",Toast.LENGTH_SHORT).show();
                //finish(); //销毁活动
                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);//显式Intent
                //Intent intent = new Intent("com.hikeen.fenghl.activitytest.ACTION_START");//隐式Intent
                //Intent intent = new Intent(FirstActivity.this, FirstActivity.class);//用于探讨Standard启动模式的问题
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });


    }
    
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
        Log.d(TAG, "fenghl -> onDestroy 222");
    }
}
