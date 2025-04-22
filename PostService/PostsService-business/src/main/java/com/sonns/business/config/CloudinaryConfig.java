package com.sonns.business.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        Map config = ObjectUtils.asMap(
                "cloud_name", "darvug7fk",
                "api_key", "165153254544586",
                "api_secret", "SHswGN9UI8W8RmEFAoIKFMey4dM",
                "secure", true
        );
        return new Cloudinary(config);
    }
}
