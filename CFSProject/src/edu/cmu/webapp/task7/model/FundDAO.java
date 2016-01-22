package edu.cmu.webapp.task7.model;

import edu.cmu.webapp.task7.databean.FundBean;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FundDAO {
    private SessionFactory sessionFactory;

    public FundDAO() {
        try {
            this.sessionFactory = DAOFactory.CreateSessionFactory();
        } catch (Exception e) {
            System.out.println("cannot get session factory.");
            e.printStackTrace();
        }
    }

    public void createFund(FundBean fund) {
        if (fund == null) {
            return;
        }
        Session session = this.sessionFactory.openSession();
        try {
            session.beginTransaction();
            fund.setSymbol(fund.getSymbol().toUpperCase());
            session.save(fund);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("cannot create a new fund into database.");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateFund(FundBean fund) {
        if (fund == null) {
            return;
        }
        Session session = this.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(fund);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println("cannot update the fund into database.");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public FundBean getFundByName(String name) {
        Session session = this.sessionFactory.openSession();
        try {
            session.beginTransaction();
            FundBean fund = (FundBean) session.get(FundBean.class, name);
            session.getTransaction().commit();
            return fund;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("cannot get fund by fund name.");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public FundBean getFundBySymbol(String symbol) {
        if (symbol == null) {
            return null;
        }
        Session session = this.sessionFactory.openSession();
        try {
            session.beginTransaction();
            symbol = symbol.toUpperCase();
            FundBean fund = (FundBean) session.get(FundBean.class, symbol);
            session.getTransaction().commit();
            return fund;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("cannot get fund by fund symbol.");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public FundBean getFundById(int fundId) {
        Session session = this.sessionFactory.openSession();
        try {
            session.beginTransaction();
            FundBean fund = (FundBean) session.get(FundBean.class, fundId);
            session.getTransaction().commit();
            return fund;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("cannot get fund by fund id.");
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public void deleteFund(FundBean fund) {
        if (fund == null) {
            return;
        }
        Session session = this.sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(fund);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("cannot delete fund.");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
