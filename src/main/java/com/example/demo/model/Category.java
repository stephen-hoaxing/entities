package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference
    private Set<Tag> tags = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "category_post",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id")
    )
//    @JsonManagedReference
    private List<Post> posts = new ArrayList<>();

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public Category() {
    }

    public Category(Long id, String title, Set<Tag> tags, List<Post> posts) {
        this.id = id;
        this.title = title;
        this.tags = tags;
        this.posts = posts;
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

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
