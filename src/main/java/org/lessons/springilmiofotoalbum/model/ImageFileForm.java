package org.lessons.springilmiofotoalbum.model;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;


public class ImageFileForm {

    //questo è il DTO Data Transfer Object

    private MultipartFile multipartFile;

    private Image image;

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
