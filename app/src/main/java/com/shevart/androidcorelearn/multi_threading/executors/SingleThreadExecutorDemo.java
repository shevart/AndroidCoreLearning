package com.shevart.androidcorelearn.multi_threading.executors;

import com.shevart.androidcorelearn.common.DemoStartable;
import com.shevart.androidcorelearn.utils.ThreadDemoUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SingleThreadExecutorDemo implements DemoStartable {
    @Override
    public void startDemo() {
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        ThreadDemoUtil.sendEmptyTasksToExecutor50(executorService);
        executorService.shutdown();
    }
}