package org.lessons.springilmiofotoalbum.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ImageRepositoryTest {

    @Autowired
    ImageRepository imageRepository;
    @Test
    void findByTitleContainingIgnoreCase() {
    }
}