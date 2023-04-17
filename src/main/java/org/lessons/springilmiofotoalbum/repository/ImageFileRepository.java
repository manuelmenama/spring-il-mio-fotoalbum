package org.lessons.springilmiofotoalbum.repository;

import org.lessons.springilmiofotoalbum.model.ImageFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageFileRepository extends JpaRepository<ImageFile, Integer> {
}
