package com.example.uicustomviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class TitleLayout extends LinearLayout{
    public TitleLayout(Context context, AttributeSet attrs) { //重写带两个参数的构造函数，在布局中引用TitleLayout控件就会调用这个构造函数
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this); //LayoutInflater用于动态加载一个布局文件

        Button button_back = findViewById(R.id.title_back);
        Button button_edit = findViewById(R.id.title_edit);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Back!", Toast.LENGTH_SHORT).show();
            }
        });
        button_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Edit", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
