package com.cts.employeemanagement.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.employeemanagemnt.service.LoginService;
import com.cts.employeemanagemnt.service.LoginServiceImpl;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
    	super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginService loginService = LoginServiceImpl.getInstance();
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		RequestDispatcher requestDispatcher=null;
		//String type =  loginService.getUserType(userId);
		if(loginService.authenticate(userId, password)){
			String status = loginService.getUserStatus(userId);
			String authorize = loginService.authorization(userId);
			if("A".equals(authorize)){
				if("0".equals(status)){
					requestDispatcher = request.getRequestDispatcher("admin.html");
					requestDispatcher.forward(request, response);
				}
				else if("1".equals(status)){
					System.out.println("You are already loged in");
				}
				else if("2".equals(status)){
					System.out.println("Your account is deactivated");
				}
			}
			else if("U".equals(authorize)){
				if("0".equals(status)){
					requestDispatcher = request.getRequestDispatcher("userHome.html");
					requestDispatcher.forward(request, response);
				}
				else if("1".equals(status)){
					System.out.println("You are already loged in");
				}
				else if("2".equals(status)){
					System.out.println("Your account is deactivated");
				}
			}
			else if("V".equals(authorize)){
				if("0".equals(status)){
					requestDispatcher = request.getRequestDispatcher("venderHome.html");
					requestDispatcher.forward(request, response);
				}
				else if("1".equals(status)){
					System.out.println("You are already loged in");
				}
				else if("2".equals(status)){
					System.out.println("Your account is deactivated");
				}
			}
			else{
				System.out.println("Invalid credential");
			}
		}
		else{
			requestDispatcher = request.getRequestDispatcher("login.html");
			requestDispatcher.forward(request, response);
		}
		
		
	}

}
