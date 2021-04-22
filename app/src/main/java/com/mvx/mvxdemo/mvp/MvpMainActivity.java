package com.mvx.mvxdemo.mvp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.mvx.mvxdemo.R;

// View层，视图层
public class MvpMainActivity extends MvpActivity<IHelloView, HelloWorldPresenter> implements IHelloView {
    TextView greetingTextView;
    Button helloButton;
    Button goodbyeButtonClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpmain);
        greetingTextView = findViewById(R.id.greetingTextView);
        helloButton = findViewById(R.id.helloButton);
        goodbyeButtonClicked = findViewById(R.id.goodbyeButtonClicked);
        helloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // （1）调用Presenter层数据操作
                presenter.greetHello();
            }
        });
        goodbyeButtonClicked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // （1）调用Presenter层数据操作
                presenter.greetGoodbye();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public HelloWorldPresenter createPresenter() {
        return new HelloWorldPresenter();
    }

    // 实现IView 接口，具体对View的操作
    @Override
    public void showHello(String greetingText) {
        greetingTextView.setTextColor(Color.RED);
        greetingTextView.setText(greetingText);
    }

    // 实现IView 接口，具体对View的操作
    @Override
    public void showGoodbye(String greetingText) {
        greetingTextView.setTextColor(Color.BLUE);
        greetingTextView.setText(greetingText);
    }
}
