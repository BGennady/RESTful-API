package ru.netology.model;

import lombok.Getter;
import lombok.Setter;


// класс для комбинированного ответа с данными пользователя и заказов
@Getter
@Setter
public class BFFResponse {
    private Person user; // данные пользователя
    private Order[] order; // заказы пользователя

    public BFFResponse(Person user, Order[] order) {
        this.user = user;
        this.order = order;
    }
}