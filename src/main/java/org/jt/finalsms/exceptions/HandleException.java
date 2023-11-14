package org.jt.finalsms.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class HandleException {
    @ExceptionHandler
    public ProblemDetail handleException(Exception exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(500), exception.getMessage());
    }
}
