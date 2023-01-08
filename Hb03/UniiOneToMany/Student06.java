package com.Hb03.UniiOneToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student06")
public class Student06 {
    @Id
    private int id;
    @Column(name = "std_name")
    private String name;

    private int grade;
@OneToMany
@JoinColumn
    private List<Book> book=new ArrayList<>();

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

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Student06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", book=" + book +
                '}';
    }
}
