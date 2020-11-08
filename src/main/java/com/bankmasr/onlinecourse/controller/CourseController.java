package com.bankmasr.onlinecourse.controller;

import com.bankmasr.onlinecourse.dto.CourseDto;
import com.bankmasr.onlinecourse.enums.Status;
import com.bankmasr.onlinecourse.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author agamal on 11/3/2020
 */
@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping
    public ResponseEntity<?> getAllCourses(@RequestParam(value = "status", required = false) Status status) {
        List<CourseDto> courseDtoList;
        if(status != null) {
            courseDtoList = courseService.getCoursesByStatus(status);
        } else {
            courseDtoList = courseService.getAllCourses();
        }
        return ResponseEntity.ok().body(courseDtoList);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<?> getCourseById(@PathVariable Long courseId) {
        return ResponseEntity.ok().body(courseService.getCourseById(courseId));
    }
}
