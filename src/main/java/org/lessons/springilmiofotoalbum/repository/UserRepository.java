package org.lessons.springilmiofotoalbum.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.lessons.springilmiofotoalbum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findByEmail(String email);
}
