package com.example.controllers.person;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.interfaces.IPersonService;
import com.example.services.PersonService;

@WebServlet(urlPatterns = "/person/delete")
@SuppressWarnings("serial")
public class DeletePersonServlet extends HttpServlet {

	public DeletePersonServlet() {
		super();
		this.personService = PersonService.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null) {
			this.personService.delete(id);
			response.sendRedirect("/person-java-web-app/person");
		} else {
			response.sendRedirect("/person-java-web-app/person?error=ID required");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private final IPersonService personService;

}
