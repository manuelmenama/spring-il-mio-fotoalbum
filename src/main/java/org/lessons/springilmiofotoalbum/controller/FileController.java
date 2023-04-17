package org.lessons.springilmiofotoalbum.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.lessons.springilmiofotoalbum.model.ImageFile;
import org.lessons.springilmiofotoalbum.repository.ImageFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/files")
public class FileController {

    @Autowired
    ImageFileRepository imageFileRepository;

    @GetMapping("/{imageFileId}")
    public ResponseEntity<byte[]> serveFile(@PathVariable Integer imageFileId) {
        ImageFile imageFile = imageFileRepository.findById(imageFileId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        MediaType mediaType = MediaType.IMAGE_JPEG;
        return ResponseEntity.ok().contentType(mediaType).body(imageFile.getContent());
    }
}
