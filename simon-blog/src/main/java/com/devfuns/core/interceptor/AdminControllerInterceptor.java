package com.devfuns.core.interceptor;

import com.devfuns.core.utils.AuthToken;
import com.devfuns.exception.ServiceException;
import com.devfuns.model.TokenModel;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AdminControllerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("x-authentication-token");
        if (request.getRequestURI().contains("adminLogin")) {
            return true;
        } else {
//            TokenModel tokenModel = AuthToken.parserTokenToString(token);
//            if (StringUtils.isEmpty(tokenModel.getTokenException())) {
//                return true;
//            } else {
//                if (AuthToken.TOKEN_EXCEPTION_EXP.equals(tokenModel.getTokenException())) {
//                    throw new ServiceException("token已过期");
//                } else {
//                    throw new ServiceException("token认证解析失败");
//                }
//            }
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
