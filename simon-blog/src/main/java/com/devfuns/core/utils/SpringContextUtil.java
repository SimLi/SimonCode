package com.devfuns.core.utils;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


@Component
public class SpringContextUtil implements ApplicationContextAware {
	
	private static final Logger logger = LogManager.getLogger(SpringContextUtil.class);
	
	private static ApplicationContext context;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		context = applicationContext;
	}
	
	public static ApplicationContext getContext() {
		return context;
	}
	
	public static <T> T getBean(String bean){
		try{
			return (T) context.getBean(bean);
		}catch(Exception e){
			logger.error("获取bean["+bean+"]失败", e);
			return null;
		}
	}
	
	public static <T> T getBean(Class clazz) {
		try{
			Map<String,T> map = context.getBeansOfType(clazz);
			if(map.size() == 0){
				logger.error("获取bean类型["+clazz.getName()+"]失败");
			}else if(map.size() == 1){
				return map.values().iterator().next();
			}else{
				map.values().iterator().next();
			}
		}catch(Exception e){
			logger.error("获取bean["+clazz.getName()+"]失败", e);
			return null;
		}
		return null;
	}

}
