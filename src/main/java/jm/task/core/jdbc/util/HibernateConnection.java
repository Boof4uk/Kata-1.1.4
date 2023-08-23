package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnection {
    private static final SessionFactory SESSION_FACTORY = HibernateConnection.initSessionFactory();

    public static SessionFactory initSessionFactory () {
        try {
            return new Configuration().configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static void shutdownSessionFactory() {
        SESSION_FACTORY.close();
    }
}
