package com.example.uicustomviews;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "fenghl";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.d(TAG, "onCreate: ");
        ActionBar actionbar = getSupportActionBar();//getActionBar()此处用这个是错的，用了没有效果
        if(actionbar != null) {
            actionbar.hide();
            //Log.d(TAG, "hide actionbar");
        }
        Button button = findViewById(R.id.button_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
