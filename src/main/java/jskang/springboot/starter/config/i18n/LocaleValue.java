package jskang.springboot.starter.config.i18n;

/**
 * This class can call information from files set in application.yaml.
 *
 * @author jskang
 * @version 0.1.0
 * @since 0.1.0
 */
public class LocaleValue {

    protected static String locale = "ko_kr";
    protected static String[] basename = new String[]{"messages/log", "messages/response", "messages/description"};
    protected static String encoding = "UTF-8";

    /**
     * Load set locale information.
     *
     * @return the locale.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static String getLocale() {
        return locale;
    }

    /**
     * Load set basename path.
     *
     * @return the basenames.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static String[] getBasename() {
        return basename;
    }

    /**
     * Load set encoding information.
     *
     * @return the encoding.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static String getEncoding() {
        return encoding;
    }
}
