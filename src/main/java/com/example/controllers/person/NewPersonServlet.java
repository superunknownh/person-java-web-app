package com.example.controllers.person;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.interfaces.IPersonService;
import com.example.models.Person;
import com.example.services.PersonService;

@WebServlet(urlPatterns = "/person/new")
@SuppressWarnings("serial")
public class NewPersonServlet extends HttpServlet {

	public NewPersonServlet() {
		super();
		this.personService = PersonService.getInstance();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/person/new-person.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = UUID.randomUUID().toString();
		String name = request.getParameter("name");
		String ageString = request.getParameter("age");
		int age = 0;
		if (ageString != null && !ageString.equals("")) {
			age = Integer.parseInt(ageString);
		}
		Person person = new Person(id, name, age);
		this.personService.add(person);
		response.sendRedirect("/person-java-web-app/person");
	}

	private final IPersonService personService;

}
