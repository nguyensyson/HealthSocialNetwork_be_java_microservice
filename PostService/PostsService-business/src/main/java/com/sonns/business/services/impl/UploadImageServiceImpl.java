package com.sonns.business.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.sonns.business.services.UploadImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UploadImageServiceImpl implements UploadImageService {

    private final Cloudinary cloudinary;

    @Override
    public String uploadImage(MultipartFile file, String customFileName) {
        try {
            String publicId = "HealthSocialNetwork/" + customFileName;

            Map uploadResult = cloudinary.uploader().upload(file.getBytes(),
                    ObjectUtils.asMap(
                            "resource_type", "auto",
                            "public_id", publicId));

            return uploadResult.get("secure_url").toString();
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload image to Cloudinary", e);
        }
    }

    @Override
    public String deleteImage(String url) {
        return "";
    }
}
