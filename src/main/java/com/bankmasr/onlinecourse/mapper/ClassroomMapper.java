package com.bankmasr.onlinecourse.mapper;

import com.bankmasr.onlinecourse.dto.ClassroomDto;
import com.bankmasr.onlinecourse.dto.CourseDto;
import com.bankmasr.onlinecourse.entity.Classroom;
import com.bankmasr.onlinecourse.entity.Course;
import com.bankmasr.onlinecourse.enums.Status;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;

import java.util.stream.Collectors;

/**
 * @author agamal on 11/3/2020
 */
public class ClassroomMapper {

    public static ClassroomDto convertEntityToDto(Classroom classroom) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(classroom, ClassroomDto.class);
    }

    public static void convertDtoToEntity(ClassroomDto classroomDto, Classroom classroom) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(classroomDto, classroom);
    }
}
