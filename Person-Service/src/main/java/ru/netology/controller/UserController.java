package ru.netology.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.service.UserService;
import ru.netology.model.Users;

// аннотация @RestController объединяет @Controller и @ResponseBody,
@RestController
// указывает базовый путь для всех маршрутов в контроллере
@RequestMapping("api/users")

// класс принимающий запрос
public class UserController {

    private final UserService service; // сервис для работы с бизнес-логикой

    // конструктор контроллера, который принимает сервис
    public UserController(UserService service) {
        this.service = service;
    }

    // метод для обработки запроса на получение user по id
    @GetMapping("/{userId}") // аннотация для обработки GET-запроса с параметром id
    public Users getUserById(@PathVariable long userId) {
        return service.getById(userId); // возвращаем пост по id. Spring автоматически сериализует его в JSON
    }
}