package com.Hb13.get_Load;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/*
   get() ---> gerçek nesneyi döndürür ,
               nesne yoksa null döner
               nesnenin olduğundan emin değilseniz get() kullanın
               dönen nesneye hemen kullanacaksam get() kullanılmalı
   load() --> proxy nesne döndürür, gerçek nesnenin gölgesi ,
               nesne yoksa exception fırlatır
               dönen nesne üzerinde delete yapılacaksa kullanılabilir
 */
public class RunnerFetch13 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//        Student13 student1=session.get(Student13.class,1L);
//        System.out.println(student1.getId());
//get metodu gider alir gelir. load proxy sini alir ama islem yapilcaginda gider getirir

        Student13 student2=session.load(Student13.class,1L);
        System.out.println(student2.getName());//bisey isteninceye kadar cagirmaz
        tx.commit();
        session.close();
        sf.close();

    }
}
