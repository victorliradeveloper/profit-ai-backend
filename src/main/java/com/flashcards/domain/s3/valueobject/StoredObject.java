package com.flashcards.domain.s3.valueobject;

public record StoredObject(byte[] bytes, String contentType) {
}

