package com.mvx.mvxdemo.mvvm;

import android.os.AsyncTask;

// Model层，封装各种数据来源
public class GeneratorModel extends AsyncTask<Void, Void, Integer> {
    private String baseText;
    private GeneratorObj generatorObj;

    public GeneratorModel(String baseText, GeneratorObj generatorObj) {
        this.baseText = baseText;
        this.generatorObj = generatorObj;
    }

    // Simulates computing and returns a random integer
    @Override
    protected Integer doInBackground(Void... params) {
        try {
            // Simulate computing
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        return (int) (Math.random() * 100);
    }

    @Override
    protected void onPostExecute(Integer randomInt) {
        // （3）Model层调用ViewModel层
        generatorObj.setBaseText(baseText + randomInt);
    }
}
