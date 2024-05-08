package com.example.services;

import com.example.model.Student;
import com.example.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent() {
        return (List<Student>) this.studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findStudentById(id).orElseThrow(
                () -> new IllegalStateException("student ID not found")
        );
    }

    public List<Student> getStudentByName(String name) {
        return (List<Student>) this.studentRepository.findAllByName(name);
    }

    public List<Student> getStudentByClass(String className) {
        return (List<Student>) this.studentRepository.findAllByCurrentClass(className);
    }

    public void addStudent(Student student) {
        Optional<Student> optionalStudent = studentRepository.findStudentByDOB(student.getDob());
        if (optionalStudent.isPresent()) {
            throw new IllegalStateException("already exist");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean find = studentRepository.existsById(id);
        if (!find) {
            throw new IllegalStateException("student not found");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String dob, String joiningDate, String currentClass) {
        Student student = studentRepository.findStudentById(id).orElseThrow(
                () -> new IllegalStateException("student not found")
        );

        if (name != null && !name.isEmpty()) {
            student.setName(name);
        }
        if (dob != null && !dob.isEmpty()) {
            student.setDob(dob);
        }
        if (joiningDate != null && !joiningDate.isEmpty()) {
            student.setJoiningDate(joiningDate);
        }
        if (currentClass != null && !currentClass.isEmpty()) {
            student.setCurrentClass(currentClass);
        }

    }
}
