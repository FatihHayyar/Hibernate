package com.Hb1.Annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {
    public static void main(String[] args) {
        Student01 student1 = new Student01();
        student1.setId(1001);
        student1.setName("Fatih");
        student1.setGrade(90);
        Student01 student2 = new Student01();
        student2.setId(1002);
        student2.setName("Tarik");
        student2.setGrade(80);
        Student01 student3 = new Student01();
        student3.setId(1003);
        student3.setName("Hakan");
        student3.setGrade(95);

        Configuration conf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
   //hibernate e configuration dosyami ve entity class imi bildirdim.

        SessionFactory sf=conf.buildSessionFactory();
        Session ses =sf.openSession();
        Transaction trnc = ses.beginTransaction();
//commit e kadar olan alana yazilanlari DB ye aktarir
//        ses.save(student1);
//        ses.save(student2);
//        ses.save(student3);

        trnc.commit();

        ses.close();
        sf.close();
    }
}
