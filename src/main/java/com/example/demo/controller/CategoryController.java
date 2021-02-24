package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Tag;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/load")
    public void load() {
        Category category = new Category();
        category.setTitle("Origami / Kirigami");

        Tag tag = new Tag();
        tag.setText("hobby");
        tag.setCategory(category);

        Tag tag1 = new Tag();
        tag1.setText("art");
        tag1.setCategory(category);

        Set<Tag> tags = new HashSet<>();
        tags.add(tag);
        tags.add(tag1);

        category.setTags(tags);

        categoryService.saveCategory(category);
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable("id") String id) {
        return categoryService.getCategoryById(id);
    }

}
