package jskang.springboot.starter.common.code.provider;

import jskang.springboot.starter.common.code.Code;

/**
 * This class provides LogCode or ResponseCode.
 * A class that provides values for code classes, which are basically ENUM classes.
 *
 * @author jskang
 * @version 0.1.0
 * @since 0.1.0
 */
public class CodeProvider {

    /**
     * Convert it to the desired code.
     *
     * @param code A class that implements the code interface
     *
     * @return The value of the class that implements the code interface
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static <T extends Code> T of(T code) {
        return code;
    }
}
