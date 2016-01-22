package edu.cmu.webapp.task7.controller.customer;

import edu.cmu.webapp.task7.controller.Action;
import edu.cmu.webapp.task7.databean.CustomerBean;
import edu.cmu.webapp.task7.model.AbstractDAOFactory;
import edu.cmu.webapp.task7.model.CustomerDAO;
import edu.cmu.webapp.task7.model.TransactionDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Siqi Wang siqiw1 on 1/20/16.
 */
public class ViewMyAccountAction extends Action {
    private CustomerDAO customerDAO;
    private TransactionDAO transactionDAO;

    public ViewMyAccountAction(AbstractDAOFactory dao) {
        customerDAO = dao.getCustomerDAO();
        transactionDAO = dao.getTransactionDAO();
    }

    @Override
    public String getName() {
        return "viewMyAccount.do";
    }

    @Override
    public String perform(HttpServletRequest request) {

        HttpSession customerSession = request.getSession();
        CustomerBean customer = (CustomerBean) customerSession.getAttribute("user");

        if (customer == null) {
            return "login.jsp";
        }
        customerSession.setAttribute("customer", customer);
        customerSession.setAttribute("fund", transactionDAO.findTransactionsByCustomerId(customer.getCustomerId()));

        return "viewMyAccount.jsp";
    }
}
