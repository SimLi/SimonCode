package com.devfuns.advice;

import com.devfuns.exception.ServiceException;
import com.devfuns.result.ActionResult;
import com.devfuns.result.ActionResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by sim on 2018/8/29.
 * 异常控制的增强，在该类中监控了ServiceException和Exception
 */
@RestControllerAdvice
public class ModelControllerExceptionAdvice {

    private final Logger logger = LoggerFactory.getLogger(ServiceException.class);
    private final Logger exceptionLogger = LoggerFactory.getLogger(Exception.class);

    /**
     * 对ServiceException类进行增强控制，返回前端有效的异常信息
     * 并且后台记录该异常
     * */
    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    private ActionResult handleServiceException(ServiceException se) {
        ActionResult actionResult = new ActionResult();
        logger.info(se.getMessage());
        logger.error(logger.getName());
        String message = "业务服务失败，失败原因：" + se.getMessage();
        actionResult.setMessage(message);
        logger.error(message);
        actionResult.setCode(ActionResultEnum.EXCEPTION);
        return actionResult;
    }

    /**
     * 对Exception类进行增强控制，返回前端有效的异常信息
     * 并且后台记录该异常
     * */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    private ActionResult handleException(Exception e) {
        ActionResult actionResult = new ActionResult();
        String message = "服务出现异常，异常原因是：" + e.getMessage();
        actionResult.setMessage(message);
        actionResult.setCode(ActionResultEnum.EXCEPTION);
        e.printStackTrace();
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        e.printStackTrace(new java.io.PrintWriter(buf, true));
        String  expMessage = buf.toString();
        try {
            buf.close();
        } catch (IOException ie) {
            ie.printStackTrace();
        }

        //记录到日志
        exceptionLogger.error("GlobalExceptionHandler,捕获异常:"+ e.getMessage() + ";eString:" + expMessage);
        return actionResult;
    }
}
