package test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{

	HashMap<String,Controller> list = null;
	public void init(ServletConfig config) throws ServletException
	{
		list = new HashMap<String, Controller>();
		list.put("/memberDelete.do", new MemberDeleteController());
		list.put("/memberUpdate.do", new MemberUpdateController());
		list.put("/roomDelete.do", new RoomDeleteController());
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String url = req.getRequestURI();
		String cp = req.getContextPath();
		String path = url.substring(cp.length(),url.length());
		
		Controller sc = list.get(path);
		PrintWriter out = resp.getWriter();
		out.print(path + " " + sc);
		sc.execute(req, resp);
	}
}









