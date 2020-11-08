package com.bankmasr.onlinecourse.service;

import com.bankmasr.onlinecourse.dto.ClassroomDto;
import com.bankmasr.onlinecourse.dto.StudentDto;

import java.util.List;

/**
 * @author agamal on 11/3/2020
 */
public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long studentId);

    StudentDto registerToClass(Long studentId, Long classroomId);

    List<ClassroomDto> getStudentRegisteredClasses(Long studentId);
}
