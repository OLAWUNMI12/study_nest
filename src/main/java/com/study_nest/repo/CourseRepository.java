package com.study_nest.repo;

import com.study_nest.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findByDepartmentId(Integer departmentId);

    @Query("SELECT c FROM Course c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%')) AND c.department.id = :departmentId ")
    Page<Course> searchCourses(@Param("name") String name, @Param("departmentId") Integer departmentId,  Pageable pageable);


    @Query("SELECT c FROM Course c WHERE  c.department.id = :departmentId ORDER BY RAND() LIMIT 3")
    List<Course> searchRandomCourses(@Param("departmentId") Integer departmentId);


}
