package com.Hb03.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RunnerSave08 {
    public static void main(String[] args) {
        Book08 book1 = new Book08();
        book1.setId(101);
        book1.setName("Art Book");

        Book08 book2 = new Book08();
        book2.setId(102);
        book2.setName("Math Book");

        Student08 student = new Student08();
        student.setId(1001);
        student.setName("Fatih");
        student.setGrade(95);

        Student08 student2 = new Student08();
        student2.setId(1002);
        student2.setName("Tarik Bey");
        student2.setGrade(75);

        Student08 student3 = new Student08();
        student3.setId(1003);
        student3.setName("Ömer Çelebi");
        student3.setGrade(75);

        List<Book08> booklist = new ArrayList<Book08>();
        booklist.add(book1);
        booklist.add(book2);

        List<Book08> booklist1 = new ArrayList<Book08>();
        booklist1.add(book1);
        booklist1.add(book2);

        List<Book08> booklist3 = new ArrayList<Book08>();
        booklist3.add(book1);

        student.setStudent(booklist);
        student2.setStudent(booklist1);
        student3.setStudent(booklist3);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student08.class).addAnnotatedClass(Book08.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

session.save(book1);
session.save(book2);

session.save(student);
session.save(student2);
session.save(student3);



        tx.commit();
        session.close();
        sf.close();

    }
}
