package com.Hb03.Uni_ManyToOne;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Student05 {
    @Id
    private int id;
    @Column(nullable = false,name = "std_name")
    private String name;
    private int grade;
private LocalDateTime createOn;

@ManyToOne
@JoinColumn(name="uni_id")
    private University university;
@PrePersist //bu variable persist edildigi an o anki tarihi alir atar
public void persist(){
    createOn=LocalDateTime.now();
}

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

    public LocalDateTime getCreateOn() {
        return createOn;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createOn=" + createOn +
                ", university=" + university +
                '}';
    }
}
