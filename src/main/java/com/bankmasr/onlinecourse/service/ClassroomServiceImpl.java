package com.bankmasr.onlinecourse.service;

import com.bankmasr.onlinecourse.dto.ClassroomDto;
import com.bankmasr.onlinecourse.dto.CourseDto;
import com.bankmasr.onlinecourse.entity.Classroom;
import com.bankmasr.onlinecourse.entity.Course;
import com.bankmasr.onlinecourse.exception.ConflictException;
import com.bankmasr.onlinecourse.exception.ExceptionMessages;
import com.bankmasr.onlinecourse.exception.NotFoundException;
import com.bankmasr.onlinecourse.mapper.ClassroomMapper;
import com.bankmasr.onlinecourse.mapper.CourseMapper;
import com.bankmasr.onlinecourse.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author agamal on 11/3/2020
 */
@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    CourseService courseService;

    @Override
    public CourseDto createClassroom(ClassroomDto classroomDto) {
        Classroom classroom = new Classroom();
        ClassroomMapper.convertDtoToEntity(classroomDto, classroom);
        classroom.getCourse().getClassrooms().add(classroom);
        Course course;
        try {
            classroom = classroomRepository.save(classroom);
            course = courseService.updateCourseStatus(classroom.getCourse());
        } catch (Exception exception) {
            throw new ConflictException(ExceptionMessages.CLASSROOM_ALREADY_EXISTS);
        }
        return CourseMapper.convertEntityToDto(course);
    }

    @Override
    public CourseDto partialUpdateClassroom(Long classroomId, ClassroomDto classroomDto) {
        Classroom classroom = classroomRepository.findById(classroomId).orElseThrow(() ->
                new NotFoundException(ExceptionMessages.CLASSROOM_NOT_FOUND));
        ClassroomMapper.convertDtoToEntity(classroomDto, classroom);
        classroom = classroomRepository.save(classroom);
        Course course = courseService.updateCourseStatus(classroom.getCourse());
        return CourseMapper.convertEntityToDto(course);
    }
}
