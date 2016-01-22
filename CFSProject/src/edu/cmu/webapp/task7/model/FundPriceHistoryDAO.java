package edu.cmu.webapp.task7.model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.cmu.webapp.task7.databean.FundPriceHistoryBean;
import edu.cmu.webapp.task7.databean.TransactionBean;

public class FundPriceHistoryDAO {
    private SessionFactory sessionFactory;
    public FundPriceHistoryDAO() {
        try {
            this.sessionFactory = DAOFactory.CreateSessionFactory();
        } catch (Exception e) {
            System.out.println("cannot get session factory.");
            e.printStackTrace();
        }
    }
    public void createFundPriceHistory(FundPriceHistoryBean fundPriceHistory) {
        if (fundPriceHistory == null) {
            return;
        }
        Session session = this.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(fundPriceHistory);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("cannot create a new fundPriceHistory into database.");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void updateFundPriceHistory(FundPriceHistoryBean fundPriceHistory) {
        if (fundPriceHistory == null) {
            return;
        }
        Session session = this.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(fundPriceHistory);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("cannot update the fundPriceHistory into database.");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void deleteFundPriceHistory(FundPriceHistoryBean fundPriceHistory) {
        if (fundPriceHistory == null) {
            return;
        }
        Session session = this.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(fundPriceHistory);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("cannot delete fundPriceHistory.");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public List<TransactionBean> findFundPriceHistoryByFundId(int fundId) {
        return null;
    }
    public List<TransactionBean> findFundPriceHistoryByPriceDate(String priceDate) {
        return null;
    }
    public void deleteFundPriceHistoryByFundId(int fundId) {
        
    }
    public void deleteFundPriceHistoryByPriceDate(String priceDate) {
        
    }
}
