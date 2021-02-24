package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @Column(name = "tag_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, max = 10)
    @NotNull
    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
//    @JsonBackReference
    private Category category;

    public Tag() {
    }

    public Tag(Long id, String text, Category category) {
        this.id = id;
        this.text = text;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
