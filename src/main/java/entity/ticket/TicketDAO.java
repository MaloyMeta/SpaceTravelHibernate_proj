package entity.ticket;

import entity.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TicketDAO {
    Transaction transaction = null;

    public void create(Ticket ticket){
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
        } catch (Exception e){
            if(transaction !=null){
                transaction.rollback();
            }
            throw new RuntimeException("Error while creating ticket", e);
        }
    }

    public Ticket read(Long id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.find(Ticket.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error while reading ticket", e);
        }
    }

    public void update(Ticket ticket){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.merge(ticket);
            transaction.commit();
        } catch (Exception e){
            if(transaction !=null){
                transaction.rollback();
            }
            throw new RuntimeException("Error while updating ticket", e);
        }
    }

    public void delete(Long id){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Ticket ticket = session.find(Ticket.class,id);
            if(ticket !=null){
                session.remove(ticket);
            }
        }catch (Exception e){
            if(transaction !=null){
                transaction.rollback();
            }
            throw new RuntimeException("Error while delete ticket", e);
        }
    }
}
