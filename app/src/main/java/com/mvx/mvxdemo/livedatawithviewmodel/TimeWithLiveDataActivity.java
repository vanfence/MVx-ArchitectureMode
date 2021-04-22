package com.mvx.mvxdemo.livedatawithviewmodel;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.mvx.mvxdemo.R;

/*
  LiveData的基本使用方法
 */
public class TimeWithLiveDataActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();

    }

    private void initComponent() {

        // 通过 ViewModelProviders或 ViewModelProvider来获取ViewModel对象
        /*final TimeWithLiveDataViewModel timeWithLiveDataViewModel = ViewModelProviders.of(TimeWithLiveDataActivity.this)
                .get(TimeWithLiveDataViewModel.class);*/

        final TimeWithLiveDataViewModel timeWithLiveDataViewModel = new ViewModelProvider(this).get(TimeWithLiveDataViewModel.class);

        // 得到ViewModel中的LiveData
        final MutableLiveData<Integer> liveData = (MutableLiveData<Integer>) timeWithLiveDataViewModel.getCurrentSeconds();

        // 通过 LiveData.observer()观察ViewModel中的数据变化(LiveData中包装的数据)
        liveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                tv = findViewById(R.id.tv);
                tv.setText("Time: " + integer);
            }
        });

        // 重置计时器
        findViewById(R.id.btnReset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 通过 LiveData.setValue()或 LiveData.postValue()对ViewModel中的数据更新
                liveData.setValue(0);
                timeWithLiveDataViewModel.stopTiming();
            }
        });

        // 开始计数
        timeWithLiveDataViewModel.startTiming();
    }
}
