package jskang.springboot.starter.common.api;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jskang.springboot.starter.common.code.ResponseCode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class ResponserDtoTest {

    ResponseEntity responseEntity = null;

    @Test
    void toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "wisenut, kang");
        map.put("age", 22);
        map.put("company", "wisenut");
        map.put("address", "경기도 성남시 분당구 대왕판교로");
        responseEntity = Responser.SUCCESS_200(ResponseCode.R000001, map);

        assertThat(ResponseDto.toMap(responseEntity).toString())
            .isEqualTo(
                "{code=R000001, message=알 수 없는 에러가 발생하였습니다. 관리자에게 문의해주세요., result={address=경기도 성남시 분당구 대왕판교로, name=wisenut, kang, company=wisenut, age=22}, description={0}}"
            );
    }

    @Test
    void toJson() throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "wisenut, kang");
        map.put("age", 22);
        map.put("company", "wisenut");
        map.put("address", "경기도 성남시 분당구 대왕판교로");
        responseEntity = Responser.SUCCESS_200(ResponseCode.R000001, map);

        assertThat(ResponseDto.toJson(responseEntity))
            .isEqualTo(
                "{\"code\":\"R000001\",\"message\":\"알 수 없는 에러가 발생하였습니다. 관리자에게 문의해주세요.\",\"result\":{\"address\":\"경기도 성남시 분당구 대왕판교로\",\"name\":\"wisenut, kang\",\"company\":\"wisenut\",\"age\":22},\"description\":\"{0}\"}"
            );
    }

    @Test
    void toObject() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "wisenut, kang");
        map.put("age", 22);
        map.put("company", "wisenut");
        map.put("address", "경기도 성남시 분당구 대왕판교로");
        responseEntity = Responser.SUCCESS_200(ResponseCode.R000001, map);

        assertThat(ResponseDto.toObject(responseEntity, new TypeReference<Map<String, Object>>() {}).toString())
            .isEqualTo(
                "{code=R000001, message=알 수 없는 에러가 발생하였습니다. 관리자에게 문의해주세요., result={address=경기도 성남시 분당구 대왕판교로, name=wisenut, kang, company=wisenut, age=22}, description={0}}"
            );
    }

    @Test
    void getResult() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "wisenut, kang");
        map.put("age", 22);
        map.put("company", "wisenut");
        map.put("address", "경기도 성남시 분당구 대왕판교로");
        responseEntity = Responser.SUCCESS_200(ResponseCode.R000001, map);

        assertThat(ResponseDto.getResult(responseEntity).toString())
            .isEqualTo(
                "{address=경기도 성남시 분당구 대왕판교로, name=wisenut, kang, company=wisenut, age=22}"
            );
    }

    @Test
    void getResultTypeReference() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "wisenut, kang");
        map.put("age", 22);
        map.put("company", "wisenut");
        map.put("address", "경기도 성남시 분당구 대왕판교로");
        responseEntity = Responser.SUCCESS_200(ResponseCode.R000001, map);

        assertThat(ResponseDto.getResult(responseEntity, new TypeReference<Map<String, Object>>() {}).toString())
            .isEqualTo(
                "{address=경기도 성남시 분당구 대왕판교로, name=wisenut, kang, company=wisenut, age=22}"
            );
    }

    @Test
    void getResultList() {
        List<String> list = new ArrayList<>();
        list.add("AAA");
        list.add("BBB");
        responseEntity = Responser.SUCCESS_200(ResponseCode.R000001, list);

        assertThat(ResponseDto.getResultList(responseEntity).toString())
            .isEqualTo(
                "[AAA, BBB]"
            );
    }

    @Test
    void getResultMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "wisenut, kang");
        map.put("age", 22);
        map.put("company", "wisenut");
        map.put("address", "경기도 성남시 분당구 대왕판교로");
        responseEntity = Responser.SUCCESS_200(ResponseCode.R000001, map);

        assertThat(ResponseDto.getResultMap(responseEntity).toString())
            .isEqualTo(
                "{address=경기도 성남시 분당구 대왕판교로, name=wisenut, kang, company=wisenut, age=22}"
            );
    }
}