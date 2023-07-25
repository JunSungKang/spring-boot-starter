package jskang.springboot.starter.common.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

/**
 * This class helps user developers to easily convert the ResponseBody standard automatically generated through the Response class.
 *
 * @author jskang
 * @version 0.1.0
 * @since 0.1.0
 */
public class ResponseDto<T> {

    static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Convert response result to map.
     *
     * @param entity ResponseEntity
     *
     * @return Map
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static Map<String, Object> toMap(ResponseEntity entity) {
        return mapper.convertValue(entity.getBody(), new TypeReference<Map<String, Object>>() {});
    }

    /**
     * Convert response result to json string.
     *
     * @param entity ResponseEntity
     *
     * @return Json string
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static String toJson(ResponseEntity entity) throws JsonProcessingException {
        return mapper.writeValueAsString(entity.getBody());
    }

    /**
     * Convert response result to object.
     *
     * @param entity ResponseEntity
     * @param typeReference converte class
     *
     * @return custom object.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static <T> T toObject(ResponseEntity entity, TypeReference<T> typeReference) {
        return mapper.convertValue(entity.getBody(), typeReference);
    }

    /**
     * Get result data TypeReference in response result.
     *
     * @param entity ResponseEntity
     * @param typeReference converte class
     *
     * @return real result data.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static <T> T getResult(ResponseEntity entity, TypeReference<T> typeReference) {
        ResponseBody body = (ResponseBody) entity.getBody();
        return mapper.convertValue(body.getResult(), typeReference);
    }

    /**
     * Get result data object in response result.
     *
     * @param entity ResponseEntity
     *
     * @return real result data.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static Object getResult(ResponseEntity entity) {
        return getResult(entity, new TypeReference<Object>() {});
    }

    /**
     * Get result data list in response result.
     *
     * @param entity ResponseEntity
     *
     * @return real result data.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static List<Object> getResultList(ResponseEntity entity) {
        ResponseBody body = (ResponseBody) entity.getBody();
        return mapper.convertValue(body.getResult(), new TypeReference<List<Object>>() {});
    }

    /**
     * Get result data map in response result.
     *
     * @param entity ResponseEntity
     *
     * @return real result data.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static Map<String, Object> getResultMap(ResponseEntity entity) {
        ResponseBody body = (ResponseBody) entity.getBody();
        return mapper.convertValue(body.getResult(), new TypeReference<Map<String, Object>>() {});
    }
}
