package jskang.springboot.starter.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ConverterUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    public static <T> T jsonStrToTypeRef(String json, TypeReference<T> typeRef) throws IOException {
        return mapper.readValue(json, typeRef);
    }

    public static Map<String, Object> jsonStrToMap(String json) throws IOException {
        return jsonStrToTypeRef(json, new TypeReference<LinkedHashMap<String, Object>>() {});
    }

    public static String mapToJsonStr(Map map) throws JsonProcessingException {
        return mapper.writeValueAsString(map);
    }

    public static List jsonStrToList(String json) throws IOException {
        return jsonStrToTypeRef(json, new TypeReference<List<Object>>() {});
    }

    public static String listToJsonStr(List map) throws JsonProcessingException {
        return mapper.writeValueAsString(map);
    }

    public static String stringArrToJsonStr(String[] stringArr) throws JsonProcessingException {
        return mapper.writeValueAsString(stringArr);
    }
}
