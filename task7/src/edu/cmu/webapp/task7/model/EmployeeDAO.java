package edu.cmu.webapp.task7.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.cmu.webapp.task7.databean.CustomerBean;
import edu.cmu.webapp.task7.databean.EmployeeBean;

public class EmployeeDAO {
    private SessionFactory sessionFactory;
    public EmployeeDAO() {
        this.sessionFactory = DAOFactory.CreateSessionFactory();
    }
    public void createEmployee(EmployeeBean employee) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(employee);
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
    public void update(EmployeeBean employee) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.update(employee);
        session.getTransaction().commit();
        session.close();
        this.sessionFactory.close();
    }
    public void create(EmployeeBean employee) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
        this.sessionFactory.close();
    }
}
