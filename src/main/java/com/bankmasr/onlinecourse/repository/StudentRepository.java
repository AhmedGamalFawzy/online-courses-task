package com.bankmasr.onlinecourse.repository;

import com.bankmasr.onlinecourse.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author agamal on 11/3/2020
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
