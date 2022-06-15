package com.peaksoft.entity5;

import com.peaksoft.entity.Cow;
import com.peaksoft.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class App {
    public static void main(String[] args) {

    Horse horse= new Horse("Takay",2);
    //updateHorse(1,"Gulsary",3);
        //create(horse);
       // System.out.println(getById(1));
       // System.out.println(getAllHorse());
        deleteById(1);
    }

    public static void create(Horse horse){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(horse);
        session.getTransaction().commit();
        session.close();

    }
    public static Horse getById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Horse horse=(Horse) session.get(Horse.class,id);
        session.getTransaction().commit();
        session.close();
        return horse;
    }

    public static List<Horse> getAllHorse(){
        List<Horse>horses;
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        horses=session.createQuery("FROM Horse").list();
        session.getTransaction().commit();
        session.close();
        return horses;
    }
    public static void updateHorse(int id,String name,int age){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Horse horse=(Horse) session.get(Horse.class,id);
        horse.setName(name);
        horse.setAge(age);
        session.getTransaction().commit();
        session.close();

    }
    public static void deleteById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Horse horse =(Horse) session.get(Horse.class,id);
        session.delete(horse);
        session.getTransaction().commit();
        session.close();
    }
    public static void deleteALL(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("DELETE FROM Horse");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}

