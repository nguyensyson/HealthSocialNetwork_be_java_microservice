package com.sonns.infratructures.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.sonns"})
@EntityScan(basePackages = {"com.sonns"})
public class JpaConfig {
}
