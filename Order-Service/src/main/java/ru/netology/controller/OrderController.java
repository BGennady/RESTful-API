package ru.netology.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.model.Order;
import ru.netology.service.OrderService;

import java.util.List;

// аннотация @RestController объединяет @Controller и @ResponseBody,

@RestController
// указывает базовый путь для всех маршрутов в контроллере
@RequestMapping("api/orders")

// класс принимающий запрос
public class OrderController {

    private final OrderService service; // сервис для работы с бизнес-логикой

    // конструктор контроллера, который принимает сервис
    public OrderController(OrderService service) {
        this.service = service;
    }

    // метод для обработки запроса на получение user по id
    @GetMapping("/{id}") // аннотация для обработки GET-запроса с параметром id
    public List<Order> getOrderById(@PathVariable long id) {
        return service.getByUserId(id); // возвращает пост по id. Spring автоматически сериализует его в JSON
    }
}