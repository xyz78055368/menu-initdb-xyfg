package com.groupshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupshop.entity.B_wdk;

public class OrderDish extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public OrderDish() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		List<B_wdk> bList = new ArrayList<B_wdk>();
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			try {
//				String indetity  =request.getParameter(i+"");
//				if (indetity.equals(null)||indetity.equals("")) {
//					break;
//				}
//				
				String indetity  =request.getParameter("UID");
				System.out.println(indetity);
			} catch (Exception e) {
				// TODO: handle exception
			}
			B_wdk bWdk = new B_wdk();


		}



		out.flush();
		out.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
