package ru.netology;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// аннотация, что это конфигурационный класс
@Configuration
public class GatewayConfig {

    @Value("${services.bff-id}")
    private String bffId;  // ID сервиса, получает из application.properties

    @Value("${services.bff-url}")
    private String bffUrl;  // URL сервиса, получает из application.properties

    @Value("${services.bff-port}")
    private int bffPort;  // порт сервиса, получает из application.properties

    @Value("${services.bff-pattern}")
    private String bffPattern;  // путь для маршрута, получает из application.properties

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes() // строит маршруты
                .route(bffId, r -> r.path(bffPattern) // создает маршрут по шаблону пути
                        .uri(bffUrl + ":" + bffPort))  // строит URI с использованием данных из application.properties
                .build(); // сроит и возвращает маршрут
    }
}
