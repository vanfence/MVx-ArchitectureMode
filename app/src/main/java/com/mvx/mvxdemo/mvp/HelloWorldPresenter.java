package com.mvx.mvxdemo.mvp;


import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

// Presenter层，逻辑控制层
public class HelloWorldPresenter extends MvpBasePresenter<IHelloView> {
    // Greeting Task is "business logic"
    private GeneratorModel greetingTask;

    private void cancelGreetingTaskIfRunning() {
        if (greetingTask != null) {
            greetingTask.cancel(true);
        }
    }

    public void greetHello() {
        cancelGreetingTaskIfRunning();
        // 实现Model层的回调监听
        greetingTask = new GeneratorModel("HelloWorld", new GeneratorModel.GreetingTaskListener() {
            @Override
            public void onGreetingGenerated(String greetingText) {
                // （4）调用View层更新View
                if (isViewAttached())
                    getView().showHello(greetingText);
            }
        });
        // （2）调用Model层获取数据
        greetingTask.execute();
    }

    public void greetGoodbye() {
        cancelGreetingTaskIfRunning();
        // 实现Model层的回调监听
        greetingTask = new GeneratorModel("Goodbye", new GeneratorModel.GreetingTaskListener() {
            public void onGreetingGenerated(String greetingText) {
                // （4）调用View层更新View
                if (isViewAttached())
                    getView().showGoodbye(greetingText);
            }
        });
        // （2）调用Model层获取数据
        greetingTask.execute();
    }

    // Called when Activity gets destroyed, so cancel running background task
    public void detachView(boolean retainPresenterInstance) {
        super.detachView(retainPresenterInstance);
        if (!retainPresenterInstance) {
            cancelGreetingTaskIfRunning();
        }
    }
}
