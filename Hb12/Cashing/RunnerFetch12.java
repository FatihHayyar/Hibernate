package com.Hb12.Cashing;

import com.Hb11.CriteriaApi.Student11;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch12 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student12.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student12 student1=session.get(Student12.class,1L);
        System.out.println(student1);

//        Student12 student2=session.get(Student12.class,1L); //2.kez calistirinca query yapmaz oncekini kullanir
//session.clear();//onceki islemleri sifirlar


        tx.commit();
        session.close();//first level cache de session kapandigi an cashing silinir clear yapar

        Session session1= sf.openSession();
        Transaction tx1= session1.beginTransaction();


        Student12 student3=session1.get(Student12.class,1L);


        tx1.commit();
        session1.close();

        sf.close();
    }
}
