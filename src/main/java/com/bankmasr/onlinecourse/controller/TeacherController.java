package com.bankmasr.onlinecourse.controller;

import com.bankmasr.onlinecourse.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author agamal on 11/3/2020
 */
@RestController
@RequestMapping(value = "/teachers")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping
    public ResponseEntity<?> getAllTeachers() {
        return ResponseEntity.ok().body(teacherService.getAllTeachers());
    }
}
