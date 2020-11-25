package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.SQLException;
import models.*;
import postgreSQL.QueryTool;

@WebServlet("/")
public class MainServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		try {
			ArrayList<Animal> animals = QueryTool.selectAnimal();
			request.setAttribute("animals", animals);
			
			ArrayList<Cat> cats = QueryTool.selectCat();
			request.setAttribute("cats", cats);
			
			ArrayList<Tiger> tigers = QueryTool.selectTiger();
			request.setAttribute("tigers", tigers);
			
			getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
