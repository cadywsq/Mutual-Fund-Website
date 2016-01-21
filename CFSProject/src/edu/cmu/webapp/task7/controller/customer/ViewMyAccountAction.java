package edu.cmu.webapp.task7.controller.customer;

import edu.cmu.webapp.task7.controller.Action;
import edu.cmu.webapp.task7.formbean.ViewCustomerFormBean;
import edu.cmu.webapp.task7.model.AbstractDAOFactory;
import edu.cmu.webapp.task7.model.CustomerDAO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Siqi Wang siqiw1 on 1/20/16.
 */
public class ViewMyAccountAction extends Action {
    private CustomerDAO customerDAO;

    public ViewMyAccountAction(AbstractDAOFactory dao) {
        customerDAO = dao.getCustomerDAO();
    }

    @Override
    public String getName() {
        return "viewMyAccount.do";
    }

    @Override
    public String perform(HttpServletRequest request) {

        return null;
    }
}
