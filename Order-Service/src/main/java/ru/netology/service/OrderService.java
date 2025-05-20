package ru.netology.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ru.netology.model.Order;
import ru.netology.repository.OrderRepository;

@Service
public class OrderService {
    public final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }
    public Order getById (long id){
        // возвращаем пост по идентификатору или выбрасываем исключение, если пост не найден
        return repository.findById(id)
                // выбрасываем исключение, если пользователь не найден
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + id));
    }
}
