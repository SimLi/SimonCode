package com.devfuns.exception;

/**
 * Created by sim on 2018/8/29.
 * 服务层的异常控制类，系统中对改异常进行了增强
 * 在service如果有异常，可以通过
 * throw new ServiceException("分页参数pageNum和pageSize不能为空");
 * 进行抛出
 */
public class ServiceException extends RuntimeException {
    public ServiceException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
