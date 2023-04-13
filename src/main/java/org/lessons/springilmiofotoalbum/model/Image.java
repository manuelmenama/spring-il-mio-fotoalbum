package org.lessons.springilmiofotoalbum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "images")
public class Image {

    //attributi
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(nullable = false)
    private String title;
    private String description;
    @NotNull
    @Column(nullable = false)
    private String image;
    @Column(name = "is_visible", columnDefinition = "boolean default true")
    private boolean isVisible;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToMany
    @JoinTable(
            name = "category_image",
            joinColumns = @JoinColumn(name = "image_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categorySet;

    //costruttore
    public Image() {
    }

    public Image(Integer id, String title, String description, String image, boolean isVisible, LocalDateTime createdAt, LocalDateTime updatedAt, Set<Category> categorySet) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.isVisible = isVisible;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.categorySet = categorySet;
    }

    //setter e getter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<Category> getCategorySet() {
        return categorySet;
    }

    public void setCategorySet(Set<Category> categorySet) {
        this.categorySet = categorySet;
    }


    //metodi

}
