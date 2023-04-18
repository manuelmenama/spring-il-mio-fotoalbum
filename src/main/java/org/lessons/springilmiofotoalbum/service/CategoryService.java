package org.lessons.springilmiofotoalbum.service;

import org.lessons.springilmiofotoalbum.exception.CategoryNotFoundException;
import org.lessons.springilmiofotoalbum.exception.ImageNotFoundException;
import org.lessons.springilmiofotoalbum.model.Category;
import org.lessons.springilmiofotoalbum.model.Image;
import org.lessons.springilmiofotoalbum.repository.CategoryRepository;
import org.lessons.springilmiofotoalbum.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ImageRepository imageRepository;

    public List<Category> categories() {
        return categoryRepository.findAll();
    }

    public Category categoryById(Integer id) throws CategoryNotFoundException{
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category not found"));
    }

    public Category create(Category formCategory) {
        Category newCategory = new Category();
        newCategory.setName(formCategory.getName());
        newCategory.setCreatedAt(LocalDateTime.now());
        newCategory.setUpdatedAt(LocalDateTime.now());
        return categoryRepository.save(newCategory);
    }

    public Category update(Category formCategory) throws CategoryNotFoundException{
        Category categoryToUpdate = categoryById(formCategory.getId());
        categoryToUpdate.setName(formCategory.getName());
        categoryToUpdate.setUpdatedAt(LocalDateTime.now());
        return categoryRepository.save(categoryToUpdate);
    }

    public boolean delete(Integer id) throws CategoryNotFoundException {

        categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category with id " + id + " not found!"));

        try {
            categoryRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }




    }

}
