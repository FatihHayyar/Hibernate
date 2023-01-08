package com.Hb03.Bi_OneToMany;

import com.Hb03.UniiOneToMany.Book;
import com.Hb03.UniiOneToMany.Student06;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch07 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//Student07 student = session.get(Student07.class,1001);
//        System.out.println(student);

        //101 id li kitabi okuyan kisinn bilgileri

//        Book07 book = session.get(Book07.class,101);
//        System.out.println(book.getStudent());

//
//101 id li kitabi getir
//        String hql="from Book07 b where b.id=101";
//Book07 book=session.createQuery(hql,Book07.class).uniqueResult();
//        System.out.println(book);


        //bir ogrenicinin kitaplarini ogrenciye gore getirelim
        //1.yol
//Student06 student = session.get(Student06.class,1001);
//        System.out.println(student.getBook());
//2.yol
//        String hql="select b.id,b.name from Student06 s inner join s.book b where s.id=1001";
//List<Object[]> list=session.createQuery(hql).getResultList();
//list.forEach(t-> System.out.println(Arrays.toString(t)));

//        String hql="select s.std_name,b.book_name from t_student07 s inner join book07 b on s.id=b.student_id";
//
//        List<Object[]> list=session.createSQLQuery(hql).getResultList();
//        list.forEach(t-> System.out.println(Arrays.toString(t)));

        //delete yapalim
//String hql="delete from book07";
//int silinensayi=session.createSQLQuery(hql).executeUpdate();
//        System.out.println(silinensayi);

//        String hql="delete from Student07";
//        int silinensayi=session.createQuery(hql).executeUpdate();
//        System.out.println(silinensayi);

//        String hql="delete from Book07 b where b.name='Deutsch Book'";
//        int silinensayi=session.createQuery(hql).executeUpdate();
//        System.out.println(silinensayi);


        //1001 i d studneti sil
//       Student07 student=session.get(Student07.class,1001);
//       session.delete(student);

//Book listte icinde Java olani alalim

String hql="select s from Student07 s inner join s.booklist b where b.name like '%Java%'";
List<Student07> list=session.createQuery(hql).getResultList();
        list.forEach(t-> System.out.println(t));
        tx.commit();
        session.close();
        sf.close();
    }

}
