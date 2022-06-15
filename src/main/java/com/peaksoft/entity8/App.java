package com.peaksoft.entity8;

import com.peaksoft.entity.Cow;
import com.peaksoft.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class App {
    public static void main(String[] args) {
        City city= new City("Akbata",8);
      //  updateCity(1,"Moscow",25);
        //create(city);
       // System.out.println(getById(1));
       // System.out.println(getAllCity());
        deleteById(1);
    }

    public static void create(City city){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(city);
        session.getTransaction().commit();
        session.close();

    }
    public static City getById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        City city=(City) session.get(City.class,id);
        session.getTransaction().commit();
        session.close();
        return city;
    }

    public static List<City> getAllCity(){
        List<City>cities;
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        cities=session.createQuery("FROM City").list();
        session.getTransaction().commit();
        session.close();
        return cities;
    }
    public static void updateCity(int id,String name,int age){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        City city =(City) session.get(City.class,id);
        city.setName(name);
        city.setAge(age);
        session.getTransaction().commit();
        session.close();

    }
    public static void deleteById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        City city =(City) session.get(City.class,id);
        session.delete(city);
        session.getTransaction().commit();
        session.close();
    }
    public static void deleteALL(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("DELETE FROM City");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
