package com.bankmasr.onlinecourse.dto;

import com.bankmasr.onlinecourse.resolver.TeacherResolver;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author agamal on 11/3/2020
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "name",
        resolver = TeacherResolver.class, scope = TeacherDto.class)
public class TeacherDto {

    private Long id;

    @NotBlank
    private String name;

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

    public List<ClassroomDto> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<ClassroomDto> classrooms) {
        this.classrooms = classrooms;
    }
}
