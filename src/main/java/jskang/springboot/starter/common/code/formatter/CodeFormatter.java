package jskang.springboot.starter.common.code.formatter;

import jskang.springboot.starter.common.code.Code;
import jskang.springboot.starter.common.code.provider.CodeProvider;
import jskang.springboot.starter.common.code.provider.MessageProvider;
import jskang.springboot.starter.config.i18n.LocaleType;

/**
 * This class is an implementation of the LogCodeFormatter class.
 * Most of the common functionality is implemented in the CodeFormatter abstract class.
 * Nevertheless, if you need additional functionality for a specific log message,
 * you can create a new function in each actual implementation class and use it as a custom function.
 *
 * @author jskang
 * @version 0.1.0
 * @since 0.1.0
 */
public abstract class CodeFormatter {

    /**
     * Translate the code in LogCode and ResponseCode formats into your preferred language.
     *
     * @param code LogCode or ResponseCode, it's ENUM Class.
     * @param args code parameter values.
     *
     * @return code message.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static String create(Code code, Object... args) {
        return create(code, args, LocaleType.getLocalType());
    }

    /**
     * Translate the code in LogCode and ResponseCode formats into your preferred language.
     *
     * @param code LogCode or ResponseCode, it's ENUM Class.
     * @param localeType Code messages are output in the selected language.
     *
     * @return code message.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static String create(Code code, LocaleType localeType) {
        return create(code, new String[]{}, localeType);
    }


    /**
     * Translate the code in LogCode and ResponseCode formats into your preferred language.
     *
     * @param localeType Code messages are output in the selected language.
     * @param code LogCode or ResponseCode, it's ENUM Class.
     * @param args code parameter values.
     *
     * @return code message.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static String create(Code code, Object[] args, LocaleType localeType) {
        return MessageProvider.of(CodeProvider.of(code), args, localeType);
    }

    public abstract <T extends Code> String conversion(T code, Object[] args, LocaleType localeType);

    public abstract <T extends Code> String conversion(T code, LocaleType localeType);

    public abstract <T extends Code> String conversion(T code);
}
