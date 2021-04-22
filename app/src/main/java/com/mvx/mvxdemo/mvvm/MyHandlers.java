package com.mvx.mvxdemo.mvvm;

import android.view.View;

// 绑定方法类
// MyHandlers中实现操作Model的方法，这些方法与xml中布局文件是对应的，会被DataBinding框架自动调用。
public class MyHandlers {
    private GeneratorObj generatorObj;

    public MyHandlers(GeneratorObj generatorObj) {
        this.generatorObj = generatorObj;
    }

    public void onClickHello(View view) {

        // （2）ViewModel层调用Model层
        new GeneratorModel("HelloWorld", generatorObj).execute();
    }

    public void onClickGoodbye(View view) {

        // （2）ViewModel层调用Model层
        new GeneratorModel("GoodBye", generatorObj).execute();
    }
}
