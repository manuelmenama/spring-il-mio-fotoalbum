package org.lessons.springilmiofotoalbum.controller;

import jakarta.validation.Valid;
import org.lessons.springilmiofotoalbum.exception.ImageNotFoundException;
import org.lessons.springilmiofotoalbum.model.Image;
import org.lessons.springilmiofotoalbum.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/images")
public class ImageController {

    @Autowired
    ImageService imageService;

    @GetMapping
    public String index(Model model, @RequestParam Optional<String> q) {

        List<Image> selectedImages = null;
        if (!q.isPresent()) {
            selectedImages = imageService.getAllImage();
            model.addAttribute("selectedImages", selectedImages);
        } else {
            selectedImages = imageService.getImageByTitle(q.get());
            model.addAttribute("selectedImages", selectedImages);
        }
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

    @GetMapping("/edit")
    public String create(Model model) {

        model.addAttribute("image", new Image());

        return "image_page/edit";
    }

    @PostMapping("/edit")
    public String store(@Valid @ModelAttribute("image") Image formImage,
                        BindingResult bindingResult,
                        Model model) {
        boolean hasErrors = bindingResult.hasErrors();

        if (hasErrors) {
            return "/image_page/edit";
        } else {
            imageService.create(formImage);
            return "redirect:/images";
        }
    }
}
