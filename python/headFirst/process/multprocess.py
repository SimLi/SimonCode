from multiprocessing import Process,Pool

import os,time,random



def children_run(name):
    print("子进程运行的程序 %s (%s)" %(name,os.getpid()))

if __name__ == "__main__":
    print("父进程ID是 %s" %os.getpid())
    p = Process(target=children_run,args=("child",))
    print("子进程将要执行了")
    p.start()
    print("子进程执行的以后，父进程的输出....")
    p.join()
    print("子进程执行结束...")

def long_time_task(name):
    print(" 进程池启动的进程 task %s （%s）" %(name,os.getpid()))
    start = time.time()
    time.sleep(random.random() * 3)
    end = time.time()
    print("进程 %s 执行了 %0.2f 秒" %(name,(end-start)))

if __name__ == "__main__":
    print(" 父进程的ID是 %s" % os.getpid())
    p = Pool(4)
    for i in range(5):
        p.apply_async(long_time_task,args=(i,))
    print("等待进程池执行完毕")
    p.close()
    p.join()
    print("所有进程执行完毕")