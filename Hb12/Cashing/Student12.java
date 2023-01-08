package com.Hb12.Cashing;

import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
/*
1)	First Level Cache --->
			* defaultta açık geliyor , kapatma durumu yok
			* Aynı session içinde kayıt alır
			* session kapanınca içindejkiler silinir

2) Second Level Cache --->
			* Defaultta kapalıdır
			* Session factory seviyesinde cachleme yapar, yani farklı
					sessionlar arasında data kullanılabiliyor
			* hibernate.cfg.xml den active edilebilir

3) Query Cache
			* Query ler için kullanılıyor
			* hibernate.cfg.xml den active edilebilir

 */


@Entity
@Cacheable
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE, region = "Student12")
public class Student12 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="std_name", nullable = false,length = 20)
    private String name;

    private int grade;

        // Getter-Setter ***********************************


    public Long getId() {
        return id;
    }

        //    public void setId(Long id) {
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

        // toString() *************************************


    @Override
    public String toString() {
        return "Student12{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mathGrade=" + grade +
                '}';
    }
}