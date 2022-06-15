package com.peaksoft.entity9;

import com.peaksoft.entity.Cow;
import com.peaksoft.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Person person = new Person("Kyial", 12);
       // updatePerson(1,"Suli",11);
        //create(person);
        //System.out.println(getById(1));
        //System.out.println(getAllPerson());
        deleteById(1);
    }

    public static void create(Person person) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();

    }

    public static Person getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Person person  = (Person) session.get(Person.class, id);
        session.getTransaction().commit();
        session.close();
        return person;
    }

    public static List<Person> getAllPerson() {
        List<Person> persons;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        persons = session.createQuery("FROM Person").list();
        session.getTransaction().commit();
        session.close();
        return persons;
    }

    public static void updatePerson(int id, String name, int age) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Person person = (Person) session.get(Person.class, id);
        person.setName(name);
        person.setAge(age);
        session.getTransaction().commit();
        session.close();

    }

    public static void deleteById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Person person = (Person) session.get(Person.class, id);
        session.delete(person);
        session.getTransaction().commit();
        session.close();
    }

    public static void deleteALL() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM Person");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}