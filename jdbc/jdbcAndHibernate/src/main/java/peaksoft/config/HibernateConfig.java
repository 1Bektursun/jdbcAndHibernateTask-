package peaksoft.config;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import peaksoft.model.User;

import java.util.Properties;

public class HibernateConfig {
    public static SessionFactory getSession(){
        SessionFactory sessionFactory =  null;
        try{
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            System.out.println("Connected... ");

        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return sessionFactory;
    }
}
