package test.dao;



import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;

import test.vo.Bbs;



public class BbsDAO {

		// dao : 占쏙옙占쏙옙占싶븝옙占싱쏙옙 占쏙옙占쏙옙 占쏙옙체占쏙옙 占쏙옙占쏙옙

	

		private Connection conn; // connection:db占쏙옙占쏙옙占쏙옙占싹곤옙 占쏙옙占쌍댐옙 占쏙옙체

		//private PreparedStatement pstmt;

		private ResultSet rs;



		// mysql 처占쏙옙占싸븝옙

		public BbsDAO() {

			// 占쏙옙占쏙옙占쌘몌옙 占쏙옙占쏙옙占쏙옙娩占�.

			try {

				String dbURL = "jdbc:mysql://localhost:3306/bbs?serverTimezone=UTC"; // localhost:3306 占쏙옙트占쏙옙 占쏙옙퓨占싶쇽옙치占쏙옙 mysql占쌍쇽옙

				String dbID = "root";

				String dbPassword = "cs1234";

				Class.forName("com.mysql.jdbc.Driver");

				conn = DriverManager.getConnection(dbURL, dbID, dbPassword);

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

		

		//占쏙옙占쏙옙占쏙옙 占시곤옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쌉쇽옙

		public String getDate() { 

			String SQL = "SELECT NOW()";

			try {

				PreparedStatement pstmt = conn.prepareStatement(SQL);

				rs = pstmt.executeQuery();

				if(rs.next()) {

					return rs.getString(1);

				}

			} catch (Exception e) {

				e.printStackTrace();

			}

			return ""; //占쏙옙占쏙옙占싶븝옙占싱쏙옙 占쏙옙占쏙옙

		}

		

		//bbsID 占쌉시깍옙 占쏙옙호 占쏙옙占쏙옙占쏙옙占쏙옙 占쌉쇽옙

			public int getNext() { 

				String SQL = "SELECT bbsID FROM BBS ORDER BY bbsID DESC";

				try {

					PreparedStatement pstmt = conn.prepareStatement(SQL);

					rs = pstmt.executeQuery();

					if(rs.next()) {

						return rs.getInt(1) + 1;

					}

					return 1;//첫 占쏙옙째 占쌉시뱄옙占쏙옙 占쏙옙占�

				} catch (Exception e) {

					e.printStackTrace();

				}

				return -1; //占쏙옙占쏙옙占싶븝옙占싱쏙옙 占쏙옙占쏙옙

			}

			

			//占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쌜쇽옙占싹댐옙 占쌉쇽옙

			public int write(String bbsTitle, String userID, String bbsContent) { 

				String SQL = "INSERT INTO BBS VALUES(?, ?, ?, ?, ?, ?)";

				try {

					

					PreparedStatement pstmt = conn.prepareStatement(SQL);

					pstmt.setInt(1, getNext());

					pstmt.setString(2, bbsTitle);

					pstmt.setString(3, userID);

					pstmt.setString(4, getDate());

					pstmt.setString(5, bbsContent);

					pstmt.setInt(6,1);

					

					return pstmt.executeUpdate();

					

				} catch (Exception e) {

					e.printStackTrace();

				}

				return -1; //占쏙옙占쏙옙占싶븝옙占싱쏙옙 占쏙옙占쏙옙

			}
			
			public ArrayList<Bbs> getList(int pageNumber){ 

				String SQL = "SELECT * FROM BBS WHERE bbsID < ? AND bbsAvailable = 1 ORDER BY bbsID DESC LIMIT 10";

				ArrayList<Bbs> list = new ArrayList<Bbs>();

				try {

					PreparedStatement pstmt = conn.prepareStatement(SQL);

					pstmt.setInt(1, getNext() - (pageNumber -1) * 10);

					rs = pstmt.executeQuery();

					while (rs.next()) {

						Bbs bbs = new Bbs();

						bbs.setBbsID(rs.getInt(1));

						bbs.setBbsTitle(rs.getString(2));

						bbs.setUserID(rs.getString(3));

						bbs.setBbsDate(rs.getString(4));

						bbs.setBbsContent(rs.getString(5));

						bbs.setBbsAvailable(rs.getInt(6));

						list.add(bbs);

					}

				} catch (Exception e) {

					e.printStackTrace();

				}

				return list; 

			}
			
			//10 占쏙옙占쏙옙 占쏙옙占쏙옙징 처占쏙옙占쏙옙 占쏙옙占쏙옙 占쌉쇽옙

			public boolean nextPage (int pageNumber) {

				String SQL = "SELECT * FROM BBS WHERE bbsID < ? AND bbsAvailable = 1 ORDER BY bbsID DESC LIMIT 10";

				ArrayList<Bbs> list = new ArrayList<Bbs>();

				try {

					PreparedStatement pstmt = conn.prepareStatement(SQL);

					pstmt.setInt(1, getNext() - (pageNumber -1) * 10);

					rs = pstmt.executeQuery();

					if (rs.next()) {

						return true;

					}

				} catch (Exception e) {

					e.printStackTrace();

				}

				return false; 		

			}
			
			public Bbs getBbs(int bbsID) {

				String SQL = "SELECT * FROM BBS WHERE bbsID = ?";

				try {

					PreparedStatement pstmt = conn.prepareStatement(SQL);

					pstmt.setInt(1, bbsID);

					rs = pstmt.executeQuery();

					if (rs.next()) {

						Bbs bbs = new Bbs();

						bbs.setBbsID(rs.getInt(1));

						bbs.setBbsTitle(rs.getString(2));

						bbs.setUserID(rs.getString(3));

						bbs.setBbsDate(rs.getString(4));

						bbs.setBbsContent(rs.getString(5));

						bbs.setBbsAvailable(rs.getInt(6));



						return bbs;

					}

				} catch (Exception e) {

					e.printStackTrace();

				}

				return null;



			}
			
			//占쏙옙占쏙옙 占쌉쇽옙

			public int update(int bbsID, String bbsTitle, String bbsContent) {

					String SQL = "UPDATE BBS SET bbsTitle = ?, bbsContent = ?, WHERE bbsID = ?";

					try {

						PreparedStatement pstmt = conn.prepareStatement(SQL);

						pstmt.setString(1, bbsTitle);

						pstmt.setString(2, bbsContent);

						pstmt.setInt(3, bbsID);

						return pstmt.executeUpdate();



					} catch (Exception e) {

						e.printStackTrace();

					}

					return -1; // 占쏙옙占쏙옙占싶븝옙占싱쏙옙 占쏙옙占쏙옙

				}
			
			//占쏙옙占쏙옙 占쌉쇽옙

			public int delete(int bbsID) {

				String SQL = "UPDATE BBS SET bbsAvailable = 0 WHERE bbsID = ?";

				try {

					PreparedStatement pstmt = conn.prepareStatement(SQL);   

					pstmt.setInt(1, bbsID);

					return pstmt.executeUpdate();



				} catch (Exception e) {

					e.printStackTrace();

				}

				return -1; // 占쏙옙占쏙옙占싶븝옙占싱쏙옙 占쏙옙占쏙옙

			}

	}

