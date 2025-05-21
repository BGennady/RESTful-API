package ru.netology.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ru.netology.model.Order;
import ru.netology.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    public final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> getByUserId(long id) {
        // возвращаем пост по идентификатору или выбрасываем исключение, если пост не найден
        List<Order> orders = repository.findByUserId(id);

        // если список пустой
        if (orders.isEmpty()) {
            // выбрасываем исключение
            throw new EntityNotFoundException("Orders not found for user with id: " + id);
        }
        return orders;
    }
}
