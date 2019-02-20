package com.example.controllers.person;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.interfaces.IPersonService;
import com.example.services.PersonService;

@WebServlet(urlPatterns = "/person")
@SuppressWarnings("serial")
public class PersonServlet extends HttpServlet {

	public PersonServlet() {
		super();
		// dependency injection (manual)
		this.personService = PersonService.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("persons", this.personService.list());
		request.getRequestDispatcher("/WEB-INF/views/person/persons.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private final IPersonService personService;

}
