package test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.dao.UserDAO;

public class MemberDeleteController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		
		
		String id = req.getParameter("userID");
		
		UserDAO dao = UserDAO.getInstance();
		dao.memberDelete(id);
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		
		HttpUtil.forward(req, resp, "admin.jsp");
	}
	
	
	
	

}
