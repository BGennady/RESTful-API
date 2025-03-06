package ru.netology.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.netology.model.BFFResponse;
import ru.netology.model.Order;
import ru.netology.model.Users;

@RestController // Обрабатывает HTTP запросы
@RequestMapping("api/site-bff") // Устанавливает базовый путь для всех маршрутов
public class BffController {

    private final RestTemplate restTemplate;

    @Value("${services.user}")
    private String userUrl; // URL для получения данных пользователя

    @Value("${services.order}")
    private String orderUrl; // URL для получения заказов пользователя

    // Конструктор, принимающий RestTemplate
    public BffController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Обработчик GET-запроса по пути "/user/{userId}"
    @GetMapping("/user/{userId}")
    public BFFResponse getByUserAndOrder(@PathVariable long userId) {

        // Строим URL для запроса к микросервису, который возвращает данные пользователя по userId
        String userServiceUrl = userUrl + "/" + userId;
        Users users = restTemplate.getForObject(userServiceUrl, Users.class); // Получаем данные пользователя

        // Строим URL для запроса заказов пользователя по userId
        String userOrderUrl = orderUrl + "/" + userId;
        Order[] orders = restTemplate.getForObject(userOrderUrl, Order[].class); // Получаем заказы пользователя

        // Возвращаем комбинированный ответ
        return new BFFResponse(users, orders);
    }
}