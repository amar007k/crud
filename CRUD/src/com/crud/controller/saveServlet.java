package com.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.EmployeeDaoImpl;
import com.crud.pojo.Employee;

/**
 * Servlet implementation class saveServlet
 */
@WebServlet("/saveServlet")
public class saveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		Employee e = new Employee();
		e.setName(name);
		e.setPass(password);
		e.setEmail(email);
		e.setCountry(country);
		
		EmployeeDaoImpl emp = new EmployeeDaoImpl();
		int status=emp.save(e);
		System.out.println(status);
		if(status>0){
			response.sendRedirect("index.html");
			
		}else {
			response.sendRedirect("error.html");
		}
		out.close();
	}

}
                                                                                                                                                                                                                        