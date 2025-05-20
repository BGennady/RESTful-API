package ru.netology.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String deliveryAddress;
    private String phoneNumber;
    private String email;
}
