package com.example.controller;

import java.util.List;

import com.example.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.repository.StudentRepository;
import com.example.model.Student;

@RestController
@RequestMapping(path = "api/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "allStudents")
    public List<Student> getAllStudents() {
        return this.studentService.getStudent();
    }

    @GetMapping(path = "findStudentId/{studentId}")
    public Student findStudentById(@PathVariable Long studentId) {
        return this.studentService.getStudentById(studentId);
    }

    @GetMapping(path = "findStudentName/{studentName}")
    public Student findStudentName(@PathVariable     String studentName) {
        return this.studentService.getStudentByName(studentName);
    }

    @GetMapping(path = "findStudentClass/{currentClass}")
    public Student findStudentClass(@PathVariable String currentClass) {
        return this.studentService.getStudentByClass(currentClass);
    }

    @PostMapping(path = "addStudent")
    public void addStudent(@RequestBody Student student) {
        this.studentService.addStudent(student);
    }

    @DeleteMapping(path = "delete/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "updateStudent/{studentId}")
    public void upDateStudent
            (@PathVariable("studentId") Long id,
             @RequestParam(required = false) String name,
             @RequestParam(required = false) String dob,
             @RequestParam(required = false) String joiningDate,
             @RequestParam(required = false) String currentClass) {
        studentService.updateStudent(id, name, dob, joiningDate, currentClass);
    }
}

