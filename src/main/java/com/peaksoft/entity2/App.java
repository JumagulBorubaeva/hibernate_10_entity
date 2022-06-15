package com.peaksoft.entity2;

import com.peaksoft.entity.Cow;
import com.peaksoft.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Mouse mouse= new Mouse("Bu-bu",3);
        //updateMouse(2,"MiMi",4);
        //create(mouse);
        //System.out.println(getById(1));
        //System.out.println(getAllMouse());
        deleteById(1);
    }

    public static void create(Mouse mouse){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(mouse);
        session.getTransaction().commit();
        session.close();

    }
    public static Mouse getById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Mouse mouse=(Mouse) session.get(Mouse.class,id);
        session.getTransaction().commit();
        session.close();
        return mouse;
    }

    public static List<Mouse> getAllMouse(){
        List<Mouse>mouse;
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        mouse=session.createQuery("FROM Mouse").list();
        session.getTransaction().commit();
        session.close();
        return mouse ;
    }
    public static void updateMouse(int id,String name,int age){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Mouse mouse =(Mouse) session.get(Mouse.class,id);
        mouse.setName(name);
        mouse.setAge(age);
        session.getTransaction().commit();
        session.close();

    }
    public static void deleteById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Mouse mouse =(Mouse) session.get(Mouse.class,id);
        session.delete(mouse);
        session.getTransaction().commit();
        session.close();
    }
    public static void deleteALL(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("DELETE FROM Mouse");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}

