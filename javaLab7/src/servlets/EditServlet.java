package servlets;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Animal;
import models.Cat;
import models.Tiger;
import postgreSQL.QueryTool;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String type = request.getParameter("type");
			int id = Integer.parseInt(request.getParameter("id"));
			Animal animal = new Animal();
			switch(type) {
				case "animal":{
					animal = QueryTool.selectAnimalById(id);
					break;
				}
				case "cat":{
					animal = QueryTool.selectCatById(id);
					break;
				}
				case "tiger":{
					animal = QueryTool.selectTigerById(id);
					break;
				}
			}
			if (animal != null) {
				request.setAttribute("type", type);
				request.setAttribute("animal", animal);
				getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
			}
			else
				getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String type = request.getParameter("type");
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			double weight = Double.parseDouble(request.getParameter("weight"));
			String color, category;
			int numOfEatenEmployees;
			switch(type) {
				case "animal": {
					QueryTool.updateAnimal(new Animal(id, name, age, weight));
					break;
				}
				case "cat": {
					color = request.getParameter("color");
					category = request.getParameter("category");
					QueryTool.updateCat(new Cat(id, name, age, weight, color, category));
					break;
				}
				case "tiger": {
					color = request.getParameter("color");
					category = request.getParameter("category");
					numOfEatenEmployees = Integer.parseInt(request.getParameter("numOfEatenEmployees"));
					QueryTool.updateTiger(new Tiger(id, name, age, weight, color, category, numOfEatenEmployees));
					break;
				}
			}
			response.sendRedirect(request.getContextPath());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
