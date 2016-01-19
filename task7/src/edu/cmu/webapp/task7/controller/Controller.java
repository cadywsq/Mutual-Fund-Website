package edu.cmu.webapp.task7.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.cmu.webapp.task7.databean.CustomerBean;
import edu.cmu.webapp.task7.model.AbstractDAOFactory;


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
        AbstractDAOFactory dao = AbstractDAOFactory.getDAOFactory();
        Action.add(new LoginAction(dao));
        Action.add(new CreateFundAction(dao));
        Action.add(new LogoutAction(dao));
//        Action.add(new EmployeeMainAction(dao));
//        Action.add(new SellFundAction(dao));
//        Action.add(new CustomerMainAction(dao));
//        Action.add(new CreateEmployeeAccountAction(dao));
//        Action.add(new CreateCustomerAccountAction(dao));
//        Action.add(new DepositCheckAction(dao));
//        Action.add(new TransitionDayAction(dao));
//        Action.add(new ViewCustomerAction(dao));
//        Action.add(new RequestCheckAction(dao));
//        Action.add(new ChangePwdAction(dao));
//        Action.add(new ViewCustomerAccountAction(dao));
//        Action.add(new ResetPwdAction(dao));
//        Action.add(new HistoryAction(dao));
//        Action.add(new ViewPortfolioAction(dao));
//        Action.add(new BuyFundAction(dao));
//        Action.add(new ResearchFundAction(dao));
//        Action.add(new AccountManageC(dao));
//        Action.add(new AccountManageE(dao));
//        Action.add(new SuccessAction(dao));
}


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nextPage = performTheAction(request);
        sendToNextPage(nextPage,request,response);
    }
    
    /*
     * Extracts the requested action and (depending on whether the user is logged in)
     * perform it (or make the user login).
     * @param request
     * @return the next page (the view)
     */
    private String performTheAction(HttpServletRequest request) {
        HttpSession session     = request.getSession(true);
        String      servletPath = request.getServletPath();
        String      action = getActionName(servletPath);

        if (session.getAttribute("user") == null) {
        	// If the user hasn't logged in, so login is the only option
			return Action.perform("login.do",request);
        }
        
        if (action.equals("welcome")) {
        	// User is logged in, but at the root of our web app
        	if (session.getAttribute("user") instanceof CustomerBean)
        		return Action.perform("customerMain.do",request);
        	else 
        		return Action.perform("employeeMain.do",request);
        }
        
      	// Let the logged in user run his chosen action
		return Action.perform(action,request);
    }
    
    /*
     * If nextPage is null, send back 404
     * If nextPage ends with ".do", redirect to this page.
     * If nextPage ends with ".jsp", dispatch (forward) to the page (the view)
     *    This is the common case
     */
    private void sendToNextPage(String nextPage, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	if (nextPage == null) {
    		response.sendError(HttpServletResponse.SC_NOT_FOUND,request.getServletPath());
    		return;
    	}
    	
    	if (nextPage.endsWith(".do")) {
			response.sendRedirect(nextPage);
			return;
    	}
    	
    	if (nextPage.endsWith(".jsp")) {
	   		RequestDispatcher d = request.getRequestDispatcher("WEB-INF/" + nextPage);
	   		d.forward(request,response);
	   		return;
    	}
    	
    	throw new ServletException(Controller.class.getName()+".sendToNextPage(\"" + nextPage + "\"): invalid extension.");
    }

	/*
	 * Returns the path component after the last slash removing any "extension"
	 * if present.
	 */
    private String getActionName(String path) {
    	// We're guaranteed that the path will start with a slash
        int slash = path.lastIndexOf('/');
        return path.substring(slash+1);
    }
}
