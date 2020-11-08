package com.bankmasr.onlinecourse.controller;

import com.bankmasr.onlinecourse.dto.ClassroomDto;
import com.bankmasr.onlinecourse.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author agamal on 11/3/2020
 */
@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.ok().body(studentService.getAllStudents());
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<?> getStudentById(@PathVariable Long studentId) {
        return ResponseEntity.ok().body(studentService.getStudentById(studentId));
    }

    @PatchMapping("/{studentId}/classrooms/{classroomId}")
    ResponseEntity<?> registerToClass(@PathVariable Long studentId, @PathVariable Long classroomId){
        return ResponseEntity.ok().body(studentService.registerToClass(studentId, classroomId));
    }

    @GetMapping("/{studentId}/classrooms")
    public ResponseEntity<?> getStudentRegisteredClasses(@PathVariable Long studentId) {
        return ResponseEntity.ok().body(studentService.getStudentRegisteredClasses(studentId));
    }
}
