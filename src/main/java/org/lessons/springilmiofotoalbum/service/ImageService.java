package org.lessons.springilmiofotoalbum.service;


import org.lessons.springilmiofotoalbum.repository.CategoryRepository;
import org.lessons.springilmiofotoalbum.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository;

    @Autowired
    CategoryRepository categoryRepository;
}
