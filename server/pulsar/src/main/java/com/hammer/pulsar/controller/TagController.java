package com.hammer.pulsar.controller;

import com.hammer.pulsar.dto.common.Tag;
import com.hammer.pulsar.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/tag")
    public ResponseEntity<List<Tag>> getAllTags() {
        return new ResponseEntity<>(tagService.getAllTags(), HttpStatus.OK);
    }

    @GetMapping("/exercise")
    public ResponseEntity<List<Tag>> getAllExerciseTags() {
        return new ResponseEntity<>(tagService.getAllExerciseTags(), HttpStatus.OK);
    }

}
