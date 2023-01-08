package com.Hb1.Annotation;
import javax.persistence.*;

    @Entity //eEntity anotationu koydugumuz sinifi DB de bir tabloya karsilik getiri
    @Table(name="t_student01") //DB de table ismini degistirdik.
    public class Student01 {//Db ye gider student 01 diye tablo olusturur.
    @Id//primary key olusmasini sagliyor zorunludur
    @Column(name="student_id") //field adini degistiri
    private int id;
    //column ile ozellik ekliyoz
    @Column(name="student_name",length = 20,nullable = false,unique = false)
    private String name;
    //@Transient //DB de tabloda grade adinda bir kolon olusmasini engeller
    private int grade;
//    @Lob//Db se buyuk data geldigini soyleriz
//    private byte[] image;

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

        @Override
        public String toString() {
            return "Student01{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", grade=" + grade +
                    '}';
        }
    }
