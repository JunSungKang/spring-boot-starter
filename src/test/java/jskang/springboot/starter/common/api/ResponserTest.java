package jskang.springboot.starter.common.api;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import jskang.springboot.starter.common.code.ResponseCode;
import jskang.springboot.starter.config.i18n.LocaleType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ResponserTest {

    Map<String, Object> map = new HashMap<>();

    @BeforeEach
    void ready() {
        map.put("name", "wisenut, kang");
        map.put("age", 22);
        map.put("company", "wisenut");
        map.put("address", "경기도 성남시 분당구 대왕판교로");
    }

    @Test
    void status_200_1() {
        assertThat(Responser.SUCCESS_200(ResponseCode.R000001, map).toString())
            .isEqualTo(
                "<200 OK OK,ResponseBodyMap{code='R000001', message='알 수 없는 에러가 발생하였습니다. 관리자에게 문의해주세요.', result={address=경기도 성남시 분당구 대왕판교로, name=wisenut, kang, company=wisenut, age=22}, description='{0}'},[]>"
            );
    }

    @Test
    void status_200_2() {
        assertThat(Responser.SUCCESS_200(ResponseCode.R000001, map, LocaleType.KOKR).toString())
            .isEqualTo(
                "<200 OK OK,ResponseBodyMap{code='R000001', message='알 수 없는 에러가 발생하였습니다. 관리자에게 문의해주세요.', result={address=경기도 성남시 분당구 대왕판교로, name=wisenut, kang, company=wisenut, age=22}, description='{0}'},[]>"
            );
    }

    @Test
    void status_400_1() {
        assertThat(Responser.BAD_REQUEST_400(ResponseCode.R000001, map).toString())
            .isEqualTo(
                "<400 BAD_REQUEST Bad Request,ResponseBodyMap{code='R000001', message='알 수 없는 에러가 발생하였습니다. 관리자에게 문의해주세요.', result={address=경기도 성남시 분당구 대왕판교로, name=wisenut, kang, company=wisenut, age=22}, description='{0}'},[]>"
            );
    }

    @Test
    void status_400_2() {
        assertThat(Responser.BAD_REQUEST_400(ResponseCode.R000001, map, LocaleType.KOKR).toString())
            .isEqualTo(
                "<400 BAD_REQUEST Bad Request,ResponseBodyMap{code='R000001', message='알 수 없는 에러가 발생하였습니다. 관리자에게 문의해주세요.', result={address=경기도 성남시 분당구 대왕판교로, name=wisenut, kang, company=wisenut, age=22}, description='{0}'},[]>"
            );
    }

    @Test
    void status_403_1() {
        assertThat(Responser.FORBIDDEN_403(ResponseCode.R000001, map).toString())
            .isEqualTo(
                "<403 FORBIDDEN Forbidden,ResponseBodyMap{code='R000001', message='알 수 없는 에러가 발생하였습니다. 관리자에게 문의해주세요.', result={address=경기도 성남시 분당구 대왕판교로, name=wisenut, kang, company=wisenut, age=22}, description='{0}'},[]>"
            );
    }

    @Test
    void status_403_2() {
        assertThat(Responser.FORBIDDEN_403(ResponseCode.R000001, map, LocaleType.KOKR).toString())
            .isEqualTo(
                "<403 FORBIDDEN Forbidden,ResponseBodyMap{code='R000001', message='알 수 없는 에러가 발생하였습니다. 관리자에게 문의해주세요.', result={address=경기도 성남시 분당구 대왕판교로, name=wisenut, kang, company=wisenut, age=22}, description='{0}'},[]>"
            );
    }

    @Test
    void status_404_1() {
        assertThat(Responser.NOT_FOUND_404(ResponseCode.R000001, map).toString())
            .isEqualTo(
                "<404 NOT_FOUND Not Found,ResponseBodyMap{code='R000001', message='알 수 없는 에러가 발생하였습니다. 관리자에게 문의해주세요.', result={address=경기도 성남시 분당구 대왕판교로, name=wisenut, kang, company=wisenut, age=22}, description='{0}'},[]>"
            );
    }

    @Test
    void status_404_2() {
        assertThat(Responser.NOT_FOUND_404(ResponseCode.R000001, map, LocaleType.KOKR).toString())
            .isEqualTo(
                "<404 NOT_FOUND Not Found,ResponseBodyMap{code='R000001', message='알 수 없는 에러가 발생하였습니다. 관리자에게 문의해주세요.', result={address=경기도 성남시 분당구 대왕판교로, name=wisenut, kang, company=wisenut, age=22}, description='{0}'},[]>"
            );
    }

    @Test
    void status_500_1() {
        assertThat(Responser.INTERNAL_SERVER_ERROR_500(ResponseCode.R000001, map).toString())
            .isEqualTo(
                "<500 INTERNAL_SERVER_ERROR Internal Server Error,ResponseBodyMap{code='R000001', message='알 수 없는 에러가 발생하였습니다. 관리자에게 문의해주세요.', result={address=경기도 성남시 분당구 대왕판교로, name=wisenut, kang, company=wisenut, age=22}, description='{0}'},[]>"
            );
    }

    @Test
    void status_500_2() {
        assertThat(Responser.INTERNAL_SERVER_ERROR_500(ResponseCode.R000001, map, LocaleType.KOKR).toString())
            .isEqualTo(
                "<500 INTERNAL_SERVER_ERROR Internal Server Error,ResponseBodyMap{code='R000001', message='알 수 없는 에러가 발생하였습니다. 관리자에게 문의해주세요.', result={address=경기도 성남시 분당구 대왕판교로, name=wisenut, kang, company=wisenut, age=22}, description='{0}'},[]>"
            );
    }
}