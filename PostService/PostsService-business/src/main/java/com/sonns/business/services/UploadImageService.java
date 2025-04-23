package com.sonns.business.services;

import org.springframework.web.multipart.MultipartFile;

public interface UploadImageService {
    String uploadImage(MultipartFile file, String customFileName);
    String deleteImage(String url);
}
