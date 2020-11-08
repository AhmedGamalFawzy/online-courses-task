package com.bankmasr.onlinecourse.resolver;

import com.bankmasr.onlinecourse.entity.Teacher;
import com.bankmasr.onlinecourse.exception.ExceptionMessages;
import com.bankmasr.onlinecourse.exception.NotFoundException;
import com.bankmasr.onlinecourse.mapper.TeacherMapper;
import com.bankmasr.onlinecourse.repository.TeacherRepository;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author agamal on 11/3/2020
 */
public class TeacherResolver implements ObjectIdResolver {

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public void bindItem(ObjectIdGenerator.IdKey idKey, Object o) {
    }

    @Override
    public Object resolveId(ObjectIdGenerator.IdKey idKey) {
        Teacher teacher = teacherRepository.findByName(idKey.key.toString()).orElseThrow(() ->
                new NotFoundException(ExceptionMessages.TEACHER_NOT_FOUND));
        return TeacherMapper.convertEntityToDto(teacher);
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
