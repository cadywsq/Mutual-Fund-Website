package edu.cmu.webapp.task7.controller;

import edu.cmu.webapp.task7.databean.CustomerBean;
import edu.cmu.webapp.task7.databean.EmployeeBean;
import edu.cmu.webapp.task7.formbean.LoginFormBean;
import edu.cmu.webapp.task7.model.AbstractDAOFactory;
import edu.cmu.webapp.task7.model.CustomerDAO;
import edu.cmu.webapp.task7.model.EmployeeDAO;
import org.mybeans.form.FormBeanFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class LoginAction extends Action {
    private FormBeanFactory<LoginFormBean> formBeanFactory = FormBeanFactory.getInstance(LoginFormBean.class);
    private EmployeeDAO employeeDAO;
    private CustomerDAO customerDAO;

    public LoginAction(AbstractDAOFactory dao) {
        customerDAO = dao.getCustomerDAO();
        employeeDAO = dao.getEmployeeDAO();
    }

    @Override
    public String getName() {
        return "login.do";
    }

    @Override
    public String perform(HttpServletRequest request) {
        System.out.println("LoginAction: inside perform");
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);
        try {
            LoginFormBean form = formBeanFactory.create(request);
            System.out.println("form: " + form.getUserName());
            System.out.println("form: " + form.getPassword());
            System.out.println("request: " + request.getParameter("userName"));
            System.out.println("request: " + request.getParameter("password"));
            request.setAttribute("form", form);
            if (!form.isPresent()) {
                System.out.println("LoginAction: is not present");
                return "login.jsp";
            }
            errors.addAll(form.getValidationErrors());
            if (errors.size() > 0) {
                System.out.println("LoginAction: has error");
                return "login.jsp";
            }
            if (form.getAction().equals("Customer Login")) {
                System.out.println("LoginAction: action is customer login");
                CustomerBean customer = customerDAO.getCustomerByUserName(form.getUserName());
                if (customer != null && customer.getPassword().equals(form.getPassword())) {
                    System.out.println("LoginAction: customer logged in");
                    HttpSession session = request.getSession();
                    session.setAttribute("user", customer);
                    return "viewMyAccount.jsp";
                } else {
                    System.out.println("LoginAction: wrong input");
                    errors.add("Wrong email or password");
                    return "login.jsp";
                }
            } else if (form.getAction().equals("Employee Login")) {
                System.out.println("LoginAction: action is employee login");
                EmployeeBean employee = employeeDAO.getEmployeeByUserName(form.getUserName());
                if (employee != null && employee.getPassword().equals(form.getPassword())) {
                    System.out.println("LoginAction: employee logged in");
                    HttpSession session = request.getSession();
                    session.setAttribute("user", employee);
                    return "employeeMain.jsp";
                } else {
                    System.out.println("LoginAction: wrong input");
                    errors.add("Wrong email or password");
                    return "login.jsp";
                }
            }
            return "login.jsp";
        } catch (Exception e) {
            return "login.jsp";
        }
    }
}
