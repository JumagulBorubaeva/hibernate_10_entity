package com.peaksoft.entity;

import com.peaksoft.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Queue;

public class App {
    public static void main(String[] args) {

               Cow cow= new Cow("Mu-mu",2);
               //create(cow);
        //System.out.println(getAllCow());
       //System.out.println(getById(1));
        deleteById(1);

            }

        public static void create(Cow cow){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(cow);
        session.getTransaction().commit();
        session.close();

        }
       public static Cow getById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Cow cow=(Cow)session.get(Cow.class,id);
        session.getTransaction().commit();
        session.close();
        return cow;
       }

    public static List<Cow>getAllCow(){
        List<Cow>cows;
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        cows=session.createQuery("FROM Cow").list();
        session.getTransaction().commit();
        session.close();
        return cows;
    }
    public static void updateCow(int id,String name,int age){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Cow cow =(Cow)session.get(Cow.class,id);
        cow.setName(name);
        cow.setAge(age);
        session.getTransaction().commit();
        session.close();

    }
    public static void deleteById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Cow cow =(Cow) session.get(Cow.class,id);
        session.delete(cow);
        session.getTransaction().commit();
        session.close();
    }
    public static void deleteALL(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("DELETE FROM Cow");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}

