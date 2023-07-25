package jskang.springboot.starter.common.code.provider;

import jskang.springboot.starter.common.code.Code;
import jskang.springboot.starter.config.i18n.LocaleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * A MessageProvider that provides multiple languages.
 * LocaleType allows you to select the language to serve.
 * The messages served are based on bundles in the resource/message path.
 *
 * @author jskang
 * @version 0.1.0
 * @since 0.1.0
 */
@Component
public class MessageProvider {

    protected static MessageSource messageSource;

    @Autowired
    public MessageProvider(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Messages are output in the language of the code set by the user in the initial application.yaml.
     *
     * @param code A class that implements the code interface
     * @param args arguments to the message
     *
     * @return The value of the class that implements the code interface
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static <T extends Code> String of(T code, Object[] args) {
        return messageSource.getMessage(code.name(), args, LocaleType.getLocale());
    }

    /**
     * Outputs messages in the language of the code chosen by the user.
     *
     * @param localeType Language you want to print, Korean (ko_kr) / English (en_us) / Japanese (ja_jp) / Chinese (zh_cn)
     * @param code A class that implements the code interface
     * @param args arguments to the message
     *
     * @return The value of the class that implements the code interface
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static <T extends Code> String of(T code, Object[] args, LocaleType localeType) {
        return messageSource.getMessage(code.name(), args, LocaleType.getLocale(localeType));
    }
}
