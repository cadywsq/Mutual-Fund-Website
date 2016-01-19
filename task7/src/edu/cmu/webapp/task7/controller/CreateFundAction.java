package edu.cmu.webapp.task7.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.webapp.task7.databean.FundBean;
import edu.cmu.webapp.task7.model.FundDAO;

public class CreateFundAction  extends Action {
	private FormBeanFactory<CreateFundForm> formBeanFactory = FormBeanFactory
			.getInstance(CreateFundForm.class);

	private FundDAO fundDAO;

	public CreateFundAction(Model model) {
		fundDAO = model.getFundDAO();
	}

	public String getName() {
		return "createFund.do";
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
				CreateFundForm form = formBeanFactory.create(request);
				request.setAttribute("form", form);

				// If no parameters were passed in the form,
				// return createCustomer.jsp
				if (!form.isPresent()) {
					return "createFund.jsp";
				}

				// If any validation errors, return createCustomer.jsp
				errors.addAll(form.getValidationErrors());
				if (errors.size() != 0) {
					return "createFund.jsp";
				}
				try{
					Transaction.begin();
					// given name and symbol, search in DB first to find any duplicate
					// If the name/symbol username has been created before,
					// return errors
					
					/*******/
					
					
					// If everything is correct, create new fund
					// using fundDAO to create new fundbean
					FundBean newFund = new FundBean();
					newFund.setName(form.getFundName());
					newFund.setSymbol(form.getTicker());
					
					fundDAO.createAutoIncrement(newFund);
					
					// remove form attribute and show success reminder
					
					/*******/
					
					Transaction.commit();
				} finally {
					if (Transaction.isActive()) Transaction.rollback();
				}
				
				return "success.do";
			} else {
				
				// if the user is customer,
				// he/she is not allowed to create new fund
				// don't show to him/her
				if (session.getAttribute("user") != null)
					session.removeAttribute("user");
				return "login.do";
			}
		} catch (RollbackException e) {
			errors.add(e.getMessage());
			return "createFund.jsp";
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "createFund.jsp";
		}

	}
}
