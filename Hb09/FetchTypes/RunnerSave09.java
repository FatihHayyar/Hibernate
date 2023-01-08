package com.Hb09.FetchTypes;

import com.Hb03.ManyToMany.Book08;
import com.Hb03.ManyToMany.Student08;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave09 {
    public static void main(String[] args) {
        Student09 student1 = new Student09();
        student1.setId(1001);
        student1.setName("Fatih");
        student1.setGrade(95);

        Student09 student2 = new Student09();
        student2.setId(1002);
        student2.setName("Gulsah");
        student2.setGrade(65);

        Student09 student3 = new Student09();
        student3.setId(1003);
        student3.setName("Osman");
        student3.setGrade(85);

        Book09 book1 = new Book09();
        book1.setId(101);
        book1.setName("A Book");

        Book09 book2 = new Book09();
        book2.setId(102);
        book2.setName("B Book");

        Book09 book3 = new Book09();
        book3.setId(103);
        book3.setName("C Book");

        Book09 book4 = new Book09();
        book4.setId(104);
        book4.setName("D Book");

        Book09 book5 = new Book09();
        book5.setId(105);
        book5.setName("E Book");

        student1.getBooklist().add(book1);
        student1.getBooklist().add(book2);
        student2.getBooklist().add(book3);
        student2.getBooklist().add(book4);
        student3.getBooklist().add(book5);

        book1.setStudent(student1);
        book2.setStudent(student1);
        book3.setStudent(student2);
        book4.setStudent(student2);
        book5.setStudent(student3);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student09.class).addAnnotatedClass(Book09.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        session.save(student1);
        session.save(student2);
        session.save(student3);




        tx.commit();
        session.close();
        sf.close();
    }
}
