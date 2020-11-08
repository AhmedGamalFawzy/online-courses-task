package com.bankmasr.onlinecourse.repository;

import com.bankmasr.onlinecourse.entity.Course;
import com.bankmasr.onlinecourse.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author agamal on 11/3/2020
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findByName(String name);
}
