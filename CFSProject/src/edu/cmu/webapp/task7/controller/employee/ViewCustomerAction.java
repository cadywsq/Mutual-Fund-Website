package edu.cmu.webapp.task7.controller.employee;

import edu.cmu.webapp.task7.controller.Action;
import edu.cmu.webapp.task7.databean.CustomerBean;
import edu.cmu.webapp.task7.databean.EmployeeBean;
import edu.cmu.webapp.task7.formbean.ViewCustomerFormBean;
import edu.cmu.webapp.task7.model.AbstractDAOFactory;
import edu.cmu.webapp.task7.model.CustomerDAO;
import edu.cmu.webapp.task7.model.TransactionDAO;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Siqi Wang siqiw1 on 1/20/16.
 */
public class ViewCustomerAction extends Action {
    private FormBeanFactory<ViewCustomerFormBean> formBeanFactory = FormBeanFactory.getInstance(ViewCustomerFormBean.class);
    private CustomerDAO customerDAO;
    private TransactionDAO transactionDAO;

    public ViewCustomerAction(AbstractDAOFactory dao) {
        customerDAO = dao.getCustomerDAO();
        transactionDAO = dao.getTransactionDAO();
    }

    @Override
    public String getName() {
        return "viewCustomer.do";
    }

    @Override
    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);
        HttpSession employeeSession = request.getSession();
        try {
            ViewCustomerFormBean form = formBeanFactory.create(request);
            request.setAttribute("form", form);
            EmployeeBean employee = (EmployeeBean) employeeSession.getAttribute("user");
            //Check employee login.
            if (employee == null) {
                return "login.jsp";
            }

            if (!form.isPresent()) {
                return "selectCustomerAccount.jsp";
            }

            if (form.getAction().equals("Get Customer Details")) {
                errors.addAll(form.getValidationErrors());
                //check form input.
                if (errors.size() > 0) {
                    return "selectCustomerAccount.jsp";
                }
                CustomerBean customer = customerDAO.getCustomerByUserName(form.getUserName());
                //check customer existence.
                if (customer == null) {
                    errors.add("The customer doesn't exist");
                    return "selectCustomerAccount.jsp";
                }
                //print out viewMyAccount.
                HttpSession customerSession = request.getSession();
                customerSession.setAttribute("customer", customer);
                customerSession.setAttribute("fund",transactionDAO.findTransactionsByCustomerId(customer.getCustomerId()));
                return "viewCustomerAccount.jsp";
            }
        } catch (FormBeanException e) {
            return "selectCustomerAccount.jsp";
        }
        return "selectCustomerAccount.jsp";
    }
}
