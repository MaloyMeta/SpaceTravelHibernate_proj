package entity.planet;

import entity.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PlanetDAO {
    public void create(Planet planet){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        }catch (Exception e){
            if(transaction !=null){
                transaction.rollback();
            }
            throw new RuntimeException("Error while creating planet", e);
        }
    }

    public Planet read(String id){
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            return session.find(Planet.class, id);
        } catch (Exception e){
            throw new RuntimeException("Error while reading planet", e);
        }
    }

    public void update(Planet planet){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.merge(planet);
            transaction.commit();
        } catch (Exception e){
            if(transaction !=null){
                transaction.rollback();
            }
            throw new RuntimeException("Error while updating planet", e);
        }

    }

    public void delete(String id){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getInstance().getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Planet planet = session.find(Planet.class,id);
            if (planet != null){
                session.remove(planet);
            }
            transaction.commit();
        } catch (Exception e){
            if (transaction!=null){
                transaction.rollback();
            }
            throw new RuntimeException("Error while delete planet", e);
        }
    }
}
