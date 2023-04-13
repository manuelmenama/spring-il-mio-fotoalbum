package org.lessons.springilmiofotoalbum.controller;

import org.lessons.springilmiofotoalbum.exception.ImageNotFoundException;
import org.lessons.springilmiofotoalbum.model.Image;
import org.lessons.springilmiofotoalbum.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/images")
public class ImageController {

    @Autowired
    ImageService imageService;

    @GetMapping
    public String index(Model model) {
        List<Image> selectedImages = imageService.getAllImage();
        model.addAttribute("selectedImages", selectedImages);
        return "image_page/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        try {
            Image imageToShow = imageService.getImageById(id);
            model.addAttribute("imageToShow", imageToShow);
        } catch (ImageNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "image_page/show";
    }
}
