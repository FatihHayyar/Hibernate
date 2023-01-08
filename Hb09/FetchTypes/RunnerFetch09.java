package com.Hb09.FetchTypes;

import com.Hb03.ManyToMany.Book08;
import com.Hb03.ManyToMany.Student08;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student09.class).addAnnotatedClass(Book09.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//        Student09 student = session.get(Student09.class,1001);
////        session.delete(student);

//        Book09 book = session.get(Book09.class,101);
//        System.out.println(book);



        tx.commit();
        session.close();
        sf.close();
    }

}
