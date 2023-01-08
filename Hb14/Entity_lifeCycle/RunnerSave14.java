package com.Hb14.Entity_lifeCycle;

import com.Hb13.get_Load.Student13;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
Hinernate in Objeler ile nasıl çalıştığı ile ilgili ek bilgi :
   Entity State :
      *) Transient : Objenin newlenmiş hali, DB ile ilişkisi yok.

      *) Persisted or Managed : DB de row a karşılık geldiği durum,
                        save(),get() vs. yapıldığı zamana denk geliyor.

      *) Detached : Session kapandıktan sonra elimizdeki objenin state durumu.

      *) Removed : obje remove yapıldığı zmanki durum.
*/
public class RunnerSave14 {
    public static void main(String[] args) {
        Student14 student1=new Student14();
        student1.setName("Fatih");
        student1.setGrade(96);

        Student14 student2=new Student14();
        student2.setName("Emir");
        student2.setGrade(85);

        Student14 student3=new Student14(); //Transient State
        student3.setName("Tarik");
        student3.setGrade(92);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1); //Persistet State
        session.save(student2);
        session.save(student3);

        session.evict(student1);//bunu takip etme demek. detachted a gecer
        session.update(student1);//detachted edilmisi tekrar persiste a alir
        session.merge(student1);//detachted edilmisi tekrar persiste a alir yukardakinin aynisi
        tx.commit();
        session.close();
        sf.close();
    }
}
