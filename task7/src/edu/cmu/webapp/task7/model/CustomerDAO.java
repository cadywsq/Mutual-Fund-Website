package edu.cmu.webapp.task7.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.cmu.webapp.task7.databean.CustomerBean;

public class CustomerDAO {
    private SessionFactory sessionFactory;
    public CustomerDAO() {
        this.sessionFactory = DAOFactory.CreateSessionFactory();
    }
    public void createEmployee(CustomerBean customer) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
        this.sessionFactory.close();
    }
    public void update(CustomerBean customer) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.beginTransaction();
        session.update(customer);
        session.getTransaction().commit();
        session.close();
        this.sessionFactory.close();
    }
    public void create(CustomerBean customer) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
        this.sessionFactory.close();
    }
    public CustomerBean read(String userName) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        CustomerBean customer = (CustomerBean) session.get(CustomerBean.class, userName);
        session.getTransaction().commit();
        session.close();
        this.sessionFactory.close();
        return customer;
    }
}
