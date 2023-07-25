package jskang.springboot.starter.common.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

/**
 * The ResponseBody class contains API response result specifications.
 * When you create an API response result specification through the Response class,
 * it is automatically created as a specification for the ResponseBody .
 *
 * @author jskang
 *
 * @version 0.1.0
 * @since 0.1.0
 */
public class ResponseBody implements Serializable {

    @JsonProperty(value = "code")
    private String code;
    @JsonProperty(value = "message")
    private String message;
    @JsonProperty(value = "result")
    private Object result;
    @JsonProperty(value = "description")
    private String description;

    public ResponseBody(
        @JsonProperty(value = "code") String code,
        @JsonProperty(value = "message") String message,
        @JsonProperty(value = "result") Object result,
        @JsonProperty(value = "description") String description) {

        this.code = code;
        this.message = message;
        this.result = result;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getResult() {
        return result;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ResponseBodyMap{" +
            "code='" + code + '\'' +
            ", message='" + message + '\'' +
            ", result=" + result +
            ", description='" + description + '\'' +
            '}';
    }
}
