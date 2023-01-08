package com.Hb11.CriteriaApi;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerFetch11 {
    public static void main(String[] args) {

        //CRUD
        //session.save create
        //get,sql,hql read
        //session.update, updatequerry query
        //session.delete, Sql, Hql delete

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student11.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

          Student11 student=session.get(Student11.class,1L);
//        student.setName("Yeni Isim");
//        session.update(student);

//        int sGrade=80;
//        int lGrade=75;
//
//        String hql = "update Student11 s set grade=:sGrade where s.grade<:lGrade";
//        Query query=  session.createQuery(hql);
//        query.setParameter("sGrade",sGrade);
//        query.setParameter("lGrade",lGrade);
//        int say=query.executeUpdate();
//        System.out.println(say);

        //CriteriaApi

        CriteriaBuilder cb=session.getCriteriaBuilder();
        CriteriaQuery<Student11> criteriaQuery= cb.createQuery(Student11.class);
        Root<Student11> root= criteriaQuery.from(Student11.class);

        //ornek hepsini gorelim

//        criteriaQuery.select(root);
//        Query<Student11> query1=session.createQuery(criteriaQuery);
//        List<Student11> resultList =query1.getResultList();
//        resultList.forEach(t-> System.out.println(t));


        //belli birini secelim
//        criteriaQuery.select(root).where(cb.equal(root.get("name"),"Student name9"));
//        Query<Student11> query2=session.createQuery(criteriaQuery);
//        List<Student11> resultList1 =query2.getResultList();
//        resultList1.forEach(t-> System.out.println(t));

        //grade degeri 80 den buyukleri getirelim
//        criteriaQuery.select(root).where(cb.greaterThan(root.get("grade"),80));
//        Query<Student11> query3=session.createQuery(criteriaQuery);
//        List<Student11> resultList2 =query3.getResultList();
//        resultList2.forEach(System.out::println);

        //grade degeri 95 den buyukleri getirelim
//        criteriaQuery.select(root).where(cb.lessThan(root.get("grade"),95));
//        Query<Student11> query4=session.createQuery(criteriaQuery);
//        List<Student11> resultList3 =query4.getResultList();
//        resultList3.forEach(System.out::println);

        //id si veya grade i 75 den buyuk olani bul
        Predicate forID=cb.equal(root.get("id"),1L);
        Predicate forGrade=cb.greaterThan(root.get("grade"),75);
        Predicate ortak=cb.or(forID,forGrade);

      criteriaQuery.where(ortak);
        Query<Student11> query5=session.createQuery(criteriaQuery);
        List<Student11> resultList4 =query5.getResultList();
        resultList4.forEach(System.out::println);

        tx.commit();
        session.close();
        sf.close();


    }
}
