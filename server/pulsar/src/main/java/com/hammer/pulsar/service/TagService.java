package com.hammer.pulsar.service;

import com.hammer.pulsar.dto.common.Tag;

import java.util.List;

public interface TagService {

    public List<Tag> getAllTags();

    public List<Tag> getAllExerciseTags();

}
