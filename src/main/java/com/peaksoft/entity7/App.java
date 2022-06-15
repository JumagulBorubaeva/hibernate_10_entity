package com.peaksoft.entity7;

import com.peaksoft.entity.Cow;
import com.peaksoft.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class App {
    public static void main(String[] args) {
            Country country= new Country("Bishkek",25);
            //updateCountry(1,"Kyrgyzstan",28);
            //create(country);
       // System.out.println(getById(1));
        //System.out.println(getAllCountry());
        deleteById(1);
        }

        public static void create(Country country){
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(country);
            session.getTransaction().commit();
            session.close();

        }
        public static Country getById(int id){
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Country country=(Country) session.get(Country.class,id);
            session.getTransaction().commit();
            session.close();
            return country;
        }

        public static List<Country> getAllCountry(){
            List<Country>countries;
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            countries=session.createQuery("FROM Country").list();
            session.getTransaction().commit();
            session.close();
            return countries;
        }
        public static void updateCountry(int id,String name,int age){
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Country country =(Country) session.get(Country.class,id);
            country.setName(name);
            country.setAge(age);
            session.getTransaction().commit();
            session.close();

        }
        public static void deleteById(int id){
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
             Country country =(Country) session.get(Country.class,id);
            session.delete(country);
            session.getTransaction().commit();
            session.close();
        }
        public static void deleteALL(){
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query=session.createQuery("DELETE FROM Country");
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
        }
    }

