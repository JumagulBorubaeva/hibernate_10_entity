package com.peaksoft.entity6;

import com.peaksoft.entity.Cow;
import com.peaksoft.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Farm farm= new Farm("Akyl",2);
        //System.out.println(getById(1));
        //updateFarm(1,"Salman",18);
       // create(farm);
        //System.out.println(getAllFarm());
        deleteById(1);
    }

    public static void create(Farm farm){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(farm);
        session.getTransaction().commit();
        session.close();

    }
    public static Farm getById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Farm farm=(Farm) session.get(Farm.class,id);
        session.getTransaction().commit();
        session.close();
        return farm;
    }

    public static List<Farm> getAllFarm(){
        List<Farm>farms;
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        farms=session.createQuery("FROM Farm").list();
        session.getTransaction().commit();
        session.close();
        return farms;
    }
    public static void updateFarm(int id,String name,int age){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Farm farm=(Farm) session.get(Farm.class,id);
        farm.setName(name);
        farm.setAge(age);
        session.getTransaction().commit();
        session.close();

    }
    public static void deleteById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Farm farm =(Farm) session.get(Farm.class,id);
        session.delete(farm);
        session.getTransaction().commit();
        session.close();
    }
    public static void deleteALL(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("DELETE FROM Farm");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
