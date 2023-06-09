package org.lessons.springilmiofotoalbum.service;


import org.lessons.springilmiofotoalbum.exception.ImageNotFoundException;
import org.lessons.springilmiofotoalbum.model.Image;
import org.lessons.springilmiofotoalbum.model.ImageFile;
import org.lessons.springilmiofotoalbum.model.ImageFileForm;
import org.lessons.springilmiofotoalbum.repository.CategoryRepository;
import org.lessons.springilmiofotoalbum.repository.ImageFileRepository;
import org.lessons.springilmiofotoalbum.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ImageFileRepository imageFileRepository;

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

    public Image create(Image formImage) {
        Image imageToStorage = new Image();
        imageToStorage.setTitle(formImage.getTitle());
        imageToStorage.setPathImage(formImage.getPathImage());
        imageToStorage.setDescription(formImage.getDescription());
        imageToStorage.setCategorySet(formImage.getCategorySet());
        imageToStorage.setIsVisible(formImage.getIsVisible());
        imageToStorage.setCreatedAt(LocalDateTime.now());
        imageToStorage.setUpdatedAt(LocalDateTime.now());
        return imageRepository.save(imageToStorage);
    }
    public Image update(Image formImage, Integer id) throws ImageNotFoundException{
        Image imageToUpdate = imageRepository.findById(id).orElseThrow(() -> new ImageNotFoundException("Image with id " + id + " not found!"));
        imageToUpdate.setTitle(formImage.getTitle());
        imageToUpdate.setPathImage(formImage.getPathImage());
        imageToUpdate.setDescription(formImage.getDescription());
        imageToUpdate.setCategorySet(formImage.getCategorySet());
        imageToUpdate.setIsVisible(formImage.getIsVisible());
        imageToUpdate.setUpdatedAt(LocalDateTime.now());
        return imageRepository.save(imageToUpdate);
    }

    public boolean delete(Integer id) throws ImageNotFoundException {
        imageRepository.findById(id).orElseThrow(() -> new ImageNotFoundException("Image with id " + id + " not found!"));

        try {
            imageRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ImageFile updateBookImageFile(Integer id, ImageFileForm imageFileForm) throws ImageNotFoundException, IOException {
        Image imageToUpdateCover = imageRepository.findById(id).orElseThrow(() -> new ImageNotFoundException("Image with id " + id + " not found!"));
        ImageFile newImageFile = new ImageFile();
        newImageFile.setImage(imageToUpdateCover);
        newImageFile.setContent(imageFileForm.getMultipartFile().getBytes());
        return imageFileRepository.save(newImageFile);
    }
}
