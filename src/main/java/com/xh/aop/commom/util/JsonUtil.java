package com.xh.aop.commom.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
* @Name JsonUtils
* @Description JsonUtils工具
* @Author wen
* @Date 2019/3/30
* @return
*/
@Slf4j
public class JsonUtil {

    public static final ObjectMapper mapper = new ObjectMapper();

    /**
    * @Name serialize
    * @Description 序列化对象（转json）
    * @Author wen
    * @Date 2019/3/30
    * @param obj
    * @return java.lang.String
    */
    public static String serialize(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj.getClass() == String.class) {
            return (String) obj;
        }
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("json序列化出错：" + obj, e);
            return null;
        }
    }

    /**
    * @Name parse
    * @Description 反序列化（json转为Bean）
    * @Author wen
    * @Date 2019/3/30
    * @param json
    * @param tClass
    * @return T
    */
    public static <T> T parse(String json, Class<T> tClass) {
        try {
            return mapper.readValue(json, tClass);
        } catch (IOException e) {
            log.error("json解析出错：" + json, e);
            return null;
        }
    }

    /**
    * @Name parseList
    * @Description 反序列化（json转List）
    * @Author wen
    * @Date 2019/3/30
    * @param json
    * @param eClass
    * @return java.util.List<E>
    */
    public static <E> List<E> parseList(String json, Class<E> eClass) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, eClass));
        } catch (IOException e) {
            log.error("json解析出错：" + json, e);
            return null;
        }
    }

    /**
    * @Name parseMap
    * @Description 反序列化（json转Map）
    * @Author wen
    * @Date 2019/3/30
    * @param json
    * @param kClass
    * @param vClass
    * @return java.util.Map<K,V>
    */
    public static <K, V> Map<K, V> parseMap(String json, Class<K> kClass, Class<V> vClass) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructMapType(Map.class, kClass, vClass));
        } catch (IOException e) {
            log.error("json解析出错：" + json, e);
            return null;
        }
    }

    /**
    * @Name nativeRead
    * @Description json转复杂对象
    * @Author wen
    * @Date 2019/3/30
    * @param json
    * @param type
    * @return T
    */
    public static <T> T nativeRead(String json, TypeReference<T> type) {
        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {
            log.error("json解析出错：" + json, e);
            return null;
        }
    }

}
