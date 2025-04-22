package Entity.Planet;

import Entity.Client.Client;
import Entity.Hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PlanetCRUDService {
    public void create(Planet planet){
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        }
    }

    public Planet read(String id){
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            return session.find(Planet.class, id);
        }
    }

    public void update(Planet planet){
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.merge(planet);
            transaction.commit();
        }

    }

    public void delete(String id){
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Planet planet = session.find(Planet.class,id);
            if (planet != null){
                session.remove(planet);
            }
            transaction.commit();
        }
    }
}
