package edu.cmu.webapp.task7.model;

public abstract class AbstractDAOFactory {
    public abstract CustomerDAO getCustomerDAO();
    public abstract EmployeeDAO getEmployeeDAO();
    public abstract FundDAO getFundDAO();
    public static AbstractDAOFactory getDAOFactory() {
        return new DAOFactory();
    }
}
