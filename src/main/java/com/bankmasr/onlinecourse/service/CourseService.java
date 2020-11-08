package com.bankmasr.onlinecourse.service;

import com.bankmasr.onlinecourse.dto.CourseDto;
import com.bankmasr.onlinecourse.entity.Course;
import com.bankmasr.onlinecourse.enums.Status;

import java.util.List;

/**
 * @author agamal on 11/3/2020
 */
public interface CourseService {

    List<CourseDto> getAllCourses();

    CourseDto getCourseById(Long courseId);

    List<CourseDto> getCoursesByStatus(Status status);

    Course updateCourseStatus(Course course);
}
