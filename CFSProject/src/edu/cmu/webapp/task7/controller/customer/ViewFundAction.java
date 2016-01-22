package edu.cmu.webapp.task7.controller.customer;

import edu.cmu.webapp.task7.controller.Action;
import edu.cmu.webapp.task7.model.AbstractDAOFactory;
import edu.cmu.webapp.task7.model.FundDAO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Siqi Wang siqiw1 on 1/21/16.
 */
public class ViewFundAction extends Action {
    private FundDAO fundDAO;

    public ViewFundAction(AbstractDAOFactory dao) {
        fundDAO = dao.getFundDAO();
    }


    @Override
    public String getName() {
        return "viewFund.do";
    }

    @Override
    public String perform(HttpServletRequest request) {
        return null;
    }
}
