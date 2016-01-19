package edu.cmu.webapp.task7.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DAOFactory extends AbstractDAOFactory {
    public static SessionFactory CreateSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
    @Override
    public CustomerDAO getCustomerDAO() {
        return new CustomerDAO();
    }
    @Override
    public EmployeeDAO getEmployeeDAO() {
        return new EmployeeDAO();
    }
    @Override
    public FundDAO getFundDAO() {
        return new FundDAO();
    }
}
