package com.mvx.mvxdemo.mvvm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.mvx.mvxdemo.R;
import com.mvx.mvxdemo.databinding.ActivityMvvmmainBinding;


public class MvvmMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //   ActivityMvvmmainBinding binding = ActivityMvvmmainBinding.inflate(getLayoutInflater());
        ActivityMvvmmainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvmmain);
        GeneratorObj generatorObj = new GeneratorObj("");

        // (1)按套路写好数据绑定，具体怎么实现双向数据绑定，都由DataBinding框架来完成
        // binding.setXX 与 variable进行数据绑定和事件绑定
        binding.setGeneratorObj(generatorObj);
        binding.setHandlers(new MyHandlers(generatorObj));

    }

}
