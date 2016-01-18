package edu.cmu.webapp.task7.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybeans.form.FormBeanFactory;

import edu.cmu.webapp.task7.databean.EmployeeBean;
import edu.cmu.webapp.task7.formbean.LoginForm;
import edu.cmu.webapp.task7.model.Model;

public class LoginAction extends Action {
	private FormBeanFactory<LoginForm> formBeanFactory =
			FormBeanFactory.getInstance(LoginForm.class);
	
	private EmployeeDAO employeeDAO;
	private CustomerDAO customerDAO;

	public LoginAction(Model model) {
		customerDAO = model.getCustomerDAO();
		employeeDAO = model.getEmployeeDAO();
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
		
		if (session.getAttribute("user") != null) {
			if (session.getAttribute("user") instanceof EmployeeBean) {
				return "";
			} else {
				return "";
			}
		}
		
		try {
			LoginForm form = formBeanFactory.create(request);
			request.setAttribute("form", form);
			if (!form.isPresent()) {
				return "login.jsp";
			}
			
			errors.addAll(form.getValidationErrors());
			if (errors.size() > 0) {
				return "login.jsp";
			}
			
			if (form.isEmployee())
			request.setAttribute("user", null);
			
		}
		return ;
	}
	
}
