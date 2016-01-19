package edu.cmu.webapp.task7.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.cmu.webapp.task7.databean.FundBean;

public class FundDAO {
    private SessionFactory sessionFactory;
    public FundDAO() {
        this.sessionFactory = DAOFactory.CreateSessionFactory();
    }
    public void createFund(FundBean fund) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.beginTransaction();
        session.save(fund);
        session.getTransaction().commit();
        session.close();
        this.sessionFactory.close();
    }
    public void createAutoIncrement(FundBean newFund) {
        // TODO Auto-generated method stub
        
    }
}
