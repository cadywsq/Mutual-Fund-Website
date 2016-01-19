package edu.cmu.webapp.task7.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.webapp.task7.databean.CustomerBean;
import edu.cmu.webapp.task7.databean.EmployeeBean;
import edu.cmu.webapp.task7.formbean.CreateCustomerForm;
import edu.cmu.webapp.task7.model.CustomerDAO;
import edu.cmu.webapp.task7.model.Model;

public class CreateCustomerAccountAction extends Action {
	private FormBeanFactory<CreateCustomerForm> formBeanFactory = FormBeanFactory
			.getInstance(CreateCustomerForm.class);

	private CustomerDAO customerDAO;

	public CreateCustomerAccountAction(Model model) {
		customerDAO = model.getCustomerDAO();
	}

	public String getName() {
		return "createCustomer.do";
	}

	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		// set errors attribute
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		try {
			// If user is employee and logged in already,
			// process and return success
			if (session.getAttribute("user") != null &&
					session.getAttribute("user") instanceof EmployeeBean) {
				// extract form from http request
				CreateCustomerForm form = formBeanFactory.create(request);
				request.setAttribute("form", form);

				// If no parameters were passed in the form,
				// return createCustomer.jsp
				if (!form.isPresent()) {
					return "createCustomer.jsp";
				}

				// If any validation errors, return createCustomer.jsp
				errors.addAll(form.getValidationErrors());
				if (errors.size() != 0) {
					return "createCustomer.jsp";
				}

				// If the username has been registed before,
				// errors.add("This username already exists")
				// and return createCustomer.jsp
				
				/*******/
				
				
				// If everything is correct, create new customer account
				// using customerDAO to create new customerBean
				CustomerBean newCustomer = new CustomerBean();
				newCustomer.setUserName(form.getUserName());
				newCustomer.setCash(0);

				customerDAO.create(newCustomer);
				
				// remove form attribute in order to prevent further errors
				request.removeAttribute("form");
				request.getSession().setAttribute("msg", "Customer account created successfully");

				return "success.do";
			} else {
				
				// if the user is customer,
				// he/she is not allowed to create new customer
				// I'm not very sure about the next page?? please correct
				
				return "login.do";
			}
		} catch (RollbackException e) {
			errors.add(e.getMessage());
			return "createCustomer.jsp";
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "createCustomer.jsp";
		}

	}
}
