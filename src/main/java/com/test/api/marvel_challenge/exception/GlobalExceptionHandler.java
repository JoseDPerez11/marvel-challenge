package com.test.api.marvel_challenge.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<ApiErrorDto> handlerGeneralExceptions(Exception exception,
                                                                HttpServletRequest request,
                                                                WebRequest webRequest) {
        if (exception instanceof HttpClientErrorException) {
            return this.handleHttpClientErrorException((HttpClientErrorException) exception, request, webRequest);
        } else if (exception instanceof AccessDeniedException) {
            return this.handleAccessDeniedException((AccessDeniedException) exception, request, webRequest);
        } else if (exception instanceof AuthenticationCredentialsNotFoundException) {
            return this.handleAuthenticationCredentialsNotFoundException((AuthenticationCredentialsNotFoundException) exception, request, webRequest);
        } else {
            return this.handleGenericException(exception, request, webRequest);
        }
    }

    private ResponseEntity<ApiErrorDto> handleGenericException(Exception exception, HttpServletRequest request, WebRequest webRequest) {

        String message = null;

        if (exception instanceof HttpClientErrorException.Forbidden) {
            message = "no tienes acceso a este recurso";
        } else if (exception instanceof HttpClientErrorException.Unauthorized) {
            message = "no haz iniciado sesion para acceder a este recurso";
        } else if (exception instanceof HttpClientErrorException.NotFound) {
            message = "recurso no encontrado";
        } else if (exception instanceof HttpClientErrorException.Conflict) {
            message = "conflicto en el procesamiento de la petición";
        }

        ApiErrorDto dto = new ApiErrorDto(
                message,
                exception.getMessage(),
                request.getMethod(),
                request.getRequestURL().toString()
        );

        return ResponseEntity.internalServerError().body(dto);
    }

    private ResponseEntity<ApiErrorDto> handleAuthenticationCredentialsNotFoundException(AuthenticationCredentialsNotFoundException exception, HttpServletRequest request, WebRequest webRequest) {
        ApiErrorDto dto = new ApiErrorDto(
                "no tienes acceso a este recurso",
                exception.getMessage(),
                request.getMethod(),
                request.getRequestURL().toString()
        );

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(dto);
    }

    private ResponseEntity<ApiErrorDto> handleAccessDeniedException(AccessDeniedException exception, HttpServletRequest request, WebRequest webRequest) {
        ApiErrorDto dto = new ApiErrorDto(
                "no tienes acceso a este recurso",
                exception.getMessage(),
                request.getMethod(),
                request.getRequestURL().toString()
        );

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(dto);
    }

    private ResponseEntity<ApiErrorDto> handleHttpClientErrorException(HttpClientErrorException exception, HttpServletRequest request, WebRequest webRequest) {
        ApiErrorDto dto = new ApiErrorDto(
                "error inesperado al realizar consulta",
                exception.getMessage(),
                request.getMethod(),
                request.getRequestURL().toString()
        );

        return ResponseEntity.status(exception.getStatusCode()).body(dto);
    }
}
