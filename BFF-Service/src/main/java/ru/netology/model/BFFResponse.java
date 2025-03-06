package ru.netology.model;

import lombok.Getter;
import lombok.Setter;


// класс для комбинированного ответа с данными пользователя и заказов
@Getter
@Setter
public class BFFResponse {
    private Users user; // Данные пользователя
    private Order[] order; // Заказы пользователя

    // Конструктор для инициализации полей


    public BFFResponse(Users user, Order[] order) {
        this.user = user;
        this.order = order;
    }
}