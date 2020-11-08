package com.bankmasr.onlinecourse.mapper;

import com.bankmasr.onlinecourse.dto.ClassroomDto;
import com.bankmasr.onlinecourse.dto.StudentDto;
import com.bankmasr.onlinecourse.entity.Classroom;
import com.bankmasr.onlinecourse.entity.Student;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;

/**
 * @author agamal on 11/3/2020
 */
public class StudentMapper {

    public static StudentDto convertEntityToDto(Student student) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(student, StudentDto.class);
    }

    public static void convertDtoToEntity(StudentDto studentDto, Student student) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(studentDto, student);
    }
}
