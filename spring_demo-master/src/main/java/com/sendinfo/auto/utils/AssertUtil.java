package com.sendinfo.auto.utils;

import com.xiaoleilu.hutool.util.ObjectUtil;
import com.xiaoleilu.hutool.util.StrUtil;
import java.util.Collection;
import java.util.Objects;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

public class AssertUtil {

    public AssertUtil() {
    }

    public static boolean isTrue(boolean expression, String errorMsg) throws BusinessException {
        if (!expression) {
            throw new BusinessException(errorMsg);
        } else {
            return expression;
        }
    }

    public static Object notNull(Object obj, String errorMsg) throws BusinessException {
        if (ObjectUtil.isNull(obj)) {
            throw new BusinessException(errorMsg);
        } else {
            return obj;
        }
    }

    public static String notBlank(String str, String errorMsg) throws BusinessException {
        if (StringUtils.isBlank(str)) {
            throw new BusinessException(errorMsg);
        } else {
            return str;
        }
    }

    public static String notEmpty(String str, String errorMsg) throws BusinessException {
        if (StrUtil.isEmpty(str)) {
            throw new BusinessException(errorMsg);
        } else {
            return str;
        }
    }

    public static void notEmpty(Collection collection, String errorMsg) throws BusinessException {
        if (CollectionUtils.isEmpty(collection)) {
            throw new BusinessException(errorMsg);
        }
    }

    public static void isEquals(Object obj1, Object obj2, String errorMsg) throws BusinessException {
        if (!Objects.equals(obj1, obj2)) {
            throw new BusinessException(errorMsg);
        }
    }

}