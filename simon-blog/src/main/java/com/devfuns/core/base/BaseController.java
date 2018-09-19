package com.devfuns.core.base;

import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sim on 2018/8/29.
 * 系统Controller的基础类，所有Controller中，需要对类型进行效验的，需要继承该类
 */
public class BaseController {
    /**
     * Mode类，效验失败处理，返回字段效验失败信息
     * */
    List<String> validError(List<ObjectError> list) {
        List<String> errorList = new ArrayList<>();
        StringBuilder sb = null;
        for (ObjectError objectError : list) {
            sb = new StringBuilder();
            sb.append(objectError.getDefaultMessage()).append("[");
            sb.append(objectError.getObjectName());
            for (String code : objectError.getCodes()) {
                sb.append(code).append(",");
            }
            sb.append("]");
            errorList.add(sb.toString());
        }
        return errorList;
    }
}
