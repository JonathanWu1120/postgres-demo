package com.example.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Column(name = "dob")
    @Getter
    @Setter
    private String DOB ;

    @Column(name = "joining_date")
    @Getter
    @Setter
    private String joiningDate;

    @Column(name = "class")
    @Getter
    @Setter
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