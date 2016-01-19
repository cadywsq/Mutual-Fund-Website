package edu.cmu.webapp.task7.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.webapp.task7.databean.EmployeeBean;
import edu.cmu.webapp.task7.model.CustomerDAO;
import edu.cmu.webapp.task7.model.EmployeeDAO;

public class CreateEmployeeAccountAction extends Action {
	private FormBeanFactory<CreateEmployeeForm> formBeanFactory = FormBeanFactory
			.getInstance(CreateEmployeeForm.class);

	private EmployeeDAO employeeDAO;

	public CreateEmployeeAccountAction(Model model) {
		employeeDAO = model.getEmployeeDAO();
	}

	public String getName() {
		return "createEmployee.do";
	}

	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();

		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		try {
			// If user is employee and logged in already,
			// process and return success
			if (session.getAttribute("user") != null &&
					session.getAttribute("user") instanceof EmployeeBean) {
				CreateEmployeeForm form = formBeanFactory.create(request);
				request.setAttribute("form", form);

				// If no parameters were passed in the form,
				// return createCustomer.jsp
				if (!form.isPresent()) {
					return "createEmployee.jsp";
				}

				// If any validation errors, return createCustomer.jsp
				errors.addAll(form.getValidationErrors());
				if (errors.size() != 0) {
					return "createEmployee.jsp";
				}

				// If the employee username has been registed before,
				// errors.add("This employee username has already exists")
				// and return createEmployee.jsp
				
				/*******/
				
				
				// If everything is correct, create new employee account
				// using employeeDAO to create new employeeBean
				EmployeeBean newEmployee = new EmployeeBean();
				newEmployee.setUserName(form.getUserName());
				
				employeeDAO.create(newEmployee);
				
				// remove form attribute in order to prevent further errors
				request.removeAttribute("form");
				request.getSession().setAttribute("msg", "Employee account " +form.getUserName()+ " was created successfully.");
				
				
				return "success.do";
			} else {
				
				// if the user is customer,
				// he/she is not allowed to create new customer
				// I'm not very sure about the next page?? please correct
				
				return "login.do";
			}
		} catch (RollbackException e) {
			errors.add(e.getMessage());
			return "createEmployee.jsp";
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "createEmployee.jsp";
		}

	}
}
