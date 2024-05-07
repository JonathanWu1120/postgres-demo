package com.example.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "dob")
    private String DOB ;

    @Column(name = "joining_date")
    private String joiningDate;

    @Column(name = "class")
    private String CLASS;


    public Student() {

    }

    public Student(String name, String DOB, String joiningDate, String CLASS) {
        super();
        this.name = name;
        this.DOB = DOB;
        this.joiningDate = joiningDate;
        this.CLASS = CLASS;
    }
}