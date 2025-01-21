package com.test.api.marvel_challenge.exception;

public record ApiErrorDto(
        String message,
        String backendMessage,
        String method,
        String url
) {
}
