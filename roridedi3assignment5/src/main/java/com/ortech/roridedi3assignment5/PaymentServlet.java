package com.ortech.roridedi3assignment5;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = request.getSession();

		Registration registration = (Registration) session.getAttribute("registration");
		session.setAttribute("registration", registration);

		RequestDispatcher rd = request.getRequestDispatcher("checkout.jsp");
		rd.forward(request, resp);

	}
	

}
