package com.devfuns.core.execute;


import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class BlogThreadPoolFactory {

    private ThreadPoolExecutor executor;

    public ExecutorService buildExecutorFactory() {
        if (executor == null) {
            Executors.newCachedThreadPool();
            executor = new ThreadPoolExecutor(10,20,
                    60, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
        }
        return executor;
    }

    public void submitExecutorRunable(Runnable runnable) {
        buildExecutorFactory();
        System.out.println("ActiveCount == "+executor.getActiveCount() + "-- core==" +executor.getCorePoolSize() +
        "--" + executor.getMaximumPoolSize() + "--" + executor.getQueue().size());
        executor.submit(runnable);
    }

}
