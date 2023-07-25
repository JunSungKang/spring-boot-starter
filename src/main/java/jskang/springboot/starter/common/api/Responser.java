package jskang.springboot.starter.common.api;

import jskang.springboot.starter.common.code.DescriptionCode;
import jskang.springboot.starter.common.code.ResponseCode;
import jskang.springboot.starter.common.code.formatter.CodeFormatter;
import jskang.springboot.starter.config.i18n.LocaleType;
import jskang.springboot.starter.config.i18n.LocaleValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * The Response class contains API response result specifications.
 * You should use this class when returning responses to API requests.
 *
 * @author jskang
 * @version 0.1.1
 * @since 0.1.0
 */
public class Responser {

    /**
     * request success and When there is data to return.
     *
     * @param code The desired choice is ResponseCode class.
     * @param returnData return data.
     * @param description The desired choice is DescriptionCode class.
     * @param descriptionParam Parameter message of the DescriptionCode class.
     * @param localeType Language you want to print, Korean (ko_kr) / English (en_us) / Japanese (ja_jp) / Chinese (zh_cn), example: LocaleType.getLocaleType(language)
     *
     * @return HttpStatus code 200 ResponseEntity.
     *
     * @version 0.1.1
     * @since 0.1.0
     */
    public static ResponseEntity SUCCESS_200(
        ResponseCode code, Object returnData, DescriptionCode description, Object[] descriptionParam, LocaleType localeType
    ) {
        return ResponseEntity.ok(generateResponseBody(code, returnData, description, descriptionParam, localeType));
    }

    /**
     * request success and When there is data to return.
     *
     * @param code The desired choice is ResponseCode class.
     * @param returnData return data.
     * @param description The desired choice is DescriptionCode class.
     * @param descriptionParam Parameter message of the DescriptionCode class.
     *
     * @return HttpStatus code 200 ResponseEntity.
     *
     * @version 0.1.1
     * @since 0.1.0
     */
    public static ResponseEntity SUCCESS_200(
        ResponseCode code, Object returnData, DescriptionCode description, Object... descriptionParam
    ) {
        return SUCCESS_200(code, returnData, description, descriptionParam, LocaleType.getLocalType());
    }

    /**
     * request success and When there is data to return.
     *
     * @param code The desired choice is ResponseCode class.
     * @param returnData return data.
     * @param description The desired choice is DescriptionCode class.
     * @param descriptionParam Parameter message of the DescriptionCode class.
     *
     * @return HttpStatus code 200 ResponseEntity.
     *
     * @version 0.1.1
     * @since 0.1.0
     */
    public static ResponseEntity SUCCESS_200(ResponseCode code, Object returnData, DescriptionCode description) {
        return SUCCESS_200(code, returnData, description, new Object[]{}, LocaleType.getLocalType());
    }

    /**
     * request success and When there is data to return.
     *
     * @param code The desired choice is ResponseCode class.
     * @param returnData return data.
     * @param localeType Language you want to print, Korean (ko_kr) / English (en_us) / Japanese (ja_jp) / Chinese (zh_cn), example: LocaleType.getLocaleType(language)
     *
     * @return HttpStatus code 200 ResponseEntity.
     *
     * @version 0.1.1
     * @since 0.1.0
     */
    public static ResponseEntity SUCCESS_200(ResponseCode code, Object returnData, LocaleType localeType) {
        return SUCCESS_200(code, returnData, DescriptionCode.D000000, new Object[]{}, localeType);
    }

    /**
     * request success and When there is data to return.
     *
     * @param code The desired choice is ResponseCode class.
     * @param returnData return data.
     *
     * @return HttpStatus code 200 ResponseEntity.
     *
     * @version 0.1.1
     * @since 0.1.0
     */
    public static ResponseEntity SUCCESS_200(ResponseCode code, Object returnData) {
        return SUCCESS_200(code, returnData, DescriptionCode.D000000, new Object[]{}, LocaleType.getLocalType());
    }

    /**
     * If the request comes in wrong from the client.
     *
     * @param code The desired choice is ResponseCode class.
     * @param returnData return data.
     * @param description The desired choice is DescriptionCode class.
     * @param descriptionParam Parameter message of the DescriptionCode class.
     * @param localeType Language you want to print, Korean (ko_kr) / English (en_us) / Japanese (ja_jp) / Chinese (zh_cn), example: LocaleType.getLocaleType(language)
     *
     * @return HttpStatus code 400 ResponseEntity.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static ResponseEntity BAD_REQUEST_400(
        ResponseCode code, Object returnData, DescriptionCode description, Object[] descriptionParam, LocaleType localeType
    ) {
        return ResponseEntity.badRequest()
            .body(generateResponseBody(code, returnData, description, descriptionParam, localeType));
    }

    /**
     * If the request comes in wrong from the client.
     *
     * @param code The desired choice is ResponseCode class.
     * @param returnData return data.
     * @param description The desired choice is DescriptionCode class.
     * @param descriptionParam Parameter message of the DescriptionCode class.
     *
     * @return HttpStatus code 400 ResponseEntity.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static ResponseEntity BAD_REQUEST_400(
        ResponseCode code, Object returnData, DescriptionCode description, Object... descriptionParam
    ) {
        return ResponseEntity.badRequest()
            .body(generateResponseBody(code, returnData, description, descriptionParam, LocaleType.getLocalType()));
    }

    /**
     * request success and When there is data to return.
     *
     * @param code The desired choice is ResponseCode class.
     * @param returnData return data.
     * @param description The desired choice is DescriptionCode class.
     *
     * @return HttpStatus code 400 ResponseEntity.
     *
     * @version 0.1.1
     * @since 0.1.0
     */
    public static ResponseEntity BAD_REQUEST_400(ResponseCode code, Object returnData, DescriptionCode description) {
        return BAD_REQUEST_400(code, returnData, description, new Object[]{}, LocaleType.getLocalType());
    }

    /**
     * If the request comes in wrong from the client.
     *
     * @param code The desired choice is ResponseCode class.
     * @param returnData return data.
     * @param localeType Language you want to print, Korean (ko_kr) / English (en_us) / Japanese (ja_jp) / Chinese (zh_cn), example: LocaleType.getLocaleType(language)
     *
     * @return HttpStatus code 400 ResponseEntity.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static ResponseEntity BAD_REQUEST_400(ResponseCode code, Object returnData, LocaleType localeType) {
        return BAD_REQUEST_400(code, returnData, DescriptionCode.D000000, new Object[]{}, localeType);
    }

    /**
     * If the request comes in wrong from the client.
     *
     * @param code The desired choice is ResponseCode class.
     * @param returnData return data.
     *
     * @return HttpStatus code 400 ResponseEntity.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static ResponseEntity BAD_REQUEST_400(ResponseCode code, Object returnData) {
        return BAD_REQUEST_400(code, returnData, DescriptionCode.D000000, new Object[]{}, LocaleType.getLocalType());
    }

    /**
     * Trying to access something you don't have permission for.
     *
     * @param code The desired choice is ResponseCode class.
     * @param returnData return data.
     * @param description The desired choice is DescriptionCode class.
     * @param descriptionParam Parameter message of the DescriptionCode class.
     * @param localeType Language you want to print, Korean (ko_kr) / English (en_us) / Japanese (ja_jp) / Chinese (zh_cn), example: LocaleType.getLocaleType(language)
     *
     * @return HttpStatus code 403 ResponseEntity.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static ResponseEntity FORBIDDEN_403(
        ResponseCode code, Object returnData, DescriptionCode description, Object[] descriptionParam, LocaleType localeType
    ) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
            .body(generateResponseBody(code, returnData, description, descriptionParam, localeType));
    }

    /**
     * Trying to access something you don't have permission for.
     *
     * @param code The desired choice is ResponseCode class.
     * @param returnData return data.
     * @param description The desired choice is DescriptionCode class.
     * @param descriptionParam Parameter message of the DescriptionCode class.
     *
     * @return HttpStatus code 403 ResponseEntity.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static ResponseEntity FORBIDDEN_403(
        ResponseCode code, Object returnData, DescriptionCode description, Object... descriptionParam
    ) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
            .body(generateResponseBody(code, returnData, description, descriptionParam, LocaleType.getLocalType()));
    }

    /**
     * request success and When there is data to return.
     *
     * @param code The desired choice is ResponseCode class.
     * @param returnData return data.
     * @param description The desired choice is DescriptionCode class.
     *
     * @return HttpStatus code 403 ResponseEntity.
     *
     * @version 0.1.1
     * @since 0.1.0
     */
    public static ResponseEntity FORBIDDEN_403(ResponseCode code, Object returnData, DescriptionCode description) {
        return FORBIDDEN_403(code, returnData, description, new Object[]{}, LocaleType.getLocalType());
    }

    /**
     * Trying to access something you don't have permission for.
     *
     * @param code The desired choice is ResponseCode class.
     * @param returnData return data.
     * @param localeType Language you want to print, Korean (ko_kr) / English (en_us) / Japanese (ja_jp) / Chinese (zh_cn), example: LocaleType.getLocaleType(language)
     *
     * @return HttpStatus code 403 ResponseEntity.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static ResponseEntity FORBIDDEN_403(ResponseCode code, Object returnData, LocaleType localeType) {
        return FORBIDDEN_403(code, returnData, DescriptionCode.D000000, new Object[]{}, localeType);
    }

    /**
     * Trying to access something you don't have permission for.
     *
     * @param code The desired choice is ResponseCode class.
     * @param returnData return data.
     *
     * @return HttpStatus code 403 ResponseEntity.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static ResponseEntity FORBIDDEN_403(ResponseCode code, Object returnData) {
        return FORBIDDEN_403(code, returnData, DescriptionCode.D000000, new Object[]{}, LocaleType.getLocalType());
    }

    /**
     * If the page does not exist.
     *
     * @param code The desired choice is ResponseCode class.
     * @param returnData return data.
     * @param description The desired choice is DescriptionCode class.
     * @param descriptionParam Parameter message of the DescriptionCode class.
     * @param localeType Language you want to print, Korean (ko_kr) / English (en_us) / Japanese (ja_jp) / Chinese (zh_cn), example: LocaleType.getLocaleType(language)
     *
     * @return HttpStatus code 404 ResponseEntity.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static ResponseEntity NOT_FOUND_404(
        ResponseCode code, Object returnData, DescriptionCode description, Object[] descriptionParam, LocaleType localeType
    ) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(generateResponseBody(code, returnData, description, descriptionParam, localeType));
    }

    /**
     * If the page does not exist.
     *
     * @param code The desired choice is ResponseCode class.
     * @param returnData return data.
     * @param description The desired choice is DescriptionCode class.
     * @param descriptionParam Parameter message of the DescriptionCode class.
     *
     * @return HttpStatus code 404 ResponseEntity.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static ResponseEntity NOT_FOUND_404(
        ResponseCode code, Object returnData, DescriptionCode description, Object... descriptionParam
    ) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(generateResponseBody(code, returnData, description, descriptionParam, LocaleType.getLocalType()));
    }

    /**
     * request success and When there is data to return.
     *
     * @param code The desired choice is ResponseCode class.
     * @param returnData return data.
     * @param description The desired choice is DescriptionCode class.
     *
     * @return HttpStatus code 404 ResponseEntity.
     *
     * @version 0.1.1
     * @since 0.1.0
     */
    public static ResponseEntity NOT_FOUND_404(ResponseCode code, Object returnData, DescriptionCode description) {
        return NOT_FOUND_404(code, returnData, description, new Object[]{}, LocaleType.getLocalType());
    }

    /**
     * If the page does not exist.
     *
     * @param code The desired choice is ResponseCode class.
     * @param returnData return data.
     * @param localeType Language you want to print, Korean (ko_kr) / English (en_us) / Japanese (ja_jp) / Chinese (zh_cn), example: LocaleType.getLocaleType(language)
     *
     * @return HttpStatus code 404 ResponseEntity.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static ResponseEntity NOT_FOUND_404(ResponseCode code, Object returnData, LocaleType localeType) {
        return NOT_FOUND_404(code, returnData, DescriptionCode.D000000, new Object[]{}, localeType);
    }

    /**
     * If the page does not exist.
     *
     * @param code The desired choice is ResponseCode class.
     * @param returnData return data.
     *
     * @return HttpStatus code 404 ResponseEntity.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static ResponseEntity NOT_FOUND_404(ResponseCode code, Object returnData) {
        return NOT_FOUND_404(code, returnData, DescriptionCode.D000000, new Object[]{}, LocaleType.getLocalType());
    }

    /**
     * If an error occurred in the server logic.
     *
     * @param code The desired choice is ResponseCode class.
     * @param returnData return data.
     * @param description The desired choice is DescriptionCode class.
     * @param descriptionParam Parameter message of the DescriptionCode class.
     * @param localeType Language you want to print, Korean (ko_kr) / English (en_us) / Japanese (ja_jp) / Chinese (zh_cn), example: LocaleType.getLocaleType(language)
     *
     * @return HttpStatus code 500 ResponseEntity.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static ResponseEntity INTERNAL_SERVER_ERROR_500(
        ResponseCode code, Object returnData, DescriptionCode description, Object[] descriptionParam, LocaleType localeType
    ) {
        return ResponseEntity.internalServerError()
            .body(generateResponseBody(code, returnData, description, descriptionParam, localeType));
    }

    /**
     * If an error occurred in the server logic.
     *
     * @param code The desired choice is ResponseCode class.
     * @param returnData return data.
     * @param description The desired choice is DescriptionCode class.
     * @param descriptionParam Parameter message of the DescriptionCode class.
     *
     * @return HttpStatus code 500 ResponseEntity.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static ResponseEntity INTERNAL_SERVER_ERROR_500(
        ResponseCode code, Object returnData, DescriptionCode description, Object... descriptionParam
    ) {
        return ResponseEntity.internalServerError()
            .body(generateResponseBody(code, returnData, description, descriptionParam, LocaleType.getLocalType()));
    }

    /**
     * request success and When there is data to return.
     *
     * @param code The desired choice is ResponseCode class.
     * @param returnData return data.
     * @param description The desired choice is DescriptionCode class.
     *
     * @return HttpStatus code 500 ResponseEntity.
     *
     * @version 0.1.1
     * @since 0.1.0
     */
    public static ResponseEntity INTERNAL_SERVER_ERROR_500(ResponseCode code, Object returnData, DescriptionCode description) {
        return INTERNAL_SERVER_ERROR_500(code, returnData, description, new Object[]{}, LocaleType.getLocalType());
    }

    /**
     * If an error occurred in the server logic.
     *
     * @param code The desired choice is ResponseCode class.
     * @param returnData return data.
     * @param localeType Language you want to print, Korean (ko_kr) / English (en_us) / Japanese (ja_jp) / Chinese (zh_cn), example: LocaleType.getLocaleType(language)
     *
     * @return HttpStatus code 500 ResponseEntity.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static ResponseEntity INTERNAL_SERVER_ERROR_500(ResponseCode code, Object returnData, LocaleType localeType) {
        return INTERNAL_SERVER_ERROR_500(code, returnData, DescriptionCode.D000000, new Object[]{}, localeType);
    }

    /**
     * If an error occurred in the server logic.
     *
     * @param code The desired choice is ResponseCode class.
     * @param returnData return data.
     *
     * @return HttpStatus code 500 ResponseEntity.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    public static ResponseEntity INTERNAL_SERVER_ERROR_500(ResponseCode code, Object returnData) {
        return INTERNAL_SERVER_ERROR_500(code, returnData, DescriptionCode.D000000, new Object[]{}, LocaleType.getLocalType());
    }

    /**
     * generate response body.
     *
     * @param localeType input language locale type.
     * @param code input response code.
     * @param returnData data to send by server to client.
     * @param description data description.
     * @param descriptionParam Parameter message of the DescriptionCode class.
     *
     * @return data to send by server to client.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    private static ResponseBody generateResponseBody(
        ResponseCode code, Object returnData, DescriptionCode description, Object[] descriptionParam, LocaleType localeType
    ) {
        return new ResponseBody(code.name(), CodeFormatter.create(code, localeType), returnData,
            CodeFormatter.create(description, descriptionParam, localeType));
    }

    /**
     * generate response body.
     *
     * @param code input response code.
     * @param returnData data to send by server to client.
     * @param description data description.
     *
     * @return data to send by server to client.
     *
     * @version 0.1.0
     * @since 0.1.0
     */
    private static ResponseBody generateResponseBody(ResponseCode code, Object returnData,
        DescriptionCode description) {
        return generateResponseBody(code, returnData, description, new Object[]{}, LocaleType.getLocalType(LocaleValue.getLocale()));
    }
}
