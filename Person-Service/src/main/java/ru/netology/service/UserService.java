package ru.netology.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.model.Users;
import ru.netology.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    public final UserRepository repository;

    public Users getById(long id) {
        // возвращаем пост по идентификатору или выбрасываем исключение, если пост не найден
        return repository.findById(id)
                // выбрасываем исключение, если пользователь не найден
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }
}
