package com.peaksoft.entity3;

import com.peaksoft.entity.Cow;
import com.peaksoft.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class App {
    public static void main(String[] args) {

       Doc doc= new Doc("Of-Of",1);
       //updateDoc(1,"Simba",3);
        //create(doc);
       // System.out.println(getById(1));
       // System.out.println(getAllDoc());
        deleteById(1);
    }

    public static void create(Doc doc){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(doc);
        session.getTransaction().commit();
        session.close();

    }
    public static Doc getById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Doc doc=(Doc)session.get(Doc.class,id);
        session.getTransaction().commit();
        session.close();
        return doc;
    }

    public static List<Doc>getAllDoc(){
        List<Doc>docs;
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        docs=session.createQuery("FROM Doc").list();
        session.getTransaction().commit();
        session.close();
        return docs;
    }
    public static void updateDoc(int id,String name,int age){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Doc doc =(Doc) session.get(Doc.class,id);
        doc.setName(name);
        doc.setAge(age);
        session.getTransaction().commit();
        session.close();

    }
    public static void deleteById(int id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Doc doc =(Doc) session.get(Doc.class,id);
        session.delete(doc);
        session.getTransaction().commit();
        session.close();
    }
    public static void deleteALL(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("DELETE FROM Doc");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
