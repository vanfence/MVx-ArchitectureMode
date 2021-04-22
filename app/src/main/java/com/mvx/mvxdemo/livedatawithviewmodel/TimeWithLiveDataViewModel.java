package com.mvx.mvxdemo.livedatawithviewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

/*
  ViewMode 存放页面所需的数据与一些与数据相关的业务逻辑，分担Activity的部分工作
  LiveData 封装数据，当ViewModel中的数据变化时通知页面
 */

public class TimeWithLiveDataViewModel extends ViewModel {

    private Timer timer;
    // 计时信息的展示
    private MutableLiveData<Integer> currentSeconds;
    private int second;


    public LiveData<Integer> getCurrentSeconds() {
        if (currentSeconds == null) {
            currentSeconds = new MutableLiveData<>();
        }
        return currentSeconds;
    }

    // 开始计时
    public void startTiming() {

        if (timer == null) {
            second = 0;
            timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    // postValue()方法用在非UI线程中,而setValue()方法用在UI线程中
                    currentSeconds.postValue(second++);
                }
            };
            timer.schedule(timerTask, 1000, 1000);
        }

    }

    public void stopTiming() {
        timer.cancel();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        timer.cancel();
    }
}
