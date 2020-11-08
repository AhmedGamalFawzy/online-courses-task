package com.bankmasr.onlinecourse.mapper;

import com.bankmasr.onlinecourse.dto.StudentDto;
import com.bankmasr.onlinecourse.dto.TeacherDto;
import com.bankmasr.onlinecourse.entity.Student;
import com.bankmasr.onlinecourse.entity.Teacher;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;

/**
 * @author agamal on 11/3/2020
 */
public class TeacherMapper {

    public static TeacherDto convertEntityToDto(Teacher teacher) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(teacher, TeacherDto.class);
    }

    public static void convertDtoToEntity(TeacherDto teacherDto, Teacher teacher) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(teacherDto, teacher);
    }
}
