package test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import test.vo.Member;

public class MemberDAO {
	private static MemberDAO memberDao = new MemberDAO();
	
	private MemberDAO() {}
	
	public static MemberDAO getInstance()
	{
		return memberDao;
	}
	public Connection connect()
	{
		Connection conn = null;
		try 
		{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/ncgproject?serverTimezone=UTC", "root", "cs1234");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void memberInsert(Member member)
	{
		try
		{
		Connection con = this.connect();
		PreparedStatement pstmt = con.prepareStatement("insert into member values(?,?,?,?)");
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPasswd());
		pstmt.setString(3, member.getName());
		pstmt.setString(4, member.getMail());
		
		pstmt.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Member memberSearch(String id)
	{
		Member member = null;
		try
		{
		Connection con = connect();
		PreparedStatement pstmt = con.prepareStatement("select * from member where id = ?");
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			member = new Member();
			member.setId(rs.getString(1));
			member.setPasswd(rs.getString(2));
			member.setName(rs.getString(3));
			member.setMail(rs.getString(4));
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return member;
		
	}
	
	public void memberUpdate(Member member) 
	{
		try
		{
		Connection con = this.connect();
		PreparedStatement pstmt = con.prepareStatement("update member set passwd=?,name=?,mail=? where id =?");
		pstmt.setString(4, member.getId());
		pstmt.setString(1, member.getPasswd());
		pstmt.setString(2, member.getName());
		pstmt.setString(3, member.getMail());
		
		pstmt.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<Member> memberList(){
		ArrayList<Member> list = new ArrayList<Member>();
		Member member = null;
		try
		{
		Connection con = connect();
		PreparedStatement pstmt = con.prepareStatement("select * from member");
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			member = new Member();
			member.setId(rs.getString(1));
			member.setPasswd(rs.getString(2));
			member.setName(rs.getString(3));
			member.setMail(rs.getString(4));
			
			list.add(member);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void memberDelete(String id) 
	{
		
		try
		{
		Connection con = connect();
		PreparedStatement pstmt = con.prepareStatement("delete from member where id=?");
		pstmt.setString(1, id);
		
		pstmt.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public int userCheck(String id, String pwd) {
		int result = -1;
		String sql = "select passwd from member where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("passwd") != null && rs.getString("passwd").equals(pwd)) {
					result = 1;
				}else {
					result = 0;
				}
			}else {
				result = -1;
			}
			
		}catch(Exception e) {
			
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}












