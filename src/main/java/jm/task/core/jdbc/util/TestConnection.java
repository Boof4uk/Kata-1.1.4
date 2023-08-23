package jm.task.core.jdbc.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestConnection {
    public static void main(String[] args) {
// Cospaem obvexi| kougurypauuu Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml"); // YkaxuTe nyTb K BaweMy Qaiinly KOHOUTypauuu

// Co3paem $abpuKy ceccuil Ha OCHOBE KOHOMIypaumn
        SessionFactory sessionFactory = configuration.buildSessionFactory();

// Nonyyaem Tekywyi ceccui
        try (Session session = sessionFactory.openSession()) {

// Haunnaem TpaH3akumi
            Transaction transaction = session.beginTransaction();

            System.out.println("Coeannenne c 6a3oil AaHHbIX YCTaHOBNEHO YCMewHo.");

// 3aBepwaem TpaHsakuuo
                    transaction.commit();

        } catch (Exception e) {

            System.err.println("0uwubka npn YCTaHOBNEHUM COefMHeHUs C 63300 faHHbIX: " + e.getMessage());
        } finally {

// 3axphiBaemM ®aGpuKy ceccuii mocne MCnoNb3oBaHus

            sessionFactory.close();
        }
    }
}