package com.study_nest.repo;

import com.study_nest.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Optional<Department> findByNameIgnoreCase(String name);
}
