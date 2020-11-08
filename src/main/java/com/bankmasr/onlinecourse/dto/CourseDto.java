package com.bankmasr.onlinecourse.dto;

import com.bankmasr.onlinecourse.enums.Status;
import com.bankmasr.onlinecourse.resolver.CourseResolver;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author agamal on 11/3/2020
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "name",
        resolver = CourseResolver.class, scope = CourseDto.class)
public class CourseDto {

    private Long id;

    @NotBlank
    private String name;

    private Status status;

    private List<ClassroomDto> classrooms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<ClassroomDto> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<ClassroomDto> classrooms) {
        this.classrooms = classrooms;
    }
}
