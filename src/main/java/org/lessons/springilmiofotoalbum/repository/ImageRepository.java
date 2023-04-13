package org.lessons.springilmiofotoalbum.repository;

import org.lessons.springilmiofotoalbum.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
