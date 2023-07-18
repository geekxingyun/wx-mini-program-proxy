package com.xingyun.wxminiprogramproxy.framework.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

/**
 * @author qing-feng.zhao
 */
@Slf4j
public class SmartJackSonUtils {
    /**
     * 根据最佳实践开发守则规约 静态工具类需要禁用实例化构造方法
     */
    private SmartJackSonUtils(){}

    private static ObjectMapper objectMapper;
    /**
     * 使用泛型方法，把json字符串转换为相应的JavaBean对象。
     * (1)转换为普通JavaBean：readValue(json,Student.class)
     * (2)转换为List,如List<Student>,将第二个参数传递为Student
     * [].class.然后使用Arrays.asList();方法把得到的数组转换为特定类型的List
     *
     * @param jsonStr
     * @param valueType
     * @return
     */
    public static <T> T readValueToObject(String jsonStr, Class<T> valueType) {
        if (null == objectMapper) {
            objectMapper = new ObjectMapper();
        }
        try {
            return objectMapper.readValue(jsonStr, valueType);
        } catch (Exception e) {
           log.error("原始JSON:{},JSON解析对象出错:",jsonStr,e);
        }
        return null;
    }

    public static <T> T readJsonDataToListValue(String jsonStr,Class<T> valueType) {
        if (null == objectMapper) {
            objectMapper = new ObjectMapper();
        }
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class,valueType);
        try {
            return objectMapper.readValue(jsonStr,javaType);
        } catch (Exception e) {
            log.error("将字符串解析成List<Object>对象出错,原始JSON:{},异常详情:",jsonStr,e);
        }
        return null;
    }

    public static <T> T readJsonDataToCollectionListValue(String jsonStr,Class<?> parametersFor,Class<?>... parameterClasses) {
        if (null == objectMapper) {
            objectMapper = new ObjectMapper();
        }
        JavaType javaType = objectMapper.getTypeFactory().constructParametrizedType(List.class,parametersFor,parameterClasses);
        try {
            return objectMapper.readValue(jsonStr,javaType);
        } catch (Exception e) {
            log.error("将字符串解析成List<Object>对象出错",e);
        }
        return null;
    }

    public static Map<String,Object> readJsonDataToMapValue(String jsonStr) {
        if (null == objectMapper) {
            objectMapper = new ObjectMapper();
        }
        try {
            return objectMapper.readValue(jsonStr,new TypeReference<Map<String,Object>>(){});
        } catch (Exception e) {
            log.error("将字符串解析成Map对象出错,原始字符串:{}",jsonStr,e);
        }
        return null;
    }
    public static List<Map<String,Object>> readJsonDataToMapListValue(String jsonStr) {
        if (null == objectMapper) {
            objectMapper = new ObjectMapper();
        }
        try {
            return objectMapper.readValue(jsonStr,new TypeReference<List<Map<String,Object>>>(){});
        } catch (Exception e) {
            log.error("将字符串解析成Map集合出错",e);
        }
        return null;
    }
    /**
     * 把JavaBean转换为json字符串
     *
     * @param object
     * @return
     */
    public static String writeObjectToJSon(Object object) {
        if (null == objectMapper) {
            objectMapper = new ObjectMapper();
        }
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            log.error("object:{},object转List出错",object,e);
        }
        return null;
    }
}
