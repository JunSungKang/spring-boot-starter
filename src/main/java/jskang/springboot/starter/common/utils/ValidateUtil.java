package jskang.springboot.starter.common.utils;

public class ValidateUtil {

    /**
     * Check if variable passed as parameter is empty or null
     *
     * @param keys check variable
     *
     * @return if true empty or null, other false.
     */
    public static boolean isBlank(Object... keys) {
        for (Object key : keys) {
            if (key == null) {
                return true;
            }

            if (key instanceof String) {
                if (((String) key).isBlank()) {
                    return true;
                }
            }
        }
        return false;
    }
}
