package org.lessons.springilmiofotoalbum.api;

import org.lessons.springilmiofotoalbum.exception.ImageNotFoundException;
import org.lessons.springilmiofotoalbum.model.Image;
import org.lessons.springilmiofotoalbum.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/images")
public class ImageRestController {

    @Autowired
    ImageService imageService;

    @GetMapping
    public List<Image> index(@RequestParam("q") Optional<String> keyword) {
        List<Image> images = null;
        if (keyword.isPresent()) {
            images = imageService.getImageByTitle(keyword.get());
        } else {
            images = imageService.getAllImage();
        }
        return images;
    }

    @GetMapping("/{id}")
    public Image show(@PathVariable Integer id) {
        try {
            return imageService.getImageById(id);
        } catch (ImageNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
