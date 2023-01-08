package com.Hb1.Annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFatch01 {
    public static void main(String[] args) {

        Configuration conf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
        SessionFactory sf= conf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction txf=session.beginTransaction();
// Db den bir datayi fetch lemek icin 3 yol var
        //1. get metodu
        //Sql ile
        //Hql ile
//        Student01 student1= session.get(Student01.class,1001);
//        Student01 student2= session.get(Student01.class,1002);
//        Student01 student3= session.get(Student01.class,1003);
//        System.out.println(student1);
//        System.out.println(student2);
//        System.out.println(student3);
        //2.yol
//String sqlkode="select * from t_student01";
//List<Object[]> list=session.createSQLQuery(sqlkode).getResultList();
//for (Object[] object:list ){
//    System.out.println(Arrays.toString(object));
//}
//HQl
//hql sorgusunda from dan sonra sinif ismi kullanilmali
//   String hql="from Student01";
//List<Student01> mylist=session.createQuery(hql,Student01.class).getResultList();
//for(Student01 student:mylist){
//    System.out.println(student);
//}

        //eger biliyorsak ki tek data gelecek, uniqueREsult() metodu kullanilabilir

//        String sql="select * from t_student01 where student_name='Fatih'";
//Object[] objext1=(Object[]) session.createSQLQuery(sql).uniqueResult();
//        System.out.println(Arrays.toString(objext1));

//        String hql="from Student01 where name='Fatih'";
//Student01 objekt=session.createQuery(hql, Student01.class).uniqueResult();
//        System.out.println(objekt);
//yukardaki sorguyu Hql ile Alies kullanarak  yapini

//        String hql="from Student01 std where std.name='Fatih'";
//Student01 student01=session.createQuery(hql, Student01.class).uniqueResult();
//        System.out.println(student01);

//        // grade değeri 90 olan öğrenciyi getirelim
//        String hqlQuery4 = "SELECT s.id,s.name FROM Student01 s WHERE s.grade=90"; // Student01 s
//        List<Object[]> resultList4 = session.createQuery(hqlQuery4).getResultList();
//        // createQuery metoduna tek parametre girdiğimiz için Student01 clası ile mappleme işlemi yapılmadı
//        // bu yüzden Object olarak aldık
//        for (Object[] object: resultList4) {
//            System.out.println(Arrays.toString(object));
//        }
        //tek cozum olursa
        String hqlQuery5 = "SELECT s.id,s.name FROM Student01 s WHERE s.grade=90";
        Object[] resultList5 = (Object[]) session.createQuery(hqlQuery5).uniqueResult();
        System.out.println(Arrays.toString(resultList5));


        txf.commit();
        session.close();
        sf.close();
    }

}
