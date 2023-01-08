package com.Hb03.Bi_OneToOne;

import com.Hb03.Uni_OneToOne.Diary;
import com.Hb03.Uni_OneToOne.Student03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//        Student04 student=session.get(Student04.class,1001);
//        System.out.println(student);
//        Diary04 diary=session.get(Diary04.class,101);
//        System.out.println(diary);

        //iki clasin kesisim kusmesini alalim
//String hql="select s.name,d.name from Student04 s inner join fetch Diary04 d on s.id = d.student";
//           List<Object[]> list= session.createQuery(hql).getResultList();
//for(Object[] o : list){
//    System.out.println(Arrays.toString(o));
//}
//butun ogrencileri ve kitabi olan ogrencileri de getirin

//        String hql="select s.name,d.name from Student04 s left join Diary04 d on s.id = d.student.id";//.id yazsak da yazmasak da hibernate onu anlar
//        List<Object[]> list=session.createQuery(hql).getResultList();
//list.forEach(t-> System.out.println(Arrays.toString(t)));


        //butun gunlukler ,gunlugu olan ogrenciler
//        String hql="select s.name,d.name from Student04 s right join Diary04 d on s.id = d.student.id";
//        List<Object[]> list=session.createQuery(hql).getResultList();
//        list.forEach(t-> System.out.println(Arrays.toString(t)));

        String hql="select s.name,d.name from Student04 s full join Diary04 d on s.id = d.student.id";
        List<Object[]> list=session.createQuery(hql).getResultList();
        list.forEach(t-> System.out.println(Arrays.toString(t)));
        tx.commit();
        session.close();
        sf.close();
    }

}
