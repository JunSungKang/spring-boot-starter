package jskang.springboot.starter.common.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.LocalDateTime;
import java.util.Date;
import jskang.springboot.starter.config.i18n.LocaleType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DateUtilTest {

    private final String testStrDate = "2023-01-10 09:00:00";
    private final Date testDate = new Date(1673308800000L);
    private final LocalDateTime testLocalDateTime = LocalDateTime.of(2023, 1, 10, 9, 0, 0);

    @Test
    void testToString() {
        String date = DateUtil.toString(testDate);
        assertThat(date).isEqualTo("2023-01-10 09:00:00");
    }

    @Test
    void testToString1() {
        String date = DateUtil.toString(testLocalDateTime);
        assertThat(date).isEqualTo("2023-01-10 09:00:00");
    }

    @Test
    void toLong() {
        long l = DateUtil.toLong(testDate);
        assertThat(l).isEqualTo(1673308800000L);
    }

    @Test
    void testToLong() {
        long l = DateUtil.toLong(testLocalDateTime);
        assertThat(l).isEqualTo(1673308800000L);
    }

    @Test
    void toLocalDateTime() {
        LocalDateTime localDateTime = DateUtil.toLocalDateTime(testStrDate);
        assertThat(localDateTime).isEqualTo("2023-01-10T09:00:00");
    }

    @Test
    void today() {
        LocalDateTime today = DateUtil.today();
        assertThat(today).isEqualTo(LocalDateTime.now());
    }

    @Test
    void yesterday() {
        LocalDateTime yesterday = DateUtil.yesterday();
        assertThat(yesterday).isEqualTo(LocalDateTime.now().minusDays(1));
    }

    @Test
    void testYesterday() {
        LocalDateTime yesterday = DateUtil.yesterday(testDate);
        assertThat(yesterday).isEqualTo("2023-01-09T09:00:00");
    }

    @Test
    void testYesterday1() {
        LocalDateTime yesterday = DateUtil.yesterday(testLocalDateTime);
        assertThat(yesterday).isEqualTo("2023-01-09T09:00:00");
    }

    @Test
    void nPreviousDay() {
        LocalDateTime previousDay = DateUtil.nPreviousDay(testLocalDateTime, 3);
        assertThat(previousDay).isEqualTo("2023-01-07T09:00:00");
    }

    @Test
    void tomorrow() {
        LocalDateTime tomorrow = DateUtil.tomorrow();
        assertThat(tomorrow).isEqualTo(LocalDateTime.now().plusDays(1));
    }

    @Test
    void testTomorrow() {
        LocalDateTime tomorrow = DateUtil.tomorrow(testDate);
        assertThat(tomorrow).isEqualTo("2023-01-11T09:00:00");
    }

    @Test
    void testTomorrow1() {
        LocalDateTime tomorrow = DateUtil.tomorrow(testLocalDateTime);
        assertThat(tomorrow).isEqualTo("2023-01-11T09:00:00");
    }

    @Test
    void nNextDay() {
        LocalDateTime tomorrow = DateUtil.nNextDay(testLocalDateTime, 3);
        assertThat(tomorrow).isEqualTo("2023-01-13T09:00:00");
    }

    @Test
    void getFirstDayMonth() {
        LocalDateTime firstDay = DateUtil.getFirstDayMonth(testLocalDateTime);
        assertThat(firstDay).isEqualTo("2023-01-01T09:00:00");
    }

    @Test
    void getLastDayMonth() {
        LocalDateTime lastDay = DateUtil.getLastDayMonth(testLocalDateTime);
        assertThat(lastDay).isEqualTo("2023-01-31T09:00:00");
    }

    @Test
    void getDayOfTheWeek() {
        String dayOfTheWeek = DateUtil.getDayOfTheWeek(testDate, LocaleType.getLocale("ko_kr"));
        assertThat(dayOfTheWeek).isEqualTo("화요일");
    }

    @Test
    void getDayOfTheStringWeek() {
        String dayOfTheWeek = DateUtil.getDayOfTheStringWeek(testDate);
        assertThat(dayOfTheWeek).isEqualTo("화요일");
    }

    @Test
    void getDayOfTheIntegerWeek() {
        int dayOfTheWeek = DateUtil.getDayOfTheIntegerWeek(testDate);
        assertThat(dayOfTheWeek).isEqualTo(2);
    }

    @Test
    void testGetDayOfTheWeek() {
        String dayOfTheWeek = DateUtil.getDayOfTheWeek(testLocalDateTime, LocaleType.getLocale("ko_kr"));
        assertThat(dayOfTheWeek).isEqualTo("화요일");
    }

    @Test
    void testGetDayOfTheStringWeek() {
        String dayOfTheWeek = DateUtil.getDayOfTheStringWeek(testLocalDateTime);
        assertThat(dayOfTheWeek).isEqualTo("화요일");
    }

    @Test
    void testGetDayOfTheIntegerWeek() {
        int dayOfTheWeek = DateUtil.getDayOfTheIntegerWeek(testLocalDateTime);
        assertThat(dayOfTheWeek).isEqualTo(2);
    }
}