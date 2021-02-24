package com.example.demo.service;

import com.example.demo.model.Tag;
import com.example.demo.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

}
