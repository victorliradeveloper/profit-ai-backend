package com.profitai.application.s3.usecases;

public interface UploadObjectUseCase {
	String execute(String originalFilename, String contentType, byte[] bytes);
}
