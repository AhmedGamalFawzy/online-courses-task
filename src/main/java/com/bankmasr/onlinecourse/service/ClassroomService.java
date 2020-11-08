package com.bankmasr.onlinecourse.service;

import com.bankmasr.onlinecourse.dto.ClassroomDto;
import com.bankmasr.onlinecourse.dto.CourseDto;

/**
 * @author agamal on 11/3/2020
 */
public interface ClassroomService {

    CourseDto createClassroom(ClassroomDto classroomDto);

    CourseDto partialUpdateClassroom(Long classroomId, ClassroomDto classroomDto);
}
