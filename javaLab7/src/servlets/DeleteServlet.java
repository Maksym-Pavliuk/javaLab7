package servlets;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Animal;
import postgreSQL.QueryTool;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			String type = request.getParameter("type");
			int id = Integer.parseInt(request.getParameter("id"));
			switch(type) {
				case "animal":{
					QueryTool.deleteAnimalById(id);
					break;
				}
				case "cat":{
					QueryTool.deleteCatById(id);
					break;
				}
				case "tiger":{
					QueryTool.deleteTigerById(id);
					break;
				}
			}
			response.sendRedirect(request.getContextPath());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
		}
	}
}
