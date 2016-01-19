package edu.cmu.webapp.task7.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.cmu.webapp.task7.model.Model;

public class LogoutAction extends Action {

	public LogoutAction(Model model) {
		// ignore it
	}

	public String getName() {
		return "logout.do";
	}

	public String perform(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.setAttribute("user", null);

		return "login.jsp";
	}
}
