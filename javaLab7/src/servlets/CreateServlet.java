package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.*;
import postgreSQL.QueryTool;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			String type = request.getParameter("type");
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			double weight = Double.parseDouble(request.getParameter("weight"));
			String color, category;
			int numOfEatenEmployees;
			switch(type) {
				case "animal": {
					QueryTool.insertAnimal(new Animal(-1, name, age, weight));
					break;
				}
				case "cat": {
					color = request.getParameter("color");
					category = request.getParameter("category");
					QueryTool.insertCat(new Cat(-1, name, age, weight, color, category));
					break;
				}
				case "tiger": {
					color = request.getParameter("color");
					category = request.getParameter("category");
					numOfEatenEmployees = Integer.parseInt(request.getParameter("numOfEatenEmployees"));
					QueryTool.insertTiger(new Tiger(-1, name, age, weight, color, category, numOfEatenEmployees));
					break;
				}
			}
			response.sendRedirect(request.getContextPath());
		}			
		catch(Exception e) {
			System.out.println(e.getMessage());
			getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
		}
	}
}
