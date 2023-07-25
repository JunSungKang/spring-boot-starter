package jskang.springboot.starter.api.sample;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class SampleControllerTest {

    @Autowired
    MockMvc mvc;

    private static final String BASE_URL = "/v0.1/sample";

    @Test
    void readTest() throws Exception {
        mvc.perform(get(BASE_URL + "/data")
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON) //보내는 데이터의 타입을 명시
            )
            .andExpect(status().isOk())
            .andExpect(content().json("{\n"
                + "    \"code\": \"R000012\",\n"
                + "    \"message\": \"요청 작업이 모두 정상적으로 처리되었습니다.\",\n"
                + "    \"result\": [],\n"
                + "    \"description\": \"{0}\"\n"
                + "}"));
    }

    @Test
    void createTest() throws Exception {
        String body = "{\"name\":\"test\",\"age\":10,\"company\":\"wisenut\"}";

        mvc.perform(post(BASE_URL + "/data")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON) //보내는 데이터의 타입을 명시
            )
            .andExpect(status().isOk())
            .andExpect(content().json("{\n"
                + "    \"code\": \"R000012\",\n"
                + "    \"message\": \"요청 작업이 모두 정상적으로 처리되었습니다.\",\n"
                + "    \"result\": [\n"
                + "        {\n"
                + "            \"name\": \"test\",\n"
                + "            \"company\": \"wisenut\",\n"
                + "            \"age\": \"10\"\n"
                + "        }\n"
                + "    ],\n"
                + "    \"description\": \"{0}\"\n"
                + "}"));
    }

    @Test
    void createTest_exception() throws Exception {
        String body = "{\"age\":10,\"company\":\"wisenut\"}";

        mvc.perform(post(BASE_URL + "/data")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON) //보내는 데이터의 타입을 명시
            )
            .andExpect(status().isInternalServerError());
    }

    @Test
    void updateTest() throws Exception {
        String body = "{\"name\":\"test\",\"age\":10,\"company\":\"wisenut\"}";

        mvc.perform(put(BASE_URL + "/data")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON) //보내는 데이터의 타입을 명시
            )
            .andExpect(status().isInternalServerError());
    }

    @Test
    void updateTest_exception() throws Exception {
        String body = "{\"age\":10,\"company\":\"wisenut\"}";

        mvc.perform(put(BASE_URL + "/data")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON) //보내는 데이터의 타입을 명시
            )
            .andExpect(status().isInternalServerError());
    }

    @Test
    void deleteTest() throws Exception {
        String body = "{\"name\":\"test\"}";

        mvc.perform(delete(BASE_URL + "/data")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON) //보내는 데이터의 타입을 명시
            )
            .andExpect(status().isOk());
    }

    @Test
    void deleteTest_exception1() throws Exception {
        String body = "{\"name\":\"empty\"}";

        mvc.perform(delete(BASE_URL + "/data")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON) //보내는 데이터의 타입을 명시
            )
            .andExpect(status().isInternalServerError());
    }

    @Test
    void deleteTest_exception2() throws Exception {
        String body = "";

        mvc.perform(delete(BASE_URL + "/data")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON) //보내는 데이터의 타입을 명시
            )
            .andExpect(status().isInternalServerError());
    }
}