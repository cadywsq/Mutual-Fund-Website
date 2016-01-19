package edu.cmu.webapp.task7.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybeans.form.FormBeanFactory;

import edu.cmu.webapp.task7.databean.EmployeeBean;
import edu.cmu.webapp.task7.formbean.LoginFormBean;
import edu.cmu.webapp.task7.model.AbstractDAOFactory;
import edu.cmu.webapp.task7.model.CustomerDAO;
import edu.cmu.webapp.task7.model.EmployeeDAO;

public class LoginAction extends Action {
	private FormBeanFactory<LoginFormBean> formBeanFactory =
			FormBeanFactory.getInstance(LoginFormBean.class);
	
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
		HttpSession session = request.getSession();
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		System.out.println("1");
		if (session.getAttribute("user") != null) {
			if (session.getAttribute("user") instanceof EmployeeBean) {
				return "";
			} else {
				return "";
			}
		}
		System.out.println("2");
		try {
			LoginFormBean form = formBeanFactory.create(request);
			request.setAttribute("form", form);
			if (!form.isPresent()) {
				return "login.jsp";
			}
			
			errors.addAll(form.getValidationErrors());
			if (errors.size() > 0) {
				return "login.jsp";
			}
			
			if (form.isEmployee()) {
			    // need to modify here.
			    return "employeeMain.jsp";
			} else {
			    return "viewMyAccount.jsp";
			}
		} catch(Exception e) {
		    return "login.jsp";
		}
	}
	
}
