package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "updatedAt")
    private Date updatedAt;

    @ManyToMany(mappedBy = "posts")
//    @JsonBackReference
    private List<Category> categories = new ArrayList<>();

    public void addCategory(Category category) {
        categories.add(category);
    }

    public Post() {
        this.createdAt = new Date();
    }

    public Post(Long id, String title, String description, Date createdAt, Date updatedAt, List<Category> categories) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = new Date();
        this.updatedAt = updatedAt;
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
