package com.bankmasr.onlinecourse.service;

import com.bankmasr.onlinecourse.dto.CourseDto;
import com.bankmasr.onlinecourse.entity.Course;
import com.bankmasr.onlinecourse.enums.Status;
import com.bankmasr.onlinecourse.exception.ExceptionMessages;
import com.bankmasr.onlinecourse.exception.NotFoundException;
import com.bankmasr.onlinecourse.mapper.CourseMapper;
import com.bankmasr.onlinecourse.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author agamal on 11/3/2020
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(course -> CourseMapper.convertEntityToDto(course))
                .collect(Collectors.toList());
    }

    @Override
    public CourseDto getCourseById(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() ->
                new NotFoundException(ExceptionMessages.COURSE_NOT_FOUND));
        return CourseMapper.convertEntityToDto(course);
    }

    @Override
    public List<CourseDto> getCoursesByStatus(Status status) {
        List<Course> courses = courseRepository.findByStatusEquals(status);
        return courses.stream().map(course -> CourseMapper.convertEntityToDto(course))
                .collect(Collectors.toList());
    }

    @Override
    public Course updateCourseStatus(Course course) {
        boolean allClassroomsClosed = course.getClassrooms()
                .stream().allMatch(classroom -> classroom.getStatus().equals(Status.CLOSED));
        if(allClassroomsClosed) {
            course.setStatus(Status.CLOSED);
        } else {
            course.setStatus(Status.OPEN);
        }
        return courseRepository.save(course);
    }
}
