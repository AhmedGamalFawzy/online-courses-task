package com.bankmasr.onlinecourse.controller;

import com.bankmasr.onlinecourse.dto.ClassroomDto;
import com.bankmasr.onlinecourse.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author agamal on 11/3/2020
 */
@RestController
@RequestMapping(value = "/classrooms")
public class ClassroomController {

    @Autowired
    ClassroomService classroomService;

    @PostMapping
    ResponseEntity<?> createClassroom(@RequestBody ClassroomDto classroomDto){
        return ResponseEntity.ok().body(classroomService.createClassroom(classroomDto));
    }

    @PatchMapping("/{classroomId}")
    ResponseEntity<?> partialUpdateClassroom(@PathVariable Long classroomId, @RequestBody ClassroomDto classroomDto){
        return ResponseEntity.ok().body(classroomService.partialUpdateClassroom(classroomId, classroomDto));
    }

}
