package com.Hb03.Uni_ManyToOne;

import com.Hb03.Uni_OneToOne.Diary;
import com.Hb03.Uni_OneToOne.Student03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch05 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//        Student05 student=session.get(Student05.class,1001);
//        System.out.println(student);
//        University diary=session.get(University.class,101);
//        System.out.println(diary);

        //1 id li universiteye giden tüm ogrencileri bul
        String hql="from Student05 s where s.university.id=101";
        List<Student05> studentlist=session.createQuery(hql, Student05.class).getResultList();
        studentlist.forEach(t-> System.out.println(t));



        tx.commit();
        session.close();
        sf.close();
    }

}
