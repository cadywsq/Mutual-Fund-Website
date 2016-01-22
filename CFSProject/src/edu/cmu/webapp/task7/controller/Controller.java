package edu.cmu.webapp.task7.controller;

import edu.cmu.webapp.task7.databean.CustomerBean;
import edu.cmu.webapp.task7.databean.EmployeeBean;
import edu.cmu.webapp.task7.model.AbstractDAOFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@SuppressWarnings("serial")
public class Controller extends HttpServlet {
    public void init() throws ServletException {
        AbstractDAOFactory dao = AbstractDAOFactory.getDAOFactory();
        Action.add(new LoginAction(dao));
        Action.add(new LogoutAction());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nextPage = this.performTheAction(request);
        this.sendToNextPage(nextPage, request, response);
    }

    private String performTheAction(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        String servletPath = request.getServletPath();
        String action = getActionName(servletPath);
        if (session.getAttribute("user") == null) {
            System.out.println("controller: user is null");
            return Action.perform("login.do", request);
        } else {
            if (session.getAttribute("user") instanceof CustomerBean) {
                return Action.perform("viewMyAccount.jsp", request);
            }
            if (session.getAttribute("user") instanceof EmployeeBean) {
                return Action.perform("employeeMain.jsp", request);
            }
        }
        return Action.perform(action, request);
    }

    private void sendToNextPage(String nextPage, HttpServletRequest request,
                                HttpServletResponse response) throws IOException, ServletException {
        if (nextPage == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND,
                    request.getServletPath());
            return;
        }
        if (nextPage.endsWith(".do")) {
            response.sendRedirect(nextPage);
            return;
        }
        if (nextPage.endsWith(".jsp")) {
            RequestDispatcher d = request.getRequestDispatcher("/" + nextPage);
            d.forward(request, response);
            return;
        }
        response.sendRedirect(nextPage);
    }

    private String getActionName(String path) {
        // We're guaranteed that the path will start with a slash
        int slash = path.lastIndexOf('/');
        return path.substring(slash + 1);
    }
}
