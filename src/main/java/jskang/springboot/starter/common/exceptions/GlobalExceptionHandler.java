package jskang.springboot.starter.common.exceptions;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.stream.Collectors;
import jskang.springboot.starter.common.api.Responser;
import jskang.springboot.starter.common.code.DescriptionCode;
import jskang.springboot.starter.common.code.ResponseCode;
import jskang.springboot.starter.common.code.formatter.CodeFormatter;
import jskang.springboot.starter.common.code.LogCode;
import jskang.springboot.starter.common.exceptions.exception.BadRequestException;
import jskang.springboot.starter.common.exceptions.exception.ForbiddenException;
import jskang.springboot.starter.common.exceptions.exception.InternalServerException;
import jskang.springboot.starter.common.exceptions.exception.NotFoundException;
import jskang.springboot.starter.common.exceptions.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<Object> BadRequestException(final BadRequestException ex) {
        log.error(ex.getMessage());
        log.debug(CodeFormatter.create(LogCode.L000000,
            Arrays.stream(ex.getStackTrace()).map(l -> l+ "\n").collect(Collectors.joining()))
        );
        return Responser.BAD_REQUEST_400(ResponseCode.R000002, null, DescriptionCode.D000000, ex.getMessage());
    }

    @ExceptionHandler({ForbiddenException.class})
    public ResponseEntity<Object> ForbiddenException(final ForbiddenException ex) {
        log.error(ex.getMessage());
        log.debug(CodeFormatter.create(LogCode.L000000,
            Arrays.stream(ex.getStackTrace()).map(l -> l+ "\n").collect(Collectors.joining()))
        );
        return Responser.FORBIDDEN_403(ResponseCode.R000003, null, DescriptionCode.D000000, ex.getMessage());
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> NotFoundException(final NotFoundException ex) {
        log.error(ex.getMessage());
        log.debug(CodeFormatter.create(LogCode.L000000,
            Arrays.stream(ex.getStackTrace()).map(l -> l+ "\n").collect(Collectors.joining()))
        );
        return Responser.NOT_FOUND_404(ResponseCode.R000004, null, DescriptionCode.D000000, ex.getMessage());
    }

    @ExceptionHandler({InternalServerException.class})
    public ResponseEntity<Object> InternalServerException(final InternalServerException ex) {
        log.error(ex.getMessage());
        log.debug(CodeFormatter.create(LogCode.L000000,
            Arrays.stream(ex.getStackTrace()).map(l -> l+ "\n").collect(Collectors.joining()))
        );
        return Responser.INTERNAL_SERVER_ERROR_500(ResponseCode.R000005, null, DescriptionCode.D000000,
            ex.getMessage());
    }

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<Object> ValidationException(final ValidationException ex) {
        log.error(ex.getMessage());
        log.debug(CodeFormatter.create(LogCode.L000000,
            Arrays.stream(ex.getStackTrace()).map(l -> l+ "\n").collect(Collectors.joining()))
        );
        return Responser.INTERNAL_SERVER_ERROR_500(ResponseCode.R000006, null, DescriptionCode.D000000,
            ex.getMessage());
    }

    @ExceptionHandler({IndexOutOfBoundsException.class})
    public ResponseEntity<Object> IndexOutOfBoundsException(final IndexOutOfBoundsException ex) {
        log.error(CodeFormatter.create(LogCode.L000000, ex.getMessage()));
        log.debug(CodeFormatter.create(LogCode.L000000,
            Arrays.stream(ex.getStackTrace()).map(l -> l+ "\n").collect(Collectors.joining()))
        );
        return Responser.INTERNAL_SERVER_ERROR_500(ResponseCode.R000007, null, DescriptionCode.D000000,
            ex.getMessage());
    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<Object> NullPointerException(final NullPointerException ex) {
        log.error(ex.getMessage());
        log.debug(CodeFormatter.create(LogCode.L000000,
            Arrays.stream(ex.getStackTrace()).map(l -> l+ "\n").collect(Collectors.joining()))
        );
        return Responser.INTERNAL_SERVER_ERROR_500(ResponseCode.R000008, null, DescriptionCode.D000000,
            ex.getMessage());
    }

    @ExceptionHandler({ClassNotFoundException.class})
    public ResponseEntity<Object> ClassNotFoundException(final ClassNotFoundException ex) {
        log.error(ex.getMessage());
        log.debug(CodeFormatter.create(LogCode.L000000,
            Arrays.stream(ex.getStackTrace()).map(l -> l+ "\n").collect(Collectors.joining()))
        );
        return Responser.INTERNAL_SERVER_ERROR_500(ResponseCode.R000009, null, DescriptionCode.D000000,
            ex.getMessage());
    }

    @ExceptionHandler({NoSuchMethodException.class})
    public ResponseEntity<Object> NoSuchMethodException(final NoSuchMethodException ex) {
        log.error(ex.getMessage());
        log.debug(CodeFormatter.create(LogCode.L000000,
            Arrays.stream(ex.getStackTrace()).map(l -> l+ "\n").collect(Collectors.joining()))
        );
        return Responser.INTERNAL_SERVER_ERROR_500(ResponseCode.R000010, null, DescriptionCode.D000000,
            ex.getMessage());
    }

    @ExceptionHandler({FileNotFoundException.class})
    public ResponseEntity<Object> FileNotFoundException(final FileNotFoundException ex) {
        log.error(ex.getMessage());
        log.debug(CodeFormatter.create(LogCode.L000000,
            Arrays.stream(ex.getStackTrace()).map(l -> l+ "\n").collect(Collectors.joining()))
        );
        return Responser.NOT_FOUND_404(ResponseCode.R000011, null, DescriptionCode.D000000, ex.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> Exception(final Exception ex) {
        log.error(ex.getMessage());
        log.debug(CodeFormatter.create(LogCode.L000000,
            Arrays.stream(ex.getStackTrace()).map(l -> l+ "\n").collect(Collectors.joining()))
        );
        return Responser.INTERNAL_SERVER_ERROR_500(ResponseCode.R000001, null, DescriptionCode.D000000, "");
    }
}
