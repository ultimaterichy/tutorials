package com.baeldung.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.baeldung.model.Employee;
import com.google.gson.Gson;


@WebServlet(name = "EmployeeServlet", urlPatterns = "/employeeServlet")
public class EmployeeServlet extends HttpServlet {
	
	private Gson gson = new Gson();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException {

		Employee employee = new Employee(1, "Karan", "IT", 5000);
		String employeeJsonString = this.gson.toJson(employee);

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(employeeJsonString);
		out.flush();   
	}

}
