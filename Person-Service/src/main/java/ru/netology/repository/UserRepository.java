package ru.netology.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
}