package com.example.tx.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public final class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public void handleMemberException(Exception e) {
        log.error("================== GLOBAL EXCEPTION HANDLER ==================");
        log.error(e.getMessage());
    }
}
