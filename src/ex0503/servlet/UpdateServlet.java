package ex0503.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex0503.dao.CustomerDAO;
import ex0503.dao.CustomerDAOImpl;
import ex0503.dto.CustomerDTO;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		String phone=request.getParameter("tel");
		String addr=request.getParameter("addr");
		CustomerDTO dto = new CustomerDTO(id, name, age, phone, addr);
		CustomerDAO dao = new CustomerDAOImpl();
		int re=dao.update(dto);
		out.println(re);
	}

}
