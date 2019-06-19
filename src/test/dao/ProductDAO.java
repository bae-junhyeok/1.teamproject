package test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import test.vo.Member;
import test.vo.Product;

public class ProductDAO {
	private static ProductDAO productDao = new ProductDAO();
	
	private ProductDAO() {}
	
	public static ProductDAO getInstance()
	{
		return productDao;
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
	
	public ArrayList<Product> productList(){
		ArrayList<Product> list = new ArrayList<Product>();
		Product product = null;
		try
		{
		Connection con = connect();
		PreparedStatement pstmt = con.prepareStatement("select * from product");
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			product = new Product();
			product.setPid(rs.getInt(1));
			product.setpName(rs.getString(2));
			product.setPrice(rs.getString(3));
			product.setImg(rs.getString(4));
			
			list.add(product);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
}
