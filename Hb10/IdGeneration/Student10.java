package com.Hb10.IdGeneration;

import javax.persistence.*;

@Entity
public class Student10 {
    /*
    Oracle ile postgre default olarak sequence dir
    MySQL ile digeri identy dir
auto hibernate stratejiyi belirler
table kebdi tablo olusturur cok kullanilmaz. en yavasi
identy kontrol db dedir kendi yapisina gore olusturur. en basitidir
sequence kontrolu developer a birakir baslangis degeri veyakac tane id cath lenecegini developer yapabilir


     */
    @GeneratedValue(generator = "sequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence",sequenceName = "_sec",initialValue = 1000,allocationSize = 10)
    @Id
    private int id;
    @Column(nullable = false,name = "std_name")
    private String name;
    private int grade;

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

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
        return "Student10{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
