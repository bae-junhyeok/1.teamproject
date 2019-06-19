package test.service;

import java.util.ArrayList;
import test.dao.UserDAO;
import test.vo.Member;
import test.vo.User;

public class MemberService {
	private static MemberService service = new MemberService();
	public UserDAO dao = UserDAO.getInstance();
	private MemberService() {}
	
	public static MemberService getInstance() {
		return service;
	}
	
	public void memberDelete(String id) {
		dao.memberDelete(id);
	}
	
	public void memberUpdate(User user) {
		dao.memberUpdate(user);
	}

}
