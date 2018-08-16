- CompletionService的功能，是以异步的方式，一边产生新的任务，一边处理已完成的任务。使用submit执行任务，take取得已完成的任务，take方法时阻塞的方法
- poll：弹出执行结果栈中的一个结果，如果没有值，则返回null，poll是非阻塞的效果，
- poll(long timeout, TimeUnit unit): 最长等待指定时间，如果线程，在指定时间内没有结束，则poll返回null，如果在在指定时间内线程返回，
则poll取消等待