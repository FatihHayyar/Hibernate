package com.Hb03.Uni_OneToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diary {
    @Id
    private int id;

private  String name;
@OneToOne
@JoinColumn(name = "std_id")//kendimiz yazmasak java student_01 olusturur
private Student03 student;

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

    public Student03 getStudent() {
        return student;
    }

    public void setStudent(Student03 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
