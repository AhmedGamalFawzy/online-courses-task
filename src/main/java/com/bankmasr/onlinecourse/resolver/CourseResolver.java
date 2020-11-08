package com.bankmasr.onlinecourse.resolver;

import com.bankmasr.onlinecourse.entity.Course;
import com.bankmasr.onlinecourse.exception.ExceptionMessages;
import com.bankmasr.onlinecourse.exception.NotFoundException;
import com.bankmasr.onlinecourse.mapper.CourseMapper;
import com.bankmasr.onlinecourse.repository.CourseRepository;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author agamal on 11/3/2020
 */
@Component
public class CourseResolver implements ObjectIdResolver {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public void bindItem(ObjectIdGenerator.IdKey idKey, Object o) {
    }

    @Override
    public Object resolveId(ObjectIdGenerator.IdKey idKey) {
        Course course = courseRepository.findByName(idKey.key.toString()).orElseThrow(() ->
                new NotFoundException(ExceptionMessages.COURSE_NOT_FOUND));
        return CourseMapper.convertEntityToDto(course);
    }

    @Override
    public ObjectIdResolver newForDeserialization(Object o) {
        return this;
    }

    @Override
    public boolean canUseFor(ObjectIdResolver objectIdResolver) {
        return false;
    }
}
