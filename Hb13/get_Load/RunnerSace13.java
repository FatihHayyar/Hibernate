package com.Hb13.get_Load;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSace13 {
    public static void main(String[] args) {
        Student13 student1=new Student13();
        student1.setName("Fatih");
        student1.setGrade(35);

        Student13 student2=new Student13();
        student2.setName("Yusuf");
        student2.setGrade(35);

        Student13 student3=new Student13();
        student3.setName("Halide");
        student3.setGrade(35);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);

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
