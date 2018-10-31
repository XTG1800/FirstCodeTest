package com.example.fragmenttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //replaceFragment(new RightFragment());

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: replace another fragment
                //replaceFragment(new AnotherRightFragment()); //step 1: 创建碎片实例
            }
        });
    }
/*
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();  //step 2: 获取FragmentManager
        FragmentTransaction transaction = fragmentManager.beginTransaction();   //step 3: 开启一个事务
        transaction.replace(R.id.right_frame_layout, fragment); //step 4: 向容器内添加/替换碎片
        transaction.addToBackStack(null);   //在碎片中模拟返回栈
        transaction.commit();   //step 5: 提交事务
    }
*/
}
