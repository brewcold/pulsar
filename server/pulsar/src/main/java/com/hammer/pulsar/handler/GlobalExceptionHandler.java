package com.hammer.pulsar.handler;

import com.hammer.pulsar.exception.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

// 모든 컨트롤러에서 발생하는 예외를 처리하여 적절한 응답코드를 반환하는 예외 핸들러
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 존재하지 않는 정보에 접근 요청 시 404 NOT FOUND 응답을 반환
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleExceptionNoItem(NoSuchElementException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> handleExceptionAccessDenied(UnauthorizedException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

}
