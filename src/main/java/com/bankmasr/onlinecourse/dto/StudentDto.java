package com.bankmasr.onlinecourse.dto;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author agamal on 11/3/2020
 */
public class StudentDto {

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
