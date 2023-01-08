package com.Hb10.IdGeneration;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave10 {
    public static void main(String[] args) {
        Student10 student1 = new Student10();
        student1.setName("Fatih");
        student1.setGrade(96);

        Student10 student2 = new Student10();
        student2.setName("Alper");
        student2.setGrade(77);

        Student10 student3 = new Student10();
        student3.setName("Mahir");
        student3.setGrade(87);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student10.class);

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
