package com.peaksoft.entity4;

import com.peaksoft.entity.Cow;
import com.peaksoft.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Goose goose = new Goose("Gaf-gaf",4);
       // updateGoose(1,"Gari",5);
       // create(goose);
       // System.out.println(getById(1));
        //System.out.println(getAllGoose());
        deleteById(1);
    }

    public static void create(Goose goose){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(goose);
        session.getTransaction().commit();
        session.close();

    }
    public static Goose getById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Goose goose=(Goose) session.get(Goose.class,id);
        session.getTransaction().commit();
        session.close();
        return goose;
    }

    public static List<Goose> getAllGoose(){
        List<Goose>gooses;
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        gooses=session.createQuery("FROM Goose").list();
        session.getTransaction().commit();
        session.close();
        return gooses;
    }
    public static void updateGoose(int id,String name,int age){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Goose goose =(Goose) session.get(Goose.class,id);
        goose.setName(name);
        goose.setAge(age);
        session.getTransaction().commit();
        session.close();

    }
    public static void deleteById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Goose goose =(Goose) session.get(Goose.class,id);
        session.delete(goose);
        session.getTransaction().commit();
        session.close();
    }
    public static void deleteALL(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("DELETE FROM Goose");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}


