package edu.cmu.webapp.task7.model;

import edu.cmu.webapp.task7.databean.EmployeeBean;

public class ModelTest {
    public static void main(String[] args) {
        System.out.println("this is a test of model.");
        EmployeeDAO employeeDAO = AbstractDAOFactory.getDAOFactory().getEmployeeDAO();
        EmployeeBean employee = new EmployeeBean();
        employee.setFirstName("Steve");
        employee.setLastName("Jobs");
        employee.setPassword("test");
        employee.setUserName("stevej");
        employeeDAO.create(employee);
    }
}
