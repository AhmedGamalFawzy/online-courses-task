package com.bankmasr.onlinecourse.repository;

import com.bankmasr.onlinecourse.entity.Course;
import com.bankmasr.onlinecourse.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author agamal on 11/3/2020
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByStatusEquals(Status status);

    Optional<Course> findByName(String name);
}
