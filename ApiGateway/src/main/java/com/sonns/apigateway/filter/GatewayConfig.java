package com.sonns.apigateway.filter;

import org.springframework.cloud.gateway.filter.factory.DedupeResponseHeaderGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user", r -> r.path("/api/users/**","/api/auth/**")
                        .uri("http://localhost:8081"))
                .route("order", r -> r.path("/api/orders/**","/api/tables/**","/api/order-details/**")
                        .uri("http://localhost:8083"))
                .route("menu", r -> r.path("/api/menus/**","/uploads/**")
                        .uri("http://localhost:8082"))
                .route("kitchen", r -> r.path("/api/kitchens/**")
                        .uri("http://localhost:8084"))
                .route("invoice", r -> r.path("/api/invoice/**")
                        .uri("http://localhost:8085"))
                .route("report", r -> r.path("/api/reports/**","/ws-report/**")
                        .filters(f -> f.dedupeResponseHeader("Access-Control-Allow-Origin", DedupeResponseHeaderGatewayFilterFactory.Strategy.RETAIN_FIRST.name()))
                        .uri("http://localhost:8086"))
                .build();
    }
}
