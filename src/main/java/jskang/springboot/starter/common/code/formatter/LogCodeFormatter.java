package jskang.springboot.starter.common.code.formatter;

import jskang.springboot.starter.common.code.Code;
import jskang.springboot.starter.common.code.provider.MessageProvider;
import jskang.springboot.starter.config.i18n.LocaleType;

/**
 * This class is an implementation of the LogCodeFormatter class.
 * Most of the common functionality is implemented in the CodeFormatter abstract class.
 * Nevertheless, if you need additional functionality for specific log messages, you can create a new function and use it as a custom function.
 *
 * @author jskang
 * @version 0.1.0
 * @since 0.1.0
 */
public class LogCodeFormatter extends CodeFormatter {

    @Override
    public <T extends Code> String conversion(T code, Object[] args, LocaleType localeType) {
        String message = MessageProvider.of(code, args, localeType);
        return null;
    }

    @Override
    public <T extends Code> String conversion(T code, LocaleType localeType) {
        String message = MessageProvider.of(code, new Object[]{}, localeType);
        return null;
    }

    @Override
    public <T extends Code> String conversion(T code) {
        String message = MessageProvider.of(code, new Object[]{}, LocaleType.getLocalType());
        return null;
    }
}
