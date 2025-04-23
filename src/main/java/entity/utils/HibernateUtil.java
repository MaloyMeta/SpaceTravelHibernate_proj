package entity.utils;
import entity.client.Client;
import entity.planet.Planet;
import entity.ticket.Ticket;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final HibernateUtil INSTANCE;

    @Getter
    private SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtil();
    }

    private HibernateUtil(){
        Configuration configuration = new Configuration();

        configuration.addAnnotatedClass(Client.class);
        configuration.addAnnotatedClass(Planet.class);
        configuration.addAnnotatedClass(Ticket.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static HibernateUtil getInstance(){
        return INSTANCE;
    }

    public void close(){
        sessionFactory.close();
    }
}
