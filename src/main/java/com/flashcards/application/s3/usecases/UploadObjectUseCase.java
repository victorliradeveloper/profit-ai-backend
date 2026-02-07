package com.flashcards.application.s3.usecases;

public interface UploadObjectUseCase {
    String execute(String originalFilename, String contentType, byte[] bytes);
}

