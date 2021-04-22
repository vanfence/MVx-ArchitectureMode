package com.mvx.mvxdemo.mvp;

import com.hannesdorfmann.mosby.mvp.MvpView;

public interface IHelloView extends MvpView {
    void showHello(String greetingText);

    void showGoodbye(String greetingText);
}
