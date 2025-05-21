package ru.netology.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.service.PersonService;
import ru.netology.model.Person;

// аннотация @RestController объединяет @Controller и @ResponseBody,
@RestController
// указывает базовый путь для всех маршрутов в контроллере
@RequestMapping("api/users")

// класс принимающий запрос
public class PersonController {

    private final PersonService service; // сервис для работы с бизнес-логикой

    // конструктор контроллера, который принимает сервис
    public PersonController(PersonService service) {
        this.service = service;
    }

    // метод для обработки запроса на получение user по id
    @GetMapping("/{id}") // аннотация для обработки GET-запроса с параметром id
    public Person getUserById(@PathVariable long id) {
        return service.getById(id); // возвращает пост по id. Spring автоматически сериализует его в JSON
    }
}