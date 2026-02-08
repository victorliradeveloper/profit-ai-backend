package com.profitai.application.s3.usecases;

import com.profitai.domain.s3.valueobject.StoredObject;

public interface DownloadObjectUseCase {
    StoredObject execute(String key);
}


