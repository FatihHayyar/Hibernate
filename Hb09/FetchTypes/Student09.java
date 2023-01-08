package com.Hb09.FetchTypes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student09 {
    @Id
    private int id;
    @Column(name = "std_name",nullable = false)
    private String name;

    private int grade;

    /*
    Java ikinci taraflar many ise herzaman default degeri lazy ceker
    ama one ise eagger a ceker
     */
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL/*,fetch = FetchType.EAGER*/)
    private List<Book09> booklist=new ArrayList<>();

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

    public List<Book09> getBooklist() {
        return booklist;
    }

    public void setBooklist(List<Book09> booklist) {
        this.booklist = booklist;
    }

    @Override
    public String toString() {
        return "Student09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", booklist=" + booklist +
                '}';
    }
}
