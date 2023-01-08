package com.Hb03.UniiOneToMany;

import com.Hb03.Uni_ManyToOne.Student05;
import com.Hb03.Uni_ManyToOne.University;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student06.class).addAnnotatedClass(Book.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//Student06 student = session.get(Student06.class,1001);
//        System.out.println(student.getBook());

//101 id li kitabi getir
//        String hql="from Book b where b.id=101";
//Book book=session.createQuery(hql,Book.class).uniqueResult();
//        System.out.println(book);


        //bir ogrenicinin kitaplarini ogrenciye gore getirelim
        //1.yol
//Student06 student = session.get(Student06.class,1001);
//        System.out.println(student.getBook());
//2.yol
        String hql="select b.id,b.name from Student06 s inner join s.book b where s.id=1001";
List<Object[]> list=session.createQuery(hql).getResultList();
list.forEach(t-> System.out.println(Arrays.toString(t)));


        tx.commit();
        session.close();
        sf.close();
    }

}
