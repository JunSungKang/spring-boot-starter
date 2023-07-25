package jskang.springboot.starter.config.i18n;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Locale;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LocaleTypeTest {

    @Test
    void getLocale() {
        String strLocale = "ko_kr";
        assertThat(LocaleType.getLocale(strLocale)).isEqualTo(new Locale("ko", "kr"));

        strLocale = "en_us";
        assertThat(LocaleType.getLocale(strLocale)).isEqualTo(new Locale("en", "us"));

        strLocale = "ja_jp";
        assertThat(LocaleType.getLocale(strLocale)).isEqualTo(new Locale("ja", "jp"));

        strLocale = "zh_cn";
        assertThat(LocaleType.getLocale(strLocale)).isEqualTo(new Locale("zh", "cn"));

        strLocale = "aa_bb";
        assertThat(LocaleType.getLocale(strLocale)).isEqualTo(new Locale("ko", "kr"));

        strLocale = "a";
        assertThat(LocaleType.getLocale(strLocale)).isEqualTo(new Locale("ko", "kr"));
    }

    @Test
    void testGetLocale() {
        assertThat(LocaleType.getLocale("ko", "kr")).isEqualTo(new Locale("ko", "kr"));
        assertThat(LocaleType.getLocale("en", "us")).isEqualTo(new Locale("en", "us"));
        assertThat(LocaleType.getLocale("ja", "jp")).isEqualTo(new Locale("ja", "jp"));
        assertThat(LocaleType.getLocale("zh", "cn")).isEqualTo(new Locale("zh", "cn"));
        assertThat(LocaleType.getLocale("aa", "bb")).isEqualTo(new Locale("ko", "kr"));
    }
}