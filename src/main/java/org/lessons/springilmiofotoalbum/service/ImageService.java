package org.lessons.springilmiofotoalbum.service;


import org.lessons.springilmiofotoalbum.exception.ImageNotFoundException;
import org.lessons.springilmiofotoalbum.model.Image;
import org.lessons.springilmiofotoalbum.repository.CategoryRepository;
import org.lessons.springilmiofotoalbum.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<Image> getAllImage() {
        return imageRepository.findAll();
    }

    public Image getImageById(Integer id) throws ImageNotFoundException {
        Image selectedImage = imageRepository.findById(id).orElseThrow(() -> new ImageNotFoundException("Image with id " + id + " not found!"));
        return selectedImage;
    }

    public List<Image> getImageByTitle(String title) {
        return imageRepository.findByTitleContainingIgnoreCase(title);
    }
}
