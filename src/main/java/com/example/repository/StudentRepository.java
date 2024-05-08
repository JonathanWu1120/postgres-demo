package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.dob = ?1")
    Optional<Student> findStudentByDOB(String dob);

    @Query("SELECT s FROM Student s WHERE s.id = ?1")
    Optional<Student> findStudentById(Long id);

    @Query("SELECT s FROM Student s WHERE s.name = ?1")
    List<Student> findAllByName(String name);

    @Query("SELECT s FROM Student s WHERE s.currentClass =?1")
    List<Student> findAllByCurrentClass(String currentClass);

}
