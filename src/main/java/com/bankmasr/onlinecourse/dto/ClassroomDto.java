package com.bankmasr.onlinecourse.dto;

import com.bankmasr.onlinecourse.enums.Status;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * @author agamal on 11/3/2020
 */
public class ClassroomDto {

    private Long id;

    private Status status;

    @JsonIdentityReference(alwaysAsId = true)
    private CourseDto course;

    @JsonIdentityReference(alwaysAsId = true)
    private TeacherDto teacher;

    @JsonIgnore
    private List<StudentDto> students;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public CourseDto getCourse() {
        return course;
    }

    public void setCourse(CourseDto course) {
        this.course = course;
    }

    public TeacherDto getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDto teacher) {
        this.teacher = teacher;
    }

    public List<StudentDto> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDto> students) {
        this.students = students;
    }
}
