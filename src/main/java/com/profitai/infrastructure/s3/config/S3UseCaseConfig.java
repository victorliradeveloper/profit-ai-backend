package com.profitai.infrastructure.s3.config;

import com.profitai.application.s3.usecases.DownloadObjectUseCase;
import com.profitai.application.s3.usecases.DownloadObjectUseCaseImpl;
import com.profitai.application.s3.usecases.UploadObjectUseCase;
import com.profitai.application.s3.usecases.UploadObjectUseCaseImpl;
import com.profitai.domain.s3.port.ObjectStoragePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3UseCaseConfig {

	@Bean
	public UploadObjectUseCase uploadObjectUseCase(ObjectStoragePort objectStoragePort) {
		return new UploadObjectUseCaseImpl(objectStoragePort);
	}

	@Bean
	public DownloadObjectUseCase downloadObjectUseCase(ObjectStoragePort objectStoragePort) {
		return new DownloadObjectUseCaseImpl(objectStoragePort);
	}
}
