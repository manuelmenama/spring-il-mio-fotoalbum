package org.lessons.springilmiofotoalbum.controller;

import jakarta.validation.Valid;
import org.lessons.springilmiofotoalbum.exception.CategoryNotFoundException;
import org.lessons.springilmiofotoalbum.model.AlertMessage;
import org.lessons.springilmiofotoalbum.model.Category;
import org.lessons.springilmiofotoalbum.repository.CategoryRepository;
import org.lessons.springilmiofotoalbum.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    private String index(@RequestParam Optional<Integer> idParam, Model model) {

        model.addAttribute("categories", categoryService.categories());
        Category newCategory = null;
        if (idParam.isPresent()) {
            newCategory = categoryService.categoryById(idParam.get());
            model.addAttribute("newCategory", newCategory);
        } else {
            model.addAttribute("newCategory", new Category());
        }

        return "/categories/index";
    }

    @PostMapping("/edit")
    private String edit(@ModelAttribute(name = "newCategory") Category category) {

        if (category.getId() != null) {
            try {
                categoryService.update(category);
            } catch (CategoryNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            categoryService.create(category);

        }

        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    private String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            boolean success = categoryService.delete(id);
            if (success) {
                redirectAttributes.addFlashAttribute("message",
                        new AlertMessage(AlertMessage.AlertMessageType.SUCCESS, "Element with id " + id + " deleted with success."));
            } else {
                redirectAttributes.addFlashAttribute("message",
                        new AlertMessage(AlertMessage.AlertMessageType.ERROR, "Unable to delete element with id " + id));
            }
        } catch (CategoryNotFoundException e) {
            redirectAttributes.addFlashAttribute("message",
                    new AlertMessage(AlertMessage.AlertMessageType.ERROR, "Element with id " + id + " not found."));
        }
        return "redirect:/categories";
    }
}
