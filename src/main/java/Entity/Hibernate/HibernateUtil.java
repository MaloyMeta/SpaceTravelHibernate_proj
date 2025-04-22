package Entity.Hibernate;
import Entity.Client.Client;
import Entity.Planet.Planet;
import Entity.Ticket.Ticket;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.text.html.parser.Entity;

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
