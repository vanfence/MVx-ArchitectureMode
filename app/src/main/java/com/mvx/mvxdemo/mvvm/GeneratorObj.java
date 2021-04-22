package com.mvx.mvxdemo.mvvm;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.mvx.mvxdemo.BR;


// 数据对象类
public class GeneratorObj extends BaseObservable {

    @Bindable
    public static String baseText;

    public GeneratorObj(String baseText) {
        this.baseText = baseText;
    }

    public String getBaseText() {
        return baseText;
    }

    public void setBaseText(String baseText) {
        GeneratorObj.baseText = baseText;
        notifyPropertyChanged(BR.baseText);
    }

}
