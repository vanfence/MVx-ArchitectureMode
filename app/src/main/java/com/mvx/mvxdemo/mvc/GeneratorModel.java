package com.mvx.mvxdemo.mvc;

import android.graphics.Color;
import android.os.AsyncTask;
import android.widget.TextView;

// Model层，封装各种数据来源，和View层是直接通信的
public class GeneratorModel extends AsyncTask<Void, Void, Integer> {
    private final String baseText;
    private final TextView greetingTextView;

    public GeneratorModel(String baseText, TextView greetingTextView) {
        this.baseText = baseText;
        this.greetingTextView = greetingTextView;
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
        // （3）Model层调用View
        if ("HelloWorld".equals(baseText)) {
            greetingTextView.setTextColor(Color.RED);
        } else {
            greetingTextView.setTextColor(Color.BLUE);
        }
        greetingTextView.setText(baseText + randomInt);
    }
}
