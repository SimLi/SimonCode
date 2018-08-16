- 线程对象Thread不具有返回值，如果想要线程有返回值的情况下，可以使用Callable和Future进行处理
- 执行Callable可以是使用ThreadPoolExecutor的submit方法，同样，submit也可以传入Runnable，当submit使用的是Runnable时，返回的是
null，如果需要submit传入Runable有返回值，则可以使用submit(Runnable runnable, T result);
- execute和submit的区别
1. execute没有返回值，submit可以有返回值
2. execute出现异常的时候，直接打印堆栈信息，submit可以进行捕获异常