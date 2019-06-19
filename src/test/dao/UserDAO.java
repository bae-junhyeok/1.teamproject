package test.dao;



import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import test.vo.Member;
import test.vo.User;



public class UserDAO {
	
	private static UserDAO userDao = new UserDAO();

	// dao : 占쏙옙占쏙옙占싶븝옙占싱쏙옙 占쏙옙占쏙옙 占쏙옙체占쏙옙 占쏙옙占쌘로쇽옙

	// 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 db占쏙옙占쏙옙 회占쏙옙占쏙옙占쏙옙 占쌀뤄옙占쏙옙占신놂옙 db占쏙옙 회占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
	public static UserDAO getInstance()
	{
		return userDao;
	}


	private Connection conn; // connection:db占쏙옙占쏙옙占쏙옙占싹곤옙 占쏙옙占쌍댐옙 占쏙옙체

	private PreparedStatement pstmt;

	private ResultSet rs;



	// mysql占쏙옙 占쏙옙占쏙옙占쏙옙 占쌍댐옙 占싸븝옙

	public UserDAO() { // 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占� 占쌘듸옙占쏙옙占쏙옙 db占쏙옙占쏙옙占쏙옙 占싱뤄옙占� 占쏙옙 占쏙옙 占쌍듸옙占쏙옙占쏙옙

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



	// 占싸깍옙占쏙옙占쏙옙 占시듸옙占싹댐옙 占쌉쇽옙****

	public int login(String userID, String userPassword) {

		String SQL = "SELECT userPassword FROM USER WHERE userID = ?";

		try {

			// pstmt : prepared statement 占쏙옙占쏙옙占쏙옙 sql占쏙옙占쏙옙占쏙옙 db占쏙옙 占쏙옙占쏙옙占싹댐옙 占쏙옙占쏙옙占쏙옙占쏙옙 占싸쏙옙占싹쏙옙占쏙옙占쏙옙占쏙옙

			pstmt = conn.prepareStatement(SQL);

			// sql占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙킹占쏙옙占쏙옙占� 占쏙옙占쏙옙求째占�... pstmt占쏙옙 占싱울옙占쏙옙 占싹놂옙占쏙옙 占쏙옙占쏙옙占쏙옙 占싱몌옙 占쌔븝옙占쌔쇽옙(占쏙옙占쏙옙표占쏙옙占�)

			// 占쏙옙占쏙옙표占쌔댐옙占싹댐옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占싱듸옙占�, 占신곤옙占쏙옙占쏙옙占쏙옙 占싱울옙.. 1)占쏙옙占쏙옙占싹댐옙占쏙옙 2)占쏙옙橘占싫ｏ옙占쏙옙占쏙옙占쏙옙占�

			pstmt.setString(1, userID);

			// rs:result set 占쏙옙 占쏙옙占쏙옙占쏙옙占�

			rs = pstmt.executeQuery();

			// 占쏙옙占쏙옙占� 占쏙옙占쏙옙占싼다몌옙 占쏙옙占쏙옙

			if (rs.next()) {

				// 占싻쏙옙占쏙옙占쏙옙 占쏙옙치占싼다몌옙 占쏙옙占쏙옙

				if (rs.getString(1).equals(userPassword)) {

					return 1; // 占쏙옙占� 占쏙옙占쏙옙

				} else

					return 0; // 占쏙옙橘占싫� 占쏙옙占쏙옙치

			}

			return -1; // 占쏙옙占싱듸옙 占쏙옙占쏙옙 占쏙옙占쏙옙



		} catch (Exception e) {

			e.printStackTrace();

		}

		return -2; // 占쏙옙占쏙옙占싶븝옙占싱쏙옙 占쏙옙占쏙옙占쏙옙 占실뱄옙

	}
	
	public int join(User user) {

		String SQL = "INSERT INTO USER VALUES (?,?,?,?,?)";

		try {

			pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, user.getUserID());

			pstmt.setString(2, user.getUserPassword());

			pstmt.setString(3, user.getUserName());

			pstmt.setString(4, user.getUserGender());

			pstmt.setString(5, user.getUserEmail());

			return pstmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return -1; // DB 占쏙옙占쏙옙

	}
	
	
	public void memberDelete(String id) 
	{
		
		try
		{
		
		PreparedStatement pstmt = conn.prepareStatement("delete from user where userID = ?");
		pstmt.setString(1, id);
		
		pstmt.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void memberUpdate(User user)
	{
		try {
			
			PreparedStatement pstmt = conn.prepareStatement("update user set userName=?,userGender=?,userEmail=? where userID =?");
			pstmt.setString(4, user.getUserID());
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserGender());
			pstmt.setString(3, user.getUserEmail());
			
			
			pstmt.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

