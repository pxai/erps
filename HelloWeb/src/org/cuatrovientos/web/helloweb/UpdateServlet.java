package org.cuatrovientos.web.helloweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = customerDAO.selectById(Integer.parseInt(request.getParameter("id")));
		String html = "<h1>Update Customer</h1>";
		
		html = html + 
				"<form name='Formu' method='post' "+
			     "action='/HelloWeb/UpdateServlet'>"+
			"ID<input type='text' name='id' value='"+customer.getId()+"' />"+
			"Name<input type='text' name='name' value='"+customer.getName()+"' />"+
			"<input type='submit' name='send'"+
			 "value='Insert' /> " +
			"</form>'";
		
		out.println(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		
		Customer customer = new Customer(id, name);
		
		CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.update(customer);
		
		PrintWriter out = response.getWriter();
		out.println("Update OK.");
		out.println("<a href='/HelloWeb/CustomerServlet'>Back</a>");
	}

}
