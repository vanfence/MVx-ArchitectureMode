package com.mvx.mvxdemo.mvc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mvx.mvxdemo.R;

// Activity即是Controller,同时也是View的一部分
public class MvcMainActivity extends AppCompatActivity {
    TextView greetingTextView;
    Button helloButton;
    Button goodbyeButtonClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvcmain);
        greetingTextView = findViewById(R.id.greetingTextView);
        helloButton = findViewById(R.id.helloButton);
        goodbyeButtonClicked = findViewById(R.id.goodbyeButtonClicked);
        // （1）View传递调用到Controller,回调
        helloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // （2）Controller直接调用Model层
                new GeneratorModel("HelloWorld", greetingTextView).execute();
            }
        });

        // （1）View传递调用到Controller，回调
        goodbyeButtonClicked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // （2）Controller直接调用Model层
                new GeneratorModel("GoodBye", greetingTextView).execute();
            }
        });
    }
}

