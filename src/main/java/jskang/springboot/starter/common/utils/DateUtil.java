package jskang.springboot.starter.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;
import jskang.springboot.starter.config.i18n.LocaleType;

/**
 * This class provides date-related functionality.
 *
 * @author jskang
 * @version 0.1.0
 * @since 0.1.0
 */
public class DateUtil {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TIME_FORMAT = "HH:mm:ss";
    private static final String DATE_TIME_FORMAT = DATE_FORMAT + " " + TIME_FORMAT;

    /**
     * Converts a date of type Date to a string.
     * This feature is provided for compatibility and may not be supported in future versions.
     *
     * @param dateTime date
     *
     * @return Date converted to string
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    @Deprecated
    public static String toString(Date dateTime) {
        DateFormat format = new SimpleDateFormat(DATE_TIME_FORMAT);
        return format.format(dateTime);
    }

    /**
     * Converts a date of type Date to a string.
     *
     * @param dateTime date
     *
     * @return LocalDateTime converted to string
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static String toString(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
    }

    /**
     * Converts a date of type Date to a long.
     * This feature is provided for compatibility and may not be supported in future versions.
     *
     * @param dateTime date
     *
     * @return Date converted to long
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    @Deprecated
    public static long toLong(Date dateTime) {
        return dateTime.getTime();
    }

    /**
     * Converts a date of type Date to a long.
     *
     * @param dateTime date
     *
     * @return LocalDateTime converted to long
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static long toLong(LocalDateTime dateTime) {
        return dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * Converts a string of type Date to a LocalDateTime.
     *
     * @param dateTime date
     *
     * @return String converted to LocalDateTime
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static LocalDateTime toLocalDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
    }

    /**
     * Calculate today's date.
     *
     * @return today date.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static LocalDateTime today() {
        return LocalDateTime.now();
    }

    /**
     * Calculate yesterday's date.
     *
     * @return yesterday date.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static LocalDateTime yesterday() {
        return nPreviousDay(today(), 1);
    }

    /**
     * Calculate the date one day before the desired date.
     * This feature is provided for compatibility and may not be supported in future versions.
     *
     * @return yesterday date.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    @Deprecated
    public static LocalDateTime yesterday(Date date) {
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return nPreviousDay(localDateTime, 1);
    }

    /**
     * Calculate the date one day before the desired date.
     *
     * @return yesterday date.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static LocalDateTime yesterday(LocalDateTime localDateTime) {
        return nPreviousDay(localDateTime, 1);
    }

    /**
     * Calculates the number of days before the desired date.
     *
     * @return previous day date.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static LocalDateTime nPreviousDay(LocalDateTime localDateTime, long previousDay) {
        return localDateTime.minusDays(previousDay);
    }

    /**
     * Calculate tomorrow date.
     *
     * @return tomorrow date.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static LocalDateTime tomorrow() {
        return nNextDay(today(), 1);
    }

    /**
     * Calculate the date next to the desired date.
     * This feature is provided for compatibility and may not be supported in future versions.
     *
     * @return tomorrow date.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    @Deprecated
    public static LocalDateTime tomorrow(Date date) {
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return nNextDay(localDateTime, 1);
    }

    /**
     * Calculate the date next to the desired date.
     *
     * @return tomorrow date.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static LocalDateTime tomorrow(LocalDateTime localDateTime) {
        return nNextDay(localDateTime, 1);
    }

    /**
     * Calculates the number of next to the desired date.
     *
     * @return next to day date.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static LocalDateTime nNextDay(LocalDateTime localDateTime, long nextDay) {
        return localDateTime.plusDays(nextDay);
    }

    /**
     * Calculates the first day of the desired month.
     *
     * @param localDateTime the desired month.
     *
     * @return the first day
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static LocalDateTime getFirstDayMonth(LocalDateTime localDateTime) {
        return localDateTime.withDayOfMonth(1);
    }


    /**
     * Calculates the last day of the desired month.
     *
     * @param localDateTime the desired month.
     *
     * @return the last day
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static LocalDateTime getLastDayMonth(LocalDateTime localDateTime) {
        return localDateTime.withDayOfMonth(localDateTime.toLocalDate().lengthOfMonth());
    }

    /**
     * Calculates the day of the week for the desired date.
     * This feature is provided for compatibility and may not be supported in future versions.
     *
     * @param datetime the desired date.
     * @param locale locale language.
     *
     * @return Day Of The Week
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    @Deprecated
    public static String getDayOfTheWeek(Date datetime, Locale locale) {
        LocalDateTime localDateTime = datetime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return getDayOfTheWeek(localDateTime, LocaleType.getLocale());
    }

    /**
     * Calculates the day of the week for the desired date.
     * This feature is provided for compatibility and may not be supported in future versions.
     *
     * @param datetime the desired date.
     *
     * @return Day Of The Week
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    @Deprecated
    public static String getDayOfTheStringWeek(Date datetime) {
        LocalDateTime localDateTime = datetime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return getDayOfTheStringWeek(localDateTime);
    }

    /**
     * Calculates the day of the week for the desired date.
     * This feature is provided for compatibility and may not be supported in future versions.
     *
     * @param datetime the desired date.
     *
     * @return Day Of The Week
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    @Deprecated
    public static int getDayOfTheIntegerWeek(Date datetime) {
        LocalDateTime localDateTime = datetime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return getDayOfTheIntegerWeek(localDateTime);
    }

    /**
     * Calculates the day of the week for the desired date.
     *
     * @param localDateTime the desired date.
     * @param locale locale language.
     *
     * @return Day Of The Week
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static String getDayOfTheWeek(LocalDateTime localDateTime, Locale locale) {
        return localDateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
    }

    /**
     * Calculates the day of the week for the desired date.
     *
     * @param localDateTime the desired date.
     *
     * @return Day Of The Week
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static String getDayOfTheStringWeek(LocalDateTime localDateTime) {
        return getDayOfTheWeek(localDateTime, LocaleType.getLocale());
    }

    /**
     * Calculates the day of the week for the desired date.
     *
     * @param localDateTime the desired date.
     *
     * @return Day Of The Week
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static int getDayOfTheIntegerWeek(LocalDateTime localDateTime) {
        return localDateTime.getDayOfWeek().getValue();
    }
}
