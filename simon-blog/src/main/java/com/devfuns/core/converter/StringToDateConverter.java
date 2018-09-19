package com.devfuns.core.converter;

import com.devfuns.core.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * 字符串转日期
 * 转换日期格式支持 2018-08-12 和日期毫秒数
 * */
public class StringToDateConverter implements Converter<String,Date> {

    private final Logger logger = LoggerFactory.getLogger(StringToDateConverter.class);

    @Nullable
    @Override
    public Date convert(String source) {
        logger.info("字符串日期转换：" + source);
        if (StringUtils.isEmpty(source)) {
            return null;
        }
        source = source.trim();
        try {
            if (source.contains("-")) {
                if (source.contains(":")) {
                    return DateUtil.parseDateTime(source);
                } else {
                    return DateUtil.parseDate(source);
                }
            } else if (source.matches("^\\d+$")) {
                Long lDate = new Long(source);
                return new Date(lDate);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(String.format("parser %s to Date fail", source));
        }
    }
}
