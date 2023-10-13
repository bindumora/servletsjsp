package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.EmployeeDao;
import Dto.Employee;



@WebServlet("/EmpSignup")
public class EmpSingup extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

	int pid = Integer.parseInt(req.getParameter("id"));
	String name = req.getParameter("name");
	String address = req.getParameter("address");
	long phone = Long.parseLong(req.getParameter("phone"));
	String password = req.getParameter("password");

Employee e = new Employee();
e.setEmpName(name);
e.setEmpAddress(address);
e.setEmpPhone(phone);
e.setEmpPassword(password);

EmployeeDao e1=new EmployeeDao();
e1.saveBoth(e);
	
	resp.sendRedirect("https://www.flipkart.com/");
	

		
		
	}
	

}
