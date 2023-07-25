package jskang.springboot.starter.config.i18n;

import java.util.Arrays;
import java.util.Locale;

/**
 * A predefined class with local information that can be set.
 * Regions not provided by this class are not supported.
 *
 * @author jskang
 * @version 0.1.0
 * @since 0.1.0
 */
public enum LocaleType {
    KOKR("ko", "kr"),
    ENUS("en", "us"),
    JAJP("ja", "jp"),
    ZHCN("zh", "cn");

    private String language;
    private String country;

    LocaleType(String l, String c) {
        this.language = l;
        this.country = c;
    }

    /**
     * You can return a Locale class for any country you want.
     *
     * @param language the language you want.
     * @param country city you want.
     *
     * @return Locale class.
     */
    public static Locale getLocale(String language, String country) {
        return Arrays.stream(values())
            .filter(locales -> locales.language.equals(language) && locales.country.equals(country))
            .findFirst()
            .map(localeType -> new Locale(localeType.language, localeType.country))
            .orElse(new Locale("ko", "kr"));
    }

    /**
     * You can return a Locale class for any country you want.
     * default locale is korean.
     *
     * @return Locale class.
     */
    public static Locale getLocale() {
        String locale = LocaleValue.locale;
        if (locale == null || locale.length() == 0) {
            return new Locale("ko", "kr");
        }

        String[] split = locale.split("_");
        if (split.length != 2) {
            return new Locale("ko", "kr");
        }

        return getLocale(split[0], split[1]);
    }

    /**
     * You can return a Locale class for any country you want.
     *
     * @param localeType Value provided by LocaleType Enum class.
     *
     * @return Locale class.
     */
    public static Locale getLocale(LocaleType localeType) {
        return getLocale(localeType.language, localeType.country);
    }

    /**
     * You can return a Locale class for any country you want.
     *
     * @param locale the language you want and city you want. (ex. ko_kr | en_us)
     *
     * @return Locale class.
     */
    public static Locale getLocale(String locale) {
        if (locale == null || locale.length() == 0) {
            return new Locale("ko", "kr");
        }

        String[] split = locale.split("_");
        if (split.length < 2) {
            return new Locale("ko", "kr");
        }

        return getLocale(split[0], split[1]);
    }

    /**
     * You can return a LocaleType class for any country you want.
     *
     * @param language the language you want.
     * @param country city you want.
     *
     * @return LocaleType class.
     */
    public static LocaleType getLocalType(String language, String country) {
        return Arrays.stream(values())
            .filter(locales -> locales.language.equals(language) && locales.country.equals(country))
            .findFirst()
            .orElse(LocaleType.KOKR);
    }

    /**
     * You can return a LocaleType class for any country you want.
     *
     * @return LocaleType class.
     */
    public static LocaleType getLocalType() {
        String locale = LocaleValue.locale;
        if (locale == null || locale.length() == 0) {
            return LocaleType.KOKR;
        }

        String[] split = locale.split("_");
        if (split.length != 2) {
            return LocaleType.KOKR;
        }

        return getLocalType(split[0], split[1]);
    }

    /**
     * You can return a LocaleType class for any country you want.
     *
     * @param locale the language you want and city you want. (ex. ko_kr | en_us)
     *
     * @return LocaleType class.
     */
    public static LocaleType getLocalType(String locale) {
        if (locale == null || locale.length() == 0) {
            return LocaleType.KOKR;
        }

        String[] split = locale.split("_");
        if (split.length < 2) {
            return LocaleType.KOKR;
        }

        return getLocalType(split[0], split[1]);
    }
}
