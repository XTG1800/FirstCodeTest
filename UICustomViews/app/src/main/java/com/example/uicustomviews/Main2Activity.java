package com.example.uicustomviews;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ActionBar actionbar = getSupportActionBar();//getActionBar()此处用这个是错的，用了没有效果
        if(actionbar != null) {
            actionbar.hide();
            //Log.d(TAG, "hide actionbar");
        }
    }
}
