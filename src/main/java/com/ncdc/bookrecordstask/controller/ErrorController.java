package com.ncdc.bookrecordstask.controller;

import com.ncdc.bookrecordstask.dto.ErrorResponse;
import com.ncdc.bookrecordstask.exception.LetterAException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ErrorController {
    //handling custom letterException
    @ExceptionHandler(LetterAException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleFirstLetterException(LetterAException e){
        log.warn("handle LetterAException " + e.getMessage());
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "first letter should star with A", e.getMessage());
    }
}
