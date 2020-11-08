package com.bankmasr.onlinecourse.controller;

import com.bankmasr.onlinecourse.entity.Course;
import com.bankmasr.onlinecourse.entity.Student;
import com.bankmasr.onlinecourse.entity.Teacher;
import com.bankmasr.onlinecourse.repository.CourseRepository;
import com.bankmasr.onlinecourse.repository.StudentRepository;
import com.bankmasr.onlinecourse.repository.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author agamal on 11/3/2020
 */
@RestController
@RequestMapping(value = "/initialization")
public class InitializationController {

    final CourseRepository courseRepository;

    final TeacherRepository teacherRepository;

    final StudentRepository studentRepository;

    public InitializationController(CourseRepository courseRepository, TeacherRepository teacherRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    @PostMapping
    ResponseEntity<?> initialize(){
        createCourses();
        createTeachers();
        createStudents();
        return new ResponseEntity<>("Done!", null, HttpStatus.OK);
    }

    private void createCourses() {
        List<Course> courses = new ArrayList<>();
        Course course = new Course("Spring Boot");
        courses.add(course);
        course = new Course("Java SE 8");
        courses.add(course);
        course = new Course("React.js");
        courses.add(course);
        course = new Course("Vue.js");
        courses.add(course);
        course = new Course("Angular");
        courses.add(course);
        course = new Course("MongoDB");
        courses.add(course);

        courseRepository.saveAll(courses);
    }

    private void createTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        Teacher teacher = new Teacher("Mohamed Refaat");
        teachers.add(teacher);
        teacher = new Teacher("Abdelsalam Elnaboulsy");
        teachers.add(teacher);
        teacher = new Teacher("Bahgat ElAbasiry");
        teachers.add(teacher);
        teacher = new Teacher("Ahmed Shawkat");
        teachers.add(teacher);
        teacher = new Teacher("Atef Ismail");
        teachers.add(teacher);
        teacher = new Teacher("Kamal Elshazly");
        teachers.add(teacher);

       teacherRepository.saveAll(teachers);
    }

    private void createStudents() {
        List<Student> students = new ArrayList<>();
        Student student = new Student("Ahmed Gamal");
        students.add(student);
        student = new Student("Mohamed Waheed");
        students.add(student);
        student = new Student("Shady ElQady");
        students.add(student);
        student = new Student("Ahmed Salah");
        students.add(student);
        student = new Student("Bassem Hany");
        students.add(student);
        student = new Student("Khaled Adel");
        students.add(student);

        studentRepository.saveAll(students);
    }
}
