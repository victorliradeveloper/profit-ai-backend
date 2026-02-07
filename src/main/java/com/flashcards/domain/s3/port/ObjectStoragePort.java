package com.flashcards.domain.s3.port;

import com.flashcards.domain.s3.valueobject.StoredObject;

public interface ObjectStoragePort {
    void put(String key, byte[] bytes, String contentType);
    StoredObject get(String key);
}

