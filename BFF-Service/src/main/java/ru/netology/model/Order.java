package ru.netology.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private long id;
    private long userId;
    private double totalAmount;
    private String currency;
    private long quantity;
}
