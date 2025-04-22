package Entity.Ticket;

import Entity.Hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TicketCRUDService {
    public void create(Ticket ticket){
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
        }
    }

    public Ticket read(Long id){
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            return session.find(Ticket.class, id);
        }
    }

    public void update(Ticket ticket){
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.merge(ticket);
            transaction.commit();
        }
    }

    public void delete(Long id){
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Ticket ticket = session.find(Ticket.class,id);
            if(ticket !=null){
                session.remove(ticket);
            }
        }
    }
}
