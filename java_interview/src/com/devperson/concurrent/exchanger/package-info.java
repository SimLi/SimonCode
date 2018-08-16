/**
 * 线程之间交换数据，使用Exchanger，如果一个线程，调用了一个共享的使用Exchanger的exchange方法，那么线程将在
 * 该方法处阻塞，直到共享Exchanger的另外一个线程调用了Exchanger的exchange方法，线程才会往下走
 * */
package com.devperson.concurrent.exchanger;