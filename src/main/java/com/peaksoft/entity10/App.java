package com.peaksoft.entity10;

import com.peaksoft.entity.Cow;
import com.peaksoft.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Car car= new Car("Step",6);
       // updateCar(1,"Fit",5);
        //create(car);
       // System.out.println(getById(1));
        //System.out.println(getAllCar());
        deleteById(1);


    }

    public static void create(Car car){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(car);
        session.getTransaction().commit();
        session.close();

    }
    public static Car getById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Car car=(Car)session.get(Car.class,id);
        session.getTransaction().commit();
        session.close();
        return car;
    }

    public static List<Car> getAllCar(){
        List<Car>cars;
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        cars=session.createQuery("FROM Car").list();
        session.getTransaction().commit();
        session.close();
        return cars;
    }
    public static void updateCar(int id,String name,int age){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Car car =(Car) session.get(Car.class,id);
        car.setName(name);
        car.setAge(age);
        session.getTransaction().commit();
        session.close();

    }
    public static void deleteById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Car car =(Car) session.get(Car.class,id);
        session.delete(car);
        session.getTransaction().commit();
        session.close();
    }
    public static void deleteALL(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("DELETE FROM Car");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}



