package br.com.lucaspires31.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) { }
