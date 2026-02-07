package com.flashcards.application.s3.usecases;

import com.flashcards.domain.s3.valueobject.StoredObject;

public interface DownloadObjectUseCase {
    StoredObject execute(String key);
}

