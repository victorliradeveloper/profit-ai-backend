package com.profitai.infrastructure.exception;

import java.time.Instant;

public record ErrorResponse(Instant timestamp, int status, String errorCode, String message, String path, String method,
		String requestId) {
}
