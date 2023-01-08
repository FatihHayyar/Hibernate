package com.Hb02.Embeddable;

import javax.persistence.*;

@Entity
@Table(name = "t_student02")
public class Student02 {
    @Id
    private int id;
    @Column(name = "student_name",length = 30,nullable = false,unique = false)
    private String name;
    private int grade;
    @Embedded//olsada calisir olmasa da java var oldugunu anlar
    private Address address;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Student02(int id, String name, int grade, Address address) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.address = address;
    }

    public Student02() {
    }

    @Override
    public String toString() {
        return "Student02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", address=" + address +
                '}';
    }
}
