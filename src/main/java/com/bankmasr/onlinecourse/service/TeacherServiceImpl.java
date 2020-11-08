package com.bankmasr.onlinecourse.service;

import com.bankmasr.onlinecourse.dto.TeacherDto;
import com.bankmasr.onlinecourse.entity.Teacher;
import com.bankmasr.onlinecourse.mapper.TeacherMapper;
import com.bankmasr.onlinecourse.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author agamal on 11/3/2020
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public List<TeacherDto> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream().map(teacher -> TeacherMapper.convertEntityToDto(teacher))
                .collect(Collectors.toList());
    }
}
