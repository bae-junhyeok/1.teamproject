package test.service;

import java.util.ArrayList;

import test.dao.RoomDAO;
import test.dao.UserDAO;
import test.vo.Member;
import test.vo.User;

public class RoomService {
	private static RoomService service = new RoomService();
	public RoomDAO dao = RoomDAO.getInstance();
	private RoomService() {}
	
	public static RoomService getInstance() {
		return service;
	}
	
	public void roomDelete(String id) {
		dao.roomDelete(id);
	}

}