package com.poseidon.erp.exception;

import com.poseidon.erp.utils.R;
import com.poseidon.erp.utils.ResponseCode;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * @author mario on 2020/9/21.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public R<?> businessException(BusinessException e) {
        return R.error(e.getResponseCode());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    @ResponseBody
    public R<?> bodyValidExceptionHandler(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        return R.fail(fieldErrors.get(0).getDefaultMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public R<?> exception(ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        StringBuilder builder = new StringBuilder();
        violations.stream().findFirst().ifPresent(violation -> builder.append(violation.getMessage()));
        return R.fail(builder.toString());
    }

    /**
     * 认证异常
     */
    @ExceptionHandler(UnAuthorizedException.class)
    @ResponseBody
    public R<?> exception(UnAuthorizedException e) {
        return R.fail(e.getMessage());
    }

    /**
     * 权限不足
     */
    @ResponseBody
    @ExceptionHandler(AccessDeniedException.class)
    public R<?> accessDeniedException(AccessDeniedException e) {
        return R.error(ResponseCode.PERMISSION_DENIED);
    }

    /**
     * 违反约束异常
     */
    @ResponseBody
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<?> duplicateKeyException(SQLIntegrityConstraintViolationException e) {
        return R.error(ResponseCode.REPEAT_SUBMIT);
    }

}
