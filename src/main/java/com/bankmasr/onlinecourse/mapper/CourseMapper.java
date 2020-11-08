package com.bankmasr.onlinecourse.mapper;

import com.bankmasr.onlinecourse.dto.CourseDto;
import com.bankmasr.onlinecourse.entity.Course;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
/**
 * @author agamal on 11/3/2020
 */
public class CourseMapper {

    public static CourseDto convertEntityToDto(Course course) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(course, CourseDto.class);
    }

    public static void convertDtoToEntity(CourseDto courseDto, Course course) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(courseDto, course);
    }
}
