package com.example.controllers.person;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.interfaces.IPersonService;
import com.example.models.Person;
import com.example.services.PersonService;

@WebServlet(urlPatterns = "/person/edit")
@SuppressWarnings("serial")
public class EditPersonServlet extends HttpServlet {

	public EditPersonServlet() {
		super();
		this.personService = PersonService.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null) {
			Person person = this.personService.get(id);
			if (person != null) {
				request.setAttribute("person", person);
				request.getRequestDispatcher("/WEB-INF/views/person/edit-person.jsp").forward(request, response);
			} else {
				response.sendRedirect("/person-java-web-app/person?error=ID not valid.");
			}
		} else {
			response.sendRedirect("/person-java-web-app/person?error=ID required.");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (this.personService.get(id) != null) {
			String name = request.getParameter("name");
			String ageString = request.getParameter("age");
			int age = 0;
			if (ageString != null && !ageString.equals("")) {
				age = Integer.parseInt(ageString);
			}
			Person personUpdated = new Person(id, name, age);
			this.personService.edit(personUpdated);
			response.sendRedirect("/person-java-web-app/person");
		} else {
			response.sendRedirect("/person-java-web-app/person?error=ID not valid.");
		}
	}
	
	private final IPersonService personService;

}
