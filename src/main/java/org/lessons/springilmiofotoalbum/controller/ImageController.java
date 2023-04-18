package org.lessons.springilmiofotoalbum.controller;

import jakarta.validation.Valid;
import org.lessons.springilmiofotoalbum.exception.ImageNotFoundException;
import org.lessons.springilmiofotoalbum.model.AlertMessage;
import org.lessons.springilmiofotoalbum.model.Category;
import org.lessons.springilmiofotoalbum.model.Image;
import org.lessons.springilmiofotoalbum.model.ImageFileForm;
import org.lessons.springilmiofotoalbum.service.CategoryService;
import org.lessons.springilmiofotoalbum.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/images")
public class ImageController {

    @Autowired
    ImageService imageService;

    @Autowired
    CategoryService categoryService;

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
        model.addAttribute("allCategories", categoryService.categories());

        return "image_page/edit";
    }

    @PostMapping("/edit")
    public String store(@Valid @ModelAttribute(name = "image") Image formImage,
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

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Optional<Integer> id, Model model) {
        if (id.isPresent()) {
            try {
                Image image = imageService.getImageById(id.get());
                model.addAttribute("allCategories", categoryService.categories());
                model.addAttribute("image", image);
            } catch (ImageNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return "image_page/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Integer id,
                         @Valid @ModelAttribute Image imageForm,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()){
            return "image_page/edit";
        }
        try {
            Image imageToUpdate = imageService.update(imageForm, id);
            return "redirect:/images/" + id;
        } catch (ImageNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            boolean success = imageService.delete(id);
            if (success) {
                redirectAttributes.addFlashAttribute("message",
                        new AlertMessage(AlertMessage.AlertMessageType.SUCCESS, "Element with id " + id + " deleted with success."));
            } else {
                redirectAttributes.addFlashAttribute("message",
                        new AlertMessage(AlertMessage.AlertMessageType.ERROR, "Unable to delete element with id " + id));
            }

        } catch (ImageNotFoundException e) {
            redirectAttributes.addFlashAttribute("message",
                    new AlertMessage(AlertMessage.AlertMessageType.ERROR, "Element with id " + id + " not found."));
        }
        return "redirect:/images";
    }

    @GetMapping("/{id}/image_file")
    public String editImageFile(@PathVariable Integer id, Model model) {
        try {
            Image image = imageService.getImageById(id);
            //creo un oggetto imageFileForm e lo setto come attributo del model
            ImageFileForm imageFileForm = new ImageFileForm();
            imageFileForm.setImage(image);
            model.addAttribute("imageFileForm", imageFileForm);
            return "/image_page/cover_edit";
        } catch (ImageNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/image_file/save")
    public String storeImageFile(@PathVariable Integer id, @ModelAttribute ImageFileForm imageFileForm) {
        //salvo l'immagine nel db
        try {
            imageService.updateBookImageFile(id, imageFileForm);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ImageNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return "redirect:/images/" + Integer.toString(id);
    }
}
