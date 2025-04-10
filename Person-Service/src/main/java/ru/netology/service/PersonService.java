package ru.netology.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.model.Person;
import ru.netology.repository.PersonRepository;

@Service
@RequiredArgsConstructor
public class PersonService {
    public final PersonRepository repository;

    public Person getById(long id) {
        // возвращаем пост по идентификатору или выбрасываем исключение, если пост не найден
        return repository.findById(id)
                // выбрасываем исключение, если пользователь не найден
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

}
