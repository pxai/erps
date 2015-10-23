package org.cuatrovientos.web.helloweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerDAO customerDAO = new CustomerDAO();
		PrintWriter out = response.getWriter();
		
		String html = "<h1>Customers</h1>";
		Vector<Customer> customers = customerDAO.selectAll();
		
		for (Customer customer : customers) {
			html += customer.getName();
			html += " <a href='/HelloWeb/DeleteServlet?id="+
							customer.getId()+
								"'>Eliminar</a>";	
			html += " <a href='/HelloWeb/UpdateServlet?id="+
					customer.getId()+
						"'>Update</a>";
			html += "<br>"; 
		}
		
		out.println(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerDAO customerDAO = new CustomerDAO();
		Customer customer = 
				new Customer(Integer.parseInt(request.getParameter("id")),
											request.getParameter("name"));
		customerDAO.insert(customer);
		PrintWriter out = response.getWriter();
		out.println("Ok, registro insertado");
	}

}
