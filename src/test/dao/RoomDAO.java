package test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import test.vo.Member;
import test.vo.Room;

public class RoomDAO {
	
	
	private static RoomDAO roomDao = new RoomDAO();

	// dao : 占쏙옙占쏙옙占싶븝옙占싱쏙옙 占쏙옙占쏙옙 占쏙옙체占쏙옙 占쏙옙占쌘로쇽옙

	// 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 db占쏙옙占쏙옙 회占쏙옙占쏙옙占쏙옙 占쌀뤄옙占쏙옙占신놂옙 db占쏙옙 회占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
	public static RoomDAO getInstance()
	{
		return roomDao;
	}
	
	
	
	private Connection conn; // connection:db占쏙옙占쏙옙占쏙옙占싹곤옙 占쏙옙占쌍댐옙 占쏙옙체

	private PreparedStatement pstmt;

	private ResultSet rs;



	// mysql占쏙옙 占쏙옙占쏙옙占쏙옙 占쌍댐옙 占싸븝옙

	public RoomDAO() { // 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占� 占쌘듸옙占쏙옙占쏙옙 db占쏙옙占쏙옙占쏙옙 占싱뤄옙占� 占쏙옙 占쏙옙 占쌍듸옙占쏙옙占쏙옙

		try {

			String dbURL = "jdbc:mysql://localhost:3306/bbs?serverTimezone=UTC"; // localhost:3306 占쏙옙트占쏙옙 占쏙옙퓨占싶쇽옙치占쏙옙 mysql占쌍쇽옙

			String dbID = "root";

			String dbPassword = "cs1234";

			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);

		} catch (Exception e) {

			e.printStackTrace(); // 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占�

		}

	}
	
	public int insert(Room room) {

		String SQL = "INSERT INTO ROOM VALUES (?,?,?,?,?)";
		
		try {
			
			
			pstmt = conn.prepareStatement(SQL);

			
			pstmt.setString(1, room.getRoomName());

			pstmt.setString(2, room.getRoomDate());

			pstmt.setString(3, room.getRoomLong());

			pstmt.setString(4, room.getRoomCount());
			
			pstmt.setString(5, room.getRoomID());
			
			


			return pstmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return -1; // DB 占쏙옙占쏙옙

	}
	
	public Room roomQuery(String id)
	{
		Room room = null;
		try
		{
		PreparedStatement pstmt = conn.prepareStatement("select * from room where id = ?");
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			room = new Room();
			room.setRoomName(rs.getString(1));
			room.setRoomDate(rs.getString(2));
			room.setRoomLong(rs.getString(3));
			room.setRoomCount(rs.getString(4));
			room.setRoomID(rs.getString(5));
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return room;
		
	}
	
	public void roomDelete(String id) 
	{
		
		try
		{
		
		PreparedStatement pstmt = conn.prepareStatement("delete from room where userID = ?");
		pstmt.setString(1, id);
		
		pstmt.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
