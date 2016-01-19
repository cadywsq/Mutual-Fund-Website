package edu.cmu.webapp.task7.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.webapp.task7.databean.CustomerBean;
import edu.cmu.webapp.task7.databean.EmployeeBean;
import edu.cmu.webapp.task7.model.CustomerDAO;
import edu.cmu.webapp.task7.model.EmployeeDAO;
import edu.cmu.webapp.task7.model.Model;

public class ChangePwdAction extends Action {
	private FormBeanFactory<ChangePwdForm> formBeanFactory = FormBeanFactory
			.getInstance(ChangePwdForm.class);
	private CustomerDAO customerDAO;
	private EmployeeDAO employeeDAO;

	public ChangePwdAction(Model model) {
		customerDAO = model.getCustomerDAO();
		employeeDAO = model.getEmployeeDAO();
	}

	public String getName() {
		return "changePwd.do";
	}

	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		
		try {
			if (request.getSession().getAttribute("user") == null) {
				return "login.do";
			}
			
			// If user is customer and logged in already,
			// process and return success
			if (request.getSession().getAttribute("user") instanceof CustomerBean) {
				// get user attribute from session
				CustomerBean user = (CustomerBean) request.getSession().getAttribute("user");

				// extract change pwd form bean from request
				ChangePwdForm form = formBeanFactory.create(request);
				request.setAttribute("form", form);

				// if no parameters were passed in the form,
				// return customerchangepwd jsp (please confirm)
				if (!form.isPresent()) {
					return "";
				}

				// If any validation errors,
				// return customerchangepwd jsp (please confirm)
				errors.addAll(form.getValidationErrors());
				if (errors.size() > 0) {
					return "";
				}
				
				// the user need to input the origin pwd
				// if it doesn't match the one in the DB,
				// show errors and return customerchangepwd jsp (please confirm)
				
				/*******/
				
				// otherwise, the password is correct and revise to new pwd
				user.setPassword(form.getNewPwd());
				customerDAO.update(user);
				
				request.removeAttribute("form");
				request.setAttribute("msg", "Password was changed successfully.");
				
				// which page should we return back to ?
				/*******/
				
				return "";
				
			} else if (request.getSession().getAttribute("user") instanceof EmployeeBean) {
				// get user attribute from session
				EmployeeBean user = (EmployeeBean) request.getSession().getAttribute("user");
				
				// extract change pwd form bean from request
				ChangePwdForm form = formBeanFactory.create(request);
				request.setAttribute("form", form);

				// if no parameters were passed in the form,
				// return employeechangepwd jsp (please confirm)
				if (!form.isPresent()) {
					return "employeePSW.jsp";
				}

				
				errors.addAll(form.getValidationErrors());
				if (errors.size() > 0) {
					return "employeePSW.jsp";
				}
				
				if (!form.getCurrPwd().equals(employeeDAO.read(user.getUserName()).getPassword())) {
					errors.add("Incorrect original password");
				}
				
				if (errors.size() > 0) {
					return "employeePSW.jsp";
				}

				user.setPassword(form.getNewPwd());
				employeeDAO.update(user);
				
				request.getSession().setAttribute("msg", "Password was changed successfully.");

				if (errors.size() > 0) 
					return "employeePSW.jsp";	
				
				return "success.do";
			}
			else {
				if (request.getSession().getAttribute("user") != null)
					request.getSession().removeAttribute("user");

				return "login.do";
			}

        } catch (RollbackException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        } catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        }

	}
}
