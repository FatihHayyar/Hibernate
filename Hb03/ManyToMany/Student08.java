package com.Hb03.ManyToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student08")
public class Student08 {
    @Id
    private int id;
    @Column(nullable = false,name = "std_name")
    private String name;

    private  int grade;

    @ManyToMany
    @JoinTable(name = "student_book",joinColumns ={@JoinColumn(name = "st_id")},inverseJoinColumns = {@JoinColumn(name = "bok_id")})
    private List<Book08> student=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Book08> getStudent() {
        return student;
    }

    public void setStudent(List<Book08> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Student08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", student=" + student +
                '}';
    }
}
