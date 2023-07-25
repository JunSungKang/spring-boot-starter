package jskang.springboot.starter.common.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ValidateUtilTest {

    @Test
    void isBlank() {
        String test1 = "A";
        String test2 = "B";

        assertThat(ValidateUtil.isBlank(test1, test2)).isEqualTo(false);
    }

    @Test
    void isBlank_exception1() {
        String test1 = "A";
        String test2 = "";

        assertThat(ValidateUtil.isBlank(test1, test2)).isEqualTo(true);
    }

    @Test
    void isBlank_exception2() {
        String test1 = "A";
        String test2 = null;

        assertThat(ValidateUtil.isBlank(test1, test2)).isEqualTo(true);
    }
}