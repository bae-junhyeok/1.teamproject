package test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.service.MemberService;
import test.vo.Member;
import test.vo.User;

public class MemberUpdateController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userID = req.getParameter("userID");
		String userName = req.getParameter("userName");
		String userGender = req.getParameter("userGender");
		String userEmail = req.getParameter("userEmail");
		
		User user = new User();
		user.setUserID(userID);
		user.setUserName(userName);
		user.setUserGender(userGender);
		user.setUserEmail(userEmail);
		
		MemberService service = MemberService.getInstance();
		service.memberUpdate(user);
		
		req.setAttribute("userID", userID);
		HttpUtil.forward(req, resp, "admin.jsp");
	}

}