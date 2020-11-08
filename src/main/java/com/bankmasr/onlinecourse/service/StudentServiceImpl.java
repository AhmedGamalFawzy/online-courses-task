package com.bankmasr.onlinecourse.service;

import com.bankmasr.onlinecourse.dto.ClassroomDto;
import com.bankmasr.onlinecourse.dto.StudentDto;
import com.bankmasr.onlinecourse.entity.Classroom;
import com.bankmasr.onlinecourse.entity.Student;
import com.bankmasr.onlinecourse.enums.Status;
import com.bankmasr.onlinecourse.exception.ExceptionMessages;
import com.bankmasr.onlinecourse.exception.NotFoundException;
import com.bankmasr.onlinecourse.exception.UnprocessableException;
import com.bankmasr.onlinecourse.mapper.ClassroomMapper;
import com.bankmasr.onlinecourse.mapper.StudentMapper;
import com.bankmasr.onlinecourse.repository.ClassroomRepository;
import com.bankmasr.onlinecourse.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author agamal on 11/3/2020
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClassroomRepository classroomRepository;

    @Value("${student.classrooms.limit}")
    private Integer classroomsLimit;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(student -> StudentMapper.convertEntityToDto(student))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() ->
                new NotFoundException(ExceptionMessages.STUDENT_NOT_FOUND));
        return StudentMapper.convertEntityToDto(student);
    }

    @Override
    public StudentDto registerToClass(Long studentId, Long classroomId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() ->
                new NotFoundException(ExceptionMessages.STUDENT_NOT_FOUND));
        Classroom classroom = classroomRepository.findById(classroomId).orElseThrow(() ->
                new NotFoundException(ExceptionMessages.CLASSROOM_NOT_FOUND));
        if(classroom.getStatus().equals(Status.CLOSED)) {
            throw new UnprocessableException(ExceptionMessages.CLASSROOM_CLOSED);
        }
        Set<Classroom> classrooms = student.getClassrooms();
        classrooms.add(classroom);
        student.setClassrooms(classrooms);
        classroom.getStudents().add(student);
        if(student.getClassrooms().size() > classroomsLimit) {
            throw new UnprocessableException(ExceptionMessages.CLASSROOMS_LIMIT_REACHED);
        }
        return StudentMapper.convertEntityToDto(studentRepository.save(student));
    }

    @Override
    public List<ClassroomDto> getStudentRegisteredClasses(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() ->
                new NotFoundException(ExceptionMessages.STUDENT_NOT_FOUND));
        return student.getClassrooms().stream().map(classroom -> ClassroomMapper.convertEntityToDto(classroom))
                .collect(Collectors.toList());
    }
}
