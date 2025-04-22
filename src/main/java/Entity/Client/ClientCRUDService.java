package Entity.Client;

import Entity.Hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ClientCRUDService {
    public void create(Client client){
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        }
    }

    public Client read(Long id){
    try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
        return session.find(Client.class, id);
    }
    }

    public void update(Client client){
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.merge(client);
            transaction.commit();
        }

    }

    public void delete(Long id){
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Client client = session.find(Client.class,id);
            if (client != null){
                session.remove(client);
            }
            transaction.commit();
        }
    }
}
