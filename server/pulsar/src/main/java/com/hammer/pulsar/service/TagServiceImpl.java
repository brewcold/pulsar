package com.hammer.pulsar.service;

import com.hammer.pulsar.dao.ExerciseDao;
import com.hammer.pulsar.dao.TagDao;
import com.hammer.pulsar.dto.common.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private final TagDao tagDao;
    private final ExerciseDao exerciseDao;

    @Autowired
    public TagServiceImpl(TagDao tagDao, ExerciseDao exerciseDao) {
        this.tagDao = tagDao;
        this.exerciseDao = exerciseDao;
    }

    @Override
    public List<Tag> getAllTags() {
        return tagDao.selectAllTags();
    }

    @Override
    public List<Tag> getAllExerciseTags() {
        return exerciseDao.selectAllExerciseTags();
    }

}
