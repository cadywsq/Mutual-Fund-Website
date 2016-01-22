package edu.cmu.webapp.task7.model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.cmu.webapp.task7.databean.PositionBean;

public class PositionDAO {
    private SessionFactory sessionFactory;
    public PositionDAO() {
        try {
            this.sessionFactory = DAOFactory.CreateSessionFactory();
        } catch (Exception e) {
            System.out.println("cannot get session factory.");
            e.printStackTrace();
        }
    }
    public void createPosition(PositionBean position) {
        if (position == null) {
            return;
        }
        Session session = this.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(position);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("cannot create a new position into database.");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void updatePosition(PositionBean position) {
        if (position == null) {
            return;
        }
        Session session = this.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(position);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("cannot update the position into database.");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public PositionBean getPosition(int customerId, int fundId) {
        return null;
    }
    public List<PositionBean> getPositionsByCustomerId(int customerId) {
        return null;
    }
    public List<PositionBean> getPositionsByFundId(int fundId) {
        return null;
    }
    public void deletePosition(PositionBean position) {
        if (position == null) {
            return;
        }
        Session session = this.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(position);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("cannot delete position.");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void deletePositionsByCustomerId(int customerId) {
        
    }
    public void deletePositionsByFundId(int fundId) {
        
    }
}
